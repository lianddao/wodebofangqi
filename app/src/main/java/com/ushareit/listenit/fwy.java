package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fwy implements OnClickListener {
    final /* synthetic */ fww f13648a;

    fwy(fww com_ushareit_listenit_fww) {
        this.f13648a = com_ushareit_listenit_fww;
    }

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        int c = this.f13648a.f13642f.m18926c();
        this.f13648a.m21223a(this.f13648a.f13642f.m18927d(), this.f13648a.c);
        this.f13648a.f13642f.m18928e();
        this.f13648a.f13644h.m26965a(false);
        this.f13648a.m21220W();
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        hhx.m23869a(new fwz(this), 0, currentTimeMillis < 400 ? (int) (400 - currentTimeMillis) : 0);
        fiq.m19372a(this.f13648a.m1326l(), "UF_MenuAddToPlaylist", this.f13648a.aj.mo2565a(), "direct");
        fip.m19370a(this.f13648a.m1326l(), "UF_ManageAddSongCount", this.f13648a.aj.mo2565a(), c);
        fis.m19422a(this.f13648a.m1326l(), "UF_PlaylistAddSongToPlaylist", "addtolist");
        fxh.m21246Z();
    }
}
