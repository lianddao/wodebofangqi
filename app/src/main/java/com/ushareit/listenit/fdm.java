package com.ushareit.listenit;

import com.ushareit.listenit.widget.CustomCheckBox;

class fdm implements hbl {
    final /* synthetic */ int f12479a;
    final /* synthetic */ fdl f12480b;

    fdm(fdl com_ushareit_listenit_fdl, int i) {
        this.f12480b = com_ushareit_listenit_fdl;
        this.f12479a = i;
    }

    public void mo2353a(CustomCheckBox customCheckBox) {
        gla com_ushareit_listenit_gla = (gla) this.f12480b.f12474b.get(this.f12479a);
        com_ushareit_listenit_gla.m20775a(!com_ushareit_listenit_gla.m20780f());
        customCheckBox.m26809a(com_ushareit_listenit_gla.m20780f());
        if (this.f12480b.f12475c != null) {
            this.f12480b.f12475c.mo2606a();
        }
    }
}
