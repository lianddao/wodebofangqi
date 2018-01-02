package com.ushareit.listenit;

import android.view.View;
import android.view.animation.Interpolator;
import com.mopub.volley.DefaultRetryPolicy;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0277j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

class ert extends erl {
    ArrayList<erw> f11626a = new ArrayList();
    private final ery f11627b;
    private final WeakReference<View> f11628c;
    private long f11629d;
    private boolean f11630e = false;
    private long f11631f = 0;
    private boolean f11632g = false;
    private Interpolator f11633h;
    private boolean f11634i = false;
    private epl f11635j = null;
    private erv f11636k = new erv();
    private Runnable f11637l = new eru(this);
    private HashMap<epk, erx> f11638m = new HashMap();

    ert(View view) {
        this.f11628c = new WeakReference(view);
        this.f11627b = ery.m17650a(view);
    }

    public erl mo2272a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f11630e = true;
        this.f11629d = j;
        return this;
    }

    public erl mo2273a(Interpolator interpolator) {
        this.f11634i = true;
        this.f11633h = interpolator;
        return this;
    }

    public erl mo2274a(epl com_ushareit_listenit_epl) {
        this.f11635j = com_ushareit_listenit_epl;
        return this;
    }

    public erl mo2271a(float f) {
        m17628a(1, f);
        return this;
    }

    public erl mo2275b(float f) {
        m17628a(2, f);
        return this;
    }

    public erl mo2276c(float f) {
        m17628a(4, f);
        return this;
    }

    public erl mo2277d(float f) {
        m17628a(8, f);
        return this;
    }

    public erl mo2278e(float f) {
        m17628a((int) C0277j.f3696g, f);
        return this;
    }

    private void m17627a() {
        eqy b = eqy.m17366b(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        ArrayList arrayList = (ArrayList) this.f11626a.clone();
        this.f11626a.clear();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            i |= ((erw) arrayList.get(i2)).f11641a;
        }
        this.f11638m.put(b, new erx(i, arrayList));
        b.m17384a(this.f11636k);
        b.m17274a(this.f11636k);
        if (this.f11632g) {
            b.m17393e(this.f11631f);
        }
        if (this.f11630e) {
            b.mo2252c(this.f11629d);
        }
        if (this.f11634i) {
            b.m17383a(this.f11633h);
        }
        b.mo2234a();
    }

    private void m17628a(int i, float f) {
        float a = m17625a(i);
        m17629a(i, a, f - a);
    }

    private void m17629a(int i, float f, float f2) {
        if (this.f11638m.size() > 0) {
            for (epk com_ushareit_listenit_epk : this.f11638m.keySet()) {
                erx com_ushareit_listenit_erx = (erx) this.f11638m.get(com_ushareit_listenit_epk);
                if (com_ushareit_listenit_erx.m17649a(i) && com_ushareit_listenit_erx.f11644a == 0) {
                    break;
                }
            }
            epk com_ushareit_listenit_epk2 = null;
            if (com_ushareit_listenit_epk2 != null) {
                com_ushareit_listenit_epk2.mo2235b();
            }
        }
        this.f11626a.add(new erw(i, f, f2));
        View view = (View) this.f11628c.get();
        if (view != null) {
            view.removeCallbacks(this.f11637l);
            view.post(this.f11637l);
        }
    }

    private void m17633b(int i, float f) {
        switch (i) {
            case 1:
                this.f11627b.m17674i(f);
                return;
            case 2:
                this.f11627b.m17676j(f);
                return;
            case 4:
                this.f11627b.m17670g(f);
                return;
            case 8:
                this.f11627b.m17672h(f);
                return;
            case 16:
                this.f11627b.m17664d(f);
                return;
            case C0154a.f2957m /*32*/:
                this.f11627b.m17666e(f);
                return;
            case 64:
                this.f11627b.m17668f(f);
                return;
            case 128:
                this.f11627b.m17678k(f);
                return;
            case C0277j.f3694e /*256*/:
                this.f11627b.m17680l(f);
                return;
            case C0277j.f3696g /*512*/:
                this.f11627b.m17656a(f);
                return;
            default:
                return;
        }
    }

    private float m17625a(int i) {
        switch (i) {
            case 1:
                return this.f11627b.m17677k();
            case 2:
                return this.f11627b.m17679l();
            case 4:
                return this.f11627b.m17669g();
            case 8:
                return this.f11627b.m17671h();
            case 16:
                return this.f11627b.m17663d();
            case C0154a.f2957m /*32*/:
                return this.f11627b.m17665e();
            case 64:
                return this.f11627b.m17667f();
            case 128:
                return this.f11627b.m17681m();
            case C0277j.f3694e /*256*/:
                return this.f11627b.m17682n();
            case C0277j.f3696g /*512*/:
                return this.f11627b.m17655a();
            default:
                return 0.0f;
        }
    }
}
