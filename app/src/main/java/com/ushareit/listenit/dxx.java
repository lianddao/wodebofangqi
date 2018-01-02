package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

class dxx implements Runnable {
    final /* synthetic */ dyf f10628a;
    final /* synthetic */ long f10629b;
    final /* synthetic */ Bundle f10630c;
    final /* synthetic */ Context f10631d;
    final /* synthetic */ dxg f10632e;
    final /* synthetic */ dxw f10633f;

    dxx(dxw com_ushareit_listenit_dxw, dyf com_ushareit_listenit_dyf, long j, Bundle bundle, Context context, dxg com_ushareit_listenit_dxg) {
        this.f10633f = com_ushareit_listenit_dxw;
        this.f10628a = com_ushareit_listenit_dyf;
        this.f10629b = j;
        this.f10630c = bundle;
        this.f10631d = context;
        this.f10632e = com_ushareit_listenit_dxg;
    }

    public void run() {
        dwj c = this.f10628a.m16465p().m16114c(this.f10628a.m16471v().m16203f(), "_fot");
        long longValue = (c == null || !(c.f10477d instanceof Long)) ? 0 : ((Long) c.f10477d).longValue();
        long j = this.f10629b;
        longValue = (longValue <= 0 || (j < longValue && j > 0)) ? j : longValue - 1;
        if (longValue > 0) {
            this.f10630c.putLong("click_timestamp", longValue);
        }
        AppMeasurement.getInstance(this.f10631d).m2428a("auto", "_cmp", this.f10630c);
        this.f10632e.m16235E().m16263a("Install campaign recorded");
    }
}
