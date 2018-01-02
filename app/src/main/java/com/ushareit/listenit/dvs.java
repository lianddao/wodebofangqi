package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.Context;

class dvs implements Runnable {
    final /* synthetic */ dvo f10436a;

    dvs(dvo com_ushareit_listenit_dvo) {
        this.f10436a = com_ushareit_listenit_dvo;
    }

    public void run() {
        dvg com_ushareit_listenit_dvg = this.f10436a.f10427a;
        Context q = this.f10436a.f10427a.mo2090q();
        String str = (!this.f10436a.f10427a.mo2098y().m16015N() || this.f10436a.f10427a.n.m16422D()) ? "com.google.android.gms.measurement.AppMeasurementService" : "com.google.android.gms.measurement.PackageMeasurementService";
        com_ushareit_listenit_dvg.m15785a(new ComponentName(q, str));
    }
}
