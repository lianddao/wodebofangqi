package com.ushareit.listenit;

class hgm extends hht {
    final /* synthetic */ hgw f15430a;
    final /* synthetic */ int f15431b;
    final /* synthetic */ hgk f15432c;

    hgm(hgk com_ushareit_listenit_hgk, hgw com_ushareit_listenit_hgw, int i) {
        this.f15432c = com_ushareit_listenit_hgk;
        this.f15430a = com_ushareit_listenit_hgw;
        this.f15431b = i;
    }

    public void execute() {
        if (this.f15432c.f15424j.mo2770a()) {
            this.f15432c.m23801f();
        }
        this.f15432c.f15424j.mo2768a(this.f15430a.mo2558g());
    }

    public void callback() {
        if (this.f15432c.f15424j.mo2770a()) {
            this.f15432c.f15424j.mo2764a(this.f15431b);
        } else {
            this.f15432c.m23763a(this.f15430a, 9, -2);
        }
    }
}
