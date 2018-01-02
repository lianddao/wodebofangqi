package com.ushareit.listenit;

class hgl extends hht {
    final /* synthetic */ hgw f15427a;
    final /* synthetic */ hgk f15428b;
    private long f15429c;

    hgl(hgk com_ushareit_listenit_hgk, hgw com_ushareit_listenit_hgw) {
        this.f15428b = com_ushareit_listenit_hgk;
        this.f15427a = com_ushareit_listenit_hgw;
    }

    public void execute() {
        boolean a = hhh.m23859a(this.f15427a.mo2558g());
        boolean z = a && this.f15428b.m23797b() && hgg.m23704a(this.f15427a.mo2558g());
        hgf.m23696a(a, z);
        if (!a) {
            hgf.m23695a(this.f15427a.mo2558g());
        }
        this.f15429c = System.currentTimeMillis();
        this.f15428b.f15424j.mo2768a(this.f15427a.mo2558g());
    }

    public void callback() {
        int i = 0;
        if (this.f15428b.f15424j.mo2770a()) {
            boolean a = hhh.m23859a(this.f15427a.mo2558g());
            long currentTimeMillis = System.currentTimeMillis() - this.f15429c;
            boolean z = a && this.f15428b.m23797b() && hgg.m23704a(this.f15427a.mo2558g());
            hgf.m23694a(currentTimeMillis, a, z);
            hgk com_ushareit_listenit_hgk = this.f15428b;
            hgw com_ushareit_listenit_hgw = this.f15427a;
            if (this.f15428b.f15424j.mo2771b()) {
                i = 1;
            }
            com_ushareit_listenit_hgk.m23763a(com_ushareit_listenit_hgw, 1, i);
            if (this.f15428b.f15415a != 0) {
                this.f15428b.f15424j.mo2764a(this.f15428b.f15415a);
                this.f15428b.f15416b = this.f15428b.f15415a;
            }
            this.f15428b.f15424j.mo2774e();
            return;
        }
        this.f15428b.m23763a(this.f15427a, 9, -1);
    }
}
