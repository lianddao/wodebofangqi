package com.ushareit.listenit;

public class cxk extends cws {
    private static final cxk f9310a = new cxk();

    private cxk() {
    }

    public static cxk m13299d() {
        return f9310a;
    }

    public int m13300a(cwz com_ushareit_listenit_cwz, cwz com_ushareit_listenit_cwz2) {
        int compareTo = com_ushareit_listenit_cwz.m13268d().compareTo(com_ushareit_listenit_cwz2.m13268d());
        return compareTo == 0 ? com_ushareit_listenit_cwz.m13267c().m13143a(com_ushareit_listenit_cwz2.m13267c()) : compareTo;
    }

    public cwz mo1658a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        return new cwz(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa);
    }

    public boolean mo1659a(cxa com_ushareit_listenit_cxa) {
        return true;
    }

    public cwz mo1660b() {
        return new cwz(cwc.m13140b(), cxa.f9244d);
    }

    public String mo1661c() {
        return ".value";
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m13300a((cwz) obj, (cwz) obj2);
    }

    public boolean equals(Object obj) {
        return obj instanceof cxk;
    }

    public int hashCode() {
        return 4;
    }

    public String toString() {
        return "ValueIndex";
    }
}
