package com.ushareit.listenit;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;

class dym implements Runnable {
    final /* synthetic */ AppMetadata f10700a;
    final /* synthetic */ EventParcel f10701b;
    final /* synthetic */ dyk f10702c;

    dym(dyk com_ushareit_listenit_dyk, AppMetadata appMetadata, EventParcel eventParcel) {
        this.f10702c = com_ushareit_listenit_dyk;
        this.f10700a = appMetadata;
        this.f10701b = eventParcel;
    }

    public void run() {
        this.f10702c.f10695a.m16429K();
        this.f10702c.m16490a(this.f10700a.f1892h);
        this.f10702c.f10695a.m16435a(this.f10701b, this.f10700a);
    }
}
