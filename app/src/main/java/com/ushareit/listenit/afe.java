package com.ushareit.listenit;

public abstract class afe<Z> extends aey<Z> {
    private final int f4105a;
    private final int f4106b;

    public afe() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public afe(int i, int i2) {
        this.f4105a = i;
        this.f4106b = i2;
    }

    public final void mo581a(aff com_ushareit_listenit_aff) {
        if (afu.m5498a(this.f4105a, this.f4106b)) {
            com_ushareit_listenit_aff.mo596a(this.f4105a, this.f4106b);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f4105a + " and height: " + this.f4106b + ", either provide dimensions in the constructor" + " or call override()");
    }
}
