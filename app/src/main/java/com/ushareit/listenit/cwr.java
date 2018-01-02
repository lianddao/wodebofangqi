package com.ushareit.listenit;

import java.util.Collections;
import java.util.Iterator;

public class cwr extends cwf implements cxa {
    private static final cwr f9281c = new cwr();

    private cwr() {
    }

    public static cwr m13215j() {
        return f9281c;
    }

    public int mo1652a(cxa com_ushareit_listenit_cxa) {
        return com_ushareit_listenit_cxa.mo1635b() ? 0 : -1;
    }

    public cxa mo1629a(cqq com_ushareit_listenit_cqq) {
        return this;
    }

    public cxa mo1630a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        if (com_ushareit_listenit_cqq.m12347h()) {
            return com_ushareit_listenit_cxa;
        }
        cwc d = com_ushareit_listenit_cqq.m12343d();
        return mo1631a(d, mo1637c(d).mo1630a(com_ushareit_listenit_cqq.m12344e(), com_ushareit_listenit_cxa));
    }

    public cxa mo1631a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        return (com_ushareit_listenit_cxa.mo1635b() || com_ushareit_listenit_cwc.m13145e()) ? this : new cwf().mo1631a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa);
    }

    public Object mo1643a() {
        return null;
    }

    public Object mo1632a(boolean z) {
        return null;
    }

    public String mo1644a(cxc com_ushareit_listenit_cxc) {
        return "";
    }

    public boolean mo1633a(cwc com_ushareit_listenit_cwc) {
        return false;
    }

    public cwc mo1634b(cwc com_ushareit_listenit_cwc) {
        return null;
    }

    public /* synthetic */ cxa mo1645b(cxa com_ushareit_listenit_cxa) {
        return m13228c(com_ushareit_listenit_cxa);
    }

    public boolean mo1635b() {
        return true;
    }

    public int mo1636c() {
        return 0;
    }

    public cwr m13228c(cxa com_ushareit_listenit_cxa) {
        return this;
    }

    public cxa mo1637c(cwc com_ushareit_listenit_cwc) {
        return this;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return mo1652a((cxa) obj);
    }

    public String mo1638d() {
        return "";
    }

    public boolean mo1639e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof cwr) {
            return true;
        }
        boolean z = (obj instanceof cxa) && ((cxa) obj).mo1635b() && mo1640f().equals(((cxa) obj).mo1640f());
        return z;
    }

    public cxa mo1640f() {
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public Iterator<cwz> mo1641i() {
        return Collections.emptyList().iterator();
    }

    public Iterator<cwz> iterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        return "<Empty Node>";
    }
}
