package com.ushareit.listenit;

import android.os.RemoteException;

class dvn implements Runnable {
    final /* synthetic */ dvg f10426a;

    dvn(dvg com_ushareit_listenit_dvg) {
        this.f10426a = com_ushareit_listenit_dvg;
    }

    public void run() {
        dxb c = this.f10426a.f10404b;
        if (c == null) {
            this.f10426a.mo2096w().m16242f().m16263a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            c.mo2101a(this.f10426a.mo2086m().m16200a(this.f10426a.mo2096w().m16236F()));
            this.f10426a.m15779D();
        } catch (RemoteException e) {
            this.f10426a.mo2096w().m16242f().m16264a("Failed to send app launch to the service", e);
        }
    }
}
