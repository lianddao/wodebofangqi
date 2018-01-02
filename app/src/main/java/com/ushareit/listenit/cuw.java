package com.ushareit.listenit;

public class cuw implements cux {
    private final cuy f9165a;
    private final cqh f9166b;
    private final ecb f9167c;
    private final String f9168d;

    public cuw(cuy com_ushareit_listenit_cuy, cqh com_ushareit_listenit_cqh, ecb com_ushareit_listenit_ecb, String str) {
        this.f9165a = com_ushareit_listenit_cuy;
        this.f9166b = com_ushareit_listenit_cqh;
        this.f9167c = com_ushareit_listenit_ecb;
        this.f9168d = str;
    }

    public cqq m12963a() {
        cqq c = this.f9167c.m16705c().m16729c();
        return this.f9165a == cuy.VALUE ? c : c.m12345f();
    }

    public void mo1612b() {
        this.f9166b.mo1583a(this);
    }

    public ecb m12965c() {
        return this.f9167c;
    }

    public String toString() {
        if (this.f9165a == cuy.VALUE) {
            String valueOf = String.valueOf(m12963a());
            String valueOf2 = String.valueOf(this.f9165a);
            String valueOf3 = String.valueOf(this.f9167c.m16702a(true));
            return new StringBuilder(((String.valueOf(valueOf).length() + 4) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(valueOf).append(": ").append(valueOf2).append(": ").append(valueOf3).toString();
        }
        valueOf = String.valueOf(m12963a());
        valueOf2 = String.valueOf(this.f9165a);
        valueOf3 = String.valueOf(this.f9167c.m16706d());
        String valueOf4 = String.valueOf(this.f9167c.m16702a(true));
        return new StringBuilder((((String.valueOf(valueOf).length() + 10) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append(valueOf).append(": ").append(valueOf2).append(": { ").append(valueOf3).append(": ").append(valueOf4).append(" }").toString();
    }
}
