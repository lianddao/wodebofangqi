package com.ushareit.listenit;

import com.umeng.analytics.pro.C0277j;

public final class bid {
    private static final String[] f6395h = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] f6396i = new int[]{44100, 48000, 32000};
    private static final int[] f6397j = new int[]{32, 64, 96, 128, C0277j.f3691b, 192, 224, C0277j.f3694e, 288, 320, 352, 384, 416, 448};
    private static final int[] f6398k = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 144, C0277j.f3691b, 176, 192, 224, C0277j.f3694e};
    private static final int[] f6399l = new int[]{32, 48, 56, 64, 80, 96, 112, 128, C0277j.f3691b, 192, 224, C0277j.f3694e, 320, 384};
    private static final int[] f6400m = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, C0277j.f3691b, 192, 224, C0277j.f3694e, 320};
    private static final int[] f6401n = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, C0277j.f3691b};
    public int f6402a;
    public String f6403b;
    public int f6404c;
    public int f6405d;
    public int f6406e;
    public int f6407f;
    public int f6408g;

    public static int m8555a(int i) {
        if ((i & -2097152) != -2097152) {
            return -1;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return -1;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 == 0 || i4 == 15) {
            return -1;
        }
        int i5 = (i >>> 10) & 3;
        if (i5 == 3) {
            return -1;
        }
        int i6 = f6396i[i5];
        if (i2 == 2) {
            i5 = i6 / 2;
        } else if (i2 == 0) {
            i5 = i6 / 4;
        } else {
            i5 = i6;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? f6397j[i4 - 1] : f6398k[i4 - 1]) * 12000) / i5) + i7) * 4;
        }
        if (i2 == 3) {
            i4 = i3 == 2 ? f6399l[i4 - 1] : f6400m[i4 - 1];
        } else {
            i4 = f6401n[i4 - 1];
        }
        if (i2 == 3) {
            return ((144000 * i4) / i5) + i7;
        }
        return (((i3 == 1 ? 72000 : 144000) * i4) / i5) + i7;
    }

    public static boolean m8557a(int i, bid com_ushareit_listenit_bid) {
        int i2 = 2;
        if ((i & -2097152) != -2097152) {
            return false;
        }
        int i3 = (i >>> 19) & 3;
        if (i3 == 1) {
            return false;
        }
        int i4 = (i >>> 17) & 3;
        if (i4 == 0) {
            return false;
        }
        int i5 = (i >>> 12) & 15;
        if (i5 == 0 || i5 == 15) {
            return false;
        }
        int i6 = (i >>> 10) & 3;
        if (i6 == 3) {
            return false;
        }
        int i7;
        int i8;
        int i9 = f6396i[i6];
        if (i3 == 2) {
            i9 /= 2;
        } else if (i3 == 0) {
            i9 /= 4;
        }
        i6 = (i >>> 9) & 1;
        if (i4 == 3) {
            i7 = i3 == 3 ? f6397j[i5 - 1] : f6398k[i5 - 1];
            i6 = (((i7 * 12000) / i9) + i6) * 4;
            i8 = 384;
        } else if (i3 == 3) {
            i7 = i4 == 2 ? f6399l[i5 - 1] : f6400m[i5 - 1];
            i8 = 1152;
            i6 += (144000 * i7) / i9;
        } else {
            i5 = f6401n[i5 - 1];
            i8 = i4 == 1 ? 576 : 1152;
            i6 += ((i4 == 1 ? 72000 : 144000) * i5) / i9;
            i7 = i5;
        }
        String str = f6395h[3 - i4];
        if (((i >> 6) & 3) == 3) {
            i2 = 1;
        }
        com_ushareit_listenit_bid.m8556a(i3, str, i6, i9, i2, i7 * 1000, i8);
        return true;
    }

    private void m8556a(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        this.f6402a = i;
        this.f6403b = str;
        this.f6404c = i2;
        this.f6405d = i3;
        this.f6406e = i4;
        this.f6407f = i5;
        this.f6408g = i6;
    }
}
