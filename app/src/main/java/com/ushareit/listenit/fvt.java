package com.ushareit.listenit;

import java.util.List;

class fvt extends hhw {
    final /* synthetic */ fvs f13602a;
    private List<gla> f13603b = null;

    fvt(fvs com_ushareit_listenit_fvs, String str) {
        this.f13602a = com_ushareit_listenit_fvs;
        super(str);
    }

    public void execute() {
        this.f13603b = this.f13602a.f13599g.mo2568d();
    }

    public void callback() {
        if (this.f13603b != null) {
            try {
                this.f13602a.f13597e.m18921a(this.f13603b);
                this.f13602a.f13594b.setVisibility(8);
                if (this.f13602a.f13596d != null) {
                    this.f13602a.f13596d.m26791a(this.f13603b.size());
                }
            } catch (Exception e) {
                this.f13602a.f13600h = true;
            }
        }
    }
}
