package com.ushareit.listenit;

public class cxg {
    public static cxa m13288a() {
        return cwr.m13215j();
    }

    public static cxa m13289a(Object obj) {
        cxa a = cxd.m13275a(obj);
        if (a instanceof cwy) {
            a = new cwq(Double.valueOf((double) ((Long) a.mo1643a()).longValue()), m13288a());
        }
        if (m13290a(a)) {
            return a;
        }
        throw new ecf("Invalid Firebase Database priority (must be a string, double, ServerValue, or null)");
    }

    public static boolean m13290a(cxa com_ushareit_listenit_cxa) {
        return com_ushareit_listenit_cxa.mo1640f().mo1635b() && (com_ushareit_listenit_cxa.mo1635b() || (com_ushareit_listenit_cxa instanceof cwq) || (com_ushareit_listenit_cxa instanceof cxi) || (com_ushareit_listenit_cxa instanceof cwp));
    }
}
