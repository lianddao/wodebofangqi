package com.ushareit.listenit;

import android.app.Activity;

class bwq extends bws<djz> {
    final /* synthetic */ Activity f7918a;
    final /* synthetic */ bwj f7919b;

    bwq(bwj com_ushareit_listenit_bwj, Activity activity) {
        this.f7919b = com_ushareit_listenit_bwj;
        this.f7918a = activity;
        super(com_ushareit_listenit_bwj);
    }

    public djz m10260a() {
        djz a = this.f7919b.f7891h.m14731a(this.f7918a);
        if (a != null) {
            return a;
        }
        this.f7919b.m10213a(this.f7918a, "iap");
        return null;
    }

    public djz m10261a(bxu com_ushareit_listenit_bxu) {
        return com_ushareit_listenit_bxu.mo1191b(ckj.m11512a(this.f7918a));
    }

    public /* synthetic */ Object mo1177b() {
        return m10260a();
    }

    public /* synthetic */ Object mo1178b(bxu com_ushareit_listenit_bxu) {
        return m10261a(com_ushareit_listenit_bxu);
    }
}
