package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.listenit.lyrics.LyricEditorActivity;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import com.ushareit.listenit.popupview.EditID3TagPopupView;
import java.util.List;

public class gkm extends gkf {
    public gkm(int i) {
        super(i);
    }

    public void mo2569a() {
        m20848t().setShowPlayNext();
        m20848t().setShowAddToPlaylist();
        if (!m22184A()) {
            m20848t().setShowAddToFavorite();
        }
        m20848t().setShowID3TagEdit();
        m20848t().setShowEditLyric();
        m20848t().setShowSetAsRingtone();
        m20848t().setShowShare();
        m20848t().setShowDelete();
    }

    public void mo2570b() {
        if (m20849u() != null) {
            gyp.m23281b((glg) m20849u());
            fiq.m19372a(m20847s(), "UF_MenuPlayNext", m20846r(), "menu");
        } else if (m20850v().size() > 0) {
            gyp.m23276a(m20850v());
            fiq.m19372a(m20847s(), "UF_MenuPlayNext", m20846r(), "batch");
        }
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
        m22187a(confirmPopupView);
        confirmPopupView.m25557f().setSelectDesc((int) C0349R.string.confirm_view_delete_local_file);
        confirmPopupView.setConfirmListener(new gkn(this, confirmPopupView));
        m20825a(confirmPopupView);
    }

    private void m22187a(ConfirmPopupView confirmPopupView) {
        String string;
        String string2;
        int size = m20849u() != null ? 1 : m20850v().size();
        if (size == 1) {
            string = m20847s().getResources().getString(C0349R.string.confirm_view_remove_song_title, new Object[]{Integer.valueOf(size)});
        } else {
            string = m20847s().getResources().getString(C0349R.string.confirm_view_remove_songs_title, new Object[]{Integer.valueOf(size)});
        }
        if (size == 1) {
            string2 = m20847s().getResources().getString(C0349R.string.confirm_view_remove_song_content);
        } else {
            string2 = m20847s().getResources().getString(C0349R.string.confirm_view_remove_songs_content);
        }
        String string3 = m20847s().getResources().getString(C0349R.string.confirm_view_delete_local_file);
        confirmPopupView.m25554a().setTitle(string);
        confirmPopupView.m25556d().setContent(string2);
        confirmPopupView.m25557f().setSelectDesc(string3);
    }

    private void m22188a(boolean z, glg com_ushareit_listenit_glg) {
        if (z) {
            gyp.m23287c(com_ushareit_listenit_glg);
            frf.m20681g(com_ushareit_listenit_glg);
            gyn.m23216b(com_ushareit_listenit_glg);
            return;
        }
        frf.m20638a(com_ushareit_listenit_glg.f14334b, 0);
    }

    private void m22189a(boolean z, List<glg> list) {
        if (z) {
            gyp.m23282b((List) list);
            frf.m20663b((List) list);
            gyn.m23198a((List) list);
            return;
        }
        for (glg com_ushareit_listenit_glg : list) {
            frf.m20638a(com_ushareit_listenit_glg.f14334b, 0);
        }
    }

    public void mo2573e() {
        if (m20849u() != null) {
            BasePopupView editID3TagPopupView = new EditID3TagPopupView(m20847s(), m20846r());
            editID3TagPopupView.setItem(m20849u());
            m20825a(editID3TagPopupView);
        }
    }

    public void mo2575g() {
        hij.m23900a((glg) m20849u(), m20847s());
        fii.m19294a(m20847s(), m20849u(), m20846r());
    }

    public void mo2694k() {
        glg com_ushareit_listenit_glg = (glg) m20849u();
        if (com_ushareit_listenit_glg != null) {
            BasePopupView confirmPopupView = new ConfirmPopupView(m20847s());
            confirmPopupView.m25554a().setTitle(m20847s().getResources().getString(C0349R.string.cutter_dialog_title));
            confirmPopupView.m25556d().setContent(m20847s().getResources().getString(C0349R.string.cutter_dialog_content));
            confirmPopupView.setConfirmListener(new gko(this, com_ushareit_listenit_glg));
            m20825a(confirmPopupView);
        }
    }

    public void mo2574f() {
        glg com_ushareit_listenit_glg = (glg) m20849u();
        if (com_ushareit_listenit_glg != null) {
            Intent intent = new Intent(m20847s(), LyricEditorActivity.class);
            intent.putExtra("song_id", com_ushareit_listenit_glg.f14334b);
            intent.putExtra("is_load_lyric", true);
            m20847s().startActivity(intent);
            m20853y();
        }
    }

    public void mo2572d() {
        glg com_ushareit_listenit_glg = (glg) m20849u();
        if (com_ushareit_listenit_glg != null) {
            fre.m20626a(com_ushareit_listenit_glg, true);
            heb.m23597a(m20847s().getResources().getString(C0349R.string.toast_add_to_favorite), 0).show();
            m20853y();
        }
    }

    private boolean m22184A() {
        glg com_ushareit_listenit_glg = (glg) m20849u();
        if (com_ushareit_listenit_glg == null) {
            return true;
        }
        return fre.m20627a(com_ushareit_listenit_glg);
    }
}
