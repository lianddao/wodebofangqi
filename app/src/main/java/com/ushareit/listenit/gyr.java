package com.ushareit.listenit;

import android.content.Context;
import android.util.DisplayMetrics;

public class gyr {
    public static final void m23308a(Context context) {
        try {
            float f;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            fbc b = fbb.m18760b(context);
            int i = displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels;
            if (b != fbc.DEVICE_PHONE) {
                f = ((float) i) * 0.0020833334f;
            } else if ((displayMetrics.density / ((float) displayMetrics.heightPixels)) - 1.5625E-4f > 0.0015625f) {
                f = ((float) i) * 0.0027777778f;
            } else {
                f = 0.0f;
            }
            if (f > 0.0f && f < 10.0f) {
                displayMetrics.density = f;
                displayMetrics.scaledDensity = f;
            }
        } catch (Exception e) {
            exw.m18457e("DensityScaleUtils", "resetDisplayMatric error");
        }
    }

    public static int m23306a() {
        return eys.m18562a().getResources().getDisplayMetrics().widthPixels;
    }

    public static int m23309b() {
        return eys.m18562a().getResources().getDisplayMetrics().heightPixels;
    }

    public static int m23307a(float f) {
        return (int) ((eys.m18562a().getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
