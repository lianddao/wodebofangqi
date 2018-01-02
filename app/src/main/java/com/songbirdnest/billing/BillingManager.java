package com.songbirdnest.billing;

import android.content.Context;
import android.os.Handler;
import com.songbirdnest.billing.db.Purchase;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.util.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillingManager {
    private static BillingManager singleton = new BillingManager();
    private BillingListener billingListener;
    private Context context;
    private BillingHelper helper;
    private Map<String, Boolean> purchasedItems = new HashMap();

    class BillingHandler implements BillingListener {
        BillingHandler() {
        }

        public void onPurchased(String productId, boolean purchased) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "BillingManager.BillingHandler:onPurchased productId " + productId + " purchased " + purchased);
            }
            BillingManager.this.purchasedItems.put(productId, Boolean.valueOf(purchased));
        }

        public void onRestoreTransactions(ResponseCode responseCode) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "BillingManager.BillingHandler:onRestoreTransactions responseCode " + responseCode);
            }
            switch (responseCode) {
                case RESULT_OK:
                    BillingManager.this.retrievePurchases();
                    return;
                default:
                    return;
            }
        }

        public void onBillingSupported(boolean supported) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "BillingManager.BillingHandler:onBillingSupported supported " + supported);
            }
            if (supported) {
                BillingManager.this.retrievePurchases();
            }
        }

        public void onError(ResponseCode responseCode) {
            Logger.error((Object) this, "BillingManager.BillingHandler:onError " + responseCode);
            switch (responseCode) {
                case RESULT_SERVICE_UNAVAILABLE:
                case RESULT_BILLING_UNAVAILABLE:
                    Utils.showLongToast(BillingManager.this.context, BillingManager.this.context.getString(C0116R.string.purchaseBillingUnavailable));
                    return;
                case RESULT_ITEM_UNAVAILABLE:
                    Utils.showLongToast(BillingManager.this.context, BillingManager.this.context.getString(C0116R.string.purchaseProductNotFound));
                    return;
                default:
                    Utils.showLongToast(BillingManager.this.context, BillingManager.this.context.getString(C0116R.string.purchaseError1));
                    return;
            }
        }
    }

    public static BillingManager getBillingManager() {
        return singleton;
    }

    private BillingManager() {
    }

    public void start(Context context) {
        this.context = context;
        if (this.helper == null) {
            this.helper = new BillingHelper(context, new Handler());
            this.helper.addBillingListener(new BillingHandler());
            if (this.billingListener != null) {
                this.helper.addBillingListener(this.billingListener);
            }
            this.helper.start();
            retrievePurchases();
        }
    }

    public void stop() {
        if (this.helper != null) {
            this.helper.stop();
            this.helper.destroy();
            this.helper = null;
        }
    }

    public boolean isPurchased(String productId) {
        return this.purchasedItems.containsKey(productId) && ((Boolean) this.purchasedItems.get(productId)).booleanValue();
    }

    public boolean isBillingAvailable() {
        if (BillingHelper.debugging) {
            Logger.debug(this, "Google Billing is " + (this.helper.isGoogleBillingAvailable() ? "available" : "unavailable"));
            Logger.debug(this, "Amazon Billing is " + (this.helper.isAmazonAvailable() ? "available" : "unavailable"));
        }
        return this.helper.isGoogleBillingAvailable() || this.helper.isAmazonAvailable();
    }

    public void addBillingListener(BillingListener listener) {
        this.billingListener = listener;
        if (this.helper != null) {
            this.helper.addBillingListener(listener);
        }
    }

    public void removeBillingListener(BillingListener listener) {
        if (this.helper != null) {
            this.helper.removeBillingListener(listener);
        }
        this.billingListener = null;
    }

    public void purchase(InAppPurchases purchase) {
        this.helper.purchase(purchase);
    }

    public boolean isEQAvailable() {
        if (!this.helper.isPurchased(InAppPurchases.EQUALIZER)) {
            return false;
        }
        if (BillingHelper.debugging) {
            Logger.debug(this, "isEQAvailable: Equalizer Purchased");
        }
        return true;
    }

    private void retrievePurchases() {
        List<Purchase> purchases = this.helper.getPurchases();
        if (BillingHelper.debugging) {
            Logger.debug(this, "retrievePurchases: Found " + purchases.size() + " purchases");
        }
        for (Purchase purchase : purchases) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "BillingManager:retrievePurchases Purchase " + purchase.getProductId() + " with quantity " + purchase.getQuantity());
            }
            this.purchasedItems.put(purchase.getProductId(), Boolean.valueOf(true));
        }
    }
}
