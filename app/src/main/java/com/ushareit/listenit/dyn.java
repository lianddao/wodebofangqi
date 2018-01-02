package com.ushareit.listenit;

import com.google.android.gms.measurement.internal.EventParcel;

class dyn implements Runnable {
    final /* synthetic */ String f10703a;
    final /* synthetic */ EventParcel f10704b;
    final /* synthetic */ String f10705c;
    final /* synthetic */ dyk f10706d;

    dyn(dyk com_ushareit_listenit_dyk, String str, EventParcel eventParcel, String str2) {
        this.f10706d = com_ushareit_listenit_dyk;
        this.f10703a = str;
        this.f10704b = eventParcel;
        this.f10705c = str2;
    }

    public void run() {
        this.f10706d.f10695a.m16429K();
        this.f10706d.m16490a(this.f10703a);
        this.f10706d.f10695a.m16436a(this.f10704b, this.f10705c);
    }
}
