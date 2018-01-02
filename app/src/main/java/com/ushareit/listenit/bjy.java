package com.ushareit.listenit;

import com.google.android.exoplayer2.drm.DrmInitData;

final class bjy {
    public final bkg f6681a = new bkg();
    public final bii f6682b;
    public bke f6683c;
    public bjs f6684d;
    public int f6685e;
    public int f6686f;
    public int f6687g;

    public bjy(bii com_ushareit_listenit_bii) {
        this.f6682b = com_ushareit_listenit_bii;
    }

    public void m8780a(bke com_ushareit_listenit_bke, bjs com_ushareit_listenit_bjs) {
        this.f6683c = (bke) bsg.m9654a((Object) com_ushareit_listenit_bke);
        this.f6684d = (bjs) bsg.m9654a((Object) com_ushareit_listenit_bjs);
        this.f6682b.mo975a(com_ushareit_listenit_bke.f6723f);
        m8778a();
    }

    public void m8778a() {
        this.f6681a.m8806a();
        this.f6685e = 0;
        this.f6687g = 0;
        this.f6686f = 0;
    }

    public void m8779a(DrmInitData drmInitData) {
        this.f6682b.mo975a(this.f6683c.f6723f.m2080a(drmInitData));
    }
}
