package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class fvd implements OnClickListener {
    final /* synthetic */ fva f13569a;

    fvd(fva com_ushareit_listenit_fva) {
        this.f13569a = com_ushareit_listenit_fva;
    }

    public void onClick(View view) {
        List b = this.f13569a.f13563g.m18900b();
        int size = b.size();
        if (size != 0) {
            this.f13569a.f13563g.m18902c();
            this.f13569a.m21061X();
            gyp.m23276a(b);
            heb.m23597a(this.f13569a.m1329n().getString(C0349R.string.toast_play_next), 0).show();
            fiq.m19372a(this.f13569a.m1326l(), "UF_MenuPlayNext", this.f13569a.am.mo2565a(), "batch");
            fiq.m19373a(this.f13569a.m1326l(), "UF_MenuPlayNextClick", this.f13569a.am.mo2565a(), "--", "batch");
            fip.m19370a(this.f13569a.m1326l(), "UF_ManagePlayNextSongCount", this.f13569a.am.mo2565a(), size);
        }
    }
}
