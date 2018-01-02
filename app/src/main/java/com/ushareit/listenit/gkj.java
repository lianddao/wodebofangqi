package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.listenit.lyrics.LyricEditorActivity;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import com.ushareit.listenit.popupview.EditID3TagPopupView;
import java.util.ArrayList;
import java.util.List;

public class gkj extends gkf {
    public gkj(int i) {
        super(i);
    }

    public void mo2569a() {
        m20848t().setShowPlayNext();
        m20848t().setShowAddToPlaylist();
        if (!m22160A()) {
            m20848t().setShowAddToFavorite();
        }
        m20848t().setShowID3TagEdit();
        m20848t().setShowEditLyric();
        if (!gyn.m23260p(m20849u().mo2558g())) {
            m20848t().setShowSetAsRingtone();
        }
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
        fis.m19422a(m20847s(), "UF_PlaylistPlayNext", "playnext");
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
        ConfirmPopupView confirmPopupView = new ConfirmPopupView(m20847s());
        m22164a(confirmPopupView);
        confirmPopupView.setConfirmListener(new gkk(this, confirmPopupView));
        m20825a((BasePopupView) confirmPopupView);
    }

    private void m22164a(ConfirmPopupView confirmPopupView) {
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

    private void m22165a(boolean z, glg com_ushareit_listenit_glg) {
        if (gyn.m23260p(com_ushareit_listenit_glg.f14342j)) {
            m22163a(com_ushareit_listenit_glg);
        } else {
            m22168b(z, com_ushareit_listenit_glg);
        }
        fxh.m21246Z();
    }

    private void m22166a(boolean z, List<glg> list) {
        List arrayList = new ArrayList();
        for (glg com_ushareit_listenit_glg : list) {
            if (!gyn.m23260p(com_ushareit_listenit_glg.f14342j)) {
                arrayList.add(com_ushareit_listenit_glg);
            }
        }
        if (arrayList.size() > 0) {
            m22169b(z, arrayList);
        }
        list.removeAll(arrayList);
        if (list.size() > 0) {
            m22167b(list);
        }
        fxh.m21246Z();
    }

    private void m22168b(boolean z, glg com_ushareit_listenit_glg) {
        if (!fbb.m18763c(m20851w())) {
            String e = frd.m20621e(m20851w());
            if (!fbb.m18763c(e)) {
                frd.m20603a(e, com_ushareit_listenit_glg.f14334b);
                if (z) {
                    gyp.m23287c(com_ushareit_listenit_glg);
                    frf.m20681g(com_ushareit_listenit_glg);
                    gyn.m23216b(com_ushareit_listenit_glg);
                } else if (m22170c(m20851w())) {
                    gyp.m23287c((glg) m20849u());
                }
            }
        }
    }

    private void m22169b(boolean z, List<glg> list) {
        if (!fbb.m18763c(m20851w())) {
            String e = frd.m20621e(m20851w());
            if (!fbb.m18763c(e)) {
                frd.m20605a(e, (List) list);
                if (z) {
                    frf.m20663b((List) list);
                    gyn.m23198a((List) list);
                    gyp.m23282b((List) list);
                } else if (m22170c(m20851w())) {
                    gyp.m23282b((List) list);
                }
            }
        }
    }

    private void m22163a(glg com_ushareit_listenit_glg) {
        if (!fbb.m18763c(m20851w())) {
            String e = frd.m20621e(m20851w());
            if (!fbb.m18763c(e)) {
                frd.m20603a(e, com_ushareit_listenit_glg.f14334b);
                if (m22170c(m20851w())) {
                    gyp.m23287c(com_ushareit_listenit_glg);
                }
            }
        }
    }

    private void m22167b(List<glg> list) {
        if (!fbb.m18763c(m20851w())) {
            String e = frd.m20621e(m20851w());
            if (!fbb.m18763c(e)) {
                frd.m20605a(e, (List) list);
                if (m22170c(m20851w())) {
                    gyp.m23282b((List) list);
                }
            }
        }
    }

    private boolean m22170c(String str) {
        if (gyp.m23305s()) {
            String q = gyp.m23303q();
            if (!fbb.m18763c(q)) {
                return q.equals(str);
            }
        }
        return false;
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
            confirmPopupView.setConfirmListener(new gkl(this, com_ushareit_listenit_glg));
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

    private boolean m22160A() {
        glg com_ushareit_listenit_glg = (glg) m20849u();
        if (com_ushareit_listenit_glg == null) {
            return true;
        }
        return fre.m20627a(com_ushareit_listenit_glg);
    }
}
