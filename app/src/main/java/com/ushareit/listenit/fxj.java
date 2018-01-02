package com.ushareit.listenit;

class fxj extends hhw {
    final /* synthetic */ fxh f13674a;
    private int f13675b;
    private int f13676c;
    private int f13677d;
    private int f13678e;

    fxj(fxh com_ushareit_listenit_fxh, String str) {
        this.f13674a = com_ushareit_listenit_fxh;
        super(str);
    }

    public void execute() {
        this.f13675b = frf.m20655b();
        this.f13676c = frf.m20680g();
        this.f13677d = fre.m20628b();
        this.f13678e = fre.m20624a();
    }

    public void callback() {
        if (this.f13674a.f13662d.size() == 0) {
            this.f13674a.ab();
        }
        int i = this.f13674a.f13662d.get(0) instanceof gje ? 1 : 0;
        ((gjb) this.f13674a.f13662d.get(i)).m22060a(this.f13675b);
        gjd com_ushareit_listenit_gjd = (gjd) this.f13674a.f13662d.get(i + 1);
        com_ushareit_listenit_gjd.m22062a(this.f13676c);
        com_ushareit_listenit_gjd.m22064c(this.f13677d);
        com_ushareit_listenit_gjd.m22066d(this.f13678e);
        this.f13674a.f13661c.m18891a(this.f13674a.f13662d);
    }
}
