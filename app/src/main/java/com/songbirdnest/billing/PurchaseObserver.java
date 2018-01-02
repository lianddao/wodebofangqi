package com.songbirdnest.billing;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Handler;
import com.songbirdnest.billing.BillingService.RequestPurchase;
import com.songbirdnest.billing.BillingService.RestoreTransactions;
import com.songbirdnest.util.Logger;
import java.lang.reflect.Method;

public abstract class PurchaseObserver {
    private static final Class[] START_INTENT_SENDER_SIG = new Class[]{IntentSender.class, Intent.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};
    private final Context context;
    private final Handler mHandler;
    private Method mStartIntentSender;
    private Object[] mStartIntentSenderArgs = new Object[5];

    public abstract void onBillingSupported(boolean z, String str);

    public abstract void onPurchaseStateChange(PurchaseState purchaseState, String str, int i, long j, String str2);

    public abstract void onRequestPurchaseResponse(RequestPurchase requestPurchase, ResponseCode responseCode);

    public abstract void onRestoreTransactionsResponse(RestoreTransactions restoreTransactions, ResponseCode responseCode);

    public PurchaseObserver(Context activity, Handler handler) {
        this.context = activity;
        this.mHandler = handler;
        initCompatibilityLayer();
    }

    private void initCompatibilityLayer() {
        try {
            this.mStartIntentSender = this.context.getClass().getMethod("startIntentSender", START_INTENT_SENDER_SIG);
        } catch (SecurityException e) {
            this.mStartIntentSender = null;
        } catch (NoSuchMethodException e2) {
            this.mStartIntentSender = null;
        }
    }

    void startBuyPageActivity(PendingIntent pendingIntent, Intent intent) {
        if (this.mStartIntentSender != null) {
            try {
                this.mStartIntentSenderArgs[0] = pendingIntent.getIntentSender();
                this.mStartIntentSenderArgs[1] = intent;
                this.mStartIntentSenderArgs[2] = Integer.valueOf(0);
                this.mStartIntentSenderArgs[3] = Integer.valueOf(0);
                this.mStartIntentSenderArgs[4] = Integer.valueOf(0);
                this.mStartIntentSender.invoke(this.context, this.mStartIntentSenderArgs);
                return;
            } catch (Exception e) {
                Logger.error(this, "error starting activity", e);
                return;
            }
        }
        try {
            pendingIntent.send(this.context, 0, intent);
        } catch (CanceledException e2) {
            Logger.error(this, "error starting activity", e2);
        }
    }

    void postPurchaseStateChange(PurchaseState purchaseState, String productId, int quantity, long purchaseTime, String developerPayload) {
        final PurchaseState purchaseState2 = purchaseState;
        final String str = productId;
        final int i = quantity;
        final long j = purchaseTime;
        final String str2 = developerPayload;
        this.mHandler.post(new Runnable() {
            public void run() {
                PurchaseObserver.this.onPurchaseStateChange(purchaseState2, str, i, j, str2);
            }
        });
    }
}
