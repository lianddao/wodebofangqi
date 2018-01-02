package com.ushareit.listenit;

import com.ushareit.listenit.popupview.SelectAlbumPopupView;

public class gjv extends gkd {
    public gjv(int i) {
        super(i);
    }

    public void mo2569a() {
        m20848t().setShowPlay();
        m20848t().setShowAddToPlaylist();
        if (fzi.f13764a) {
            m20848t().setShowChangeAlbum();
        }
        m20848t().setShowDelete();
    }

    public void mo2693i() {
        if (m20849u() instanceof gkv) {
            m20825a(new SelectAlbumPopupView(m20847s(), m20849u(), "AlbumItem"));
        }
    }
}
