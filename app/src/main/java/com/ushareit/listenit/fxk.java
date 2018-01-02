package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class fxk extends hhw {
    final /* synthetic */ fxh f13679a;
    private List<glc> f13680b = new ArrayList();

    fxk(fxh com_ushareit_listenit_fxh, String str) {
        this.f13679a = com_ushareit_listenit_fxh;
        super(str);
    }

    public void execute() {
        Collection m = fqs.m20480m();
        if (m != null && m.size() > 0) {
            this.f13680b.clear();
            this.f13680b.addAll(m);
        }
    }

    public void callback() {
        int i = 0;
        if (this.f13679a.f13662d.size() == 0) {
            this.f13679a.ab();
        }
        if (this.f13679a.f13662d.get(0) instanceof gje) {
            i = 1;
        }
        ((gjf) this.f13679a.f13662d.get(i + 2)).m22068a(this.f13680b);
        this.f13679a.f13661c.m18891a(this.f13679a.f13662d);
    }
}
