package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.listenit.cutter.RingEditActivity;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class gjw extends gkf {
    public gjw(int i) {
        super(i);
    }

    public void mo2569a() {
        m20848t().setShowSetAsRingtone();
        m20848t().setShowSetAsNotification();
        m20848t().setShowSetAsAlarm();
        m20848t().setShowShare();
        m20848t().setShowDelete();
    }

    public void mo2691j() {
        BasePopupView confirmPopupView = new ConfirmPopupView(m20847s());
        m22096a(confirmPopupView);
        confirmPopupView.setConfirmListener(new gjx(this, confirmPopupView));
        m20825a(confirmPopupView);
    }

    private void m22096a(ConfirmPopupView confirmPopupView) {
        String string = m20847s().getResources().getString(C0349R.string.confirm_view_delete_song_title, new Object[]{Integer.valueOf(1)});
        String string2 = m20847s().getResources().getString(C0349R.string.confirm_view_delete_song_content);
        String string3 = m20847s().getResources().getString(C0349R.string.confirm_view_delete_local_file);
        confirmPopupView.m25554a().setTitle(string);
        confirmPopupView.m25556d().setContent(string2);
        confirmPopupView.m25557f().setSelectDesc(string3);
    }

    private void m22097a(boolean z, gkx com_ushareit_listenit_gkx) {
        fqz.m20503b(com_ushareit_listenit_gkx);
        if (z) {
            gyn.m23246h(com_ushareit_listenit_gkx.f14256c);
        }
    }

    public void mo2575g() {
        hij.m23900a(new glg((gkx) m20849u()), m20847s());
        fii.m19294a(m20847s(), m20849u(), m20846r());
    }

    public void mo2694k() {
        super.mo2694k();
        gkx com_ushareit_listenit_gkx = (gkx) m20849u();
        if (com_ushareit_listenit_gkx != null) {
            grz.m22656a().m22667b(com_ushareit_listenit_gkx.f14256c, 1);
        }
        m20853y();
    }

    public void mo2695l() {
        super.mo2695l();
        gkx com_ushareit_listenit_gkx = (gkx) m20849u();
        if (com_ushareit_listenit_gkx != null) {
            grz.m22656a().m22667b(com_ushareit_listenit_gkx.f14256c, 2);
        }
        m20853y();
    }

    public void mo2696m() {
        super.mo2696m();
        gkx com_ushareit_listenit_gkx = (gkx) m20849u();
        if (com_ushareit_listenit_gkx != null) {
            grz.m22656a().m22667b(com_ushareit_listenit_gkx.f14256c, 4);
        }
        m20853y();
    }

    public void mo2697n() {
        super.mo2697n();
        if (m20849u() != null) {
            gkx com_ushareit_listenit_gkx = (gkx) m20849u();
            Intent intent = new Intent(eys.m18562a(), RingEditActivity.class);
            intent.putExtra("songId", com_ushareit_listenit_gkx.f14254a);
            eys.m18562a().startActivity(intent);
            fii.m19320f(eys.m18562a(), gyn.m23181a(m20846r()));
        }
    }
}
