package com.ushareit.listenit;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

class dvl implements Runnable {
    final /* synthetic */ UserAttributeParcel f10421a;
    final /* synthetic */ dvg f10422b;

    dvl(dvg com_ushareit_listenit_dvg, UserAttributeParcel userAttributeParcel) {
        this.f10422b = com_ushareit_listenit_dvg;
        this.f10421a = userAttributeParcel;
    }

    public void run() {
        dxb c = this.f10422b.f10404b;
        if (c == null) {
            this.f10422b.mo2096w().m16242f().m16263a("Discarding data. Failed to set user attribute");
            return;
        }
        try {
            c.mo2104a(this.f10421a, this.f10422b.mo2086m().m16200a(this.f10422b.mo2096w().m16236F()));
            this.f10422b.m15779D();
        } catch (RemoteException e) {
            this.f10422b.mo2096w().m16242f().m16264a("Failed to send attribute to the service", e);
        }
    }
}
