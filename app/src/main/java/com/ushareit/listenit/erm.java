package com.ushareit.listenit;

import android.view.View;
import android.view.animation.Interpolator;
import com.mopub.volley.DefaultRetryPolicy;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0277j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

class erm extends erl {
    ArrayList<erp> f11604a = new ArrayList();
    private final WeakReference<View> f11605b;
    private long f11606c;
    private boolean f11607d = false;
    private long f11608e = 0;
    private boolean f11609f = false;
    private Interpolator f11610g;
    private boolean f11611h = false;
    private epl f11612i = null;
    private ero f11613j = new ero();
    private Runnable f11614k = new ern(this);
    private HashMap<epk, erq> f11615l = new HashMap();

    erm(View view) {
        this.f11605b = new WeakReference(view);
    }

    public erl mo2272a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f11607d = true;
        this.f11606c = j;
        return this;
    }

    public erl mo2273a(Interpolator interpolator) {
        this.f11611h = true;
        this.f11610g = interpolator;
        return this;
    }

    public erl mo2274a(epl com_ushareit_listenit_epl) {
        this.f11612i = com_ushareit_listenit_epl;
        return this;
    }

    public erl mo2271a(float f) {
        m17595a(1, f);
        return this;
    }

    public erl mo2275b(float f) {
        m17595a(2, f);
        return this;
    }

    public erl mo2276c(float f) {
        m17595a(4, f);
        return this;
    }

    public erl mo2277d(float f) {
        m17595a(8, f);
        return this;
    }

    public erl mo2278e(float f) {
        m17595a((int) C0277j.f3696g, f);
        return this;
    }

    private void m17594a() {
        eqy b = eqy.m17366b(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        ArrayList arrayList = (ArrayList) this.f11604a.clone();
        this.f11604a.clear();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            i |= ((erp) arrayList.get(i2)).f11618a;
        }
        this.f11615l.put(b, new erq(i, arrayList));
        b.m17384a(this.f11613j);
        b.m17274a(this.f11613j);
        if (this.f11609f) {
            b.m17393e(this.f11608e);
        }
        if (this.f11607d) {
            b.mo2252c(this.f11606c);
        }
        if (this.f11611h) {
            b.m17383a(this.f11610g);
        }
        b.mo2234a();
    }

    private void m17595a(int i, float f) {
        float a = m17592a(i);
        m17596a(i, a, f - a);
    }

    private void m17596a(int i, float f, float f2) {
        if (this.f11615l.size() > 0) {
            for (epk com_ushareit_listenit_epk : this.f11615l.keySet()) {
                erq com_ushareit_listenit_erq = (erq) this.f11615l.get(com_ushareit_listenit_epk);
                if (com_ushareit_listenit_erq.m17616a(i) && com_ushareit_listenit_erq.f11621a == 0) {
                    break;
                }
            }
            epk com_ushareit_listenit_epk2 = null;
            if (com_ushareit_listenit_epk2 != null) {
                com_ushareit_listenit_epk2.mo2235b();
            }
        }
        this.f11604a.add(new erp(i, f, f2));
        View view = (View) this.f11605b.get();
        if (view != null) {
            view.removeCallbacks(this.f11614k);
            view.post(this.f11614k);
        }
    }

    private void m17600b(int i, float f) {
        View view = (View) this.f11605b.get();
        if (view != null) {
            switch (i) {
                case 1:
                    view.setTranslationX(f);
                    return;
                case 2:
                    view.setTranslationY(f);
                    return;
                case 4:
                    view.setScaleX(f);
                    return;
                case 8:
                    view.setScaleY(f);
                    return;
                case 16:
                    view.setRotation(f);
                    return;
                case C0154a.f2957m /*32*/:
                    view.setRotationX(f);
                    return;
                case 64:
                    view.setRotationY(f);
                    return;
                case 128:
                    view.setX(f);
                    return;
                case C0277j.f3694e /*256*/:
                    view.setY(f);
                    return;
                case C0277j.f3696g /*512*/:
                    view.setAlpha(f);
                    return;
                default:
                    return;
            }
        }
    }

    private float m17592a(int i) {
        View view = (View) this.f11605b.get();
        if (view != null) {
            switch (i) {
                case 1:
                    return view.getTranslationX();
                case 2:
                    return view.getTranslationY();
                case 4:
                    return view.getScaleX();
                case 8:
                    return view.getScaleY();
                case 16:
                    return view.getRotation();
                case C0154a.f2957m /*32*/:
                    return view.getRotationX();
                case 64:
                    return view.getRotationY();
                case 128:
                    return view.getX();
                case C0277j.f3694e /*256*/:
                    return view.getY();
                case C0277j.f3696g /*512*/:
                    return view.getAlpha();
            }
        }
        return 0.0f;
    }
}
