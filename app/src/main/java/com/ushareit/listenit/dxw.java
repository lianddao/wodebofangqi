package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public final class dxw {
    static Boolean f10625a;
    static Boolean f10626b;
    private final dxy f10627c;

    public dxw(dxy com_ushareit_listenit_dxy) {
        cfi.m11080a((Object) com_ushareit_listenit_dxy);
        this.f10627c = com_ushareit_listenit_dxy;
    }

    public static boolean m16336a(Context context, boolean z) {
        cfi.m11080a((Object) context);
        if (f10625a != null && !z) {
            return f10625a.booleanValue();
        }
        if (f10626b != null && z) {
            return f10626b.booleanValue();
        }
        boolean a = dwk.m15931a(context, z ? "com.google.android.gms.measurement.PackageMeasurementReceiver" : "com.google.android.gms.measurement.AppMeasurementReceiver", false);
        if (z) {
            f10626b = Boolean.valueOf(a);
            return a;
        }
        f10625a = Boolean.valueOf(a);
        return a;
    }

    public void m16337a(Context context, Intent intent) {
        dyf a = dyf.m16409a(context);
        dxg f = a.m16455f();
        if (intent == null) {
            f.m16262z().m16263a("Receiver called with null intent");
            return;
        }
        boolean N = a.m16452d().m16015N();
        String action = intent.getAction();
        if (N) {
            f.m16235E().m16264a("Device receiver got", action);
        } else {
            f.m16235E().m16264a("Local receiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean z = N && !a.m16422D();
            dvt.m15838a(context, z);
            Intent intent2 = new Intent();
            action = (!N || a.m16422D()) ? "com.google.android.gms.measurement.AppMeasurementService" : "com.google.android.gms.measurement.PackageMeasurementService";
            Intent className = intent2.setClassName(context, action);
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            this.f10627c.mo270a(context, className);
        } else if (!N && "com.android.vending.INSTALL_REFERRER".equals(action)) {
            action = intent.getStringExtra("referrer");
            if (action == null) {
                f.m16235E().m16263a("Install referrer extras are null");
                return;
            }
            Bundle a2 = a.m16464o().m15942a(Uri.parse(action));
            if (a2 == null) {
                f.m16235E().m16263a("No campaign defined in install referrer broadcast");
                return;
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                f.m16262z().m16263a("Install referrer is missing timestamp");
            }
            a.m16457h().m16380a(new dxx(this, a, longExtra, a2, context, f));
        }
    }
}
