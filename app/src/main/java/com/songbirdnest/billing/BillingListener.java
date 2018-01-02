package com.songbirdnest.billing;

public interface BillingListener {
    void onBillingSupported(boolean z);

    void onError(ResponseCode responseCode);

    void onPurchased(String str, boolean z);

    void onRestoreTransactions(ResponseCode responseCode);
}
