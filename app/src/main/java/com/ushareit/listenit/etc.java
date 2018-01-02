package com.ushareit.listenit;

import android.util.Pair;
import android.util.SparseArray;
import com.mopub.common.Constants;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.volley.DefaultRetryPolicy;

public final class etc {
    public static final int[] f11754a = new int[]{0, 1, 2, 3, 4, 5, 10, 15, 20, 30, 50, 100, 200, 300, 500, 1000};
    public static final int[] f11755b = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 30, 50, 100, 200, 300, 500, 1000};
    public static final int[] f11756c = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 30, 50, 100, 200, 300, 500, 1000};
    private static SparseArray<String> f11757d = new SparseArray();
    private static int[] f11758e = new int[]{0, 3, 5, 10, 20, 50, 100, 200, 300, 500, 700, 999999};
    private static SparseArray<String> f11759f = new SparseArray();
    private static int[] f11760g = new int[]{0, 10, 30, 60, 120, 300, 600, 1200, 1800, 3600, 7200, 86400};
    private static SparseArray<String> f11761h = new SparseArray();
    private static int[] f11762i = new int[]{0, 2, 5, 10, 20, 30, 60, 120, 180, 240, 300, 86400};
    private static SparseArray<String> f11763j = new SparseArray();
    private static int[] f11764k = new int[]{0, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 999999};
    private static final long[] f11765l = new long[]{1024, 10240, 51200, 102400, 307200, 512000, 1048576, 1572864, 2097152, 2621440, 3145728, 4194304, 5242880, 6291456, 7340032, 8388608, 9437184, 10485760};
    private static final int[] f11766m = new int[]{0, 1, 2, 3, 5, 10, 20, 30, 50, 100, 200, 300, 500, 1000, 2000, 3000, 5000, Constants.TEN_SECONDS_MILLIS};
    private static final long[] f11767n = new long[]{10240, 51200, 102400, 307200, 512000, 1048576, 2097152, 3145728, 5242880, 10485760, 15728640, 20971520, 31457280, 52428800, 104857600, 314572800, 524288000, 1073741824, 2147483648L, 3221225472L, 5368709120L, 10737418240L, 21474836480L, 32212254720L, 53687091200L, 107374182400L, 214748364800L};
    private static final float[] f11768o = new float[]{3.0f, 5.0f, 10.0f, CtaButton.TEXT_SIZE_SP, CloseButton.TEXT_SIZE_SP, 30.0f, 60.0f, 180.0f, 300.0f, 600.0f, 1800.0f, 3600.0f};
    private static final float[] f11769p = new float[]{0.01f, 0.03f, 0.05f, 0.07f, 0.1f, 0.12f, 0.15f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f};

    public static String m17843a(Pair<Boolean, Boolean> pair) {
        if (pair == null) {
            return null;
        }
        if (((Boolean) pair.second).booleanValue()) {
            return "Wifi";
        }
        if (((Boolean) pair.first).booleanValue()) {
            return "Data";
        }
        return "No network";
    }

    static {
        f11757d.put(0, "0to3M");
        f11757d.put(3, "0to3M");
        f11757d.put(5, "3to5M");
        f11757d.put(10, "5to10M");
        f11757d.put(20, "10to20M");
        f11757d.put(50, "20to50M");
        f11757d.put(100, "50to100M");
        f11757d.put(200, "100to200M");
        f11757d.put(300, "200to300M");
        f11757d.put(500, "300to500M");
        f11757d.put(700, "500to700M");
        f11757d.put(999999, "700Mabove");
        f11761h.put(0, "0to2s");
        f11761h.put(2, "0to2s");
        f11761h.put(5, "2to5s");
        f11761h.put(10, "5to10s");
        f11761h.put(20, "10to20s");
        f11761h.put(30, "20to30s");
        f11761h.put(60, "30to60s");
        f11761h.put(120, "60to120s");
        f11761h.put(180, "120to180s");
        f11761h.put(240, "180to240s");
        f11761h.put(300, "240to300s");
        f11761h.put(86400, "300s+");
        f11759f.put(0, "0~10s");
        f11759f.put(10, "0~10s");
        f11759f.put(30, "10~30s");
        f11759f.put(60, "30~60s");
        f11759f.put(120, "1~2m");
        f11759f.put(300, "2~5m");
        f11759f.put(600, "5~10m");
        f11759f.put(1200, "10~20m");
        f11759f.put(1800, "20~30m");
        f11759f.put(3600, "30~60m");
        f11759f.put(7200, "1~2h");
        f11759f.put(86400, "2h+");
        f11763j.put(0, "0~5");
        f11763j.put(5, "0~5");
        f11763j.put(10, "5~10");
        f11763j.put(20, "10~20");
        f11763j.put(50, "20~50");
        f11763j.put(100, "50~100");
        f11763j.put(200, "100~200");
        f11763j.put(500, "200~500");
        f11763j.put(1000, "500~1000");
        f11763j.put(2000, "1000~2000");
        f11763j.put(5000, "2000~5000");
        f11763j.put(999999, "5000+");
    }

    public static String m17839a(int i) {
        return m17840a(i, f11766m);
    }

    public static String m17840a(int i, int[] iArr) {
        int i2 = 0;
        while (i2 < iArr.length) {
            if (i == iArr[i2] && (i2 == 0 || iArr[i2] - iArr[i2 - 1] == 1)) {
                return String.valueOf(iArr[i2]);
            }
            if (i >= iArr[i2]) {
                i2++;
            } else if (i2 == 0) {
                return "<" + m17837a((float) iArr[i2]);
            } else {
                return ">=" + m17837a((float) iArr[i2 - 1]) + ", <" + m17837a((float) iArr[i2]);
            }
        }
        return ">=" + m17837a((float) iArr[iArr.length - 1]);
    }

    public static String m17841a(long j) {
        return m17842a(j, f11767n);
    }

    public static String m17842a(long j, long[] jArr) {
        int i = 0;
        while (i < jArr.length) {
            if (j >= jArr[i]) {
                i++;
            } else if (i == 0) {
                return "<" + m17837a((float) jArr[i]);
            } else {
                return ">=" + m17837a((float) jArr[i - 1]) + ", <" + m17837a((float) jArr[i]);
            }
        }
        return ">=" + m17837a((float) jArr[jArr.length - 1]);
    }

    public static String m17838a(float f, float[] fArr) {
        int i = 0;
        while (i < fArr.length) {
            if (Float.compare(f, fArr[i]) == 0 && (i == 0 || fArr[i] - fArr[i - 1] == DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)) {
                return m17844b(fArr[i]);
            }
            if (f >= fArr[i]) {
                i++;
            } else if (i == 0) {
                return "<" + m17844b(fArr[i]);
            } else {
                return ">=" + m17844b(fArr[i - 1]) + ", <" + m17844b(fArr[i]);
            }
        }
        return ">=" + m17844b(fArr[fArr.length - 1]);
    }

    public static String m17837a(float f) {
        long j = 1;
        String str = "";
        if (f >= 1024.0f) {
            j = 1024;
            str = "K";
        }
        if (f >= 1048576.0f) {
            j = 1048576;
            str = "M";
        }
        if (f >= 1.07374182E9f) {
            j = 1073741824;
            str = "G";
        }
        return fbp.m18798a("#.#", (double) (f / ((float) j))) + str;
    }

    public static String m17844b(float f) {
        long j = 1;
        String str = "s";
        if (f >= 60.0f) {
            j = 60;
            str = "m";
        }
        if (f >= 3600.0f) {
            j = 3600;
            str = "h";
        }
        if (f >= 86400.0f) {
            j = 86400;
            str = "d";
        }
        return fbp.m18798a("#.#", (double) (f / ((float) j))) + str;
    }
}
