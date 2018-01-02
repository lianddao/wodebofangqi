package com.ushareit.listenit;

import android.util.Pair;

public final class bsh {
    private static final byte[] f7600a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    private static final int[] f7601b = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] f7602c = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> m9660a(byte[] bArr) {
        int c;
        boolean z;
        boolean z2 = true;
        bsr com_ushareit_listenit_bsr = new bsr(bArr);
        int c2 = com_ushareit_listenit_bsr.m9697c(5);
        int c3 = com_ushareit_listenit_bsr.m9697c(4);
        if (c3 == 15) {
            c = com_ushareit_listenit_bsr.m9697c(24);
        } else {
            if (c3 < 13) {
                z = true;
            } else {
                z = false;
            }
            bsg.m9656a(z);
            c = f7601b[c3];
        }
        c3 = com_ushareit_listenit_bsr.m9697c(4);
        if (c2 == 5 || c2 == 29) {
            c2 = com_ushareit_listenit_bsr.m9697c(4);
            if (c2 == 15) {
                c = com_ushareit_listenit_bsr.m9697c(24);
            } else {
                if (c2 < 13) {
                    z = true;
                } else {
                    z = false;
                }
                bsg.m9656a(z);
                c = f7601b[c2];
            }
            if (com_ushareit_listenit_bsr.m9697c(5) == 22) {
                c3 = c;
                c = com_ushareit_listenit_bsr.m9697c(4);
                c = f7602c[c];
                if (c == -1) {
                    z2 = false;
                }
                bsg.m9656a(z2);
                return Pair.create(Integer.valueOf(c3), Integer.valueOf(c));
            }
        }
        int i = c3;
        c3 = c;
        c = i;
        c = f7602c[c];
        if (c == -1) {
            z2 = false;
        }
        bsg.m9656a(z2);
        return Pair.create(Integer.valueOf(c3), Integer.valueOf(c));
    }

    public static byte[] m9661a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] m9662a(byte[] bArr, int i, int i2) {
        Object obj = new byte[(f7600a.length + i2)];
        System.arraycopy(f7600a, 0, obj, 0, f7600a.length);
        System.arraycopy(bArr, i, obj, f7600a.length, i2);
        return obj;
    }
}
