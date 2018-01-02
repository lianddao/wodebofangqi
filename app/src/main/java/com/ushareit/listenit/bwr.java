package com.ushareit.listenit;

import android.app.Activity;

class bwr extends bws<djn> {
    final /* synthetic */ Activity f7920a;
    final /* synthetic */ bwj f7921b;

    bwr(bwj com_ushareit_listenit_bwj, Activity activity) {
        this.f7921b = com_ushareit_listenit_bwj;
        this.f7920a = activity;
        super(com_ushareit_listenit_bwj);
    }

    public djn m10264a() {
        djn a = this.f7921b.f7892i.m14661a(this.f7920a);
        if (a != null) {
            return a;
        }
        this.f7921b.m10213a(this.f7920a, "ad_overlay");
        return null;
    }

    public djn m10265a(bxu com_ushareit_listenit_bxu) {
        return com_ushareit_listenit_bxu.mo1192c(ckj.m11512a(this.f7920a));
    }

    public /* synthetic */ Object mo1177b() {
        return m10264a();
    }

    public /* synthetic */ Object mo1178b(bxu com_ushareit_listenit_bxu) {
        return m10265a(com_ushareit_listenit_bxu);
    }
}
