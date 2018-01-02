package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import java.util.List;

class fve implements OnClickListener {
    final /* synthetic */ fva f13570a;

    fve(fva com_ushareit_listenit_fva) {
        this.f13570a = com_ushareit_listenit_fva;
    }

    public void onClick(View view) {
        List b = this.f13570a.f13563g.m18900b();
        int size = b.size();
        if (size != 0) {
            this.f13570a.f13563g.m18902c();
            this.f13570a.m21061X();
            BasePopupView addToPlaylistPopupView = new AddToPlaylistPopupView(this.f13570a.m1326l(), this.f13570a.am.mo2565a());
            addToPlaylistPopupView.setItems(b);
            gyn.m23197a(this.f13570a.m1328m(), new fyi(addToPlaylistPopupView));
            fiq.m19373a(this.f13570a.m1326l(), "UF_MenuAddToPlaylistClick", this.f13570a.am.mo2565a(), "--", "batch");
            fip.m19370a(this.f13570a.m1326l(), "UF_ManageAddToPlaylistSongCount", this.f13570a.am.mo2565a(), size);
            this.f13570a.ao = true;
        }
    }
}
