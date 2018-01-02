package com.ushareit.listenit;

public class cxf extends cws {
    private static final cxf f9303a = new cxf();

    private cxf() {
    }

    public static cxf m13282d() {
        return f9303a;
    }

    public int m13283a(cwz com_ushareit_listenit_cwz, cwz com_ushareit_listenit_cwz2) {
        return cxd.m13274a(com_ushareit_listenit_cwz.m13267c(), com_ushareit_listenit_cwz.m13268d().mo1640f(), com_ushareit_listenit_cwz2.m13267c(), com_ushareit_listenit_cwz2.m13268d().mo1640f());
    }

    public cwz mo1658a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        return new cwz(com_ushareit_listenit_cwc, new cxi("[PRIORITY-POST]", com_ushareit_listenit_cxa));
    }

    public boolean mo1659a(cxa com_ushareit_listenit_cxa) {
        return !com_ushareit_listenit_cxa.mo1640f().mo1635b();
    }

    public cwz mo1660b() {
        return mo1658a(cwc.m13140b(), cxa.f9244d);
    }

    public String mo1661c() {
        throw new IllegalArgumentException("Can't get query definition on priority index!");
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m13283a((cwz) obj, (cwz) obj2);
    }

    public boolean equals(Object obj) {
        return obj instanceof cxf;
    }

    public int hashCode() {
        return 3155577;
    }

    public String toString() {
        return "PriorityIndex";
    }
}
