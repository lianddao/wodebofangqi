package com.ushareit.listenit;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class dwg extends duy {
    private boolean f10470a;
    private final AlarmManager f10471b = ((AlarmManager) mo2090q().getSystemService("alarm"));
    private final dws f10472c;

    protected dwg(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
        this.f10472c = new dwh(this, com_ushareit_listenit_dyf);
    }

    private PendingIntent m15889g() {
        Intent intent = new Intent();
        Context q = mo2090q();
        String str = (!mo2098y().m16015N() || this.n.m16422D()) ? "com.google.android.gms.measurement.AppMeasurementReceiver" : "com.google.android.gms.measurement.PackageMeasurementReceiver";
        Intent className = intent.setClassName(q, str);
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(mo2090q(), 0, className, 0);
    }

    private void m15890z() {
        Intent intent = new Intent();
        Context q = mo2090q();
        String str = (!mo2098y().m16015N() || this.n.m16422D()) ? "com.google.android.gms.measurement.AppMeasurementReceiver" : "com.google.android.gms.measurement.PackageMeasurementReceiver";
        Intent className = intent.setClassName(q, str);
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        mo2090q().sendBroadcast(className);
    }

    public void m15891a(long j) {
        boolean z = false;
        m15696c();
        boolean z2 = mo2098y().m16015N() || dxw.m16336a(mo2090q(), false);
        cfi.m11086a(z2, (Object) "Receiver not registered/enabled");
        if (mo2098y().m16015N() || dvt.m15838a(mo2090q(), false)) {
            z = true;
        }
        cfi.m11086a(z, (Object) "Service not registered/enabled");
        m15893f();
        long b = mo2089p().mo1371b() + j;
        this.f10470a = true;
        if (j < mo2098y().ae() && !this.f10472c.m15827b()) {
            this.f10472c.m15826a(j);
        }
        this.f10471b.setInexactRepeating(2, b, Math.max(mo2098y().af(), j), m15889g());
    }

    protected void mo2080e() {
        this.f10471b.cancel(m15889g());
    }

    public void m15893f() {
        m15696c();
        this.f10470a = false;
        this.f10471b.cancel(m15889g());
        this.f10472c.m15828c();
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
}
