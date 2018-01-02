package com.songbirdnest.billing;

import com.songbirdnest.billing.BillingService.Managed;

public enum InAppPurchases {
    EQUALIZER(Managed.MANAGED, "Equalizer", "com.songbirdnest.equalizer");
    
    protected Managed managedType;
    protected String name;
    protected String productId;

    private InAppPurchases(Managed managedType, String name, String productId) {
        this.managedType = managedType;
        this.name = name;
        this.productId = productId;
    }

    public Managed getManagedType() {
        return this.managedType;
    }

    public String getName() {
        return this.name;
    }

    public String getProductId() {
        return this.productId;
    }

    public String toString() {
        return "Name: " + this.name + " product: " + this.productId + " type: " + this.managedType;
    }
}
