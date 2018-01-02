package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gkh implements gop {
    final /* synthetic */ ConfirmPopupView f14222a;
    final /* synthetic */ gkg f14223b;

    gkh(gkg com_ushareit_listenit_gkg, ConfirmPopupView confirmPopupView) {
        this.f14223b = com_ushareit_listenit_gkg;
        this.f14222a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        if (frd.m20610a(this.f14222a.getInput())) {
            heb.m23597a(this.f14223b.m20847s().getResources().getString(C0349R.string.toast_same_playlist_name), 0).show();
            return true;
        }
        this.f14223b.m22153c(this.f14222a.getInput());
        this.f14223b.m20828a(true);
        fiq.m19374a(this.f14223b.m20847s(), "UF_MenuRename", this.f14222a.getInput());
        fis.m19424b(this.f14223b.m20847s(), this.f14222a.getInput());
        fis.m19421a(this.f14223b.m20847s(), "main_rename");
        fis.m19422a(this.f14223b.m20847s(), "UF_PlaylistRenameList", "renamelist");
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
