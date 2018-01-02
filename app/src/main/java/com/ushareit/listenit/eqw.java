package com.ushareit.listenit;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;

class eqw extends eqt {
    epy f11600h;
    int f11601i;
    private erh f11602j;

    public /* synthetic */ eqt mo2261a() {
        return m17558e();
    }

    public /* synthetic */ Object clone() {
        return m17558e();
    }

    public eqw(String str, int... iArr) {
        super(str);
        mo2268a(iArr);
    }

    public eqw(eri com_ushareit_listenit_eri, int... iArr) {
        super(com_ushareit_listenit_eri);
        mo2268a(iArr);
        if (com_ushareit_listenit_eri instanceof erh) {
            this.f11602j = (erh) this.b;
        }
    }

    public void mo2268a(int... iArr) {
        super.mo2268a(iArr);
        this.f11600h = (epy) this.e;
    }

    void mo2262a(float f) {
        this.f11601i = this.f11600h.m17337b(f);
    }

    Object mo2267d() {
        return Integer.valueOf(this.f11601i);
    }

    public eqw m17558e() {
        eqw com_ushareit_listenit_eqw = (eqw) super.mo2261a();
        com_ushareit_listenit_eqw.f11600h = (epy) com_ushareit_listenit_eqw.e;
        return com_ushareit_listenit_eqw;
    }

    void mo2265b(Object obj) {
        if (this.f11602j != null) {
            this.f11602j.mo2260a(obj, this.f11601i);
        } else if (this.b != null) {
            this.b.mo2257a(obj, Integer.valueOf(this.f11601i));
        } else if (this.c != null) {
            try {
                this.g[0] = Integer.valueOf(this.f11601i);
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
