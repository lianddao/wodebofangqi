package com.songbirdnest.billing.db;

import com.songbirdnest.billing.PurchaseState;

public class Order {
    protected String developerPayload;
    protected long id;
    protected String orderId;
    protected String productId;
    protected long purchaseTime;
    protected PurchaseState state = PurchaseState.NONE;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeveloperPayload() {
        return this.developerPayload;
    }

    public void setDeveloperPayload(String developerPayload) {
        this.developerPayload = developerPayload;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getPurchaseTime() {
        return this.purchaseTime;
    }

    public void setPurchaseTime(long purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public PurchaseState getState() {
        return this.state;
    }

    public void setState(PurchaseState state) {
        this.state = state;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        if (this.id != order.id) {
            return false;
        }
        if (this.purchaseTime != order.purchaseTime) {
            return false;
        }
        if (this.developerPayload == null ? order.developerPayload != null : !this.developerPayload.equals(order.developerPayload)) {
            return false;
        }
        if (this.orderId == null ? order.orderId != null : !this.orderId.equals(order.orderId)) {
            return false;
        }
        if (this.productId == null ? order.productId != null : !this.productId.equals(order.productId)) {
            return false;
        }
        if (this.state != order.state) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = ((((int) (this.id ^ (this.id >>> 32))) * 31) + (this.orderId != null ? this.orderId.hashCode() : 0)) * 31;
        if (this.productId != null) {
            hashCode = this.productId.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode2 + hashCode) * 31;
        if (this.state != null) {
            hashCode = this.state.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (((hashCode2 + hashCode) * 31) + ((int) (this.purchaseTime ^ (this.purchaseTime >>> 32)))) * 31;
        if (this.developerPayload != null) {
            i = this.developerPayload.hashCode();
        }
        return hashCode + i;
    }
}
