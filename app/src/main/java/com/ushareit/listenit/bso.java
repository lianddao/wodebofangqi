package com.ushareit.listenit;

import android.util.Log;
import com.mopub.volley.DefaultRetryPolicy;
import com.umeng.analytics.pro.C0277j;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class bso {
    public static final byte[] f7618a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    public static final float[] f7619b = new float[]{DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object f7620c = new Object();
    private static int[] f7621d = new int[10];

    public static int m9682a(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        synchronized (f7620c) {
            int c;
            int i4 = 0;
            int i5 = 0;
            while (i5 < i) {
                c = m9691c(bArr, i5, i);
                if (c < i) {
                    if (f7621d.length <= i4) {
                        f7621d = Arrays.copyOf(f7621d, f7621d.length * 2);
                    }
                    i5 = i4 + 1;
                    f7621d[i4] = c;
                    i4 = i5;
                    i5 = c + 3;
                } else {
                    i5 = c;
                }
            }
            i2 = i - i4;
            i5 = 0;
            c = 0;
            while (i3 < i4) {
                int i6 = f7621d[i3] - c;
                System.arraycopy(bArr, c, bArr, i5, i6);
                i5 += i6;
                int i7 = i5 + 1;
                bArr[i5] = (byte) 0;
                i5 = i7 + 1;
                bArr[i7] = (byte) 0;
                c += i6 + 3;
                i3++;
            }
            System.arraycopy(bArr, c, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void m9686a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (i + 1 < position) {
            int i3 = byteBuffer.get(i) & 255;
            if (i2 == 3) {
                if (i3 == 1 && (byteBuffer.get(i + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i3 == 0) {
                i2++;
            }
            if (i3 != 0) {
                i2 = 0;
            }
            i++;
        }
        byteBuffer.clear();
    }

    public static int m9688b(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int m9690c(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static bsq m9684a(byte[] bArr, int i, int i2) {
        int c;
        int i3;
        boolean z;
        int i4;
        float f;
        bst com_ushareit_listenit_bst = new bst(bArr, i, i2);
        com_ushareit_listenit_bst.m9735a(8);
        int c2 = com_ushareit_listenit_bst.m9741c(8);
        com_ushareit_listenit_bst.m9735a(16);
        int c3 = com_ushareit_listenit_bst.m9740c();
        boolean z2 = false;
        if (c2 == 100 || c2 == 110 || c2 == 122 || c2 == 244 || c2 == 44 || c2 == 83 || c2 == 86 || c2 == 118 || c2 == 128 || c2 == 138) {
            c = com_ushareit_listenit_bst.m9740c();
            if (c == 3) {
                z2 = com_ushareit_listenit_bst.m9737a();
            }
            com_ushareit_listenit_bst.m9740c();
            com_ushareit_listenit_bst.m9740c();
            com_ushareit_listenit_bst.m9735a(1);
            if (com_ushareit_listenit_bst.m9737a()) {
                i3 = c != 3 ? 8 : 12;
                int i5 = 0;
                while (i5 < i3) {
                    if (com_ushareit_listenit_bst.m9737a()) {
                        m9685a(com_ushareit_listenit_bst, i5 < 6 ? 16 : 64);
                    }
                    i5++;
                }
            }
            z = z2;
            i4 = c;
        } else {
            z = false;
            i4 = 1;
        }
        int c4 = com_ushareit_listenit_bst.m9740c() + 4;
        int c5 = com_ushareit_listenit_bst.m9740c();
        int i6 = 0;
        boolean z3 = false;
        if (c5 == 0) {
            i6 = com_ushareit_listenit_bst.m9740c() + 4;
        } else if (c5 == 1) {
            z3 = com_ushareit_listenit_bst.m9737a();
            com_ushareit_listenit_bst.m9742d();
            com_ushareit_listenit_bst.m9742d();
            long c6 = (long) com_ushareit_listenit_bst.m9740c();
            for (i3 = 0; ((long) i3) < c6; i3++) {
                com_ushareit_listenit_bst.m9740c();
            }
        }
        com_ushareit_listenit_bst.m9740c();
        com_ushareit_listenit_bst.m9735a(1);
        c2 = com_ushareit_listenit_bst.m9740c() + 1;
        c = com_ushareit_listenit_bst.m9740c() + 1;
        boolean a = com_ushareit_listenit_bst.m9737a();
        i3 = (2 - (a ? 1 : 0)) * c;
        if (!a) {
            com_ushareit_listenit_bst.m9735a(1);
        }
        com_ushareit_listenit_bst.m9735a(1);
        c = c2 * 16;
        c2 = i3 * 16;
        if (com_ushareit_listenit_bst.m9737a()) {
            int c7 = com_ushareit_listenit_bst.m9740c();
            int c8 = com_ushareit_listenit_bst.m9740c();
            int c9 = com_ushareit_listenit_bst.m9740c();
            int c10 = com_ushareit_listenit_bst.m9740c();
            if (i4 == 0) {
                i3 = 1;
                i4 = 2 - (a ? 1 : 0);
            } else {
                i3 = i4 == 3 ? 1 : 2;
                i4 = (2 - (a ? 1 : 0)) * (i4 == 1 ? 2 : 1);
            }
            i3 = c - (i3 * (c7 + c8));
            c2 -= i4 * (c9 + c10);
        } else {
            i3 = c;
        }
        float f2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        if (com_ushareit_listenit_bst.m9737a() && com_ushareit_listenit_bst.m9737a()) {
            c = com_ushareit_listenit_bst.m9741c(8);
            if (c == 255) {
                c = com_ushareit_listenit_bst.m9741c(16);
                int c11 = com_ushareit_listenit_bst.m9741c(16);
                if (!(c == 0 || c11 == 0)) {
                    f2 = ((float) c) / ((float) c11);
                }
                f = f2;
            } else if (c < f7619b.length) {
                f = f7619b[c];
            } else {
                Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + c);
            }
            return new bsq(c3, i3, c2, f, z, a, c4, c5, i6, z3);
        }
        f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        return new bsq(c3, i3, c2, f, z, a, c4, c5, i6, z3);
    }

    public static bsp m9689b(byte[] bArr, int i, int i2) {
        bst com_ushareit_listenit_bst = new bst(bArr, i, i2);
        com_ushareit_listenit_bst.m9735a(8);
        int c = com_ushareit_listenit_bst.m9740c();
        int c2 = com_ushareit_listenit_bst.m9740c();
        com_ushareit_listenit_bst.m9735a(1);
        return new bsp(c, c2, com_ushareit_listenit_bst.m9737a());
    }

    public static int m9683a(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z = true;
        int i3 = i2 - i;
        bsg.m9658b(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr != null) {
            if (zArr[0]) {
                m9687a(zArr);
                return i - 3;
            } else if (i3 > 1 && zArr[1] && bArr[i] == (byte) 1) {
                m9687a(zArr);
                return i - 2;
            } else if (i3 > 2 && zArr[2] && bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 1) {
                m9687a(zArr);
                return i - 1;
            }
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            if ((bArr[i5] & 254) == 0) {
                if (bArr[i5 - 2] == (byte) 0 && bArr[i5 - 1] == (byte) 0 && bArr[i5] == (byte) 1) {
                    if (zArr != null) {
                        m9687a(zArr);
                    }
                    return i5 - 2;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (zArr == null) {
            return i2;
        }
        boolean z2 = i3 > 2 ? bArr[i2 + -3] == (byte) 0 && bArr[i2 - 2] == (byte) 0 && bArr[i2 - 1] == (byte) 1 : i3 == 2 ? zArr[2] && bArr[i2 - 2] == (byte) 0 && bArr[i2 - 1] == (byte) 1 : zArr[1] && bArr[i2 - 1] == (byte) 1;
        zArr[0] = z2;
        z2 = i3 > 1 ? bArr[i2 + -2] == (byte) 0 && bArr[i2 - 1] == (byte) 0 : zArr[2] && bArr[i2 - 1] == (byte) 0;
        zArr[1] = z2;
        if (bArr[i2 - 1] != (byte) 0) {
            z = false;
        }
        zArr[2] = z;
        return i2;
    }

    public static void m9687a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static int m9691c(byte[] bArr, int i, int i2) {
        int i3 = i;
        while (i3 < i2 - 2) {
            if (bArr[i3] == (byte) 0 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 3) {
                return i3;
            }
            i3++;
        }
        return i2;
    }

    private static void m9685a(bst com_ushareit_listenit_bst, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((com_ushareit_listenit_bst.m9742d() + i3) + C0277j.f3694e) % C0277j.f3694e;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }
}
