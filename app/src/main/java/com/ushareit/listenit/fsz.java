package com.ushareit.listenit;

import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import java.util.List;

public class fsz extends gkf {
    public fsz(int i) {
        super(i);
    }

    public void mo2569a() {
        m20848t().setShowPlay();
        m20848t().setShowAddToPlaylist();
    }

    public void mo2579h() {
        m20883A();
        fiq.m19372a(m20847s(), "UF_MenuPlay", m20846r(), "menu");
        m20853y();
    }

    private void m20883A() {
        fsg com_ushareit_listenit_fsg = (fsg) m20849u();
        List c = gyn.m23221c(com_ushareit_listenit_fsg.f13360f);
        if (c != null && c.size() != 0) {
            gyp.m23278a(c, (glg) c.get(0), m20846r(), com_ushareit_listenit_fsg.f13356b);
        }
    }

    public void mo2571c() {
        List c = gyn.m23221c(((fsg) m20849u()).f13360f);
        if (c != null && c.size() != 0) {
            BasePopupView addToPlaylistPopupView = new AddToPlaylistPopupView(m20847s(), m20846r());
            addToPlaylistPopupView.setItems(c);
            m20825a(addToPlaylistPopupView);
        }
    }
}
