package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.umeng.analytics.pro.C0277j;
import java.nio.ByteBuffer;

public final class bgg {
    private static final int[] f6171a = new int[]{1, 2, 3, 6};
    private static final int[] f6172b = new int[]{48000, 44100, 32000};
    private static final int[] f6173c = new int[]{24000, 22050, 16000};
    private static final int[] f6174d = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] f6175e = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, C0277j.f3691b, 192, 224, C0277j.f3694e, 320, 384, 448, C0277j.f3696g, 576, 640};
    private static final int[] f6176f = new int[]{69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static Format m8231a(bss com_ushareit_listenit_bss, String str, String str2, DrmInitData drmInitData) {
        int i = f6172b[(com_ushareit_listenit_bss.m9713g() & 192) >> 6];
        int g = com_ushareit_listenit_bss.m9713g();
        int i2 = f6174d[(g & 56) >> 3];
        if ((g & 4) != 0) {
            i2++;
        }
        return Format.m2068a(str, "audio/ac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static Format m8234b(bss com_ushareit_listenit_bss, String str, String str2, DrmInitData drmInitData) {
        com_ushareit_listenit_bss.m9709d(2);
        int i = f6172b[(com_ushareit_listenit_bss.m9713g() & 192) >> 6];
        int g = com_ushareit_listenit_bss.m9713g();
        int i2 = f6174d[(g & 14) >> 1];
        if ((g & 1) != 0) {
            i2++;
        }
        return Format.m2068a(str, "audio/eac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static Format m8230a(bsr com_ushareit_listenit_bsr, String str, String str2, DrmInitData drmInitData) {
        int i = 1;
        com_ushareit_listenit_bsr.m9695b(32);
        int c = com_ushareit_listenit_bsr.m9697c(2);
        com_ushareit_listenit_bsr.m9695b(14);
        int c2 = com_ushareit_listenit_bsr.m9697c(3);
        if (!((c2 & 1) == 0 || c2 == 1)) {
            com_ushareit_listenit_bsr.m9695b(2);
        }
        if ((c2 & 4) != 0) {
            com_ushareit_listenit_bsr.m9695b(2);
        }
        if (c2 == 2) {
            com_ushareit_listenit_bsr.m9695b(2);
        }
        boolean b = com_ushareit_listenit_bsr.m9696b();
        String str3 = "audio/ac3";
        c2 = f6174d[c2];
        if (!b) {
            i = 0;
        }
        return Format.m2068a(str, str3, null, -1, -1, c2 + i, f6172b[c], null, drmInitData, 0, str2);
    }

    public static Format m8233b(bsr com_ushareit_listenit_bsr, String str, String str2, DrmInitData drmInitData) {
        int i;
        com_ushareit_listenit_bsr.m9695b(32);
        int c = com_ushareit_listenit_bsr.m9697c(2);
        if (c == 3) {
            i = f6173c[com_ushareit_listenit_bsr.m9697c(2)];
        } else {
            com_ushareit_listenit_bsr.m9695b(2);
            i = f6172b[c];
        }
        c = com_ushareit_listenit_bsr.m9697c(3);
        boolean b = com_ushareit_listenit_bsr.m9696b();
        String str3 = "audio/eac3";
        int i2 = f6174d[c];
        if (b) {
            c = 1;
        } else {
            c = 0;
        }
        return Format.m2068a(str, str3, null, -1, -1, i2 + c, i, null, drmInitData, 0, str2);
    }

    public static int m8229a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return m8227a((bArr[4] & 192) >> 6, bArr[4] & 63);
    }

    public static int m8232b(byte[] bArr) {
        return ((((bArr[2] & 7) << 8) + (bArr[3] & 255)) + 1) * 2;
    }

    public static int m8226a() {
        return 1536;
    }

    public static int m8235c(byte[] bArr) {
        return (((bArr[4] & 192) >> 6) == 3 ? 6 : f6171a[(bArr[4] & 48) >> 4]) * C0277j.f3694e;
    }

    public static int m8228a(ByteBuffer byteBuffer) {
        int i;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) == 3) {
            i = 6;
        } else {
            i = f6171a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * C0277j.f3694e;
    }

    private static int m8227a(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= f6172b.length || i2 < 0 || i3 >= f6176f.length) {
            return -1;
        }
        int i4 = f6172b[i];
        if (i4 == 44100) {
            return (f6176f[i3] + (i2 % 2)) * 2;
        }
        i3 = f6175e[i3];
        if (i4 == 32000) {
            return i3 * 6;
        }
        return i3 * 4;
    }
}
