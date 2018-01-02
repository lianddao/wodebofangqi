package com.ushareit.listenit;

import android.view.View;
import android.view.animation.Animation;
import com.umeng.analytics.C0154a;

public class gzi {
    public static void m23381a(View view, View view2) {
        m23382a(view, view2, true, 0, 90, 270, C0154a.f2960p);
    }

    public static void m23383b(View view, View view2) {
        m23382a(view, view2, false, C0154a.f2960p, 270, 90, 0);
    }

    private static void m23382a(View view, View view2, boolean z, int i, int i2, int i3, int i4) {
        int left = view2.getLeft() + (view2.getWidth() / 2);
        int top = view2.getTop() + (view2.getHeight() / 2);
        Animation com_ushareit_listenit_gzk = new gzk((float) i, (float) i2, (float) left, (float) top, 0.0f, true);
        com_ushareit_listenit_gzk.setDuration(500);
        com_ushareit_listenit_gzk.setFillAfter(true);
        gzk com_ushareit_listenit_gzk2 = new gzk((float) i3, (float) i4, (float) left, (float) top, 0.0f, false);
        com_ushareit_listenit_gzk2.setDuration(500);
        com_ushareit_listenit_gzk2.setFillAfter(true);
        com_ushareit_listenit_gzk.setAnimationListener(new gzj(z, view, view2, com_ushareit_listenit_gzk2));
        view2.startAnimation(com_ushareit_listenit_gzk);
    }
}
