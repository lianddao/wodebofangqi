package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gog implements gop {
    final /* synthetic */ ConfirmPopupView f14503a;
    final /* synthetic */ gof f14504b;

    gog(gof com_ushareit_listenit_gof, ConfirmPopupView confirmPopupView) {
        this.f14504b = com_ushareit_listenit_gof;
        this.f14503a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        int i = 1;
        if (frd.m20610a(this.f14503a.getInput())) {
            heb.m23597a(this.f14504b.f14502a.getContext().getResources().getString(C0349R.string.toast_same_playlist_name), 0).show();
            return true;
        }
        this.f14504b.f14502a.m25535a(this.f14504b.f14502a.f16133b);
        AddToPlaylistPopupView addToPlaylistPopupView = this.f14504b.f14502a;
        String input = this.f14503a.getInput();
        if (!this.f14503a.m25559h()) {
            i = 0;
        }
        addToPlaylistPopupView.m25540a(input, i);
        fis.m19424b(this.f14504b.f14502a.getContext(), this.f14503a.getInput());
        fis.m19423b(this.f14504b.f14502a.getContext(), this.f14504b.f14502a.f16139h);
        fis.m19422a(this.f14504b.f14502a.getContext(), "UF_PlaylistAddSongToPlaylist", "addtolist");
        fir.m19391d(this.f14503a.m25559h());
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
