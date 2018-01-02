package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class aru {
    private static final String f5255a = aru.class.getSimpleName();
    private final View f5256b;
    private final int f5257c;
    private final int f5258d;
    private final arv f5259e;
    private final Handler f5260f;
    private final Runnable f5261g;
    private final boolean f5262h;
    private int f5263i;
    private int f5264j;
    private boolean f5265k;
    private arx f5266l;
    private Map<String, Integer> f5267m;
    private long f5268n;
    private int f5269o;

    public aru(View view, int i, int i2, boolean z, arv com_ushareit_listenit_arv) {
        this.f5260f = new Handler();
        this.f5261g = new arw(this);
        this.f5263i = 0;
        this.f5264j = 1000;
        this.f5265k = true;
        this.f5266l = new arx(ary.UNKNOWN);
        this.f5267m = new HashMap();
        this.f5268n = 0;
        this.f5269o = 0;
        this.f5256b = view;
        this.f5257c = i;
        this.f5259e = com_ushareit_listenit_arv;
        this.f5262h = z;
        if (i2 < 0) {
            i2 = 0;
        }
        this.f5258d = i2;
    }

    public aru(View view, int i, arv com_ushareit_listenit_arv) {
        this(view, i, 0, false, com_ushareit_listenit_arv);
    }

    public aru(View view, int i, boolean z, arv com_ushareit_listenit_arv) {
        this(view, i, 0, z, com_ushareit_listenit_arv);
    }

    public static arx m6918a(View view, int i) {
        if (view == null) {
            m6920a(view, false, "adView is null.");
            return new arx(ary.AD_IS_NULL);
        } else if (view.getParent() == null) {
            m6920a(view, false, "adView has no parent.");
            return new arx(ary.INVALID_PARENT);
        } else if (view.getWindowVisibility() != 0) {
            m6920a(view, false, "adView window is not set to VISIBLE.");
            return new arx(ary.INVALID_WINDOW);
        } else if (view.getVisibility() != 0) {
            m6920a(view, false, "adView is not set to VISIBLE.");
            return new arx(ary.AD_IS_NOT_VISIBLE);
        } else if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            m6920a(view, false, "adView has invisible dimensions (w=" + view.getMeasuredWidth() + ", h=" + view.getMeasuredHeight());
            return new arx(ary.INVALID_DIMENSIONS);
        } else if (view.getAlpha() < 0.9f) {
            m6920a(view, false, "adView is too transparent.");
            return new arx(ary.AD_IS_TRANSPARENT);
        } else {
            int width = view.getWidth();
            int height = view.getHeight();
            int[] iArr = new int[2];
            try {
                view.getLocationOnScreen(iArr);
                Context context = view.getContext();
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                Rect rect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                float f = 0.0f;
                if (rect.intersect(iArr[0], iArr[1], iArr[0] + width, iArr[1] + height)) {
                    f = (((float) (rect.width() * rect.height())) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) (width * height));
                }
                boolean m = app.m6631m(context);
                int n = app.m6632n(context);
                if (m) {
                    f *= 100.0f;
                    if (f < ((float) n)) {
                        m6920a(view, false, String.format("adView visible area is too small [%.2f%% visible, current threshold %d%%]", new Object[]{Float.valueOf(f), Integer.valueOf(n)}));
                        return new arx(ary.AD_INSUFFICIENT_VISIBLE_AREA, f);
                    }
                } else if (iArr[0] < 0 || displayMetrics.widthPixels - iArr[0] < width) {
                    m6920a(view, false, "adView is not fully on screen horizontally.");
                    return new arx(ary.AD_OFFSCREEN_HORIZONTALLY, f);
                } else {
                    width = (int) ((((double) height) * (100.0d - ((double) i))) / 100.0d);
                    if (iArr[1] < 0 && Math.abs(iArr[1]) > width) {
                        m6920a(view, false, "adView is not visible from the top.");
                        return new arx(ary.AD_OFFSCREEN_TOP, f);
                    } else if ((height + iArr[1]) - displayMetrics.heightPixels > width) {
                        m6920a(view, false, "adView is not visible from the bottom.");
                        return new arx(ary.AD_OFFSCREEN_BOTTOM, f);
                    }
                }
                if (auk.m7207b(context)) {
                    Map a = atp.m7131a(context);
                    if (atp.m7132a(a)) {
                        m6920a(view, false, "Keyguard is obstructing view.");
                        return new arx(ary.AD_IS_OBSTRUCTED_BY_KEYGUARD, f);
                    } else if (app.m6620b(context) && atp.m7134b(a)) {
                        m6920a(view, false, "Ad is on top of the Lockscreen.");
                        return new arx(ary.AD_IN_LOCKSCREEN, f, a);
                    } else {
                        m6920a(view, true, "adView is visible.");
                        return new arx(ary.IS_VIEWABLE, f, a);
                    }
                }
                m6920a(view, false, "Screen is not interactive.");
                return new arx(ary.SCREEN_NOT_INTERACTIVE, f);
            } catch (NullPointerException e) {
                m6920a(view, false, "Cannot get location on screen.");
                return new arx(ary.INVALID_DIMENSIONS);
            }
        }
    }

    private static void m6920a(View view, boolean z, String str) {
    }

    public void m6933a() {
        this.f5260f.postDelayed(this.f5261g, (long) this.f5263i);
        this.f5265k = false;
        this.f5269o = 0;
    }

    public void m6934a(int i) {
        this.f5263i = i;
    }

    public void m6935a(Map<String, String> map) {
        map.put("vrc", String.valueOf(this.f5266l.m6939b()));
        map.put("vp", String.valueOf(this.f5266l.m6940c()));
        map.put("vh", new JSONObject(this.f5267m).toString());
        map.put("vt", atz.m7159a(this.f5268n));
        map.putAll(this.f5266l.m6941d());
    }

    public void m6936b() {
        this.f5260f.removeCallbacks(this.f5261g);
        this.f5265k = true;
        this.f5269o = 0;
    }

    public void m6937b(int i) {
        this.f5264j = i;
    }
}
