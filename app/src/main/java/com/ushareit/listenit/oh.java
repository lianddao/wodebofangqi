package com.ushareit.listenit;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;

public class oh extends qe {
    final /* synthetic */ DrawerLayout f16057a;
    private final int f16058b;
    private qb f16059c;
    private final Runnable f16060d = new oi(this);

    public oh(DrawerLayout drawerLayout, int i) {
        this.f16057a = drawerLayout;
        this.f16058b = i;
    }

    public void m25304a(qb qbVar) {
        this.f16059c = qbVar;
    }

    public void m25299a() {
        this.f16057a.removeCallbacks(this.f16060d);
    }

    public boolean mo2646a(View view, int i) {
        return this.f16057a.m107g(view) && this.f16057a.m94a(view, this.f16058b) && this.f16057a.m87a(view) == 0;
    }

    public void mo2652a(int i) {
        this.f16057a.m89a(this.f16058b, i, this.f16059c.m25699c());
    }

    public void mo2653a(View view, int i, int i2, int i3, int i4) {
        float f;
        int width = view.getWidth();
        if (this.f16057a.m94a(view, 3)) {
            f = ((float) (width + i)) / ((float) width);
        } else {
            f = ((float) (this.f16057a.getWidth() - i)) / ((float) width);
        }
        this.f16057a.setDrawerViewOffset(view, f);
        view.setVisibility(f == 0.0f ? 4 : 0);
        this.f16057a.invalidate();
    }

    public void mo2970b(View view, int i) {
        ((LayoutParams) view.getLayoutParams()).f138c = false;
        m25295b();
    }

    private void m25295b() {
        int i = 3;
        if (this.f16058b == 3) {
            i = 5;
        }
        View c = this.f16057a.m101c(i);
        if (c != null) {
            this.f16057a.m109i(c);
        }
    }

    public void mo2645a(View view, float f, float f2) {
        int i;
        float d = this.f16057a.m104d(view);
        int width = view.getWidth();
        if (this.f16057a.m94a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
        } else {
            i = this.f16057a.getWidth();
            if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                i -= width;
            }
        }
        this.f16059c.m25689a(i, view.getTop());
        this.f16057a.invalidate();
    }

    public void mo2968a(int i, int i2) {
        this.f16057a.postDelayed(this.f16060d, 160);
    }

    private void m25296c() {
        View view;
        int i;
        int i2 = 0;
        int b = this.f16059c.m25693b();
        boolean z = this.f16058b == 3;
        if (z) {
            View c = this.f16057a.m101c(3);
            if (c != null) {
                i2 = -c.getWidth();
            }
            i2 += b;
            view = c;
            i = i2;
        } else {
            i2 = this.f16057a.getWidth() - b;
            view = this.f16057a.m101c(5);
            i = i2;
        }
        if (view == null) {
            return;
        }
        if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.f16057a.m87a(view) == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.f16059c.m25691a(view, i, view.getTop());
            layoutParams.f138c = true;
            this.f16057a.invalidate();
            m25295b();
            this.f16057a.m102c();
        }
    }

    public boolean mo2971b(int i) {
        return false;
    }

    public void mo2969b(int i, int i2) {
        View c;
        if ((i & 1) == 1) {
            c = this.f16057a.m101c(3);
        } else {
            c = this.f16057a.m101c(5);
        }
        if (c != null && this.f16057a.m87a(c) == 0) {
            this.f16059c.m25688a(c, i2);
        }
    }

    public int mo2967a(View view) {
        return this.f16057a.m107g(view) ? view.getWidth() : 0;
    }

    public int mo2644a(View view, int i, int i2) {
        if (this.f16057a.m94a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.f16057a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public int mo2655b(View view, int i, int i2) {
        return view.getTop();
    }
}
