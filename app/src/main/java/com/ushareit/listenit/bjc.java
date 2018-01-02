package com.ushareit.listenit;

import android.util.Pair;
import java.nio.charset.Charset;

final class bjc {
    private static final int f6537a = btc.m9777e("ID3");
    private static final Charset[] f6538b = new Charset[]{Charset.forName("ISO-8859-1"), Charset.forName("UTF-16LE"), Charset.forName("UTF-16BE"), Charset.forName("UTF-8")};

    public static void m8673a(bhz com_ushareit_listenit_bhz, bic com_ushareit_listenit_bic) {
        bss com_ushareit_listenit_bss = new bss(10);
        int i = 0;
        while (true) {
            com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, 10);
            com_ushareit_listenit_bss.m9707c(0);
            if (com_ushareit_listenit_bss.m9717k() != f6537a) {
                com_ushareit_listenit_bhz.mo962a();
                com_ushareit_listenit_bhz.mo969c(i);
                return;
            }
            int g = com_ushareit_listenit_bss.m9713g();
            int g2 = com_ushareit_listenit_bss.m9713g();
            int g3 = com_ushareit_listenit_bss.m9713g();
            int s = com_ushareit_listenit_bss.m9725s();
            if (com_ushareit_listenit_bic.m8552a() || !m8676a(g, g2, g3, s)) {
                com_ushareit_listenit_bhz.mo969c(s);
            } else {
                byte[] bArr = new byte[s];
                com_ushareit_listenit_bhz.mo970c(bArr, 0, s);
                m8674a(new bss(bArr), g, g3, com_ushareit_listenit_bic);
            }
            i += s + 10;
        }
    }

    private static boolean m8676a(int i, int i2, int i3, int i4) {
        return i2 != 255 && i >= 2 && i <= 4 && i4 <= 3145728 && ((i != 2 || ((i3 & 63) == 0 && (i3 & 64) == 0)) && ((i != 3 || (i3 & 31) == 0) && (i != 4 || (i3 & 15) == 0)));
    }

    private static void m8674a(bss com_ushareit_listenit_bss, int i, int i2, bic com_ushareit_listenit_bic) {
        m8677a(com_ushareit_listenit_bss, i, i2);
        com_ushareit_listenit_bss.m9707c(0);
        int s;
        if (i != 3 || (i2 & 64) == 0) {
            if (i == 4 && (i2 & 64) != 0) {
                if (com_ushareit_listenit_bss.m9704b() >= 4) {
                    s = com_ushareit_listenit_bss.m9725s();
                    if (s >= 6 && s <= com_ushareit_listenit_bss.m9704b() + 4) {
                        com_ushareit_listenit_bss.m9707c(s);
                    } else {
                        return;
                    }
                }
                return;
            }
        } else if (com_ushareit_listenit_bss.m9704b() >= 4) {
            s = com_ushareit_listenit_bss.m9726t();
            if (s <= com_ushareit_listenit_bss.m9704b()) {
                if (s >= 6) {
                    com_ushareit_listenit_bss.m9709d(2);
                    int t = com_ushareit_listenit_bss.m9726t();
                    com_ushareit_listenit_bss.m9707c(4);
                    com_ushareit_listenit_bss.m9705b(com_ushareit_listenit_bss.m9706c() - t);
                    if (com_ushareit_listenit_bss.m9704b() < s) {
                        return;
                    }
                }
                com_ushareit_listenit_bss.m9709d(s);
            } else {
                return;
            }
        } else {
            return;
        }
        while (true) {
            Pair a = m8672a(i, com_ushareit_listenit_bss);
            if (a == null) {
                return;
            }
            if (((String) a.first).length() > 3 && com_ushareit_listenit_bic.m8554a(((String) a.first).substring(3), (String) a.second)) {
                return;
            }
        }
    }

    private static Pair<String, String> m8672a(int i, bss com_ushareit_listenit_bss) {
        int k;
        int h;
        while (true) {
            if (i == 2) {
                if (com_ushareit_listenit_bss.m9704b() < 6) {
                    return null;
                }
                String a = com_ushareit_listenit_bss.m9698a(3, Charset.forName("US-ASCII"));
                if (a.equals("\u0000\u0000\u0000")) {
                    return null;
                }
                k = com_ushareit_listenit_bss.m9717k();
                if (k == 0 || k > com_ushareit_listenit_bss.m9704b()) {
                    return null;
                }
                if (a.equals("COM")) {
                    break;
                }
                com_ushareit_listenit_bss.m9709d(k);
            } else if (com_ushareit_listenit_bss.m9704b() < 10) {
                return null;
            } else {
                String a2 = com_ushareit_listenit_bss.m9698a(4, Charset.forName("US-ASCII"));
                if (a2.equals("\u0000\u0000\u0000\u0000")) {
                    return null;
                }
                k = i == 4 ? com_ushareit_listenit_bss.m9725s() : com_ushareit_listenit_bss.m9726t();
                if (k == 0 || k > com_ushareit_listenit_bss.m9704b() - 2) {
                    return null;
                }
                h = com_ushareit_listenit_bss.m9714h();
                if ((i != 4 || (h & 12) == 0) && (i != 3 || (h & 192) == 0)) {
                    h = 0;
                } else {
                    h = 1;
                }
                if (h == 0 && a2.equals("COMM")) {
                    break;
                }
                com_ushareit_listenit_bss.m9709d(k);
            }
        }
        h = com_ushareit_listenit_bss.m9713g();
        if (h < 0 || h >= f6538b.length) {
            return null;
        }
        Pair<String, String> create;
        String[] split = com_ushareit_listenit_bss.m9698a(k - 1, f6538b[h]).split("\u0000");
        if (split.length == 2) {
            create = Pair.create(split[0], split[1]);
        } else {
            create = null;
        }
        return create;
    }

    private static boolean m8677a(bss com_ushareit_listenit_bss, int i, int i2) {
        if (i != 4) {
            if ((i2 & 128) != 0) {
                Object obj = com_ushareit_listenit_bss.f7639a;
                int length = obj.length;
                int i3 = false;
                while (i3 + 1 < length) {
                    if ((obj[i3] & 255) == 255 && obj[i3 + 1] == (byte) 0) {
                        System.arraycopy(obj, i3 + 2, obj, i3 + 1, (length - i3) - 2);
                        length--;
                    }
                    i3++;
                }
                com_ushareit_listenit_bss.m9705b(length);
            }
        } else if (m8678a(com_ushareit_listenit_bss, false)) {
            m8679b(com_ushareit_listenit_bss, false);
        } else if (!m8678a(com_ushareit_listenit_bss, true)) {
            return false;
        } else {
            m8679b(com_ushareit_listenit_bss, true);
        }
        return true;
    }

    private static boolean m8678a(bss com_ushareit_listenit_bss, boolean z) {
        com_ushareit_listenit_bss.m9707c(0);
        while (com_ushareit_listenit_bss.m9704b() >= 10) {
            if (com_ushareit_listenit_bss.m9720n() == 0) {
                return true;
            }
            long l = com_ushareit_listenit_bss.m9718l();
            if (!z) {
                if ((8421504 & l) != 0) {
                    return false;
                }
                l = (((l >> 24) & 127) << 21) | (((l & 127) | (((l >> 8) & 127) << 7)) | (((l >> 16) & 127) << 14));
            }
            if (l > ((long) (com_ushareit_listenit_bss.m9704b() - 2))) {
                return false;
            }
            if ((com_ushareit_listenit_bss.m9714h() & 1) != 0 && com_ushareit_listenit_bss.m9704b() < 4) {
                return false;
            }
            com_ushareit_listenit_bss.m9709d((int) l);
        }
        return true;
    }

    private static void m8679b(bss com_ushareit_listenit_bss, boolean z) {
        com_ushareit_listenit_bss.m9707c(0);
        byte[] bArr = com_ushareit_listenit_bss.f7639a;
        while (com_ushareit_listenit_bss.m9704b() >= 10 && com_ushareit_listenit_bss.m9720n() != 0) {
            int d;
            int i;
            int t = z ? com_ushareit_listenit_bss.m9726t() : com_ushareit_listenit_bss.m9725s();
            int h = com_ushareit_listenit_bss.m9714h();
            if ((h & 1) != 0) {
                d = com_ushareit_listenit_bss.m9708d();
                System.arraycopy(bArr, d + 4, bArr, d, com_ushareit_listenit_bss.m9704b() - 4);
                d = t - 4;
                i = h & -2;
                com_ushareit_listenit_bss.m9705b(com_ushareit_listenit_bss.m9706c() - 4);
            } else {
                i = h;
                d = t;
            }
            if ((i & 2) != 0) {
                t = com_ushareit_listenit_bss.m9708d() + 1;
                int i2 = 0;
                int i3 = t;
                while (i2 + 1 < d) {
                    if ((bArr[t - 1] & 255) == 255 && bArr[t] == (byte) 0) {
                        t++;
                        d--;
                    }
                    int i4 = i3 + 1;
                    int i5 = t + 1;
                    bArr[i3] = bArr[t];
                    i2++;
                    i3 = i4;
                    t = i5;
                }
                com_ushareit_listenit_bss.m9705b(com_ushareit_listenit_bss.m9706c() - (t - i3));
                System.arraycopy(bArr, t, bArr, i3, com_ushareit_listenit_bss.m9704b() - t);
                t = i & -3;
            } else {
                t = i;
            }
            if (t != h || z) {
                i = com_ushareit_listenit_bss.m9708d() - 6;
                m8675a(bArr, i, d);
                bArr[i + 4] = (byte) (t >> 8);
                bArr[i + 5] = (byte) (t & 255);
            }
            com_ushareit_listenit_bss.m9709d(d);
        }
    }

    private static void m8675a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) ((i2 >> 21) & 127);
        bArr[i + 1] = (byte) ((i2 >> 14) & 127);
        bArr[i + 2] = (byte) ((i2 >> 7) & 127);
        bArr[i + 3] = (byte) (i2 & 127);
    }
}
