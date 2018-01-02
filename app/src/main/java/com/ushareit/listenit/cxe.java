package com.ushareit.listenit;

public class cxe extends cws {
    private final cqq f9302a;

    public cxe(cqq com_ushareit_listenit_cqq) {
        if (com_ushareit_listenit_cqq.m12348i() == 1 && com_ushareit_listenit_cqq.m12343d().m13145e()) {
            throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
        }
        this.f9302a = com_ushareit_listenit_cqq;
    }

    public int m13277a(cwz com_ushareit_listenit_cwz, cwz com_ushareit_listenit_cwz2) {
        int compareTo = com_ushareit_listenit_cwz.m13268d().mo1629a(this.f9302a).compareTo(com_ushareit_listenit_cwz2.m13268d().mo1629a(this.f9302a));
        return compareTo == 0 ? com_ushareit_listenit_cwz.m13267c().m13143a(com_ushareit_listenit_cwz2.m13267c()) : compareTo;
    }

    public cwz mo1658a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        return new cwz(com_ushareit_listenit_cwc, cwr.m13215j().mo1630a(this.f9302a, com_ushareit_listenit_cxa));
    }

    public boolean mo1659a(cxa com_ushareit_listenit_cxa) {
        return !com_ushareit_listenit_cxa.mo1629a(this.f9302a).mo1635b();
    }

    public cwz mo1660b() {
        return new cwz(cwc.m13140b(), cwr.m13215j().mo1630a(this.f9302a, cxa.f9244d));
    }

    public String mo1661c() {
        return this.f9302a.m12339b();
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m13277a((cwz) obj, (cwz) obj2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f9302a.equals(((cxe) obj).f9302a);
    }

    public int hashCode() {
        return this.f9302a.hashCode();
    }
}
