package com.ushareit.listenit;

class akd implements Runnable {
    final /* synthetic */ amu f4586a;
    final /* synthetic */ ajx f4587b;

    akd(ajx com_ushareit_listenit_ajx, amu com_ushareit_listenit_amu) {
        this.f4587b = com_ushareit_listenit_ajx;
        this.f4586a = com_ushareit_listenit_amu;
    }

    public void run() {
        this.f4587b.f4546a.mo79a(this.f4586a);
        if (!this.f4587b.f4555m && !this.f4587b.f4554l) {
            switch (this.f4586a.m6333a().m5821a()) {
                case 1000:
                case 1002:
                    switch (ake.f4588a[this.f4587b.m5855j().ordinal()]) {
                        case 2:
                            this.f4587b.f4551g.postDelayed(this.f4587b.f4552j, 30000);
                            this.f4587b.f4554l = true;
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }
}
