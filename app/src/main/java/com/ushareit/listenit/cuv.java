package com.ushareit.listenit;

public class cuv {
    private final cuy f9160a;
    private final cwt f9161b;
    private final cwt f9162c;
    private final cwc f9163d;
    private final cwc f9164e;

    private cuv(cuy com_ushareit_listenit_cuy, cwt com_ushareit_listenit_cwt, cwc com_ushareit_listenit_cwc, cwc com_ushareit_listenit_cwc2, cwt com_ushareit_listenit_cwt2) {
        this.f9160a = com_ushareit_listenit_cuy;
        this.f9161b = com_ushareit_listenit_cwt;
        this.f9163d = com_ushareit_listenit_cwc;
        this.f9164e = com_ushareit_listenit_cwc2;
        this.f9162c = com_ushareit_listenit_cwt2;
    }

    public static cuv m12950a(cwc com_ushareit_listenit_cwc, cwt com_ushareit_listenit_cwt) {
        return new cuv(cuy.CHILD_ADDED, com_ushareit_listenit_cwt, com_ushareit_listenit_cwc, null, null);
    }

    public static cuv m12951a(cwc com_ushareit_listenit_cwc, cwt com_ushareit_listenit_cwt, cwt com_ushareit_listenit_cwt2) {
        return new cuv(cuy.CHILD_CHANGED, com_ushareit_listenit_cwt, com_ushareit_listenit_cwc, null, com_ushareit_listenit_cwt2);
    }

    public static cuv m12952a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        return m12950a(com_ushareit_listenit_cwc, cwt.m13242a(com_ushareit_listenit_cxa));
    }

    public static cuv m12953a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa, cxa com_ushareit_listenit_cxa2) {
        return m12951a(com_ushareit_listenit_cwc, cwt.m13242a(com_ushareit_listenit_cxa), cwt.m13242a(com_ushareit_listenit_cxa2));
    }

    public static cuv m12954a(cwt com_ushareit_listenit_cwt) {
        return new cuv(cuy.VALUE, com_ushareit_listenit_cwt, null, null, null);
    }

    public static cuv m12955b(cwc com_ushareit_listenit_cwc, cwt com_ushareit_listenit_cwt) {
        return new cuv(cuy.CHILD_REMOVED, com_ushareit_listenit_cwt, com_ushareit_listenit_cwc, null, null);
    }

    public static cuv m12956b(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        return m12955b(com_ushareit_listenit_cwc, cwt.m13242a(com_ushareit_listenit_cxa));
    }

    public static cuv m12957c(cwc com_ushareit_listenit_cwc, cwt com_ushareit_listenit_cwt) {
        return new cuv(cuy.CHILD_MOVED, com_ushareit_listenit_cwt, com_ushareit_listenit_cwc, null, null);
    }

    public cuv m12958a(cwc com_ushareit_listenit_cwc) {
        return new cuv(this.f9160a, this.f9161b, this.f9163d, com_ushareit_listenit_cwc, this.f9162c);
    }

    public cwc m12959a() {
        return this.f9163d;
    }

    public cuy m12960b() {
        return this.f9160a;
    }

    public cwt m12961c() {
        return this.f9161b;
    }

    public cwt m12962d() {
        return this.f9162c;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9160a);
        String valueOf2 = String.valueOf(this.f9163d);
        return new StringBuilder((String.valueOf(valueOf).length() + 9) + String.valueOf(valueOf2).length()).append("Change: ").append(valueOf).append(" ").append(valueOf2).toString();
    }
}
