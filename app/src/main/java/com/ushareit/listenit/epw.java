package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;

class epw extends eqc {
    private float f11470g;
    private float f11471h;
    private float f11472i;
    private boolean f11473j = true;

    public /* synthetic */ eqc mo2242b() {
        return m17329a();
    }

    public /* synthetic */ Object clone() {
        return m17329a();
    }

    public epw(eqa... com_ushareit_listenit_eqaArr) {
        super(com_ushareit_listenit_eqaArr);
    }

    public Object mo2241a(float f) {
        return Float.valueOf(m17331b(f));
    }

    public epw m17329a() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        eqa[] com_ushareit_listenit_eqaArr = new eqa[size];
        for (int i = 0; i < size; i++) {
            com_ushareit_listenit_eqaArr[i] = (eqa) ((epz) arrayList.get(i)).mo2247e();
        }
        return new epw(com_ushareit_listenit_eqaArr);
    }

    public float m17331b(float f) {
        int i = 1;
        if (this.a == 2) {
            if (this.f11473j) {
                this.f11473j = false;
                this.f11470g = ((eqa) this.e.get(0)).m17355f();
                this.f11471h = ((eqa) this.e.get(1)).m17355f();
                this.f11472i = this.f11471h - this.f11470g;
            }
            if (this.d != null) {
                f = this.d.getInterpolation(f);
            }
            if (this.f == null) {
                return this.f11470g + (this.f11472i * f);
            }
            return ((Number) this.f.mo2240a(f, Float.valueOf(this.f11470g), Float.valueOf(this.f11471h))).floatValue();
        } else if (f <= 0.0f) {
            r0 = (eqa) this.e.get(0);
            r1 = (eqa) this.e.get(1);
            r2 = r0.m17355f();
            r3 = r1.m17355f();
            r0 = r0.m17347c();
            r4 = r1.m17347c();
            r1 = r1.m17348d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? (r0 * (r3 - r2)) + r2 : ((Number) this.f.mo2240a(r0, Float.valueOf(r2), Float.valueOf(r3))).floatValue();
        } else if (f >= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            r0 = (eqa) this.e.get(this.a - 2);
            r1 = (eqa) this.e.get(this.a - 1);
            r2 = r0.m17355f();
            r3 = r1.m17355f();
            r0 = r0.m17347c();
            r4 = r1.m17347c();
            r1 = r1.m17348d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? (r0 * (r3 - r2)) + r2 : ((Number) this.f.mo2240a(r0, Float.valueOf(r2), Float.valueOf(r3))).floatValue();
        } else {
            eqa com_ushareit_listenit_eqa = (eqa) this.e.get(0);
            while (i < this.a) {
                r0 = (eqa) this.e.get(i);
                if (f < r0.m17347c()) {
                    r1 = r0.m17348d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    float c = (f - com_ushareit_listenit_eqa.m17347c()) / (r0.m17347c() - com_ushareit_listenit_eqa.m17347c());
                    r2 = com_ushareit_listenit_eqa.m17355f();
                    r0 = r0.m17355f();
                    return this.f == null ? ((r0 - r2) * c) + r2 : ((Number) this.f.mo2240a(c, Float.valueOf(r2), Float.valueOf(r0))).floatValue();
                } else {
                    i++;
                    com_ushareit_listenit_eqa = r0;
                }
            }
            return ((Number) ((epz) this.e.get(this.a - 1)).mo2245b()).floatValue();
        }
    }
}
