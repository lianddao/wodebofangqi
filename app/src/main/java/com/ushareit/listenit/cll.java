package com.ushareit.listenit;

final class cll extends cme<eau, cmk> {
    private String f8425n;
    private String f8426o;

    public cll(String str, String str2) {
        super(2);
        this.f8425n = cfi.m11083a(str, (Object) "email cannot be null or empty");
        this.f8426o = cfi.m11083a(str2, (Object) "password cannot be null or empty");
    }

    public void mo1394a() {
        this.e.mo1421d(this.f8425n, this.f8426o, this.b);
    }

    public void mo1395b() {
        ebj a = cld.m11538b(this.c, this.i);
        ((cmk) this.f).mo2133a(this.h, a);
        m11558b(new cmm(a));
    }
}
