package com.ushareit.listenit;

import android.os.IBinder;
import java.util.ArrayList;
import java.util.List;

public class dho extends buv {
    private final dhl f9812a;
    private final List<bup> f9813b = new ArrayList();
    private final dha f9814c;

    public dho(dhl com_ushareit_listenit_dhl) {
        dha com_ushareit_listenit_dha;
        this.f9812a = com_ushareit_listenit_dhl;
        try {
            List<Object> c = this.f9812a.mo1790c();
            if (c != null) {
                for (Object a : c) {
                    dgx a2 = m14370a(a);
                    if (a2 != null) {
                        this.f9813b.add(new dha(a2));
                    }
                }
            }
        } catch (Throwable e) {
            bze.m10489b("Failed to get image.", e);
        }
        try {
            dgx e2 = this.f9812a.mo1792e();
            if (e2 != null) {
                com_ushareit_listenit_dha = new dha(e2);
                this.f9814c = com_ushareit_listenit_dha;
            }
        } catch (Throwable e3) {
            bze.m10489b("Failed to get icon.", e3);
        }
        com_ushareit_listenit_dha = null;
        this.f9814c = com_ushareit_listenit_dha;
    }

    dgx m14370a(Object obj) {
        return obj instanceof IBinder ? dgy.m10356a((IBinder) obj) : null;
    }

    protected /* synthetic */ Object mo1777a() {
        return m14379i();
    }

    public CharSequence mo1797b() {
        try {
            return this.f9812a.mo1789b();
        } catch (Throwable e) {
            bze.m10489b("Failed to get headline.", e);
            return null;
        }
    }

    public List<bup> mo1798c() {
        return this.f9813b;
    }

    public CharSequence mo1799d() {
        try {
            return this.f9812a.mo1791d();
        } catch (Throwable e) {
            bze.m10489b("Failed to get body.", e);
            return null;
        }
    }

    public bup mo1800e() {
        return this.f9814c;
    }

    public CharSequence mo1801f() {
        try {
            return this.f9812a.mo1793f();
        } catch (Throwable e) {
            bze.m10489b("Failed to get call to action.", e);
            return null;
        }
    }

    public CharSequence mo1802g() {
        try {
            return this.f9812a.mo1794g();
        } catch (Throwable e) {
            bze.m10489b("Failed to get attribution.", e);
            return null;
        }
    }

    public void mo1803h() {
        try {
            this.f9812a.mo1796i();
        } catch (Throwable e) {
            bze.m10489b("Failed to destroy", e);
        }
    }

    protected ckg m14379i() {
        try {
            return this.f9812a.mo1788a();
        } catch (Throwable e) {
            bze.m10489b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
