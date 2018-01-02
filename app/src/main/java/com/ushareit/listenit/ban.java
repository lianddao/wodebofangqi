package com.ushareit.listenit;

import com.facebook.internal.bk;
import com.facebook.internal.cb;

class ban implements ajf {
    final /* synthetic */ bbd f5807a;
    final /* synthetic */ bbf f5808b;
    final /* synthetic */ bbj f5809c;
    final /* synthetic */ bak f5810d;

    ban(bak com_ushareit_listenit_bak, bbd com_ushareit_listenit_bbd, bbf com_ushareit_listenit_bbf, bbj com_ushareit_listenit_bbj) {
        this.f5810d = com_ushareit_listenit_bak;
        this.f5807a = com_ushareit_listenit_bbd;
        this.f5808b = com_ushareit_listenit_bbf;
        this.f5809c = com_ushareit_listenit_bbj;
    }

    public void mo634a(aje com_ushareit_listenit_aje) {
        this.f5810d.f5797s = this.f5807a.f5843e;
        if (cb.m1591a(this.f5810d.f5797s)) {
            this.f5810d.f5797s = this.f5808b.f5848e;
            this.f5810d.f5798t = this.f5808b.f5849f;
        }
        if (cb.m1591a(this.f5810d.f5797s)) {
            bk.m1465a(ajk.DEVELOPER_ERRORS, bak.f5779a, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", this.f5810d.f5789k);
            this.f5810d.m7508a("get_verified_id", this.f5808b.c != null ? this.f5808b.c : this.f5807a.c);
        }
        if (this.f5809c != null) {
            this.f5809c.mo827a();
        }
    }
}
