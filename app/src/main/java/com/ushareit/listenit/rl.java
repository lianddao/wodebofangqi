package com.ushareit.listenit;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.mopub.common.Constants;

public abstract class rl extends sq {
    private final float f5699a;
    protected final LinearInterpolator f5700b = new LinearInterpolator();
    protected final DecelerateInterpolator f5701c = new DecelerateInterpolator();
    protected PointF f5702d;
    protected int f5703e = 0;
    protected int f5704f = 0;

    public abstract PointF mo817a(int i);

    public rl(Context context) {
        this.f5699a = mo816a(context.getResources().getDisplayMetrics());
    }

    protected void mo812a() {
    }

    protected void mo814a(View view, ss ssVar, sr srVar) {
        int b = mo818b(view, mo819c());
        int a = m7388a(view, m7399d());
        int b2 = m7394b((int) Math.sqrt((double) ((b * b) + (a * a))));
        if (b2 > 0) {
            srVar.m26185a(-b, -a, b2, this.f5701c);
        }
    }

    protected void mo813a(int i, int i2, ss ssVar, sr srVar) {
        if (m7384j() == 0) {
            m7380f();
            return;
        }
        this.f5703e = m7385a(this.f5703e, i);
        this.f5704f = m7385a(this.f5704f, i2);
        if (this.f5703e == 0 && this.f5704f == 0) {
            m7393a(srVar);
        }
    }

    protected void mo815b() {
        this.f5704f = 0;
        this.f5703e = 0;
        this.f5702d = null;
    }

    protected float mo816a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    protected int m7394b(int i) {
        return (int) Math.ceil(((double) m7398c(i)) / 0.3356d);
    }

    protected int m7398c(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.f5699a));
    }

    protected int mo819c() {
        if (this.f5702d == null || this.f5702d.x == 0.0f) {
            return 0;
        }
        return this.f5702d.x > 0.0f ? 1 : -1;
    }

    protected int m7399d() {
        if (this.f5702d == null || this.f5702d.y == 0.0f) {
            return 0;
        }
        return this.f5702d.y > 0.0f ? 1 : -1;
    }

    protected void m7393a(sr srVar) {
        PointF a = mo817a(m7383i());
        if (a == null || (a.x == 0.0f && a.y == 0.0f)) {
            Log.e("LinearSmoothScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
            srVar.m26184a(m7383i());
            m7380f();
            return;
        }
        m7372a(a);
        this.f5702d = a;
        this.f5703e = (int) (a.x * 10000.0f);
        this.f5704f = (int) (a.y * 10000.0f);
        srVar.m26185a((int) (((float) this.f5703e) * 1.2f), (int) (((float) this.f5704f) * 1.2f), (int) (((float) m7398c(Constants.TEN_SECONDS_MILLIS)) * 1.2f), this.f5700b);
    }

    private int m7385a(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public int m7387a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int m7388a(View view, int i) {
        sh e = m7379e();
        if (!e.mo43e()) {
            return 0;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return m7387a(e.m307h(view) - layoutParams.topMargin, e.m311j(view) + layoutParams.bottomMargin, e.m327w(), e.m325u() - e.m329y(), i);
    }

    public int mo818b(View view, int i) {
        sh e = m7379e();
        if (!e.mo41d()) {
            return 0;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return m7387a(e.m304g(view) - layoutParams.leftMargin, e.m309i(view) + layoutParams.rightMargin, e.m326v(), e.m324t() - e.m328x(), i);
    }
}
