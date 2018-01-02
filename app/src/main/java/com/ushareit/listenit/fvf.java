package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class fvf implements OnClickListener {
    final /* synthetic */ fva f13571a;

    fvf(fva com_ushareit_listenit_fva) {
        this.f13571a = com_ushareit_listenit_fva;
    }

    public void onClick(View view) {
        List b = this.f13571a.f13563g.m18900b();
        int size = b.size();
        if (size != 0) {
            gkf b2 = this.f13571a.am.mo2566b();
            b2.m20823a(this.f13571a.m1326l());
            b2.m20827a(b);
            b2.m20830b(this.f13571a.al);
            b2.m20826a("");
            b2.m20824a(new fvg(this, b2, b));
            b2.mo2691j();
            fiq.m19373a(this.f13571a.m1326l(), "UF_MenuDeleteClick", this.f13571a.am.mo2565a(), "--", "batch");
            fip.m19370a(this.f13571a.m1326l(), "UF_ManageDeleteSongCount", this.f13571a.am.mo2565a(), size);
            this.f13571a.ao = true;
        }
    }
}
