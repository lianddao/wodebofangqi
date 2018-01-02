package com.ushareit.listenit;

import java.util.Comparator;

public abstract class cws implements Comparator<cwz> {
    public static cws m13234a(String str) {
        if (str.equals(".value")) {
            return cxk.m13299d();
        }
        if (str.equals(".key")) {
            return cwu.m13253d();
        }
        if (!str.equals(".priority")) {
            return new cxe(new cqq(str));
        }
        throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
    }

    public int m13235a(cwz com_ushareit_listenit_cwz, cwz com_ushareit_listenit_cwz2, boolean z) {
        return z ? compare(com_ushareit_listenit_cwz2, com_ushareit_listenit_cwz) : compare(com_ushareit_listenit_cwz, com_ushareit_listenit_cwz2);
    }

    public cwz m13236a() {
        return cwz.m13265a();
    }

    public abstract cwz mo1658a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa);

    public abstract boolean mo1659a(cxa com_ushareit_listenit_cxa);

    public boolean m13239a(cxa com_ushareit_listenit_cxa, cxa com_ushareit_listenit_cxa2) {
        return compare(new cwz(cwc.m13138a(), com_ushareit_listenit_cxa), new cwz(cwc.m13138a(), com_ushareit_listenit_cxa2)) != 0;
    }

    public abstract cwz mo1660b();

    public abstract String mo1661c();
}
