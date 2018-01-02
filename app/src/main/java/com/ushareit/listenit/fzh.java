package com.ushareit.listenit;

class fzh implements kx {
    final /* synthetic */ fze f13762a;
    private int f13763b = this.f13762a.f13759i;

    fzh(fze com_ushareit_listenit_fze) {
        this.f13762a = com_ushareit_listenit_fze;
    }

    public void mo2620b(int i) {
        if (i == 0) {
            if (this.f13763b != this.f13762a.f13759i) {
                ((fvs) this.f13762a.f13758h.get(this.f13763b)).m21136V();
            }
            ((fvs) this.f13762a.f13758h.get(this.f13762a.f13759i)).m21135U();
            this.f13763b = this.f13762a.f13759i;
            fih.m19282a(this.f13762a.m1328m(), this.f13762a.f13759i);
        }
    }

    public void mo2619a(int i, float f, int i2) {
        this.f13762a.f13755e.m27022a(i, f);
    }

    public void mo2618a(int i) {
        this.f13762a.f13759i = i;
    }
}
