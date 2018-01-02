package com.ushareit.listenit;

import android.view.View;
import com.facebook.ads.C0016g;

class akj implements akw {
    final /* synthetic */ Runnable f4594a;
    final /* synthetic */ ajx f4595b;

    akj(ajx com_ushareit_listenit_ajx, Runnable runnable) {
        this.f4595b = com_ushareit_listenit_ajx;
        this.f4594a = runnable;
    }

    public void mo662a(akv com_ushareit_listenit_akv) {
        this.f4595b.f4546a.mo80b();
    }

    public void mo663a(akv com_ushareit_listenit_akv, View view) {
        if (com_ushareit_listenit_akv == this.f4595b.f4557o) {
            this.f4595b.f4551g.removeCallbacks(this.f4594a);
            aku g = this.f4595b.f4558p;
            this.f4595b.f4558p = com_ushareit_listenit_akv;
            this.f4595b.f4559q = view;
            if (this.f4595b.f4556n) {
                this.f4595b.f4546a.mo77a(view);
                this.f4595b.m5834a(g);
                this.f4595b.m5863n();
                return;
            }
            this.f4595b.f4546a.mo78a((aku) com_ushareit_listenit_akv);
        }
    }

    public void mo664a(akv com_ushareit_listenit_akv, C0016g c0016g) {
        if (com_ushareit_listenit_akv == this.f4595b.f4557o) {
            this.f4595b.f4551g.removeCallbacks(this.f4594a);
            this.f4595b.m5834a((aku) com_ushareit_listenit_akv);
            this.f4595b.m5858l();
        }
    }

    public void mo665b(akv com_ushareit_listenit_akv) {
        this.f4595b.f4546a.mo76a();
    }
}
