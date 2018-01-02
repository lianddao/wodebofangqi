package com.ushareit.listenit;

import android.util.Pair;

public class eyn {
    public int f12193a = 0;
    private long f12194b = 0;
    private long f12195c = 0;
    private Object f12196d = null;
    private Object f12197e = null;

    public eyn(Object obj, boolean z, long j) {
        if (z) {
            this.f12197e = obj;
            this.f12193a = 0;
        } else {
            this.f12196d = obj;
            this.f12193a = 2;
            this.f12195c = System.currentTimeMillis();
        }
        this.f12194b = j;
    }

    public boolean m18556a() {
        return Math.abs(System.currentTimeMillis() - this.f12195c) > this.f12194b && this.f12193a != 1;
    }

    public void m18555a(Object obj) {
        this.f12196d = obj;
        this.f12193a = 2;
        this.f12195c = System.currentTimeMillis();
    }

    public Boolean m18557b() {
        return this.f12196d != null ? (Boolean) this.f12196d : (Boolean) this.f12197e;
    }

    public Object m18558c() {
        return this.f12196d != null ? this.f12196d : this.f12197e;
    }

    public Pair<Boolean, Boolean> m18559d() {
        return this.f12196d != null ? (Pair) this.f12196d : (Pair) this.f12197e;
    }
}
