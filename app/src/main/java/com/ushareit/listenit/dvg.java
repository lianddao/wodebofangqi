package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class dvg extends duy {
    private final dvo f10403a;
    private dxb f10404b;
    private Boolean f10405c;
    private final dws f10406d;
    private final dwf f10407e;
    private final List<Runnable> f10408f = new ArrayList();
    private final dws f10409g;

    protected dvg(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
        this.f10407e = new dwf(com_ushareit_listenit_dyf.m16468s());
        this.f10403a = new dvo(this);
        this.f10406d = new dvh(this, com_ushareit_listenit_dyf);
        this.f10409g = new dvi(this, com_ushareit_listenit_dyf);
    }

    private void m15779D() {
        mo2083j();
        this.f10407e.m15885a();
        if (!this.n.m16422D()) {
            this.f10406d.m15826a(mo2098y().m16011J());
        }
    }

    private boolean m15780E() {
        if (mo2098y().m16015N()) {
            return false;
        }
        List queryIntentServices = mo2090q().getPackageManager().queryIntentServices(new Intent().setClassName(mo2090q(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    private void m15781F() {
        mo2083j();
        if (m15800f()) {
            mo2096w().m16235E().m16263a("Inactivity, disconnecting from the service");
            m15795C();
        }
    }

    private void m15782G() {
        mo2083j();
        m15793A();
    }

    private void m15783H() {
        mo2083j();
        mo2096w().m16235E().m16264a("Processing queued up service tasks", Integer.valueOf(this.f10408f.size()));
        for (Runnable a : this.f10408f) {
            mo2095v().m16380a(a);
        }
        this.f10408f.clear();
        this.f10409g.m15828c();
    }

    private void m15785a(ComponentName componentName) {
        mo2083j();
        if (this.f10404b != null) {
            this.f10404b = null;
            mo2096w().m16235E().m16264a("Disconnected from device MeasurementService", componentName);
            m15782G();
        }
    }

    private void m15788a(dxb com_ushareit_listenit_dxb) {
        mo2083j();
        cfi.m11080a((Object) com_ushareit_listenit_dxb);
        this.f10404b = com_ushareit_listenit_dxb;
        m15779D();
        m15783H();
    }

    private void m15789a(Runnable runnable) {
        mo2083j();
        if (m15800f()) {
            runnable.run();
        } else if (((long) this.f10408f.size()) >= mo2098y().m16022U()) {
            mo2096w().m16242f().m16263a("Discarding data. Max runnable queue size reached");
        } else {
            this.f10408f.add(runnable);
            if (!this.n.m16422D()) {
                this.f10409g.m15826a(60000);
            }
            m15793A();
        }
    }

    void m15793A() {
        mo2083j();
        m15696c();
        if (!m15800f()) {
            if (this.f10405c == null) {
                this.f10405c = mo2097x().m16311B();
                if (this.f10405c == null) {
                    mo2096w().m16235E().m16263a("State of service unknown");
                    this.f10405c = Boolean.valueOf(m15794B());
                    mo2097x().m16315a(this.f10405c.booleanValue());
                }
            }
            if (this.f10405c.booleanValue()) {
                mo2096w().m16235E().m16263a("Using measurement service");
                this.f10403a.m15832a();
            } else if (this.n.m16422D() || !m15780E()) {
                mo2096w().m16242f().m16263a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            } else {
                mo2096w().m16235E().m16263a("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(mo2090q(), mo2098y().m16015N() ? "com.google.android.gms.measurement.PackageMeasurementService" : "com.google.android.gms.measurement.AppMeasurementService"));
                this.f10403a.m15834a(intent);
            }
        }
    }

    protected boolean m15794B() {
        mo2083j();
        m15696c();
        if (mo2098y().m16015N()) {
            return true;
        }
        mo2096w().m16235E().m16263a("Checking service availability");
        switch (cjb.m10875b().mo1287a(mo2090q())) {
            case 0:
                mo2096w().m16235E().m16263a("Service available");
                return true;
            case 1:
                mo2096w().m16235E().m16263a("Service missing");
                return false;
            case 2:
                mo2096w().m16234D().m16263a("Service container out of date");
                return true;
            case 3:
                mo2096w().m16262z().m16263a("Service disabled");
                return false;
            case 9:
                mo2096w().m16262z().m16263a("Service invalid");
                return false;
            case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                mo2096w().m16262z().m16263a("Service updating");
                return true;
            default:
                return false;
        }
    }

    public void m15795C() {
        mo2083j();
        m15696c();
        try {
            cig.m11364a().m11375a(mo2090q(), this.f10403a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.f10404b = null;
    }

    protected void m15796a(EventParcel eventParcel, String str) {
        cfi.m11080a((Object) eventParcel);
        mo2083j();
        m15696c();
        m15789a(new dvk(this, str, eventParcel));
    }

    protected void m15797a(UserAttributeParcel userAttributeParcel) {
        mo2083j();
        m15696c();
        m15789a(new dvl(this, userAttributeParcel));
    }

    protected void m15798a(AtomicReference<List<UserAttributeParcel>> atomicReference, boolean z) {
        mo2083j();
        m15696c();
        m15789a(new dvm(this, atomicReference, z));
    }

    protected void mo2080e() {
    }

    public boolean m15800f() {
        mo2083j();
        m15696c();
        return this.f10404b != null;
    }

    protected void m15801g() {
        mo2083j();
        m15696c();
        m15789a(new dvj(this));
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

    protected void m15820z() {
        mo2083j();
        m15696c();
        m15789a(new dvn(this));
    }
}
