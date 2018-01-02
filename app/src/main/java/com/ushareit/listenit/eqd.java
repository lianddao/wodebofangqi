package com.ushareit.listenit;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

public final class eqd extends eqy {
    private static final Map<String, eri> f11514h = new HashMap();
    private Object f11515i;
    private String f11516j;
    private eri f11517k;

    public /* synthetic */ epk mo2233a(long j) {
        return mo2251b(j);
    }

    public /* synthetic */ eqy mo2252c(long j) {
        return mo2251b(j);
    }

    public /* synthetic */ Object clone() {
        return mo2254h();
    }

    public /* synthetic */ epk mo2239f() {
        return mo2254h();
    }

    public /* synthetic */ eqy mo2255i() {
        return mo2254h();
    }

    static {
        f11514h.put("alpha", eqe.f11518a);
        f11514h.put("pivotX", eqe.f11519b);
        f11514h.put("pivotY", eqe.f11520c);
        f11514h.put("translationX", eqe.f11521d);
        f11514h.put("translationY", eqe.f11522e);
        f11514h.put("rotation", eqe.f11523f);
        f11514h.put("rotationX", eqe.f11524g);
        f11514h.put("rotationY", eqe.f11525h);
        f11514h.put("scaleX", eqe.f11526i);
        f11514h.put("scaleY", eqe.f11527j);
        f11514h.put("scrollX", eqe.f11528k);
        f11514h.put("scrollY", eqe.f11529l);
        f11514h.put("x", eqe.f11530m);
        f11514h.put("y", eqe.f11531n);
    }

    public void m17406a(String str) {
        if (this.f != null) {
            eqt com_ushareit_listenit_eqt = this.f[0];
            String c = com_ushareit_listenit_eqt.m17498c();
            com_ushareit_listenit_eqt.m17493a(str);
            this.g.remove(c);
            this.g.put(str, com_ushareit_listenit_eqt);
        }
        this.f11516j = str;
        this.e = false;
    }

    public void m17405a(eri com_ushareit_listenit_eri) {
        if (this.f != null) {
            eqt com_ushareit_listenit_eqt = this.f[0];
            String c = com_ushareit_listenit_eqt.m17498c();
            com_ushareit_listenit_eqt.m17490a(com_ushareit_listenit_eri);
            this.g.remove(c);
            this.g.put(this.f11516j, com_ushareit_listenit_eqt);
        }
        if (this.f11517k != null) {
            this.f11516j = com_ushareit_listenit_eri.m17416a();
        }
        this.f11517k = com_ushareit_listenit_eri;
        this.e = false;
    }

    private eqd(Object obj, String str) {
        this.f11515i = obj;
        m17406a(str);
    }

    public static eqd m17401a(Object obj, String str, float... fArr) {
        eqd com_ushareit_listenit_eqd = new eqd(obj, str);
        com_ushareit_listenit_eqd.mo2249a(fArr);
        return com_ushareit_listenit_eqd;
    }

    public void mo2250a(int... iArr) {
        if (this.f != null && this.f.length != 0) {
            super.mo2250a(iArr);
        } else if (this.f11517k != null) {
            m17387a(eqt.m17481a(this.f11517k, iArr));
        } else {
            m17387a(eqt.m17483a(this.f11516j, iArr));
        }
    }

    public void mo2249a(float... fArr) {
        if (this.f != null && this.f.length != 0) {
            super.mo2249a(fArr);
        } else if (this.f11517k != null) {
            m17387a(eqt.m17480a(this.f11517k, fArr));
        } else {
            m17387a(eqt.m17482a(this.f11516j, fArr));
        }
    }

    public void mo2234a() {
        super.mo2234a();
    }

    void mo2253g() {
        if (!this.e) {
            if (this.f11517k == null && ery.f11646a && (this.f11515i instanceof View) && f11514h.containsKey(this.f11516j)) {
                m17405a((eri) f11514h.get(this.f11516j));
            }
            for (eqt a : this.f) {
                a.m17492a(this.f11515i);
            }
            super.mo2253g();
        }
    }

    public eqd mo2251b(long j) {
        super.mo2252c(j);
        return this;
    }

    void mo2248a(float f) {
        super.mo2248a(f);
        for (eqt b : this.f) {
            b.mo2265b(this.f11515i);
        }
    }

    public eqd mo2254h() {
        return (eqd) super.mo2255i();
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f11515i;
        if (this.f != null) {
            for (eqt com_ushareit_listenit_eqt : this.f) {
                str = str + "\n    " + com_ushareit_listenit_eqt.toString();
            }
        }
        return str;
    }
}
