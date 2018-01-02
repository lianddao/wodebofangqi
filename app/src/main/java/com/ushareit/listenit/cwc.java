package com.ushareit.listenit;

public class cwc implements Comparable<cwc> {
    static final /* synthetic */ boolean f9249a = (!cwc.class.desiredAssertionStatus());
    private static final cwc f9250c = new cwc("[MIN_KEY]");
    private static final cwc f9251d = new cwc("[MAX_KEY]");
    private static final cwc f9252e = new cwc(".priority");
    private static final cwc f9253f = new cwc(".info");
    private final String f9254b;

    private cwc(String str) {
        this.f9254b = str;
    }

    public static cwc m13138a() {
        return f9250c;
    }

    public static cwc m13139a(String str) {
        Integer d = cyr.m13391d(str);
        if (d != null) {
            return new cwe(str, d.intValue());
        }
        if (str.equals(".priority")) {
            return f9252e;
        }
        if (f9249a || !str.contains("/")) {
            return new cwc(str);
        }
        throw new AssertionError();
    }

    public static cwc m13140b() {
        return f9251d;
    }

    public static cwc m13142c() {
        return f9252e;
    }

    public int m13143a(cwc com_ushareit_listenit_cwc) {
        if (this == com_ushareit_listenit_cwc) {
            return 0;
        }
        if (this == f9250c || com_ushareit_listenit_cwc == f9251d) {
            return -1;
        }
        if (com_ushareit_listenit_cwc == f9250c || this == f9251d) {
            return 1;
        }
        if (!mo1648f()) {
            return com_ushareit_listenit_cwc.mo1648f() ? 1 : this.f9254b.compareTo(com_ushareit_listenit_cwc.f9254b);
        } else {
            if (!com_ushareit_listenit_cwc.mo1648f()) {
                return -1;
            }
            int a = cyr.m13382a(mo1649g(), com_ushareit_listenit_cwc.mo1649g());
            return a == 0 ? cyr.m13382a(this.f9254b.length(), com_ushareit_listenit_cwc.f9254b.length()) : a;
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m13143a((cwc) obj);
    }

    public String m13144d() {
        return this.f9254b;
    }

    public boolean m13145e() {
        return this == f9252e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cwc)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.f9254b.equals(((cwc) obj).f9254b);
    }

    protected boolean mo1648f() {
        return false;
    }

    protected int mo1649g() {
        return 0;
    }

    public int hashCode() {
        return this.f9254b.hashCode();
    }

    public String toString() {
        String str = this.f9254b;
        return new StringBuilder(String.valueOf(str).length() + 12).append("ChildKey(\"").append(str).append("\")").toString();
    }
}
