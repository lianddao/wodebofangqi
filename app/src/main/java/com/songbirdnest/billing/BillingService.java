package com.songbirdnest.billing;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IMarketBillingService;
import com.android.vending.billing.IMarketBillingService.Stub;
import com.songbirdnest.billing.Security.VerifiedPurchase;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class BillingService extends Service implements ServiceConnection {
    private static LinkedList<BillingRequest> mPendingRequests = new LinkedList();
    private static HashMap<Long, BillingRequest> mSentRequests = new HashMap();
    private static IMarketBillingService mService;
    private boolean bindingService;

    abstract class BillingRequest {
        protected long mRequestId;
        private final int mStartId;

        protected abstract long run() throws RemoteException;

        public BillingRequest(int startId) {
            this.mStartId = startId;
        }

        public int getStartId() {
            return this.mStartId;
        }

        public boolean runRequest() {
            if (runIfConnected()) {
                return true;
            }
            if (!BillingService.this.bindToMarketBillingService()) {
                return false;
            }
            BillingService.mPendingRequests.add(this);
            return true;
        }

        public boolean runIfConnected() {
            if (BillingHelper.debugging) {
                Logger.debug(this, getClass().getSimpleName());
            }
            if (BillingService.mService != null) {
                try {
                    this.mRequestId = run();
                    if (BillingHelper.debugging) {
                        Logger.debug(this, "request id: " + this.mRequestId);
                    }
                    if (this.mRequestId >= 0) {
                        BillingService.mSentRequests.put(Long.valueOf(this.mRequestId), this);
                    }
                    return true;
                } catch (RemoteException e) {
                    onRemoteException(e);
                }
            }
            return false;
        }

        protected void onRemoteException(RemoteException e) {
            if (BillingHelper.debugging) {
                Logger.error(this, "remote billing service crashed", e);
            }
            BillingService.mService = null;
        }

        protected void responseCodeReceived(ResponseCode responseCode) {
        }

        protected Bundle makeRequestBundle(String method) {
            Bundle request = new Bundle();
            request.putString(Constants.BILLING_REQUEST_METHOD, method);
            request.putInt(Constants.BILLING_REQUEST_API_VERSION, 2);
            request.putString(Constants.BILLING_REQUEST_PACKAGE_NAME, BillingService.this.getPackageName());
            return request;
        }

        protected void logResponseCode(String method, Bundle response) {
            ResponseCode responseCode = ResponseCode.valueOf(response.getInt(Constants.BILLING_RESPONSE_RESPONSE_CODE));
            if (BillingHelper.debugging) {
                Logger.debug(this, method + " received " + responseCode.toString());
            }
        }
    }

    class CheckBillingSupported extends BillingRequest {
        public String mProductType = null;

        @Deprecated
        public CheckBillingSupported() {
            super(-1);
        }

        public CheckBillingSupported(String itemType) {
            super(-1);
            this.mProductType = itemType;
        }

        protected long run() throws RemoteException {
            Bundle request = makeRequestBundle(Constants.CHECK_BILLING_SUPPORTED);
            if (this.mProductType != null) {
                request.putString(Constants.BILLING_REQUEST_ITEM_TYPE, this.mProductType);
            }
            int responseCode = BillingService.mService.sendBillingRequest(request).getInt(Constants.BILLING_RESPONSE_RESPONSE_CODE);
            if (BillingHelper.debugging) {
                Logger.debug(this, "CheckBillingSupported response code: " + ResponseCode.valueOf(responseCode));
            }
            ResponseHandler.checkBillingSupportedResponse(responseCode == ResponseCode.RESULT_OK.ordinal(), this.mProductType);
            return Constants.BILLING_RESPONSE_INVALID_REQUEST_ID;
        }
    }

    class ConfirmNotifications extends BillingRequest {
        final String[] mNotifyIds;

        public ConfirmNotifications(int startId, String[] notifyIds) {
            super(startId);
            this.mNotifyIds = notifyIds;
        }

        protected long run() throws RemoteException {
            Bundle request = makeRequestBundle(Constants.CONFIRM_NOTIFICATIONS);
            request.putStringArray(Constants.BILLING_REQUEST_NOTIFY_IDS, this.mNotifyIds);
            Bundle response = BillingService.mService.sendBillingRequest(request);
            logResponseCode("confirmNotifications", response);
            return response.getLong(Constants.BILLING_RESPONSE_REQUEST_ID, Constants.BILLING_RESPONSE_INVALID_REQUEST_ID);
        }
    }

    class GetPurchaseInformation extends BillingRequest {
        long mNonce;
        final String[] mNotifyIds;

        public GetPurchaseInformation(int startId, String[] notifyIds) {
            super(startId);
            this.mNotifyIds = notifyIds;
        }

        protected long run() throws RemoteException {
            this.mNonce = Security.generateNonce();
            Bundle request = makeRequestBundle(Constants.GET_PURCHASE_INFORMATION);
            request.putLong(Constants.BILLING_REQUEST_NONCE, this.mNonce);
            request.putStringArray(Constants.BILLING_REQUEST_NOTIFY_IDS, this.mNotifyIds);
            Bundle response = BillingService.mService.sendBillingRequest(request);
            logResponseCode("getPurchaseInformation", response);
            return response.getLong(Constants.BILLING_RESPONSE_REQUEST_ID, Constants.BILLING_RESPONSE_INVALID_REQUEST_ID);
        }

        protected void onRemoteException(RemoteException e) {
            super.onRemoteException(e);
            Security.removeNonce(this.mNonce);
        }
    }

    public enum Managed {
        MANAGED,
        UNMANAGED,
        SUBSCRIPTION
    }

    public class RequestPurchase extends BillingRequest {
        public final String mDeveloperPayload;
        public final String mProductId;
        public final String mProductType;

        public /* bridge */ /* synthetic */ int getStartId() {
            return super.getStartId();
        }

        public /* bridge */ /* synthetic */ boolean runIfConnected() {
            return super.runIfConnected();
        }

        public /* bridge */ /* synthetic */ boolean runRequest() {
            return super.runRequest();
        }

        @Deprecated
        public RequestPurchase(BillingService billingService, String itemId) {
            this(itemId, null, null);
        }

        @Deprecated
        public RequestPurchase(BillingService billingService, String itemId, String developerPayload) {
            this(itemId, null, developerPayload);
        }

        public RequestPurchase(String itemId, String itemType, String developerPayload) {
            super(-1);
            this.mProductId = itemId;
            this.mDeveloperPayload = developerPayload;
            this.mProductType = itemType;
        }

        protected long run() throws RemoteException {
            Bundle request = makeRequestBundle(Constants.REQUEST_PURCHASE);
            request.putString(Constants.BILLING_REQUEST_ITEM_ID, this.mProductId);
            request.putString(Constants.BILLING_REQUEST_ITEM_TYPE, this.mProductType);
            if (this.mDeveloperPayload != null) {
                request.putString(Constants.BILLING_REQUEST_DEVELOPER_PAYLOAD, this.mDeveloperPayload);
            }
            Bundle response = BillingService.mService.sendBillingRequest(request);
            PendingIntent pendingIntent = (PendingIntent) response.getParcelable(Constants.BILLING_RESPONSE_PURCHASE_INTENT);
            if (pendingIntent == null) {
                Logger.error((Object) this, "Error with requestPurchase");
                return Constants.BILLING_RESPONSE_INVALID_REQUEST_ID;
            }
            ResponseHandler.buyPageIntentResponse(pendingIntent, new Intent());
            return response.getLong(Constants.BILLING_RESPONSE_REQUEST_ID, Constants.BILLING_RESPONSE_INVALID_REQUEST_ID);
        }

        protected void responseCodeReceived(ResponseCode responseCode) {
            ResponseHandler.responseCodeReceived(this, responseCode);
        }
    }

    public class RestoreTransactions extends BillingRequest {
        long mNonce;

        public /* bridge */ /* synthetic */ int getStartId() {
            return super.getStartId();
        }

        public /* bridge */ /* synthetic */ boolean runIfConnected() {
            return super.runIfConnected();
        }

        public /* bridge */ /* synthetic */ boolean runRequest() {
            return super.runRequest();
        }

        public RestoreTransactions() {
            super(-1);
        }

        protected long run() throws RemoteException {
            this.mNonce = Security.generateNonce();
            Bundle request = makeRequestBundle(Constants.RESTORE_TRANSACTIONS);
            request.putLong(Constants.BILLING_REQUEST_NONCE, this.mNonce);
            Bundle response = BillingService.mService.sendBillingRequest(request);
            logResponseCode("restoreTransactions", response);
            return response.getLong(Constants.BILLING_RESPONSE_REQUEST_ID, Constants.BILLING_RESPONSE_INVALID_REQUEST_ID);
        }

        protected void onRemoteException(RemoteException e) {
            super.onRemoteException(e);
            Security.removeNonce(this.mNonce);
        }

        protected void responseCodeReceived(ResponseCode responseCode) {
            ResponseHandler.responseCodeReceived(this, responseCode);
        }
    }

    public void setContext(Context context) {
        attachBaseContext(context);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int startId) {
        handleCommand(intent, startId);
    }

    public void handleCommand(Intent intent, int startId) {
        if (intent == null) {
            Logger.error((Object) this, "BillingService:handleCommand. Intent is null");
            return;
        }
        String action = intent.getAction();
        if (BillingHelper.debugging) {
            Logger.debug(this, "handleCommand() action: " + action);
        }
        if (Constants.ACTION_CONFIRM_NOTIFICATION.equals(action)) {
            confirmNotifications(startId, intent.getStringArrayExtra(Constants.NOTIFICATION_ID));
        } else if (Constants.ACTION_GET_PURCHASE_INFORMATION.equals(action)) {
            String notifyId = intent.getStringExtra(Constants.NOTIFICATION_ID);
            getPurchaseInformation(startId, new String[]{notifyId});
        } else if (Constants.ACTION_PURCHASE_STATE_CHANGED.equals(action)) {
            purchaseStateChanged(startId, intent.getStringExtra(Constants.INAPP_SIGNED_DATA), intent.getStringExtra(Constants.INAPP_SIGNATURE));
        } else if (Constants.ACTION_RESPONSE_CODE.equals(action)) {
            checkResponseCode(intent.getLongExtra(Constants.INAPP_REQUEST_ID, -1), ResponseCode.valueOf(intent.getIntExtra(Constants.INAPP_RESPONSE_CODE, ResponseCode.RESULT_ERROR.ordinal())));
        }
    }

    private boolean bindToMarketBillingService() {
        try {
            if (!this.bindingService && mService == null) {
                this.bindingService = true;
                if (BillingHelper.debugging) {
                    Logger.debug(this, "binding to Market billing service");
                }
                if (bindService(new Intent(Constants.MARKET_BILLING_SERVICE_ACTION), this, 1)) {
                    return true;
                }
                this.bindingService = false;
                Logger.error((Object) this, "Could not bind to service.");
                return false;
            } else if (!BillingHelper.debugging) {
                return true;
            } else {
                Logger.debug(this, "already binding/bound to Market billing service");
                return true;
            }
        } catch (SecurityException e) {
            Logger.error((Object) this, "Security exception: " + e);
        }
    }

    public boolean checkBillingSupported() {
        return checkBillingSupported(Constants.ITEM_TYPE_INAPP);
    }

    public boolean checkBillingSupported(String itemType) {
        return new CheckBillingSupported(itemType).runRequest();
    }

    public boolean requestPurchase(String productId, String itemType, String developerPayload) {
        return new RequestPurchase(productId, itemType, developerPayload).runRequest();
    }

    public boolean restoreTransactions() {
        return new RestoreTransactions().runRequest();
    }

    private boolean confirmNotifications(int startId, String[] notifyIds) {
        return new ConfirmNotifications(startId, notifyIds).runRequest();
    }

    private boolean getPurchaseInformation(int startId, String[] notifyIds) {
        return new GetPurchaseInformation(startId, notifyIds).runRequest();
    }

    private void purchaseStateChanged(int startId, String signedData, String signature) {
        ArrayList<VerifiedPurchase> purchases = Security.verifyPurchase(this, signedData, signature);
        if (purchases != null) {
            ArrayList<String> notifyList = new ArrayList();
            Iterator i$ = purchases.iterator();
            while (i$.hasNext()) {
                VerifiedPurchase vp = (VerifiedPurchase) i$.next();
                if (vp.notificationId != null) {
                    notifyList.add(vp.notificationId);
                }
                ResponseHandler.purchaseResponse(vp.purchaseState, vp.productId, vp.orderId, vp.purchaseTime, vp.developerPayload);
            }
            if (!notifyList.isEmpty()) {
                confirmNotifications(startId, (String[]) notifyList.toArray(new String[notifyList.size()]));
            }
        } else if (BillingHelper.debugging) {
            Logger.debug(this, "purchaseStateChanged:Purchase not verified");
        }
    }

    private void checkResponseCode(long requestId, ResponseCode responseCode) {
        BillingRequest request = (BillingRequest) mSentRequests.get(Long.valueOf(requestId));
        if (request != null) {
            if (BillingHelper.debugging) {
                Logger.debug(this, request.getClass().getSimpleName() + ": " + responseCode);
            }
            request.responseCodeReceived(responseCode);
        }
        mSentRequests.remove(Long.valueOf(requestId));
    }

    private void runPendingRequests() {
        int maxStartId = -1;
        while (true) {
            BillingRequest request = (BillingRequest) mPendingRequests.peek();
            if (request == null) {
                break;
            } else if (request.runIfConnected()) {
                mPendingRequests.remove();
                if (maxStartId < request.getStartId()) {
                    maxStartId = request.getStartId();
                }
            } else {
                bindToMarketBillingService();
                return;
            }
        }
        if (maxStartId >= 0) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "stopping service, startId: " + maxStartId);
            }
            stopSelf(maxStartId);
        }
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        if (BillingHelper.debugging) {
            Logger.debug(this, "Billing service connected");
        }
        this.bindingService = false;
        mService = Stub.asInterface(service);
        runPendingRequests();
    }

    public void onServiceDisconnected(ComponentName name) {
        if (BillingHelper.debugging) {
            Logger.debug(this, "Billing service disconnected");
        }
        mService = null;
        this.bindingService = false;
    }

    public void unbind() {
        try {
            unbindService(this);
        } catch (IllegalArgumentException e) {
        }
    }
}
