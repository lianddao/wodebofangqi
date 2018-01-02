package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class fxi extends hhw {
    final /* synthetic */ fxh f13668a;
    private List<glc> f13669b = new ArrayList();
    private int f13670c;
    private int f13671d;
    private int f13672e;
    private int f13673f;

    fxi(fxh com_ushareit_listenit_fxh, String str) {
        this.f13668a = com_ushareit_listenit_fxh;
        super(str);
    }

    public void execute() {
        this.f13670c = frf.m20655b();
        this.f13671d = frf.m20680g();
        this.f13672e = fre.m20628b();
        this.f13673f = fre.m20624a();
        Collection m = fqs.m20480m();
        if (m != null && m.size() > 0) {
            this.f13669b.clear();
            this.f13669b.addAll(m);
        }
    }

    public void callback() {
        if (this.f13668a.f13662d.size() == 0) {
            this.f13668a.ab();
        }
        int i = this.f13668a.f13662d.get(0) instanceof gje ? 1 : 0;
        ((gjb) this.f13668a.f13662d.get(i)).m22060a(this.f13670c);
        gjd com_ushareit_listenit_gjd = (gjd) this.f13668a.f13662d.get(i + 1);
        com_ushareit_listenit_gjd.m22062a(this.f13671d);
        com_ushareit_listenit_gjd.m22064c(this.f13672e);
        com_ushareit_listenit_gjd.m22066d(this.f13673f);
        ((gjf) this.f13668a.f13662d.get(i + 2)).m22068a(this.f13669b);
        this.f13668a.f13661c.m18891a(this.f13668a.f13662d);
        this.f13668a.m21248a(this.f13670c, this.f13669b, this.f13673f, this.f13672e, this.f13671d);
    }
}
