package com.ushareit.listenit;

public class ecn {
    private final crx f10836a;
    private final cqq f10837b;

    private ecn(crx com_ushareit_listenit_crx, cqq com_ushareit_listenit_cqq) {
        this.f10836a = com_ushareit_listenit_crx;
        this.f10837b = com_ushareit_listenit_cqq;
        cta.m12563a(this.f10837b, m16744b());
    }

    ecn(cxa com_ushareit_listenit_cxa) {
        this(new crx(com_ushareit_listenit_cxa), new cqq(""));
    }

    cxa m16743a() {
        return this.f10836a.m12460a(this.f10837b);
    }

    public Object m16744b() {
        return m16743a().mo1643a();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ecn) && this.f10836a.equals(((ecn) obj).f10836a) && this.f10837b.equals(((ecn) obj).f10837b);
    }

    public String toString() {
        cwc d = this.f10837b.m12343d();
        String d2 = d != null ? d.m13144d() : "<none>";
        String valueOf = String.valueOf(this.f10836a.m12459a().mo1632a(true));
        return new StringBuilder((String.valueOf(d2).length() + 32) + String.valueOf(valueOf).length()).append("MutableData { key = ").append(d2).append(", value = ").append(valueOf).append(" }").toString();
    }
}
