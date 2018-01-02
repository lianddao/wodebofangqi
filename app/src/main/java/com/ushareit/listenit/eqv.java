package com.ushareit.listenit;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;

class eqv extends eqt {
    epw f11597h;
    float f11598i;
    private erg f11599j;

    public /* synthetic */ eqt mo2261a() {
        return m17551e();
    }

    public /* synthetic */ Object clone() {
        return m17551e();
    }

    public eqv(String str, float... fArr) {
        super(str);
        mo2264a(fArr);
    }

    public eqv(eri com_ushareit_listenit_eri, float... fArr) {
        super(com_ushareit_listenit_eri);
        mo2264a(fArr);
        if (com_ushareit_listenit_eri instanceof erg) {
            this.f11599j = (erg) this.b;
        }
    }

    public void mo2264a(float... fArr) {
        super.mo2264a(fArr);
        this.f11597h = (epw) this.e;
    }

    void mo2262a(float f) {
        this.f11598i = this.f11597h.m17331b(f);
    }

    Object mo2267d() {
        return Float.valueOf(this.f11598i);
    }

    public eqv m17551e() {
        eqv com_ushareit_listenit_eqv = (eqv) super.mo2261a();
        com_ushareit_listenit_eqv.f11597h = (epw) com_ushareit_listenit_eqv.e;
        return com_ushareit_listenit_eqv;
    }

    void mo2265b(Object obj) {
        if (this.f11599j != null) {
            this.f11599j.mo2259a(obj, this.f11598i);
        } else if (this.b != null) {
            this.b.mo2257a(obj, Float.valueOf(this.f11598i));
        } else if (this.c != null) {
            try {
                this.g[0] = Float.valueOf(this.f11598i);
                this.c.invoke(obj, this.g);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    void mo2263a(Class cls) {
        if (this.b == null) {
            super.mo2263a(cls);
        }
    }
}
