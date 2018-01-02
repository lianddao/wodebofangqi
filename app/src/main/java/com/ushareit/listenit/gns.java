package com.ushareit.listenit;

import com.ushareit.listenit.popupview.ActivePlaylistPopupView;

public class gns extends hhw {
    final /* synthetic */ ActivePlaylistPopupView f14481a;

    public gns(ActivePlaylistPopupView activePlaylistPopupView) {
        this.f14481a = activePlaylistPopupView;
    }

    public void execute() {
        this.f14481a.f16115a.clear();
        this.f14481a.f16115a.addAll(this.f14481a.f16122h.mo2460q());
    }

    public void callback() {
        this.f14481a.f16118d.m22557a(this.f14481a.f16115a);
        this.f14481a.f16117c.post(new gnt(this));
        this.f14481a.m25515a(this.f14481a.f16115a.size());
    }
}
