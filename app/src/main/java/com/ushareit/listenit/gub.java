package com.ushareit.listenit;

import java.util.List;

class gub extends hhw {
    List<? extends gla> f14735a;
    final /* synthetic */ gua f14736b;

    gub(gua com_ushareit_listenit_gua) {
        this.f14736b = com_ushareit_listenit_gua;
    }

    public void execute() {
        this.f14735a = this.f14736b.f14731f.m21510a(this.f14736b.f14733h, this.f14736b.f14732g);
    }

    public void callback() {
        this.f14736b.m22709W();
        if (this.f14735a != null && !this.f14735a.isEmpty()) {
            this.f14736b.f14734i.setVisibility(0);
            this.f14736b.f14734i.m26855a();
            if (this.f14736b.f14732g == 0) {
                this.f14736b.f14730e.m22726a(this.f14735a);
            } else {
                this.f14736b.f14730e.m22729b(this.f14735a);
            }
            this.f14736b.f14730e.notifyDataSetChanged();
        } else if (this.f14736b.f14732g == 0) {
            this.f14736b.f14734i.setVisibility(8);
            this.f14736b.m22710X();
            this.f14736b.f14730e.m22724a();
            this.f14736b.f14730e.notifyDataSetChanged();
        } else {
            this.f14736b.f14734i.setVisibility(0);
            this.f14736b.f14734i.setNoMoreText(this.f14736b.m1329n().getString(C0349R.string.search_fragment_music_not_found));
            this.f14736b.f14734i.m26856b();
        }
    }
}
