package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;

public class goh extends fdw {
    final /* synthetic */ AddToPlaylistPopupView f14505a;

    public goh(AddToPlaylistPopupView addToPlaylistPopupView) {
        this.f14505a = addToPlaylistPopupView;
    }

    public void mo2608a(View view, int i) {
        if (this.f14505a.f16133b.size() > 0) {
            this.f14505a.m25535a(this.f14505a.f16133b);
            fiq.m19372a(this.f14505a.getContext(), "UF_MenuAddToPlaylist", this.f14505a.f16139h, "batch");
        } else if (this.f14505a.f16135d != null) {
            this.f14505a.f16135d.m20775a(false);
            fiq.m19372a(this.f14505a.getContext(), "UF_MenuAddToPlaylist", this.f14505a.f16139h, this.f14505a.f16139h != -10001 ? "menu" : "normalplayer");
        }
        this.f14505a.m25534a(((glc) this.f14505a.f16132a.get(i)).f14283c);
        fis.m19422a(this.f14505a.getContext(), "UF_PlaylistAddSongToPlaylist", "addtolist");
        this.f14505a.mo3063e();
    }
}
