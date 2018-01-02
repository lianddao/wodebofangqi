package com.ushareit.listenit;

import java.math.BigDecimal;

public final class dcr extends Number {
    private final String f9550a;

    public dcr(String str) {
        this.f9550a = str;
    }

    public double doubleValue() {
        return Double.parseDouble(this.f9550a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dcr)) {
            return false;
        }
        dcr com_ushareit_listenit_dcr = (dcr) obj;
        return this.f9550a == com_ushareit_listenit_dcr.f9550a || this.f9550a.equals(com_ushareit_listenit_dcr.f9550a);
    }

    public float floatValue() {
        return Float.parseFloat(this.f9550a);
    }

    public int hashCode() {
        return this.f9550a.hashCode();
    }

    public int intValue() {
        try {
            return Integer.parseInt(this.f9550a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f9550a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f9550a).intValue();
            }
        }
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f9550a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f9550a).longValue();
        }
    }

    public String toString() {
        return this.f9550a;
    }
}
