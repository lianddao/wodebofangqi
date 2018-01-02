package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class fxb implements OnClickListener {
    final /* synthetic */ fww f13651a;

    fxb(fww com_ushareit_listenit_fww) {
        this.f13651a = com_ushareit_listenit_fww;
    }

    public void onClick(View view) {
        List d = this.f13651a.f13642f.m18927d();
        int size = d.size();
        if (size != 0) {
            this.f13651a.f13642f.m18928e();
            this.f13651a.m21220W();
            this.f13651a.f13644h.m26965a(false);
            gyp.m23276a(d);
            fiq.m19372a(this.f13651a.m1326l(), "UF_MenuPlayNext", this.f13651a.aj.mo2565a(), "batch");
            fiq.m19373a(this.f13651a.m1326l(), "UF_MenuPlayNextClick", this.f13651a.aj.mo2565a(), "--", "batch");
            fip.m19370a(this.f13651a.m1326l(), "UF_ManagePlayNextSongCount", this.f13651a.aj.mo2565a(), size);
            heb.m23597a(this.f13651a.m1329n().getString(C0349R.string.toast_play_next), 0).show();
        }
    }
}
