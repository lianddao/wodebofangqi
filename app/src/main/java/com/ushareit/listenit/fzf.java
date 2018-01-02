package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fzf implements OnClickListener {
    final /* synthetic */ fze f13760a;

    fzf(fze com_ushareit_listenit_fze) {
        this.f13760a = com_ushareit_listenit_fze;
    }

    public void onClick(View view) {
        fvs com_ushareit_listenit_fvs = (fvs) this.f13760a.f13758h.get(0);
        if (com_ushareit_listenit_fvs != null && com_ushareit_listenit_fvs.m21139Y() != 0) {
            fji com_ushareit_listenit_fww = new fww(new gax(), false);
            com_ushareit_listenit_fww.m21232a(com_ushareit_listenit_fvs.m21138X());
            gyn.m23186a(this.f13760a.m1326l(), com_ushareit_listenit_fww);
        }
    }
}
