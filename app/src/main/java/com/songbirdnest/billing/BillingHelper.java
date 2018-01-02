package com.songbirdnest.billing;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import com.amazon.inapp.purchasing.Offset;
import com.amazon.inapp.purchasing.PurchasingManager;
import com.songbirdnest.billing.BillingService.RequestPurchase;
import com.songbirdnest.billing.BillingService.RestoreTransactions;
import com.songbirdnest.billing.amazon.AmazonPurchasingObserver;
import com.songbirdnest.billing.db.BillingDBHelper;
import com.songbirdnest.billing.db.Purchase;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BillingHelper {
    public static boolean debugging = false;
    private boolean amazonBillingAvailable = false;
    private boolean amazonBillingInitialized;
    private AmazonPurchasingObserver amazonPurchasingObserver;
    private final Context context;
    private InAppPurchases currentPurchasingItem;
    private BillingDBHelper dbHelper;
    private boolean googleBillingInitialized;
    private boolean googleBillingSupported = false;
    private List<BillingListener> listeners = new ArrayList();
    private BillingService mBillingService;
    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    private BillingPurchaseObserver observer;
    private List<Purchase> purchases;

    class C00881 implements Runnable {
        C00881() {
        }

        public void run() {
            BillingHelper.this.mBillingService.checkBillingSupported();
        }
    }

    class C00892 implements Runnable {
        C00892() {
        }

        public void run() {
            PurchasingManager.registerObserver(BillingHelper.this.amazonPurchasingObserver);
            if (BillingHelper.this.amazonBillingInitialized) {
                BillingHelper.this.fireBillingSupported(true);
                return;
            }
            BillingHelper.this.amazonBillingInitialized = true;
            Editor edit = BillingHelper.this.context.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
            edit.putBoolean(PrefKeys.sAmazon_Billing_initialized, true);
            edit.commit();
            PurchasingManager.initiatePurchaseUpdatesRequest(Offset.BEGINNING);
        }
    }

    class BillingPurchaseObserver extends PurchaseObserver {
        public BillingPurchaseObserver(Context activity, Handler handler) {
            super(activity, handler);
        }

        public void onBillingSupported(boolean supported, String type) {
            BillingHelper.this.googleBillingSupported = supported;
            Editor edit = BillingHelper.this.context.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
            edit.putBoolean(PrefKeys.sGoogle_Billing_supported, supported);
            edit.commit();
            if (BillingHelper.debugging) {
                Logger.debug(this, "BillingPurchaseObserver:onBillingSupported billing " + supported + " of type " + type);
            }
            if (!supported || BillingHelper.this.googleBillingInitialized) {
                if (BillingHelper.debugging) {
                    Logger.debug(this, "BillingPurchaseObserver:onBillingSupported Firing BillSupported");
                }
                BillingHelper.this.fireBillingSupported(supported);
                return;
            }
            if (BillingHelper.debugging) {
                Logger.debug(this, "BillingPurchaseObserver:onBillingSupported Restoring db");
            }
            BillingHelper.this.restoreDatabase();
        }

        public void onPurchaseStateChange(PurchaseState purchaseState, String productId, int quantity, long purchaseTime, String developerPayload) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "BillingPurchaseObserver:onPurchaseStateChange purchaseState " + purchaseState + " itemId " + productId + " quantity " + quantity + " purchaseTime " + purchaseTime + " developerPayload " + developerPayload);
            }
            BillingHelper.this.firePurchased(productId, purchaseState == PurchaseState.PURCHASED);
            BillingHelper.this.purchases = BillingHelper.this.getPurchases();
        }

        public void onRequestPurchaseResponse(RequestPurchase request, ResponseCode responseCode) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "BillingPurchaseObserver:onRequestPurchaseResponse responseCode " + responseCode);
            }
            switch (responseCode) {
                case RESULT_SERVICE_UNAVAILABLE:
                case RESULT_BILLING_UNAVAILABLE:
                case RESULT_ITEM_UNAVAILABLE:
                case RESULT_DEVELOPER_ERROR:
                case RESULT_ERROR:
                    BillingHelper.this.fireError(responseCode);
                    return;
                default:
                    return;
            }
        }

        public void onRestoreTransactionsResponse(RestoreTransactions request, ResponseCode responseCode) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "BillingPurchaseObserver:onRestoreTransactionsResponse responseCode " + responseCode);
            }
            switch (responseCode) {
                case RESULT_OK:
                    Editor edit = BillingHelper.this.context.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
                    edit.putBoolean(PrefKeys.sGoogle_Billing_initialized, true);
                    BillingHelper.this.googleBillingInitialized = true;
                    edit.commit();
                    break;
                default:
                    Logger.error((Object) this, "BillingPurchaseObserver:onRestoreTransactionsResponse responseCode " + responseCode);
                    break;
            }
            BillingHelper.this.fireRestoreTransactions(responseCode);
        }
    }

    public BillingHelper(Context pContext, Handler pHandler) {
        this.context = pContext;
        SharedPreferences prefs = pContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
        this.googleBillingInitialized = prefs.getBoolean(PrefKeys.sGoogle_Billing_initialized, false);
        this.googleBillingSupported = prefs.getBoolean(PrefKeys.sGoogle_Billing_supported, false);
        this.amazonBillingInitialized = prefs.getBoolean(PrefKeys.sAmazon_Billing_initialized, false);
        this.dbHelper = new BillingDBHelper(pContext);
        this.observer = new BillingPurchaseObserver(pContext, pHandler);
        ResponseHandler.register(this, this.observer);
        this.mBillingService = new BillingService();
        this.mBillingService.setContext(pContext);
        this.amazonPurchasingObserver = new AmazonPurchasingObserver(this.context, this);
        findAmazon();
        if (debugging) {
            Logger.debug(this, "Amazon App store is " + (this.amazonBillingAvailable ? "available" : "not available"));
        }
    }

    public void findAmazon() {
        String amazonAppClass = "com.amazon.venezia";
        List<ApplicationInfo> installedApplications = this.context.getPackageManager().getInstalledApplications(0);
        for (int i = 0; i < installedApplications.size(); i++) {
            if (amazonAppClass.equalsIgnoreCase(((ApplicationInfo) installedApplications.get(i)).packageName)) {
                this.amazonBillingAvailable = true;
            }
        }
    }

    public static boolean isBillingAvailable(Context context, InAppPurchases purchase) {
        SharedPreferences prefs = context.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
        boolean googleBillingInitialized = prefs.getBoolean(PrefKeys.sGoogle_Billing_initialized, false);
        boolean googleBillingSupported = prefs.getBoolean(PrefKeys.sGoogle_Billing_supported, false);
        boolean amazonBillingInitialized = prefs.getBoolean(PrefKeys.sAmazon_Billing_initialized, false);
        if ((!googleBillingInitialized || !googleBillingSupported) && !amazonBillingInitialized) {
            return false;
        }
        if (googleBillingInitialized && googleBillingSupported && debugging) {
            Logger.debug(BillingHelper.class, "isBillingAvailable: googleBillingInitialized is initialized googleBillingSupported is supported");
        }
        if (amazonBillingInitialized && debugging) {
            Logger.debug(BillingHelper.class, "isBillingAvailable: amazonBillingInitialized is initialized");
        }
        BillingDBHelper dbHelper = new BillingDBHelper(context);
        boolean result = dbHelper.purchaseExists(purchase);
        dbHelper.close();
        if (!result) {
            return false;
        }
        if (debugging) {
            Logger.debug(BillingHelper.class, "isBillingAvailable: EQ is purchased");
        }
        return true;
    }

    public boolean isAmazonAvailable() {
        return this.amazonBillingAvailable;
    }

    public void addBillingListener(BillingListener listener) {
        this.listeners.add(listener);
    }

    public void removeBillingListener(BillingListener listener) {
        this.listeners.remove(listener);
    }

    public void firePurchased(String productId, boolean purchased) {
        if (debugging) {
            Logger.debug(this, "firePurchased");
        }
        for (BillingListener billingListener : this.listeners) {
            billingListener.onPurchased(productId, purchased);
        }
    }

    public void fireRestoreTransactions(ResponseCode responseCode) {
        if (debugging) {
            Logger.debug(this, "fireRestoreTransactions");
        }
        for (BillingListener billingListener : this.listeners) {
            billingListener.onRestoreTransactions(responseCode);
        }
    }

    public void fireBillingSupported(boolean supported) {
        if (debugging) {
            Logger.debug(this, "fireBillingSupported");
        }
        this.purchases = getPurchases();
        for (BillingListener billingListener : this.listeners) {
            billingListener.onBillingSupported(supported);
        }
    }

    public void fireError(ResponseCode responseCode) {
        if (debugging) {
            Logger.debug(this, "fireError: " + responseCode);
        }
        for (BillingListener billingListener : this.listeners) {
            billingListener.onError(responseCode);
        }
    }

    public void start() {
        ResponseHandler.register(this, this.observer);
        if (!this.googleBillingSupported || !this.googleBillingInitialized) {
            if (debugging) {
                Logger.debug(this, "BillingHelper:googleBillingSupported " + this.googleBillingSupported + " googleBillingInitialized " + this.googleBillingInitialized);
            }
            this.mExecutor.execute(new C00881());
        } else if (this.googleBillingSupported) {
            if (debugging) {
                Logger.debug(this, "BillingHelper:googleBillingSupported ");
            }
            fireBillingSupported(true);
        }
        if (this.amazonBillingAvailable) {
            this.mExecutor.execute(new C00892());
        }
    }

    public void stop() {
        ResponseHandler.unregister(this.observer);
    }

    public void destroy() {
        this.mBillingService.unbind();
        if (!this.mExecutor.isShutdown() || !this.mExecutor.isTerminated()) {
            this.mExecutor.shutdown();
        }
    }

    public List<Purchase> getPurchases() {
        if (debugging) {
            Logger.debug(this, "getPurchases");
        }
        if (this.purchases == null || this.purchases.size() == 0) {
            this.purchases = this.dbHelper.getPurchases();
            if (debugging) {
                Logger.debug(this, "getPurchases: Found " + this.purchases.size() + " purchases");
            }
            this.dbHelper.close();
        }
        return this.purchases;
    }

    public boolean purchaseExists(InAppPurchases purchase) {
        boolean result = this.dbHelper.purchaseExists(purchase);
        this.dbHelper.close();
        return result;
    }

    private void restoreDatabase() {
        if (this.googleBillingSupported) {
            this.mBillingService.restoreTransactions();
        }
    }

    public boolean isPurchased(InAppPurchases inAppPurchase) {
        if (debugging) {
            Logger.debug(this, "isPurchased: Testing " + inAppPurchase + this.purchases.size() + " purchases");
        }
        for (Purchase purchase : this.purchases) {
            if (purchase.getProductId().equalsIgnoreCase(inAppPurchase.productId)) {
                return true;
            }
        }
        return false;
    }

    public boolean isGoogleBillingAvailable() {
        return this.googleBillingSupported;
    }

    public int updatePurchase(String orderId, String productId, PurchaseState purchaseState, long purchaseTime, String developerPayload) {
        int result = this.dbHelper.updatePurchase(orderId, productId, purchaseState, purchaseTime, developerPayload);
        this.dbHelper.close();
        return result;
    }

    public void purchase(InAppPurchases purchase) {
        this.currentPurchasingItem = purchase;
        if (this.googleBillingSupported) {
            if (debugging) {
                Logger.debug(this, "BillingHelper:purchase Starting purchase in Google Play ");
            }
            this.mBillingService.requestPurchase(purchase.productId, Constants.ITEM_TYPE_INAPP, null);
        } else if (this.amazonBillingAvailable) {
            if (debugging) {
                Logger.debug(this, "BillingHelper:purchase Starting purchase in Amazon Appstore ");
            }
            PurchasingManager.initiatePurchaseRequest(purchase.productId);
        }
    }

    public InAppPurchases getCurrentPurchasingItem() {
        return this.currentPurchasingItem;
    }
}
