package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.umeng.analytics.pro.C0277j;
import java.nio.ByteBuffer;

public final class bgz {
    private static final int[] f6256a = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] f6257b = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] f6258c = new int[]{64, 112, 128, 192, 224, C0277j.f3694e, 384, 448, C0277j.f3696g, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static Format m8302a(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int i;
        bsr com_ushareit_listenit_bsr = new bsr(bArr);
        com_ushareit_listenit_bsr.m9695b(60);
        int i2 = f6256a[com_ushareit_listenit_bsr.m9697c(6)];
        int i3 = f6257b[com_ushareit_listenit_bsr.m9697c(4)];
        int c = com_ushareit_listenit_bsr.m9697c(5);
        c = c >= f6258c.length ? -1 : (f6258c[c] * 1000) / 2;
        com_ushareit_listenit_bsr.m9695b(10);
        if (com_ushareit_listenit_bsr.m9697c(2) > 0) {
            i = 1;
        } else {
            i = 0;
        }
        return Format.m2068a(str, "audio/vnd.dts", null, c, -1, i2 + i, i3, null, drmInitData, 0, str2);
    }

    public static int m8301a(byte[] bArr) {
        return ((((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2)) + 1) * 32;
    }

    public static int m8300a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int m8303b(byte[] bArr) {
        return ((((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) | ((bArr[7] & 240) >> 4)) + 1;
    }
}
