package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import java.util.List;

class fxc implements OnClickListener {
    final /* synthetic */ fww f13652a;

    fxc(fww com_ushareit_listenit_fww) {
        this.f13652a = com_ushareit_listenit_fww;
    }

    public void onClick(View view) {
        List d = this.f13652a.f13642f.m18927d();
        int size = d.size();
        if (size != 0) {
            BasePopupView addToPlaylistPopupView = new AddToPlaylistPopupView(this.f13652a.m1326l(), this.f13652a.aj.mo2565a());
            addToPlaylistPopupView.setItems(d);
            fyi com_ushareit_listenit_fyi = new fyi(addToPlaylistPopupView);
            com_ushareit_listenit_fyi.m21347a(new fxd(this));
            gyn.m23197a(this.f13652a.m1328m(), com_ushareit_listenit_fyi);
            fiq.m19373a(this.f13652a.m1326l(), "UF_MenuAddToPlaylistClick", this.f13652a.aj.mo2565a(), "--", "batch");
            fip.m19370a(this.f13652a.m1326l(), "UF_ManageAddToPlaylistSongCount", this.f13652a.aj.mo2565a(), size);
            fis.m19422a(this.f13652a.m1326l(), "UF_PlaylistAddSongToPlaylist", "addtolist");
        }
    }
}
