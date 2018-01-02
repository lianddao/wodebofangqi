package com.ushareit.listenit;

import java.io.Serializable;

public class amx implements Serializable {
    private amy f4888a;
    private amy f4889b;

    public amx() {
        this(0.5d, 0.05d);
    }

    public amx(double d) {
        this(d, 0.05d);
    }

    public amx(double d, double d2) {
        this.f4888a = new amy(d);
        this.f4889b = new amy(d2);
        m6339a();
    }

    void m6339a() {
        this.f4888a.m6344a();
        this.f4889b.m6344a();
    }

    void m6340a(double d, double d2) {
        this.f4888a.m6345a(d, d2);
    }

    public amy m6341b() {
        return this.f4888a;
    }

    void m6342b(double d, double d2) {
        this.f4889b.m6345a(d, d2);
    }

    public amy m6343c() {
        return this.f4889b;
    }
}
