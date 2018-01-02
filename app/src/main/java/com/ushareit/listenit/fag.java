package com.ushareit.listenit;

import android.graphics.BitmapFactory.Options;

public final class fag {
    public static int m18697a(Options options, int i, int i2) {
        int i3;
        int b = m18698b(options, i, i2);
        if (b <= 8) {
            i3 = 1;
            while (i3 < b) {
                i3 <<= 1;
            }
        } else {
            i3 = ((b + 7) / 8) * 8;
        }
        if (((1.0d * ((double) options.outWidth)) * ((double) options.outHeight)) / ((double) ((i2 * i3) * i3)) <= 0.5d) {
            return i3 / 2;
        }
        return i3;
    }

    private static int m18698b(Options options, int i, int i2) {
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / ((double) i)), Math.floor(d2 / ((double) i)));
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        if (i != -1) {
            return min;
        }
        return ceil;
    }
}
