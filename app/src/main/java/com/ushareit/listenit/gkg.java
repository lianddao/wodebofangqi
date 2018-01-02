package com.ushareit.listenit;

import android.text.SpannableString;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import java.util.List;

public class gkg extends gkf {
    public gkg(int i) {
        super(i);
    }

    public void mo2569a() {
        m20848t().setShowDelete();
        m20848t().setShowRename();
    }

    public void mo2700z() {
        BasePopupView confirmPopupView = new ConfirmPopupView(m20847s());
        confirmPopupView.m25554a().setTitle((int) C0349R.string.confirm_view_rename);
        confirmPopupView.m25558g().setInputDesc("0/40");
        confirmPopupView.setEditText(m20849u().mo2562c());
        confirmPopupView.setConfirmListener(new gkh(this, confirmPopupView));
        m20825a(confirmPopupView);
    }

    public void m22153c(String str) {
        frd.m20618c(str, ((glc) m20849u()).f14283c);
    }

    public void mo2691j() {
        ConfirmPopupView confirmPopupView = new ConfirmPopupView(m20847s());
        m22150a(confirmPopupView);
        confirmPopupView.setConfirmListener(new gki(this, confirmPopupView));
        m20825a((BasePopupView) confirmPopupView);
    }

    private void m22150a(ConfirmPopupView confirmPopupView) {
        String string;
        if ((m20849u() != null ? 1 : m20850v().size()) == 1) {
            string = m20847s().getResources().getString(C0349R.string.confirm_view_delete_playlist_content);
        } else {
            string = m20847s().getResources().getString(C0349R.string.confirm_view_delete_playlists_content);
        }
        confirmPopupView.m25554a();
        confirmPopupView.m25556d().setTitle(string);
        confirmPopupView.m25556d().setContent(new SpannableString(m20847s().getResources().getString(C0349R.string.confirm_view_delete_playlist_tip)));
    }

    private void m22149a(glc com_ushareit_listenit_glc) {
        List i = fqs.m20475i(com_ushareit_listenit_glc.f14283c);
        if (i != null && i.size() > 0 && gyp.m23305s() && gyp.m23303q().equals(com_ushareit_listenit_glc.f14285e)) {
            gyp.m23304r();
            gyp.m23282b(i);
        }
        frd.m20622f(com_ushareit_listenit_glc.f14283c);
    }

    private void m22151b(List<glc> list) {
        for (glc a : list) {
            m22149a(a);
        }
    }
}
