package com.ushareit.listenit;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.EventParcel;

class dvk implements Runnable {
    final /* synthetic */ String f10418a;
    final /* synthetic */ EventParcel f10419b;
    final /* synthetic */ dvg f10420c;

    dvk(dvg com_ushareit_listenit_dvg, String str, EventParcel eventParcel) {
        this.f10420c = com_ushareit_listenit_dvg;
        this.f10418a = str;
        this.f10419b = eventParcel;
    }

    public void run() {
        dxb c = this.f10420c.f10404b;
        if (c == null) {
            this.f10420c.mo2096w().m16242f().m16263a("Discarding data. Failed to send event to service");
            return;
        }
        try {
            if (TextUtils.isEmpty(this.f10418a)) {
                c.mo2102a(this.f10419b, this.f10420c.mo2086m().m16200a(this.f10420c.mo2096w().m16236F()));
            } else {
                c.mo2103a(this.f10419b, this.f10418a, this.f10420c.mo2096w().m16236F());
            }
            this.f10420c.m15779D();
        } catch (RemoteException e) {
            this.f10420c.mo2096w().m16242f().m16264a("Failed to send event to the service", e);
        }
    }
}
