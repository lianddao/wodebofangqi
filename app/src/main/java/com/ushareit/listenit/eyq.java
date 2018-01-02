package com.ushareit.listenit;

public class eyq extends Exception {
    private int f11682a;

    public eyq(int i, String str) {
        super(str);
        this.f11682a = i;
    }

    public eyq(int i, Throwable th) {
        super(th);
        this.f11682a = i;
    }

    public int mo2345a() {
        return this.f11682a;
    }

    public String toString() {
        return getClass().getName() + ": " + "[ code = " + this.f11682a + ", msg = " + getLocalizedMessage() + "]";
    }
}
