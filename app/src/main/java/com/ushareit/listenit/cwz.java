package com.ushareit.listenit;

public class cwz {
    private static final cwz f9295c = new cwz(cwc.m13138a(), cwr.m13215j());
    private static final cwz f9296d = new cwz(cwc.m13140b(), cxa.f9244d);
    private final cwc f9297a;
    private final cxa f9298b;

    public cwz(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        this.f9297a = com_ushareit_listenit_cwc;
        this.f9298b = com_ushareit_listenit_cxa;
    }

    public static cwz m13265a() {
        return f9295c;
    }

    public static cwz m13266b() {
        return f9296d;
    }

    public cwc m13267c() {
        return this.f9297a;
    }

    public cxa m13268d() {
        return this.f9298b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cwz com_ushareit_listenit_cwz = (cwz) obj;
        return !this.f9297a.equals(com_ushareit_listenit_cwz.f9297a) ? false : this.f9298b.equals(com_ushareit_listenit_cwz.f9298b);
    }

    public int hashCode() {
        return (this.f9297a.hashCode() * 31) + this.f9298b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9297a);
        String valueOf2 = String.valueOf(this.f9298b);
        return new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append("NamedNode{name=").append(valueOf).append(", node=").append(valueOf2).append("}").toString();
    }
}
