package com.ushareit.listenit;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

class bwk extends bws<bxl> {
    final /* synthetic */ Context f7894a;
    final /* synthetic */ AdSizeParcel f7895b;
    final /* synthetic */ String f7896c;
    final /* synthetic */ dii f7897d;
    final /* synthetic */ bwj f7898e;

    bwk(bwj com_ushareit_listenit_bwj, Context context, AdSizeParcel adSizeParcel, String str, dii com_ushareit_listenit_dii) {
        this.f7898e = com_ushareit_listenit_bwj;
        this.f7894a = context;
        this.f7895b = adSizeParcel;
        this.f7896c = str;
        this.f7897d = com_ushareit_listenit_dii;
        super(com_ushareit_listenit_bwj);
    }

    public bxl m10236a() {
        bxl a = this.f7898e.f7886c.m10197a(this.f7894a, this.f7895b, this.f7896c, this.f7897d, 1);
        if (a != null) {
            return a;
        }
        this.f7898e.m10213a(this.f7894a, "banner");
        return new bvu();
    }

    public bxl m10237a(bxu com_ushareit_listenit_bxu) {
        return com_ushareit_listenit_bxu.mo1185a(ckj.m11512a(this.f7894a), this.f7895b, this.f7896c, this.f7897d, cge.f8237a);
    }

    public /* synthetic */ Object mo1177b() {
        return m10236a();
    }

    public /* synthetic */ Object mo1178b(bxu com_ushareit_listenit_bxu) {
        return m10237a(com_ushareit_listenit_bxu);
    }
}
