package com.ushareit.listenit;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

class dyp implements Runnable {
    final /* synthetic */ AppMetadata f10710a;
    final /* synthetic */ UserAttributeParcel f10711b;
    final /* synthetic */ dyk f10712c;

    dyp(dyk com_ushareit_listenit_dyk, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.f10712c = com_ushareit_listenit_dyk;
        this.f10710a = appMetadata;
        this.f10711b = userAttributeParcel;
    }

    public void run() {
        this.f10712c.f10695a.m16429K();
        this.f10712c.m16490a(this.f10710a.f1892h);
        this.f10712c.f10695a.m16447b(this.f10711b, this.f10710a);
    }
}
