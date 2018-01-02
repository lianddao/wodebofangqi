package com.ushareit.listenit;

public final class blr {
    private final int f6910a;
    private final int f6911b;
    private int f6912c;

    public blr(int i, int i2) {
        this.f6910a = i;
        this.f6911b = i2;
    }

    public int m8954a() {
        int i = this.f6910a;
        int i2 = this.f6911b;
        int i3 = this.f6912c;
        this.f6912c = i3 + 1;
        return i + (i2 * i3);
    }
}
