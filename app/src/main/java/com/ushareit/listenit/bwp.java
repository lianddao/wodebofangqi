package com.ushareit.listenit;

import android.content.Context;
import android.widget.FrameLayout;

class bwp extends bws<dhb> {
    final /* synthetic */ FrameLayout f7914a;
    final /* synthetic */ FrameLayout f7915b;
    final /* synthetic */ Context f7916c;
    final /* synthetic */ bwj f7917d;

    bwp(bwj com_ushareit_listenit_bwj, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.f7917d = com_ushareit_listenit_bwj;
        this.f7914a = frameLayout;
        this.f7915b = frameLayout2;
        this.f7916c = context;
        super(com_ushareit_listenit_bwj);
    }

    public dhb m10256a() {
        dhb a = this.f7917d.f7889f.m14405a(this.f7916c, this.f7914a, this.f7915b);
        if (a != null) {
            return a;
        }
        this.f7917d.m10213a(this.f7916c, "native_ad_view_delegate");
        return new bvx();
    }

    public dhb m10257a(bxu com_ushareit_listenit_bxu) {
        return com_ushareit_listenit_bxu.mo1189a(ckj.m11512a(this.f7914a), ckj.m11512a(this.f7915b));
    }

    public /* synthetic */ Object mo1177b() {
        return m10256a();
    }

    public /* synthetic */ Object mo1178b(bxu com_ushareit_listenit_bxu) {
        return m10257a(com_ushareit_listenit_bxu);
    }
}
