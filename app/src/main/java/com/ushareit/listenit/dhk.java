package com.ushareit.listenit;

import android.os.IBinder;
import java.util.ArrayList;
import java.util.List;

public class dhk extends but {
    private final dhh f9807a;
    private final List<bup> f9808b = new ArrayList();
    private final dha f9809c;
    private buf f9810d = new buf();

    public dhk(dhh com_ushareit_listenit_dhh) {
        dha com_ushareit_listenit_dha;
        this.f9807a = com_ushareit_listenit_dhh;
        try {
            List<Object> c = this.f9807a.mo1767c();
            if (c != null) {
                for (Object a : c) {
                    dgx a2 = m14338a(a);
                    if (a2 != null) {
                        this.f9808b.add(new dha(a2));
                    }
                }
            }
        } catch (Throwable e) {
            bze.m10489b("Failed to get image.", e);
        }
        try {
            dgx e2 = this.f9807a.mo1769e();
            if (e2 != null) {
                com_ushareit_listenit_dha = new dha(e2);
                this.f9809c = com_ushareit_listenit_dha;
            }
        } catch (Throwable e3) {
            bze.m10489b("Failed to get icon.", e3);
        }
        com_ushareit_listenit_dha = null;
        this.f9809c = com_ushareit_listenit_dha;
    }

    dgx m14338a(Object obj) {
        return obj instanceof IBinder ? dgy.m10356a((IBinder) obj) : null;
    }

    protected /* synthetic */ Object mo1777a() {
        return m14350l();
    }

    public CharSequence mo1778b() {
        try {
            return this.f9807a.mo1766b();
        } catch (Throwable e) {
            bze.m10489b("Failed to get headline.", e);
            return null;
        }
    }

    public List<bup> mo1779c() {
        return this.f9808b;
    }

    public CharSequence mo1780d() {
        try {
            return this.f9807a.mo1768d();
        } catch (Throwable e) {
            bze.m10489b("Failed to get body.", e);
            return null;
        }
    }

    public bup mo1781e() {
        return this.f9809c;
    }

    public CharSequence mo1782f() {
        try {
            return this.f9807a.mo1770f();
        } catch (Throwable e) {
            bze.m10489b("Failed to get call to action.", e);
            return null;
        }
    }

    public Double mo1783g() {
        Double d = null;
        try {
            double g = this.f9807a.mo1771g();
            if (g != -1.0d) {
                d = Double.valueOf(g);
            }
        } catch (Throwable e) {
            bze.m10489b("Failed to get star rating.", e);
        }
        return d;
    }

    public CharSequence mo1784h() {
        try {
            return this.f9807a.mo1772h();
        } catch (Throwable e) {
            bze.m10489b("Failed to get store", e);
            return null;
        }
    }

    public CharSequence mo1785i() {
        try {
            return this.f9807a.mo1773i();
        } catch (Throwable e) {
            bze.m10489b("Failed to get price.", e);
            return null;
        }
    }

    public buf mo1786j() {
        try {
            if (this.f9807a.mo1776l() != null) {
                this.f9810d.m9880a(this.f9807a.mo1776l());
            }
        } catch (Throwable e) {
            bze.m10489b("Exception occurred while getting video controller", e);
        }
        return this.f9810d;
    }

    public void mo1787k() {
        try {
            this.f9807a.mo1775k();
        } catch (Throwable e) {
            bze.m10489b("Failed to destroy", e);
        }
    }

    protected ckg m14350l() {
        try {
            return this.f9807a.mo1765a();
        } catch (Throwable e) {
            bze.m10489b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
