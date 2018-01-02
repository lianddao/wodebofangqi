package com.ushareit.listenit;

class fxl extends hhw {
    final /* synthetic */ fxh f13681a;
    private int f13682b;
    private int f13683c;
    private int f13684d;

    fxl(fxh com_ushareit_listenit_fxh, String str) {
        this.f13681a = com_ushareit_listenit_fxh;
        super(str);
    }

    public void execute() {
        this.f13682b = frf.m20680g();
        this.f13683c = fre.m20628b();
        this.f13684d = fre.m20624a();
    }

    public void callback() {
        int i = 0;
        if (this.f13681a.f13662d.size() == 0) {
            this.f13681a.ab();
        }
        if (this.f13681a.f13662d.get(0) instanceof gje) {
            i = 1;
        }
        gjd com_ushareit_listenit_gjd = (gjd) this.f13681a.f13662d.get(i + 1);
        com_ushareit_listenit_gjd.m22062a(this.f13682b);
        com_ushareit_listenit_gjd.m22064c(this.f13683c);
        com_ushareit_listenit_gjd.m22066d(this.f13684d);
        this.f13681a.f13661c.m18891a(this.f13681a.f13662d);
    }
}
