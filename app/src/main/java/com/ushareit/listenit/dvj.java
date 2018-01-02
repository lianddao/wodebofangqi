package com.ushareit.listenit;

import android.os.RemoteException;

class dvj implements Runnable {
    final /* synthetic */ dvg f10417a;

    dvj(dvg com_ushareit_listenit_dvg) {
        this.f10417a = com_ushareit_listenit_dvg;
    }

    public void run() {
        dxb c = this.f10417a.f10404b;
        if (c == null) {
            this.f10417a.mo2096w().m16242f().m16263a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            c.mo2106b(this.f10417a.mo2086m().m16200a(this.f10417a.mo2096w().m16236F()));
            this.f10417a.m15779D();
        } catch (RemoteException e) {
            this.f10417a.mo2096w().m16242f().m16264a("Failed to send measurementEnabled to the service", e);
        }
    }
}
