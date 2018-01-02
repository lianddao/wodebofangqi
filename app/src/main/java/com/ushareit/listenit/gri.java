package com.ushareit.listenit;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.mopub.volley.DefaultRetryPolicy;
import com.umeng.analytics.pro.C0277j;

public class gri {
    protected Context f14583a;
    protected WindowManager f14584b;
    protected LayoutParams f14585c;

    public gri(Context context) {
        this.f14583a = context;
        this.f14584b = (WindowManager) context.getSystemService("window");
        this.f14585c = new LayoutParams();
        this.f14585c.format = 1;
        this.f14585c.gravity = 8388659;
        this.f14585c.flags = C0277j.f3694e;
        this.f14585c.alpha = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f14585c.screenOrientation = 1;
        this.f14585c.x = 0;
        this.f14585c.y = 0;
        this.f14585c.type = 2005;
        this.f14585c.width = -1;
        this.f14585c.height = -1;
    }

    public boolean m22600a(View view, Runnable runnable) {
        if (view == null) {
            return false;
        }
        try {
            this.f14584b.addView(view, this.f14585c);
            view.post(runnable);
            return true;
        } catch (Exception e) {
            fii.m19305b(this.f14583a, "add_floting_view", e.getClass().getSimpleName());
            return false;
        }
    }

    public boolean m22599a(View view) {
        if (view != null) {
            try {
                this.f14584b.removeView(view);
                return true;
            } catch (Exception e) {
                fii.m19305b(this.f14583a, "remove_floting_view", e.getClass().getSimpleName());
            }
        }
        return false;
    }
}
