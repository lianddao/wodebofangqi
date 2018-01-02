package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;

class epy extends eqc {
    private int f11474g;
    private int f11475h;
    private int f11476i;
    private boolean f11477j = true;

    public /* synthetic */ eqc mo2242b() {
        return m17335a();
    }

    public /* synthetic */ Object clone() {
        return m17335a();
    }

    public epy(eqb... com_ushareit_listenit_eqbArr) {
        super(com_ushareit_listenit_eqbArr);
    }

    public Object mo2241a(float f) {
        return Integer.valueOf(m17337b(f));
    }

    public epy m17335a() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        eqb[] com_ushareit_listenit_eqbArr = new eqb[size];
        for (int i = 0; i < size; i++) {
            com_ushareit_listenit_eqbArr[i] = (eqb) ((epz) arrayList.get(i)).mo2247e();
        }
        return new epy(com_ushareit_listenit_eqbArr);
    }

    public int m17337b(float f) {
        int i = 1;
        if (this.a == 2) {
            if (this.f11477j) {
                this.f11477j = false;
                this.f11474g = ((eqb) this.e.get(0)).m17360f();
                this.f11475h = ((eqb) this.e.get(1)).m17360f();
                this.f11476i = this.f11475h - this.f11474g;
            }
            if (this.d != null) {
                f = this.d.getInterpolation(f);
            }
            if (this.f == null) {
                return this.f11474g + ((int) (((float) this.f11476i) * f));
            }
            return ((Number) this.f.mo2240a(f, Integer.valueOf(this.f11474g), Integer.valueOf(this.f11475h))).intValue();
        } else if (f <= 0.0f) {
            r0 = (eqb) this.e.get(0);
            r1 = (eqb) this.e.get(1);
            r2 = r0.m17360f();
            r3 = r1.m17360f();
            r0 = r0.m17347c();
            r4 = r1.m17347c();
            r1 = r1.m17348d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? ((int) (r0 * ((float) (r3 - r2)))) + r2 : ((Number) this.f.mo2240a(r0, Integer.valueOf(r2), Integer.valueOf(r3))).intValue();
        } else if (f >= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            r0 = (eqb) this.e.get(this.a - 2);
            r1 = (eqb) this.e.get(this.a - 1);
            r2 = r0.m17360f();
            r3 = r1.m17360f();
            r0 = r0.m17347c();
            r4 = r1.m17347c();
            r1 = r1.m17348d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? ((int) (r0 * ((float) (r3 - r2)))) + r2 : ((Number) this.f.mo2240a(r0, Integer.valueOf(r2), Integer.valueOf(r3))).intValue();
        } else {
            eqb com_ushareit_listenit_eqb = (eqb) this.e.get(0);
            while (i < this.a) {
                r0 = (eqb) this.e.get(i);
                if (f < r0.m17347c()) {
                    r1 = r0.m17348d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    float c = (f - com_ushareit_listenit_eqb.m17347c()) / (r0.m17347c() - com_ushareit_listenit_eqb.m17347c());
                    r2 = com_ushareit_listenit_eqb.m17360f();
                    int f2 = r0.m17360f();
                    return this.f == null ? ((int) (((float) (f2 - r2)) * c)) + r2 : ((Number) this.f.mo2240a(c, Integer.valueOf(r2), Integer.valueOf(f2))).intValue();
                } else {
                    i++;
                    com_ushareit_listenit_eqb = r0;
                }
            }
            return ((Number) ((epz) this.e.get(this.a - 1)).mo2245b()).intValue();
        }
    }
}
