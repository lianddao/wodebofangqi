package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.analytics.C0154a;

public class dvx extends duy {
    private Handler f10447a;
    private long f10448b;
    private final Runnable f10449c = new dvy(this);
    private final dws f10450d = new dwa(this, this.n);
    private final dws f10451e = new dwb(this, this.n);

    dvx(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    private void m15847A() {
        synchronized (this) {
            if (this.f10447a == null) {
                this.f10447a = new Handler(Looper.getMainLooper());
            }
        }
    }

    private void m15848B() {
        mo2083j();
        mo2096w().m16235E().m16264a("Session started, time", Long.valueOf(mo2089p().mo1371b()));
        mo2097x().f10601j.m16325a(false);
        mo2085l().m15754a("auto", "_s", new Bundle());
    }

    private void m15849C() {
        mo2083j();
        long b = mo2089p().mo1371b();
        if (this.f10448b == 0) {
            this.f10448b = b - C0154a.f2954j;
        }
        long a = mo2097x().f10603l.m16328a() + (b - this.f10448b);
        mo2097x().f10603l.m16329a(a);
        mo2096w().m16235E().m16264a("Recording user engagement, ms", Long.valueOf(a));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", a);
        mo2085l().m15754a("auto", "_e", bundle);
        mo2097x().f10603l.m16329a(0);
        this.f10448b = b;
        this.f10451e.m15826a(Math.max(0, C0154a.f2954j - mo2097x().f10603l.m16328a()));
    }

    private void m15850a(long j) {
        mo2083j();
        m15847A();
        this.f10450d.m15828c();
        this.f10451e.m15828c();
        mo2096w().m16235E().m16264a("Activity resumed, time", Long.valueOf(j));
        this.f10448b = j;
        if (mo2089p().mo1370a() - mo2097x().f10600i.m16328a() > mo2097x().f10602k.m16328a()) {
            mo2097x().f10601j.m16325a(true);
            mo2097x().f10603l.m16329a(0);
        }
        if (mo2097x().f10601j.m16326a()) {
            this.f10450d.m15826a(Math.max(0, mo2097x().f10599h.m16328a() - mo2097x().f10603l.m16328a()));
        } else {
            this.f10451e.m15826a(Math.max(0, C0154a.f2954j - mo2097x().f10603l.m16328a()));
        }
    }

    private void m15853b(long j) {
        mo2083j();
        m15847A();
        this.f10450d.m15828c();
        this.f10451e.m15828c();
        mo2096w().m16235E().m16264a("Activity paused, time", Long.valueOf(j));
        if (this.f10448b != 0) {
            mo2097x().f10603l.m16329a(mo2097x().f10603l.m16328a() + (j - this.f10448b));
        }
        mo2097x().f10602k.m16329a(mo2089p().mo1370a());
        synchronized (this) {
            if (!mo2097x().f10601j.m16326a()) {
                this.f10447a.postDelayed(this.f10449c, 1000);
            }
        }
    }

    protected void mo2080e() {
    }

    protected void m15857f() {
        synchronized (this) {
            m15847A();
            this.f10447a.removeCallbacks(this.f10449c);
        }
        mo2095v().m16380a(new dwc(this, mo2089p().mo1371b()));
    }

    protected void m15858g() {
        mo2095v().m16380a(new dwd(this, mo2089p().mo1371b()));
    }

    public /* bridge */ /* synthetic */ void mo2081h() {
        super.mo2081h();
    }

    public /* bridge */ /* synthetic */ void mo2082i() {
        super.mo2082i();
    }

    public /* bridge */ /* synthetic */ void mo2083j() {
        super.mo2083j();
    }

    public /* bridge */ /* synthetic */ dwm mo2084k() {
        return super.mo2084k();
    }

    public /* bridge */ /* synthetic */ dva mo2085l() {
        return super.mo2085l();
    }

    public /* bridge */ /* synthetic */ dxe mo2086m() {
        return super.mo2086m();
    }

    public /* bridge */ /* synthetic */ dwu mo2087n() {
        return super.mo2087n();
    }

    public /* bridge */ /* synthetic */ dvg mo2088o() {
        return super.mo2088o();
    }

    public /* bridge */ /* synthetic */ cio mo2089p() {
        return super.mo2089p();
    }

    public /* bridge */ /* synthetic */ Context mo2090q() {
        return super.mo2090q();
    }

    public /* bridge */ /* synthetic */ dwo mo2091r() {
        return super.mo2091r();
    }

    public /* bridge */ /* synthetic */ dwk mo2092s() {
        return super.mo2092s();
    }

    public /* bridge */ /* synthetic */ dxz mo2093t() {
        return super.mo2093t();
    }

    public /* bridge */ /* synthetic */ dvx mo2094u() {
        return super.mo2094u();
    }

    public /* bridge */ /* synthetic */ dya mo2095v() {
        return super.mo2095v();
    }

    public /* bridge */ /* synthetic */ dxg mo2096w() {
        return super.mo2096w();
    }

    public /* bridge */ /* synthetic */ dxr mo2097x() {
        return super.mo2097x();
    }

    public /* bridge */ /* synthetic */ dwn mo2098y() {
        return super.mo2098y();
    }

    public void m15877z() {
        mo2083j();
        mo2096w().m16234D().m16263a("Application backgrounded. Logging engagement");
        long a = mo2097x().f10603l.m16328a();
        if (a > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", a);
            mo2085l().m15754a("auto", "_e", bundle);
            mo2097x().f10603l.m16329a(0);
            return;
        }
        mo2096w().m16262z().m16264a("Not logging non-positive engagement time", Long.valueOf(a));
    }
}
