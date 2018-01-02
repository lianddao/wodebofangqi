package com.ushareit.listenit;

import java.util.List;

class fvl extends hhw {
    List<gla> f13584a = null;
    final /* synthetic */ fvk f13585b;

    fvl(fvk com_ushareit_listenit_fvk, String str) {
        this.f13585b = com_ushareit_listenit_fvk;
        super(str);
    }

    public void execute() {
        this.f13584a = this.f13585b.aj.mo2568d();
    }

    public void callback() {
        boolean z = true;
        if (this.f13584a != null) {
            try {
                fvk com_ushareit_listenit_fvk = this.f13585b;
                if (this.f13584a.size() != 0) {
                    z = false;
                }
                com_ushareit_listenit_fvk.m21095g(z);
                this.f13585b.f13579e.m18921a(this.f13584a);
            } catch (Throwable e) {
                exw.m18450b(hhw.TAG, "asyncLoadData has an error.", e);
                this.f13585b.ak = true;
            } finally {
                this.f13585b.f13581g.setVisibility(8);
            }
        }
    }
}
