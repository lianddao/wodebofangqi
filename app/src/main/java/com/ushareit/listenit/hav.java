package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class hav extends hhw {
    List<glc> f15097a = new ArrayList();
    final /* synthetic */ hap f15098b;

    hav(hap com_ushareit_listenit_hap) {
        this.f15098b = com_ushareit_listenit_hap;
    }

    public void execute() {
        Collection d = this.f15098b.f15087w.mo2568d();
        this.f15097a.clear();
        this.f15097a.addAll(d);
    }

    public void callback() {
        if (this.f15097a.isEmpty()) {
            this.f15098b.f15082r.setVisibility(8);
            this.f15098b.f15085u.setVisibility(0);
            this.f15098b.f15080p.setVisibility(8);
            this.f15098b.f15086v.setVisibility(8);
            this.f15098b.f15083s.setVisibility(4);
            return;
        }
        this.f15098b.f15083s.setVisibility(0);
        gyn.m23224c(this.f15098b.f15080p, ((int) this.f15098b.o.getResources().getDimension(C0349R.dimen.common_dimens_63dp)) * this.f15097a.size());
        this.f15098b.f15082r.setVisibility(0);
        this.f15098b.f15086v.setVisibility(0);
        this.f15098b.f15085u.setVisibility(8);
        this.f15098b.f15080p.setVisibility(0);
        this.f15098b.f15081q.m18921a(this.f15097a);
        if (this.f15098b.f15068A != null) {
            this.f15098b.f15068A.m22068a(this.f15097a);
        }
        this.f15098b.f15084t = true;
    }
}
