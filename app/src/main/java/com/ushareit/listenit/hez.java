package com.ushareit.listenit;

import android.os.SystemClock;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;

public class hez implements Runnable {
    private float f15300a;
    protected long f15301b;
    final /* synthetic */ DragSortListView f15302c;
    private float f15303d;
    private float f15304e;
    private float f15305f = (this.f15303d / ((this.f15303d - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) * 2.0f));
    private float f15306g = (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f15303d));
    private float f15307h;
    private boolean f15308i;

    public hez(DragSortListView dragSortListView, float f, int i) {
        this.f15302c = dragSortListView;
        this.f15303d = f;
        this.f15300a = (float) i;
        float f2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / ((this.f15303d * 2.0f) * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f15303d));
        this.f15307h = f2;
        this.f15304e = f2;
    }

    public float m23639a(float f) {
        if (f < this.f15303d) {
            return (this.f15304e * f) * f;
        }
        if (f < DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f15303d) {
            return this.f15305f + (this.f15306g * f);
        }
        return DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((this.f15307h * (f - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)) * (f - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    public void m23643c() {
        this.f15301b = SystemClock.uptimeMillis();
        this.f15308i = false;
        mo2759a();
        this.f15302c.post(this);
    }

    public void m23644d() {
        this.f15308i = true;
    }

    public void mo2759a() {
    }

    public void mo2760a(float f, float f2) {
    }

    public void mo2761b() {
    }

    public void run() {
        if (!this.f15308i) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f15301b)) / this.f15300a;
            if (uptimeMillis >= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                mo2760a(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                mo2761b();
                return;
            }
            mo2760a(uptimeMillis, m23639a(uptimeMillis));
            this.f15302c.post(this);
        }
    }
}
