package com.ushareit.listenit;

import android.widget.ImageView;
import java.util.List;

class gtt extends hhw {
    final /* synthetic */ String f14719a;
    final /* synthetic */ gta f14720b;

    gtt(gta com_ushareit_listenit_gta, String str) {
        this.f14720b = com_ushareit_listenit_gta;
        this.f14719a = str;
    }

    public void execute() {
        this.f14720b.at.clear();
        if (!fbb.m18763c(this.f14719a)) {
            this.f14720b.at.put(this.f14720b.f14691a.mo2565a(), this.f14720b.f14692b.m22731a(this.f14720b.f14691a.mo2565a(), this.f14719a));
        }
    }

    public void callback() {
        int i = 8;
        this.f14720b.f14695e.m22727b();
        this.f14720b.f14695e.m22726a((List) this.f14720b.at.get(this.f14720b.f14691a.mo2565a()));
        this.f14720b.f14695e.notifyDataSetChanged();
        if (this.f14720b.f14695e.getCount() > 0) {
            this.f14720b.f14694d.setVisibility(0);
            this.f14720b.al.setVisibility(8);
        } else {
            this.f14720b.f14694d.setVisibility(8);
            this.f14720b.al.setVisibility(fbb.m18763c(this.f14719a) ? 8 : 0);
        }
        ImageView k = this.f14720b.aq;
        if (!fbb.m18763c(this.f14719a)) {
            i = 0;
        }
        k.setVisibility(i);
    }
}
