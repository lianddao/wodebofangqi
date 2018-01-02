package com.ushareit.listenit;

import android.content.Context;

class bwo extends bws<bya> {
    final /* synthetic */ Context f7912a;
    final /* synthetic */ bwj f7913b;

    bwo(bwj com_ushareit_listenit_bwj, Context context) {
        this.f7913b = com_ushareit_listenit_bwj;
        this.f7912a = context;
        super(com_ushareit_listenit_bwj);
    }

    public bya m10252a() {
        bya a = this.f7913b.f7888e.m10060a(this.f7912a);
        if (a != null) {
            return a;
        }
        this.f7913b.m10213a(this.f7912a, "mobile_ads_settings");
        return new bvw();
    }

    public bya m10253a(bxu com_ushareit_listenit_bxu) {
        return com_ushareit_listenit_bxu.mo1187a(ckj.m11512a(this.f7912a), (int) cge.f8237a);
    }

    public /* synthetic */ Object mo1177b() {
        return m10252a();
    }

    public /* synthetic */ Object mo1178b(bxu com_ushareit_listenit_bxu) {
        return m10253a(com_ushareit_listenit_bxu);
    }
}
