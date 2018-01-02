package com.ushareit.listenit;

import java.util.concurrent.Callable;

class aus implements Callable<Void> {
    private final int[] f5530a;
    private final int f5531b;
    private final int f5532c;
    private final int f5533d;
    private final int f5534e;
    private final int f5535f;
    private final int f5536g;

    public aus(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        this.f5530a = iArr;
        this.f5531b = i;
        this.f5532c = i2;
        this.f5533d = i3;
        this.f5534e = i4;
        this.f5535f = i5;
        this.f5536g = i6;
    }

    public Void m7224a() {
        aur.m7222b(this.f5530a, this.f5531b, this.f5532c, this.f5533d, this.f5534e, this.f5535f, this.f5536g);
        return null;
    }

    public /* synthetic */ Object call() {
        return m7224a();
    }
}
