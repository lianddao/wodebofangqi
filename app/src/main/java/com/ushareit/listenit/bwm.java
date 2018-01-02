package com.ushareit.listenit;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.mopub.common.AdType;

class bwm extends bws<bxl> {
    final /* synthetic */ Context f7903a;
    final /* synthetic */ AdSizeParcel f7904b;
    final /* synthetic */ String f7905c;
    final /* synthetic */ dii f7906d;
    final /* synthetic */ bwj f7907e;

    bwm(bwj com_ushareit_listenit_bwj, Context context, AdSizeParcel adSizeParcel, String str, dii com_ushareit_listenit_dii) {
        this.f7907e = com_ushareit_listenit_bwj;
        this.f7903a = context;
        this.f7904b = adSizeParcel;
        this.f7905c = str;
        this.f7906d = com_ushareit_listenit_dii;
        super(com_ushareit_listenit_bwj);
    }

    public bxl m10244a() {
        bxl a = this.f7907e.f7886c.m10197a(this.f7903a, this.f7904b, this.f7905c, this.f7906d, 2);
        if (a != null) {
            return a;
        }
        this.f7907e.m10213a(this.f7903a, AdType.INTERSTITIAL);
        return new bvu();
    }

    public bxl m10245a(bxu com_ushareit_listenit_bxu) {
        return com_ushareit_listenit_bxu.mo1190b(ckj.m11512a(this.f7903a), this.f7904b, this.f7905c, this.f7906d, cge.f8237a);
    }

    public /* synthetic */ Object mo1177b() {
        return m10244a();
    }

    public /* synthetic */ Object mo1178b(bxu com_ushareit_listenit_bxu) {
        return m10245a(com_ushareit_listenit_bxu);
    }
}
