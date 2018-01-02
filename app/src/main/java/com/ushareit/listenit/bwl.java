package com.ushareit.listenit;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

class bwl extends bws<bxl> {
    final /* synthetic */ Context f7899a;
    final /* synthetic */ AdSizeParcel f7900b;
    final /* synthetic */ String f7901c;
    final /* synthetic */ bwj f7902d;

    bwl(bwj com_ushareit_listenit_bwj, Context context, AdSizeParcel adSizeParcel, String str) {
        this.f7902d = com_ushareit_listenit_bwj;
        this.f7899a = context;
        this.f7900b = adSizeParcel;
        this.f7901c = str;
        super(com_ushareit_listenit_bwj);
    }

    public bxl m10240a() {
        bxl a = this.f7902d.f7886c.m10197a(this.f7899a, this.f7900b, this.f7901c, null, 3);
        if (a != null) {
            return a;
        }
        this.f7902d.m10213a(this.f7899a, "search");
        return new bvu();
    }

    public bxl m10241a(bxu com_ushareit_listenit_bxu) {
        return com_ushareit_listenit_bxu.mo1184a(ckj.m11512a(this.f7899a), this.f7900b, this.f7901c, (int) cge.f8237a);
    }

    public /* synthetic */ Object mo1177b() {
        return m10240a();
    }

    public /* synthetic */ Object mo1178b(bxu com_ushareit_listenit_bxu) {
        return m10241a(com_ushareit_listenit_bxu);
    }
}
