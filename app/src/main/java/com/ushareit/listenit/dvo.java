package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

public class dvo implements ServiceConnection, cfu, cfv {
    final /* synthetic */ dvg f10427a;
    private volatile boolean f10428b;
    private volatile dxf f10429c;

    protected dvo(dvg com_ushareit_listenit_dvg) {
        this.f10427a = com_ushareit_listenit_dvg;
    }

    public void m15832a() {
        this.f10427a.mo2083j();
        Context q = this.f10427a.mo2090q();
        synchronized (this) {
            if (this.f10428b) {
                this.f10427a.mo2096w().m16235E().m16263a("Connection attempt already in progress");
            } else if (this.f10429c != null) {
                this.f10427a.mo2096w().m16235E().m16263a("Already awaiting connection attempt");
            } else {
                this.f10429c = new dxf(q, Looper.getMainLooper(), this, this);
                this.f10427a.mo2096w().m16235E().m16263a("Connecting to remote service");
                this.f10428b = true;
                this.f10429c.m10629o();
            }
        }
    }

    public void mo1317a(int i) {
        cfi.m11088b("MeasurementServiceConnection.onConnectionSuspended");
        this.f10427a.mo2096w().m16234D().m16263a("Service connection suspended");
        this.f10427a.mo2095v().m16380a(new dvs(this));
    }

    public void m15834a(Intent intent) {
        this.f10427a.mo2083j();
        Context q = this.f10427a.mo2090q();
        cig a = cig.m11364a();
        synchronized (this) {
            if (this.f10428b) {
                this.f10427a.mo2096w().m16235E().m16263a("Connection attempt already in progress");
                return;
            }
            this.f10428b = true;
            a.m11377a(q, intent, this.f10427a.f10403a, 129);
        }
    }

    public void mo1318a(Bundle bundle) {
        cfi.m11088b("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                dxb com_ushareit_listenit_dxb = (dxb) this.f10429c.m10635u();
                this.f10429c = null;
                this.f10427a.mo2095v().m16380a(new dvr(this, com_ushareit_listenit_dxb));
            } catch (DeadObjectException e) {
                this.f10429c = null;
                this.f10428b = false;
            } catch (IllegalStateException e2) {
                this.f10429c = null;
                this.f10428b = false;
            }
        }
    }

    public void mo1319a(ConnectionResult connectionResult) {
        cfi.m11088b("MeasurementServiceConnection.onConnectionFailed");
        dxg g = this.f10427a.n.m16456g();
        if (g != null) {
            g.m16262z().m16264a("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f10428b = false;
            this.f10429c = null;
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        cfi.m11088b("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f10428b = false;
                this.f10427a.mo2096w().m16242f().m16263a("Service connected with null binder");
                return;
            }
            dxb com_ushareit_listenit_dxb = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    com_ushareit_listenit_dxb = dxc.m16187a(iBinder);
                    this.f10427a.mo2096w().m16235E().m16263a("Bound to IMeasurementService interface");
                } else {
                    this.f10427a.mo2096w().m16242f().m16264a("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException e) {
                this.f10427a.mo2096w().m16242f().m16263a("Service connect failed to get IMeasurementService");
            }
            if (com_ushareit_listenit_dxb == null) {
                this.f10428b = false;
                try {
                    cig.m11364a().m11375a(this.f10427a.mo2090q(), this.f10427a.f10403a);
                } catch (IllegalArgumentException e2) {
                }
            } else {
                this.f10427a.mo2095v().m16380a(new dvp(this, com_ushareit_listenit_dxb));
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        cfi.m11088b("MeasurementServiceConnection.onServiceDisconnected");
        this.f10427a.mo2096w().m16234D().m16263a("Service disconnected");
        this.f10427a.mo2095v().m16380a(new dvq(this, componentName));
    }
}
