package com.ushareit.listenit;

import com.google.android.gms.measurement.internal.EventParcel;
import java.util.concurrent.Callable;

class dyo implements Callable<byte[]> {
    final /* synthetic */ EventParcel f10707a;
    final /* synthetic */ String f10708b;
    final /* synthetic */ dyk f10709c;

    dyo(dyk com_ushareit_listenit_dyk, EventParcel eventParcel, String str) {
        this.f10709c = com_ushareit_listenit_dyk;
        this.f10707a = eventParcel;
        this.f10708b = str;
    }

    public byte[] m16494a() {
        this.f10709c.f10695a.m16429K();
        return this.f10709c.f10695a.m16449b(this.f10707a, this.f10708b);
    }

    public /* synthetic */ Object call() {
        return m16494a();
    }
}
