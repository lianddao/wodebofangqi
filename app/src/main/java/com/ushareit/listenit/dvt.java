package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

public final class dvt {
    private static Boolean f10437d;
    private static Boolean f10438e;
    private final Handler f10439a = new Handler();
    private final Context f10440b;
    private final dvw f10441c;

    public dvt(dvw com_ushareit_listenit_dvw) {
        this.f10440b = com_ushareit_listenit_dvw.mo271a();
        cfi.m11080a(this.f10440b);
        this.f10441c = com_ushareit_listenit_dvw;
    }

    public static boolean m15838a(Context context, boolean z) {
        cfi.m11080a((Object) context);
        if (f10437d != null && !z) {
            return f10437d.booleanValue();
        }
        if (f10438e != null && z) {
            return f10438e.booleanValue();
        }
        boolean a = dwk.m15930a(context, z ? "com.google.android.gms.measurement.PackageMeasurementService" : "com.google.android.gms.measurement.AppMeasurementService");
        if (z) {
            f10438e = Boolean.valueOf(a);
            return a;
        }
        f10437d = Boolean.valueOf(a);
        return a;
    }

    private dxg m15840c() {
        return dyf.m16409a(this.f10440b).m16455f();
    }

    public int m15841a(Intent intent, int i, int i2) {
        dyf a = dyf.m16409a(this.f10440b);
        dxg f = a.m16455f();
        if (intent == null) {
            f.m16262z().m16263a("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            if (a.m16452d().m16015N()) {
                f.m16235E().m16265a("Device PackageMeasurementService called. startId, action", Integer.valueOf(i2), action);
            } else {
                f.m16235E().m16265a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            }
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                a.m16457h().m16380a(new dvu(this, a, i2, f));
            }
        }
        return 2;
    }

    public IBinder m15842a(Intent intent) {
        if (intent == null) {
            m15840c().m16242f().m16263a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new dyk(dyf.m16409a(this.f10440b));
        }
        m15840c().m16262z().m16264a("onBind received unknown action", action);
        return null;
    }

    public void m15843a() {
        dyf a = dyf.m16409a(this.f10440b);
        dxg f = a.m16455f();
        if (a.m16452d().m16015N()) {
            f.m16235E().m16263a("Device PackageMeasurementService is starting up");
        } else {
            f.m16235E().m16263a("Local AppMeasurementService is starting up");
        }
    }

    public void m15844b() {
        dyf a = dyf.m16409a(this.f10440b);
        dxg f = a.m16455f();
        if (a.m16452d().m16015N()) {
            f.m16235E().m16263a("Device PackageMeasurementService is shutting down");
        } else {
            f.m16235E().m16263a("Local AppMeasurementService is shutting down");
        }
    }

    public boolean m15845b(Intent intent) {
        if (intent == null) {
            m15840c().m16242f().m16263a("onUnbind called with null intent");
        } else {
            m15840c().m16235E().m16264a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }

    public void m15846c(Intent intent) {
        if (intent == null) {
            m15840c().m16242f().m16263a("onRebind called with null intent");
            return;
        }
        m15840c().m16235E().m16264a("onRebind called. action", intent.getAction());
    }
}
