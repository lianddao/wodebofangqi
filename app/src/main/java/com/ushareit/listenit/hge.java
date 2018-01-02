package com.ushareit.listenit;

import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.volley.DefaultRetryPolicy;

public class hge {
    private static final int[] f15396a = new int[]{1, 2, 3, 4, 5, 10, 20, 30, 50, 80, 120, 180, 300, 480, 600, 1200, 1800, 3600};
    private static final int[] f15397b = new int[]{1, 5, 10, 30, 50, 75, 100, CtaButton.WIDTH_DIPS, 200, 300, 400, 500, 600, 800, 1000, 1200, 1500, 2000, DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3000, 4000, 5000};

    public static String m23691a(long j) {
        int i = 0;
        int i2 = (int) (j / 1000);
        String str = "other";
        for (int i3 = 0; i3 < f15396a.length; i3++) {
            int i4 = f15396a[i3];
            if (i2 < i4) {
                if (i3 > 0) {
                    i = f15396a[i3 - 1];
                }
                return "[" + i + ", " + i4 + ")";
            }
        }
        return str;
    }

    public static String m23690a(int i) {
        int i2 = 0;
        String str = "other";
        for (int i3 = 0; i3 < f15397b.length; i3++) {
            int i4 = f15397b[i3];
            if (i < i4) {
                if (i3 > 0) {
                    i2 = f15397b[i3 - 1];
                }
                return "[" + i2 + ", " + i4 + ")";
            }
        }
        return str;
    }
}
