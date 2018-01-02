package com.ushareit.listenit;

import android.content.Context;

class bwn extends bws<bxf> {
    final /* synthetic */ Context f7908a;
    final /* synthetic */ String f7909b;
    final /* synthetic */ dii f7910c;
    final /* synthetic */ bwj f7911d;

    bwn(bwj com_ushareit_listenit_bwj, Context context, String str, dii com_ushareit_listenit_dii) {
        this.f7911d = com_ushareit_listenit_bwj;
        this.f7908a = context;
        this.f7909b = str;
        this.f7910c = com_ushareit_listenit_dii;
        super(com_ushareit_listenit_bwj);
    }

    public bxf m10248a() {
        bxf a = this.f7911d.f7887d.m10194a(this.f7908a, this.f7909b, this.f7910c);
        if (a != null) {
            return a;
        }
        this.f7911d.m10213a(this.f7908a, "native_ad");
        return new bvq();
    }

    public bxf m10249a(bxu com_ushareit_listenit_bxu) {
        return com_ushareit_listenit_bxu.mo1183a(ckj.m11512a(this.f7908a), this.f7909b, this.f7910c, (int) cge.f8237a);
    }

    public /* synthetic */ Object mo1177b() {
        return m10248a();
    }

    public /* synthetic */ Object mo1178b(bxu com_ushareit_listenit_bxu) {
        return m10249a(com_ushareit_listenit_bxu);
    }
}
