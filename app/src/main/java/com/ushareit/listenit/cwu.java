package com.ushareit.listenit;

public class cwu extends cws {
    static final /* synthetic */ boolean f9286a = (!cwu.class.desiredAssertionStatus());
    private static final cwu f9287b = new cwu();

    private cwu() {
    }

    public static cwu m13253d() {
        return f9287b;
    }

    public int m13254a(cwz com_ushareit_listenit_cwz, cwz com_ushareit_listenit_cwz2) {
        return com_ushareit_listenit_cwz.m13267c().m13143a(com_ushareit_listenit_cwz2.m13267c());
    }

    public cwz mo1658a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        if (f9286a || (com_ushareit_listenit_cxa instanceof cxi)) {
            return new cwz(cwc.m13139a((String) com_ushareit_listenit_cxa.mo1643a()), cwr.m13215j());
        }
        throw new AssertionError();
    }

    public boolean mo1659a(cxa com_ushareit_listenit_cxa) {
        return true;
    }

    public cwz mo1660b() {
        return cwz.m13266b();
    }

    public String mo1661c() {
        return ".key";
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m13254a((cwz) obj, (cwz) obj2);
    }

    public boolean equals(Object obj) {
        return obj instanceof cwu;
    }

    public int hashCode() {
        return 37;
    }

    public String toString() {
        return "KeyIndex";
    }
}
