package com.ushareit.listenit;

import java.util.List;

class gyz extends hhw {
    List<glg> f14945a;
    final /* synthetic */ gyy f14946b;

    gyz(gyy com_ushareit_listenit_gyy) {
        this.f14946b = com_ushareit_listenit_gyy;
    }

    public void execute() {
        this.f14945a = this.f14946b.m23338f();
    }

    public void callback() {
        if (this.f14945a != null) {
            exw.m18443a(hhw.TAG, "asyncExtractSongMoreInfo: size=" + this.f14945a.size());
            for (glg a : this.f14945a) {
                this.f14946b.m23329a(a);
            }
            if (this.f14946b.m19817i() == 0) {
                this.f14946b.m23328g();
            }
        }
    }
}
