package com.ushareit.listenit;

import android.view.animation.Interpolator;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import java.util.Arrays;

class eqc {
    int f11464a;
    epz f11465b;
    epz f11466c;
    Interpolator f11467d;
    ArrayList<epz> f11468e = new ArrayList();
    eqx f11469f;

    public /* synthetic */ Object clone() {
        return mo2242b();
    }

    public eqc(epz... com_ushareit_listenit_epzArr) {
        this.f11464a = com_ushareit_listenit_epzArr.length;
        this.f11468e.addAll(Arrays.asList(com_ushareit_listenit_epzArr));
        this.f11465b = (epz) this.f11468e.get(0);
        this.f11466c = (epz) this.f11468e.get(this.f11464a - 1);
        this.f11467d = this.f11466c.m17348d();
    }

    public static eqc m17325a(int... iArr) {
        int i = 1;
        int length = iArr.length;
        eqb[] com_ushareit_listenit_eqbArr = new eqb[Math.max(length, 2)];
        if (length == 1) {
            com_ushareit_listenit_eqbArr[0] = (eqb) epz.m17339a(0.0f);
            com_ushareit_listenit_eqbArr[1] = (eqb) epz.m17341a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, iArr[0]);
        } else {
            com_ushareit_listenit_eqbArr[0] = (eqb) epz.m17341a(0.0f, iArr[0]);
            while (i < length) {
                com_ushareit_listenit_eqbArr[i] = (eqb) epz.m17341a(((float) i) / ((float) (length - 1)), iArr[i]);
                i++;
            }
        }
        return new epy(com_ushareit_listenit_eqbArr);
    }

    public static eqc m17324a(float... fArr) {
        int i = 1;
        int length = fArr.length;
        eqa[] com_ushareit_listenit_eqaArr = new eqa[Math.max(length, 2)];
        if (length == 1) {
            com_ushareit_listenit_eqaArr[0] = (eqa) epz.m17342b(0.0f);
            com_ushareit_listenit_eqaArr[1] = (eqa) epz.m17340a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, fArr[0]);
        } else {
            com_ushareit_listenit_eqaArr[0] = (eqa) epz.m17340a(0.0f, fArr[0]);
            while (i < length) {
                com_ushareit_listenit_eqaArr[i] = (eqa) epz.m17340a(((float) i) / ((float) (length - 1)), fArr[i]);
                i++;
            }
        }
        return new epw(com_ushareit_listenit_eqaArr);
    }

    public void m17327a(eqx com_ushareit_listenit_eqx) {
        this.f11469f = com_ushareit_listenit_eqx;
    }

    public eqc mo2242b() {
        ArrayList arrayList = this.f11468e;
        int size = this.f11468e.size();
        epz[] com_ushareit_listenit_epzArr = new epz[size];
        for (int i = 0; i < size; i++) {
            com_ushareit_listenit_epzArr[i] = ((epz) arrayList.get(i)).mo2247e();
        }
        return new eqc(com_ushareit_listenit_epzArr);
    }

    public Object mo2241a(float f) {
        if (this.f11464a == 2) {
            if (this.f11467d != null) {
                f = this.f11467d.getInterpolation(f);
            }
            return this.f11469f.mo2240a(f, this.f11465b.mo2245b(), this.f11466c.mo2245b());
        } else if (f <= 0.0f) {
            r0 = (epz) this.f11468e.get(1);
            r1 = r0.m17348d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = this.f11465b.m17347c();
            return this.f11469f.mo2240a((f - r1) / (r0.m17347c() - r1), this.f11465b.mo2245b(), r0.mo2245b());
        } else if (f >= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            r0 = (epz) this.f11468e.get(this.f11464a - 2);
            r1 = this.f11466c.m17348d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = r0.m17347c();
            return this.f11469f.mo2240a((f - r1) / (this.f11466c.m17347c() - r1), r0.mo2245b(), this.f11466c.mo2245b());
        } else {
            epz com_ushareit_listenit_epz = this.f11465b;
            int i = 1;
            while (i < this.f11464a) {
                r0 = (epz) this.f11468e.get(i);
                if (f < r0.m17347c()) {
                    r1 = r0.m17348d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    r1 = com_ushareit_listenit_epz.m17347c();
                    return this.f11469f.mo2240a((f - r1) / (r0.m17347c() - r1), com_ushareit_listenit_epz.mo2245b(), r0.mo2245b());
                }
                i++;
                com_ushareit_listenit_epz = r0;
            }
            return this.f11466c.mo2245b();
        }
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.f11464a) {
            String str2 = str + ((epz) this.f11468e.get(i)).mo2245b() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
