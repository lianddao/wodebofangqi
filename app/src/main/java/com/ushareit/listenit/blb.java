package com.ushareit.listenit;

import android.util.Log;
import java.util.Arrays;

final class blb {
    public static int m8894a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static blf m8896a(bss com_ushareit_listenit_bss) {
        m8898a(1, com_ushareit_listenit_bss, false);
        long m = com_ushareit_listenit_bss.m9719m();
        int g = com_ushareit_listenit_bss.m9713g();
        long m2 = com_ushareit_listenit_bss.m9719m();
        int o = com_ushareit_listenit_bss.m9721o();
        int o2 = com_ushareit_listenit_bss.m9721o();
        int o3 = com_ushareit_listenit_bss.m9721o();
        int g2 = com_ushareit_listenit_bss.m9713g();
        return new blf(m, g, m2, o, o2, o3, (int) Math.pow(2.0d, (double) (g2 & 15)), (int) Math.pow(2.0d, (double) ((g2 & 240) >> 4)), (com_ushareit_listenit_bss.m9713g() & 1) > 0, Arrays.copyOf(com_ushareit_listenit_bss.f7639a, com_ushareit_listenit_bss.m9706c()));
    }

    public static bld m8901b(bss com_ushareit_listenit_bss) {
        int i = 0;
        m8898a(3, com_ushareit_listenit_bss, false);
        String e = com_ushareit_listenit_bss.m9711e((int) com_ushareit_listenit_bss.m9719m());
        int length = e.length() + 11;
        long m = com_ushareit_listenit_bss.m9719m();
        String[] strArr = new String[((int) m)];
        length += 4;
        while (((long) i) < m) {
            length += 4;
            strArr[i] = com_ushareit_listenit_bss.m9711e((int) com_ushareit_listenit_bss.m9719m());
            length += strArr[i].length();
            i++;
        }
        if ((com_ushareit_listenit_bss.m9713g() & 1) != 0) {
            return new bld(e, strArr, length + 1);
        }
        throw new bfw("framing bit expected to be set");
    }

    public static boolean m8898a(int i, bss com_ushareit_listenit_bss, boolean z) {
        if (com_ushareit_listenit_bss.m9704b() < 7) {
            if (z) {
                return false;
            }
            throw new bfw("too short header: " + com_ushareit_listenit_bss.m9704b());
        } else if (com_ushareit_listenit_bss.m9713g() != i) {
            if (z) {
                return false;
            }
            throw new bfw("expected header type " + Integer.toHexString(i));
        } else if (com_ushareit_listenit_bss.m9713g() == 118 && com_ushareit_listenit_bss.m9713g() == 111 && com_ushareit_listenit_bss.m9713g() == 114 && com_ushareit_listenit_bss.m9713g() == 98 && com_ushareit_listenit_bss.m9713g() == 105 && com_ushareit_listenit_bss.m9713g() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new bfw("expected characters 'vorbis'");
        }
    }

    public static ble[] m8900a(bss com_ushareit_listenit_bss, int i) {
        int i2;
        int i3 = 0;
        m8898a(5, com_ushareit_listenit_bss, false);
        int g = com_ushareit_listenit_bss.m9713g() + 1;
        bky com_ushareit_listenit_bky = new bky(com_ushareit_listenit_bss.f7639a);
        com_ushareit_listenit_bky.m8884b(com_ushareit_listenit_bss.m9708d() * 8);
        for (i2 = 0; i2 < g; i2++) {
            m8904d(com_ushareit_listenit_bky);
        }
        i2 = com_ushareit_listenit_bky.m8881a(6) + 1;
        while (i3 < i2) {
            if (com_ushareit_listenit_bky.m8881a(16) != 0) {
                throw new bfw("placeholder of time domain transforms not zeroed out");
            }
            i3++;
        }
        m8903c(com_ushareit_listenit_bky);
        m8902b(com_ushareit_listenit_bky);
        m8897a(i, com_ushareit_listenit_bky);
        ble[] a = m8899a(com_ushareit_listenit_bky);
        if (com_ushareit_listenit_bky.m8882a()) {
            return a;
        }
        throw new bfw("framing bit after modes not set as expected");
    }

