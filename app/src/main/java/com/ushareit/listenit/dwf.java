package com.ushareit.listenit;

class dwf {
    private final cio f10468a;
    private long f10469b;

    public dwf(cio com_ushareit_listenit_cio) {
        cfi.m11080a((Object) com_ushareit_listenit_cio);
        this.f10468a = com_ushareit_listenit_cio;
    }

    public void m15885a() {
        this.f10469b = this.f10468a.mo1371b();
    }

    public boolean m15886a(long j) {
        return this.f10469b == 0 || this.f10468a.mo1371b() - this.f10469b >= j;
    }

    public void m15887b() {
        this.f10469b = 0;
    }
}
