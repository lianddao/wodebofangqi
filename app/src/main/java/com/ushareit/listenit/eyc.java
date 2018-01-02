package com.ushareit.listenit;

public final class eyc {
    private long f12156a;
    private long f12157b;

    public eyc m18467a() {
        this.f12156a = System.nanoTime();
        this.f12157b = this.f12156a;
        return this;
    }

    public long m18468b() {
        long nanoTime = System.nanoTime();
        long j = nanoTime - this.f12157b;
        this.f12157b = nanoTime;
        return j;
    }

    public long m18469c() {
        return System.nanoTime() - this.f12156a;
    }
}