    private static ble[] m8899a(bky com_ushareit_listenit_bky) {
        int a = com_ushareit_listenit_bky.m8881a(6) + 1;
        ble[] com_ushareit_listenit_bleArr = new ble[a];
        for (int i = 0; i < a; i++) {
            com_ushareit_listenit_bleArr[i] = new ble(com_ushareit_listenit_bky.m8882a(), com_ushareit_listenit_bky.m8881a(16), com_ushareit_listenit_bky.m8881a(16), com_ushareit_listenit_bky.m8881a(8));
        }
        return com_ushareit_listenit_bleArr;
    }

    private static void m8897a(int i, bky com_ushareit_listenit_bky) {
        int a = com_ushareit_listenit_bky.m8881a(6) + 1;
        for (int i2 = 0; i2 < a; i2++) {
            int a2 = com_ushareit_listenit_bky.m8881a(16);
            switch (a2) {
                case 0:
                    int i3;
                    if (com_ushareit_listenit_bky.m8882a()) {
                        a2 = com_ushareit_listenit_bky.m8881a(4) + 1;
                    } else {
                        a2 = 1;
                    }
                    if (com_ushareit_listenit_bky.m8882a()) {
                        int a3 = com_ushareit_listenit_bky.m8881a(8) + 1;
                        for (i3 = 0; i3 < a3; i3++) {
                            com_ushareit_listenit_bky.m8884b(m8894a(i - 1));
                            com_ushareit_listenit_bky.m8884b(m8894a(i - 1));
                        }
                    }
                    if (com_ushareit_listenit_bky.m8881a(2) == 0) {
                        if (a2 > 1) {
                            for (i3 = 0; i3 < i; i3++) {
                                com_ushareit_listenit_bky.m8884b(4);
                            }
                        }
                        for (i3 = 0; i3 < a2; i3++) {
                            com_ushareit_listenit_bky.m8884b(8);
                            com_ushareit_listenit_bky.m8884b(8);
                            com_ushareit_listenit_bky.m8884b(8);
                        }
                        break;
                    }
                    throw new bfw("to reserved bits must be zero after mapping coupling steps");
                default:
                    Log.e("VorbisUtil", "mapping type other than 0 not supported: " + a2);
                    break;
            }
        }
    }

    private static void m8902b(bky com_ushareit_listenit_bky) {
        int a = com_ushareit_listenit_bky.m8881a(6) + 1;
        for (int i = 0; i < a; i++) {
            if (com_ushareit_listenit_bky.m8881a(16) > 2) {
                throw new bfw("residueType greater than 2 is not decodable");
            }
            int i2;
            com_ushareit_listenit_bky.m8884b(24);
            com_ushareit_listenit_bky.m8884b(24);
            com_ushareit_listenit_bky.m8884b(24);
            int a2 = com_ushareit_listenit_bky.m8881a(6) + 1;
            com_ushareit_listenit_bky.m8884b(8);
            int[] iArr = new int[a2];
            for (i2 = 0; i2 < a2; i2++) {
                int a3;
                int a4 = com_ushareit_listenit_bky.m8881a(3);
                if (com_ushareit_listenit_bky.m8882a()) {
                    a3 = com_ushareit_listenit_bky.m8881a(5);
                } else {
                    a3 = 0;
                }
                iArr[i2] = (a3 * 8) + a4;
            }
            for (i2 = 0; i2 < a2; i2++) {
                for (a3 = 0; a3 < 8; a3++) {
                    if ((iArr[i2] & (1 << a3)) != 0) {
                        com_ushareit_listenit_bky.m8884b(8);
                    }
                }
            }
        }
    }

