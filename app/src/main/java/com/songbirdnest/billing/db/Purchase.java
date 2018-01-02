package com.songbirdnest.billing.db;

public class Purchase {
    protected long id;
    protected String productId;
    protected int quantity;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Purchase purchase = (Purchase) o;
        if (this.id != purchase.id) {
            return false;
        }
        if (this.quantity != purchase.quantity) {
            return false;
        }
        if (this.productId != null) {
            if (this.productId.equals(purchase.productId)) {
                return true;
            }
        } else if (purchase.productId == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((int) (this.id ^ (this.id >>> 32))) * 31) + (this.productId != null ? this.productId.hashCode() : 0)) * 31) + this.quantity;
    }
}
