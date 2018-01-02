package com.ushareit.listenit;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

class dvm implements Runnable {
    final /* synthetic */ AtomicReference f10423a;
    final /* synthetic */ boolean f10424b;
    final /* synthetic */ dvg f10425c;

    dvm(dvg com_ushareit_listenit_dvg, AtomicReference atomicReference, boolean z) {
        this.f10425c = com_ushareit_listenit_dvg;
        this.f10423a = atomicReference;
        this.f10424b = z;
    }

    public void run() {
        synchronized (this.f10423a) {
            try {
                dxb c = this.f10425c.f10404b;
                if (c == null) {
                    this.f10425c.mo2096w().m16242f().m16263a("Failed to get user properties");
                    this.f10423a.notify();
                    return;
                }
                this.f10423a.set(c.mo2100a(this.f10425c.mo2086m().m16200a(null), this.f10424b));
                this.f10425c.m15779D();
                this.f10423a.notify();
            } catch (RemoteException e) {
                this.f10425c.mo2096w().m16242f().m16264a("Failed to get user properties", e);
                this.f10423a.notify();
            } catch (Throwable th) {
                this.f10423a.notify();
            }
        }
    }
}
