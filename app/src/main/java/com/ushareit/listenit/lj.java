package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.View;
import java.lang.ref.WeakReference;

public final class lj {
    static final lt f15624a;
    private WeakReference<View> f15625b;
    private Runnable f15626c = null;
    private Runnable f15627d = null;
    private int f15628e = -1;

    lj(View view) {
        this.f15625b = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f15624a = new ls();
        } else if (i >= 19) {
            f15624a = new lr();
        } else if (i >= 18) {
            f15624a = new lp();
        } else if (i >= 16) {
            f15624a = new lq();
        } else if (i >= 14) {
            f15624a = new ln();
        } else {
            f15624a = new ll();
        }
    }

    public lj m24448a(long j) {
        View view = (View) this.f15625b.get();
        if (view != null) {
            f15624a.mo2875a(this, view, j);
        }
        return this;
    }

    public lj m24447a(float f) {
        View view = (View) this.f15625b.get();
        if (view != null) {
            f15624a.mo2874a(this, view, f);
        }
        return this;
    }

    public lj m24451b(float f) {
        View view = (View) this.f15625b.get();
        if (view != null) {
            f15624a.mo2878b(this, view, f);
        }
        return this;
    }

    public lj m24453c(float f) {
        View view = (View) this.f15625b.get();
        if (view != null) {
            f15624a.mo2879c(this, view, f);
        }
        return this;
    }

    public void m24450a() {
        View view = (View) this.f15625b.get();
        if (view != null) {
            f15624a.mo2873a(this, view);
        }
    }

    public void m24452b() {
        View view = (View) this.f15625b.get();
        if (view != null) {
            f15624a.mo2877b(this, view);
        }
    }

    public lj m24449a(ly lyVar) {
        View view = (View) this.f15625b.get();
        if (view != null) {
            f15624a.mo2876a(this, view, lyVar);
        }
        return this;
    }
}
