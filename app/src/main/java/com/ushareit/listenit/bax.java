package com.ushareit.listenit;

import com.facebook.internal.bk;

class bax implements ajf {
    final /* synthetic */ bbe f5826a;
    final /* synthetic */ bbc f5827b;
    final /* synthetic */ baw f5828c;

    bax(baw com_ushareit_listenit_baw, bbe com_ushareit_listenit_bbe, bbc com_ushareit_listenit_bbc) {
        this.f5828c = com_ushareit_listenit_baw;
        this.f5826a = com_ushareit_listenit_bbe;
        this.f5827b = com_ushareit_listenit_bbc;
    }

    public void mo634a(aje com_ushareit_listenit_aje) {
        if (this.f5826a.c == null && this.f5827b.c == null) {
            this.f5828c.f5825a.m7513a(this.f5826a.f5845e, this.f5827b.f5838e, this.f5827b.f5839f, this.f5827b.f5840g, this.f5827b.f5841h, this.f5826a.f5846f);
            return;
        }
        bk.m1465a(ajk.REQUESTS, bak.f5779a, "Unable to refresh like state for id: '%s'", this.f5828c.f5825a.f5789k);
    }
}
