package com.ushareit.listenit;

final class bkd {
    private static final int[] f6717a = new int[]{btc.m9777e("isom"), btc.m9777e("iso2"), btc.m9777e("iso3"), btc.m9777e("iso4"), btc.m9777e("iso5"), btc.m9777e("iso6"), btc.m9777e("avc1"), btc.m9777e("hvc1"), btc.m9777e("hev1"), btc.m9777e("mp41"), btc.m9777e("mp42"), btc.m9777e("3g2a"), btc.m9777e("3g2b"), btc.m9777e("3gr6"), btc.m9777e("3gs6"), btc.m9777e("3ge6"), btc.m9777e("3gg6"), btc.m9777e("M4V "), btc.m9777e("M4A "), btc.m9777e("f4v "), btc.m9777e("kddi"), btc.m9777e("M4VP"), btc.m9777e("qt  "), btc.m9777e("MSNV")};

    public static boolean m8803a(bhz com_ushareit_listenit_bhz) {
        return m8804a(com_ushareit_listenit_bhz, true);
    }

    public static boolean m8805b(bhz com_ushareit_listenit_bhz) {
        return m8804a(com_ushareit_listenit_bhz, false);
    }

    private static boolean m8804a(bhz com_ushareit_listenit_bhz, boolean z) {
        long d = com_ushareit_listenit_bhz.mo971d();
        if (d == -1 || d > 4096) {
            d = 4096;
        }
        int i = (int) d;
        bss com_ushareit_listenit_bss = new bss(64);
        Object obj = null;
        boolean z2 = false;
        int i2 = 0;
        while (i2 < i) {
            int i3 = 8;
            com_ushareit_listenit_bss.m9700a(8);
            com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, 8);
            long l = com_ushareit_listenit_bss.m9718l();
            int n = com_ushareit_listenit_bss.m9720n();
            if (l == 1) {
                i3 = 16;
                com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 8, 8);
                com_ushareit_listenit_bss.m9705b(16);
                l = com_ushareit_listenit_bss.m9728v();
            }
            if (l >= ((long) i3)) {
                i2 += i3;
                if (n != bji.f6563A) {
                    if (n != bji.f6572J && n != bji.f6574L) {
                        if ((((long) i2) + l) - ((long) i3) >= ((long) i)) {
                            break;
                        }
                        int i4 = (int) (l - ((long) i3));
                        int i5 = i2 + i4;
                        if (n == bji.f6589a) {
                            if (i4 < 8) {
                                return false;
                            }
                            com_ushareit_listenit_bss.m9700a(i4);
                            com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, i4);
                            i3 = i4 / 4;
                            for (i4 = 0; i4 < i3; i4++) {
                                if (i4 == 1) {
                                    com_ushareit_listenit_bss.m9709d(4);
                                } else if (m8802a(com_ushareit_listenit_bss.m9720n())) {
                                    obj = 1;
                                    break;
                                }
                            }
                            if (obj == null) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            com_ushareit_listenit_bhz.mo969c(i4);
                        }
                        i2 = i5;
                    } else {
                        z2 = true;
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        if (obj == null || z != r1) {
            return false;
        }
        return true;
    }

    private static boolean m8802a(int i) {
        if ((i >>> 8) == btc.m9777e("3gp")) {
            return true;
        }
        for (int i2 : f6717a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
