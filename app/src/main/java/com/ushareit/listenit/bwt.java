package com.ushareit.listenit;

public class bwt {
    private static final Object f7922a = new Object();
    private static bwt f7923b;
    private final bza f7924c = new bza();
    private final bwj f7925d = new bwj(new bwe(), new bwd(), new bvp(), new die(), new bys(), new dkm(), new djm());

    static {
        m10269a(new bwt());
    }

    protected bwt() {
    }

    public static bza m10268a() {
        return m10271c().f7924c;
    }

    protected static void m10269a(bwt com_ushareit_listenit_bwt) {
        synchronized (f7922a) {
            f7923b = com_ushareit_listenit_bwt;
        }
    }

    public static bwj m10270b() {
        return m10271c().f7925d;
    }

    private static bwt m10271c() {
        bwt com_ushareit_listenit_bwt;
        synchronized (f7922a) {
            com_ushareit_listenit_bwt = f7923b;
        }
        return com_ushareit_listenit_bwt;
    }
}
