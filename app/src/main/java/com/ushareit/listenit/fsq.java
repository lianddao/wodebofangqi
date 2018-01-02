package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.listenit.lyrics.LyricEditorActivity;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.EditID3TagPopupView;

public class fsq extends gkf {
    public fsq(int i) {
        super(i);
    }

    public void mo2569a() {
        m20848t().setShowPlayNext();
        m20848t().setShowAddToPlaylist();
        if (!m20855A()) {
            m20848t().setShowAddToFavorite();
        }
        m20848t().setShowID3TagEdit();
        m20848t().setShowEditLyric();
        m20848t().setShowShare();
    }

    public void mo2570b() {
        gyp.m23281b((glg) m20849u());
        fiq.m19372a(m20847s(), "UF_MenuPlayNext", m20846r(), "menu");
        fij.m19329b("playnext");
        m20853y();
    }

    public void mo2571c() {
        BasePopupView addToPlaylistPopupView = new AddToPlaylistPopupView(m20847s(), m20846r());
        if (m20849u() != null) {
            addToPlaylistPopupView.setItem(m20849u());
        }
        m20825a(addToPlaylistPopupView);
        fij.m19329b("addtoplaylsit");
    }

    public void mo2572d() {
        glg com_ushareit_listenit_glg = (glg) m20849u();
        if (com_ushareit_listenit_glg != null) {
            frg.m20688a(com_ushareit_listenit_glg);
            heb.m23597a(m20847s().getResources().getString(C0349R.string.toast_add_to_favorite), 0).show();
            fxh.aa();
            fij.m19329b("addtofavorite");
            m20853y();
        }
    }

    public void mo2573e() {
        if (m20849u() != null) {
            BasePopupView editID3TagPopupView = new EditID3TagPopupView(m20847s(), m20846r());
            editID3TagPopupView.setItem(m20849u());
            m20825a(editID3TagPopupView);
            fij.m19329b("edittag");
        }
    }

    public void mo2574f() {
        glg com_ushareit_listenit_glg = (glg) m20849u();
        if (com_ushareit_listenit_glg != null) {
            Intent intent = new Intent(m20847s(), LyricEditorActivity.class);
            intent.putExtra("song_id", com_ushareit_listenit_glg.f14334b);
            intent.putExtra("is_load_lyric", true);
            m20847s().startActivity(intent);
            fij.m19329b("editlyric");
            m20853y();
        }
    }

    public void mo2575g() {
        hij.m23900a((glg) m20849u(), m20847s());
        fii.m19294a(m20847s(), m20849u(), m20846r());
        fij.m19329b("share");
    }

    private boolean m20855A() {
        glg com_ushareit_listenit_glg = (glg) m20849u();
        if (com_ushareit_listenit_glg == null) {
            return true;
        }
        return fre.m20627a(com_ushareit_listenit_glg);
    }
}
