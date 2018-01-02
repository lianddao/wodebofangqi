package com.ushareit.listenit;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import com.mopub.volley.DefaultRetryPolicy;

public class gzd extends hhe {
    public static GradientDrawable m23356a(int i) {
        float f = 0.0f;
        float[] fArr = new float[3];
        float[] fArr2 = new float[3];
        float[] fArr3 = new float[3];
        Color.colorToHSV(i, fArr);
        Color.colorToHSV(i, fArr2);
        Color.colorToHSV(i, fArr3);
        if (fArr[1] - 0.1f >= 0.0f) {
            f = fArr[1] - 0.1f;
        }
        fArr2[1] = f;
        int HSVToColor = Color.HSVToColor(fArr2);
        fArr3[1] = fArr[1] + 0.1f > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ? DefaultRetryPolicy.DEFAULT_BACKOFF_MULT : fArr[1] + 0.1f;
        int HSVToColor2 = Color.HSVToColor(fArr3);
        return new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{HSVToColor, HSVToColor2});
    }

    public static ColorStateList m23359b(int i) {
        int alpha = (((int) (((float) Color.alpha(i)) * 0.7f)) << 24) | (16777215 & i);
        int[] iArr = new int[]{alpha, alpha, alpha, -4934476, i};
        r0 = new int[5][];
        r0[0] = new int[]{16842913};
        r0[1] = new int[]{16842908};
        r0[2] = new int[]{16842919};
        r0[3] = new int[]{-16842910};
        r0[4] = new int[0];
        return new ColorStateList(r0, iArr);
    }

    public static ColorStateList m23361c(int i) {
        r0 = new float[3];
        Color.colorToHSV(i, r0);
        int HSVToColor = Color.HSVToColor(new float[]{r0[0], m23357b(r0[1] - 0.17f), r0[2]});
        int HSVToColor2 = Color.HSVToColor(new float[]{m23352a(r0[0] - 5.0f), m23357b(r0[1] - 0.13f), m23357b(r0[2] - 0.3f)});
        int[] iArr = new int[]{HSVToColor2, HSVToColor2, HSVToColor2, HSVToColor2, HSVToColor};
        r0 = new int[5][];
        r0[0] = new int[]{16842913};
        r0[1] = new int[]{16842908};
        r0[2] = new int[]{16842919};
        r0[3] = new int[]{-16842910};
        r0[4] = new int[0];
        return new ColorStateList(r0, iArr);
    }

    private static float m23352a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return f > 360.0f ? 360.0f : f;
    }

    private static float m23357b(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return f > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ? DefaultRetryPolicy.DEFAULT_BACKOFF_MULT : f;
    }

    public static ColorStateList m23355a() {
        return ((ListenItApp) eys.m18562a()).m4937c();
    }

    public static int m23353a(int[] iArr) {
        ColorStateList c = ((ListenItApp) eys.m18562a()).m4937c();
        return c.getColorForState(iArr, c.getDefaultColor());
    }

    public static int m23358b() {
        return ((ListenItApp) eys.m18562a()).m4937c().getDefaultColor();
    }

    public static int m23354a(int[] iArr, int i) {
        ColorStateList c;
        switch (i) {
            case 0:
                c = ((ListenItApp) eys.m18562a()).m4937c();
                return c.getColorForState(iArr, c.getDefaultColor());
            case 1:
                c = m23361c(m23358b());
                return c.getColorForState(iArr, c.getDefaultColor());
            default:
                return 0;
        }
    }

    public static int m23363d(int i) {
        switch (i) {
            case 0:
                return m23358b();
            case 1:
                return m23361c(m23358b()).getDefaultColor();
            default:
                return 0;
        }
    }

    public static int m23360c() {
        r1 = new float[3];
        Color.colorToHSV(m23358b(), r1);
        return Color.HSVToColor(new float[]{r1[0], m23357b(r1[1] - 0.35f), r1[2]});
    }

    public static int m23362d() {
        r1 = new float[3];
        Color.colorToHSV(m23358b(), r1);
        return Color.HSVToColor(new float[]{r1[0], m23357b(r1[1] - 0.13f), r1[2]});
    }

    public static void m23365e(int i) {
        ((ListenItApp) eys.m18562a()).m4935b(i);
        gvj.m23021p(eys.m18562a(), i);
    }

    public static int m23364e() {
        return ((ListenItApp) eys.m18562a()).m4934b();
    }

    public static void m23367f(int i) {
        gvj.m23011n(eys.m18562a(), i);
        ((ListenItApp) eys.m18562a()).m4931a(i);
    }

    public static int m23366f() {
        return gvj.ab(eys.m18562a());
    }

    public static void m23369g(int i) {
        gvj.m23015o(eys.m18562a(), i);
    }

    public static int m23368g() {
        return eys.m18562a().getResources().getColor(C0349R.color.common_actionbar_color);
    }
}
