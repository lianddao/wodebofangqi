package com.ushareit.listenit;

import java.io.IOException;

public final class bfi extends Exception {
    public final int f6054a;
    public final int f6055b;

    public static bfi m8024a(Exception exception, int i) {
        return new bfi(1, null, exception, i);
    }

    public static bfi m8023a(IOException iOException) {
        return new bfi(0, null, iOException, -1);
    }

    static bfi m8025a(RuntimeException runtimeException) {
        return new bfi(2, null, runtimeException, -1);
    }

    private bfi(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.f6054a = i;
        this.f6055b = i2;
    }
}
