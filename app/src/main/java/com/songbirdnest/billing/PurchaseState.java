package com.songbirdnest.billing;

public enum PurchaseState {
    PURCHASED,
    CANCELED,
    REFUNDED,
    NONE;

    public static PurchaseState valueOf(int index) {
        PurchaseState[] values = values();
        if (index < 0 || index >= values.length) {
            return CANCELED;
        }
        return values[index];
    }
}
