package com.ushareit.listenit;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

class dyq implements Runnable {
    final /* synthetic */ AppMetadata f10713a;
    final /* synthetic */ UserAttributeParcel f10714b;
    final /* synthetic */ dyk f10715c;

    dyq(dyk com_ushareit_listenit_dyk, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.f10715c = com_ushareit_listenit_dyk;
        this.f10713a = appMetadata;
        this.f10714b = userAttributeParcel;
    }

    public void run() {
        this.f10715c.f10695a.m16429K();
        this.f10715c.m16490a(this.f10713a.f1892h);
        this.f10715c.f10695a.m16437a(this.f10714b, this.f10713a);
    }
}
