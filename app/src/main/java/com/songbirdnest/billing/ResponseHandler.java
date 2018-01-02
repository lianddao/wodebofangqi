package com.songbirdnest.billing;

import com.songbirdnest.billing.BillingService.RequestPurchase;
import com.songbirdnest.billing.BillingService.RestoreTransactions;
import com.songbirdnest.util.Logger;

public class ResponseHandler {
    private static BillingHelper helper;
    private static PurchaseObserver sPurchaseObserver;

    public static void register(BillingHelper helper, PurchaseObserver observer) {
        helper = helper;
        synchronized (ResponseHandler.class) {
            sPurchaseObserver = observer;
        }
    }

    public static void unregister(PurchaseObserver observer) {
        synchronized (ResponseHandler.class) {
            sPurchaseObserver = null;
        }
    }

    public static void checkBillingSupportedResponse(boolean supported, String type) {
        if (sPurchaseObserver != null) {
            sPurchaseObserver.onBillingSupported(supported, type);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void buyPageIntentResponse(android.app.PendingIntent r3, android.content.Intent r4) {
        /*
        r1 = com.songbirdnest.billing.ResponseHandler.class;
        monitor-enter(r1);
        r0 = sPurchaseObserver;	 Catch:{ all -> 0x001b }
        if (r0 != 0) goto L_0x0014;
    L_0x0007:
        r0 = com.songbirdnest.billing.BillingHelper.debugging;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0012;
    L_0x000b:
        r0 = com.songbirdnest.billing.ResponseHandler.class;
        r2 = "UI is not running";
        com.songbirdnest.util.Logger.debug(r0, r2);	 Catch:{ all -> 0x001b }
    L_0x0012:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
    L_0x0013:
        return;
    L_0x0014:
        r0 = sPurchaseObserver;	 Catch:{ all -> 0x001b }
        r0.startBuyPageActivity(r3, r4);	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0013;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.songbirdnest.billing.ResponseHandler.buyPageIntentResponse(android.app.PendingIntent, android.content.Intent):void");
    }

    public static void purchaseResponse(PurchaseState purchaseState, String productId, String orderId, long purchaseTime, String developerPayload) {
        int quantity = helper.updatePurchase(orderId, productId, purchaseState, purchaseTime, developerPayload);
        if (BillingHelper.debugging) {
            Logger.debug(ResponseHandler.class, "purchaseResponse: updated purchase to quantity " + quantity + " for order " + orderId + " product " + productId + " purchase State " + purchaseState);
        }
        synchronized (ResponseHandler.class) {
            if (sPurchaseObserver != null) {
                sPurchaseObserver.postPurchaseStateChange(purchaseState, productId, quantity, purchaseTime, developerPayload);
            }
        }
    }

    public static void responseCodeReceived(RequestPurchase request, ResponseCode responseCode) {
        synchronized (ResponseHandler.class) {
            if (sPurchaseObserver != null) {
                sPurchaseObserver.onRequestPurchaseResponse(request, responseCode);
            }
        }
    }

    public static void responseCodeReceived(RestoreTransactions request, ResponseCode responseCode) {
        synchronized (ResponseHandler.class) {
            if (sPurchaseObserver != null) {
                sPurchaseObserver.onRestoreTransactionsResponse(request, responseCode);
            }
        }
    }
}
