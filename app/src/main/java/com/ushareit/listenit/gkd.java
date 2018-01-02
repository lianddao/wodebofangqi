package com.ushareit.listenit;

import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import java.util.List;

public class gkd extends gkf {
    public gkd(int i) {
        super(i);
    }

    public void mo2569a() {
        m20848t().setShowPlay();
        m20848t().setShowAddToPlaylist();
        m20848t().setShowDelete();
        if (m20846r() == 3) {
            m20848t().setShowHide();
        }
    }

    public void mo2579h() {
        m22082A();
        fiq.m19372a(m20847s(), "UF_MenuPlay", m20846r(), "menu");
        m20853y();
    }

    public void mo2571c() {
        BasePopupView addToPlaylistPopupView = new AddToPlaylistPopupView(m20847s(), m20846r());
        if (m20849u() != null) {
            addToPlaylistPopupView.setItem(m20849u());
        } else if (m20850v().size() > 0) {
            addToPlaylistPopupView.setItems((List) m20849u());
        }
        m20825a(addToPlaylistPopupView);
    }

    public void mo2691j() {
        BasePopupView confirmPopupView = new ConfirmPopupView(m20847s());
        m22085a(confirmPopupView);
        confirmPopupView.setConfirmListener(new gke(this, confirmPopupView));
        m20825a(confirmPopupView);
    }

    private void m22085a(ConfirmPopupView confirmPopupView) {
        String string;
        String string2;
        int b = m20849u() != null ? fqs.m20458b(m20849u()) : m20850v().size();
        if (b == 1) {
            string = m20847s().getResources().getString(C0349R.string.confirm_view_delete_song_title, new Object[]{Integer.valueOf(1)});
        } else {
            string = m20847s().getResources().getString(C0349R.string.confirm_view_delete_songs_title, new Object[]{Integer.valueOf(b)});
        }
        if (b == 1) {
            string2 = m20847s().getResources().getString(C0349R.string.confirm_view_delete_song_content);
        } else {
            string2 = m20847s().getResources().getString(C0349R.string.confirm_view_delete_songs_content);
        }
        String string3 = m20847s().getResources().getString(C0349R.string.confirm_view_delete_local_file);
        confirmPopupView.m25554a().setTitle(string);
        confirmPopupView.m25556d().setContent(string2);
        confirmPopupView.m25557f().setSelectDesc(string3);
    }

    private void m22082A() {
        List a = fqs.m20453a(m20849u());
        if (a != null && a.size() != 0) {
            gyp.m23278a(a, (glg) a.get(0), m20849u().mo2703e(), m20849u().mo2562c());
        }
    }

    private void m22086a(boolean z, gla com_ushareit_listenit_gla) {
        List a = fqs.m20453a(com_ushareit_listenit_gla);
        if (a != null && a.size() != 0) {
            gyp.m23282b(a);
            frf.m20663b(a);
            if (z) {
                gyn.m23198a(a);
            }
        }
    }

    private void m22087a(boolean z, List<? extends gla> list) {
        for (gla a : list) {
            m22086a(z, a);
        }
    }

    public void mo2692q() {
        if (m20849u() != null && (m20849u() instanceof gkz)) {
            gse.m22670a().m22676c(((gkz) m20849u()).f14279c);
            heb.m23596a((int) C0349R.string.toast_hide, 0).show();
            m20853y();
        }
    }
}