    private static void m8903c(bky com_ushareit_listenit_bky) {
        int a = com_ushareit_listenit_bky.m8881a(6) + 1;
        for (int i = 0; i < a; i++) {
            int a2 = com_ushareit_listenit_bky.m8881a(16);
            int a3;
            switch (a2) {
                case 0:
                    com_ushareit_listenit_bky.m8884b(8);
                    com_ushareit_listenit_bky.m8884b(16);
                    com_ushareit_listenit_bky.m8884b(16);
                    com_ushareit_listenit_bky.m8884b(6);
                    com_ushareit_listenit_bky.m8884b(8);
                    a3 = com_ushareit_listenit_bky.m8881a(4) + 1;
                    for (a2 = 0; a2 < a3; a2++) {
                        com_ushareit_listenit_bky.m8884b(8);
                    }
                    break;
                case 1:
                    int a4;
                    int a5 = com_ushareit_listenit_bky.m8881a(5);
                    a2 = -1;
                    int[] iArr = new int[a5];
                    for (a3 = 0; a3 < a5; a3++) {
                        iArr[a3] = com_ushareit_listenit_bky.m8881a(4);
                        if (iArr[a3] > a2) {
                            a2 = iArr[a3];
                        }
                    }
                    int[] iArr2 = new int[(a2 + 1)];
                    for (a2 = 0; a2 < iArr2.length; a2++) {
                        iArr2[a2] = com_ushareit_listenit_bky.m8881a(3) + 1;
                        a4 = com_ushareit_listenit_bky.m8881a(2);
                        if (a4 > 0) {
                            com_ushareit_listenit_bky.m8884b(8);
                        }
                        for (a3 = 0; a3 < (1 << a4); a3++) {
                            com_ushareit_listenit_bky.m8884b(8);
                        }
                    }
                    com_ushareit_listenit_bky.m8884b(2);
                    int a6 = com_ushareit_listenit_bky.m8881a(4);
                    a2 = 0;
                    a4 = 0;
                    for (a3 = 0; a3 < a5; a3++) {
                        a4 += iArr2[iArr[a3]];
                        while (a2 < a4) {
                            com_ushareit_listenit_bky.m8884b(a6);
                            a2++;
                        }
                    }
                    break;
                default:
                    throw new bfw("floor type greater than 1 not decodable: " + a2);
            }
        }
    }

    private static blc m8904d(bky com_ushareit_listenit_bky) {
        int i = 0;
        if (com_ushareit_listenit_bky.m8881a(24) != 5653314) {
            throw new bfw("expected code book to start with [0x56, 0x43, 0x42] at " + com_ushareit_listenit_bky.m8883b());
        }
        int i2;
        int a = com_ushareit_listenit_bky.m8881a(16);
        int a2 = com_ushareit_listenit_bky.m8881a(24);
        long[] jArr = new long[a2];
        boolean a3 = com_ushareit_listenit_bky.m8882a();
        if (a3) {
            int a4 = com_ushareit_listenit_bky.m8881a(5) + 1;
            i2 = 0;
            while (i2 < jArr.length) {
                int a5 = com_ushareit_listenit_bky.m8881a(m8894a(a2 - i2));
                int i3 = 0;
                while (i3 < a5 && i2 < jArr.length) {
                    jArr[i2] = (long) a4;
                    i3++;
                    i2++;
                }
                a4++;
            }
        } else {
            boolean a6 = com_ushareit_listenit_bky.m8882a();
            while (i < jArr.length) {
                if (!a6) {
                    jArr[i] = (long) (com_ushareit_listenit_bky.m8881a(5) + 1);
                } else if (com_ushareit_listenit_bky.m8882a()) {
                    jArr[i] = (long) (com_ushareit_listenit_bky.m8881a(5) + 1);
                } else {
                    jArr[i] = 0;
                }
                i++;
            }
        }
        i2 = com_ushareit_listenit_bky.m8881a(4);
        if (i2 > 2) {
            throw new bfw("lookup type greater than 2 not decodable: " + i2);
        }
        if (i2 == 1 || i2 == 2) {
            long j;
            com_ushareit_listenit_bky.m8884b(32);
            com_ushareit_listenit_bky.m8884b(32);
            i = com_ushareit_listenit_bky.m8881a(4) + 1;
            com_ushareit_listenit_bky.m8884b(1);
            if (i2 != 1) {
                j = (long) (a2 * a);
            } else if (a != 0) {
                j = m8895a((long) a2, (long) a);
            } else {
                j = 0;
            }
            com_ushareit_listenit_bky.m8884b((int) (j * ((long) i)));
        }
        return new blc(a, a2, jArr, i2, a3);
    }

    private static long m8895a(long j, long j2) {
        return (long) Math.floor(Math.pow((double) j, 1.0d / ((double) j2)));
    }
}
