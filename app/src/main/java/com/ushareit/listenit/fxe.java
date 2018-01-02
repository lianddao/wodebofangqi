package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class fxe implements OnClickListener {
    final /* synthetic */ fww f13654a;

    fxe(fww com_ushareit_listenit_fww) {
        this.f13654a = com_ushareit_listenit_fww;
    }

    public void onClick(View view) {
        List d = this.f13654a.f13642f.m18927d();
        int size = d.size();
        if (size != 0) {
            gkf b = this.f13654a.aj.mo2566b();
            b.m20823a(this.f13654a.m1326l());
            b.m20827a(d);
            b.m20830b(this.f13654a.c);
            b.m20826a("");
            b.m20824a(new fxf(this, b, d));
            b.mo2691j();
            fiq.m19373a(this.f13654a.m1326l(), "UF_MenuDeleteClick", this.f13654a.aj.mo2565a(), "--", "batch");
            fip.m19370a(this.f13654a.m1326l(), "UF_ManageDeleteSongCount", this.f13654a.aj.mo2565a(), size);
        }
    }
}
