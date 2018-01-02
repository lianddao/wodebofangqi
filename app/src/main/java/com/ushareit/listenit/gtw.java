package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import com.ushareit.listenit.popupview.MenuPopupView;
import java.util.List;

class gtw extends fdw {
    final /* synthetic */ gta f14723a;
    private gal f14724b;

    public gtw(gta com_ushareit_listenit_gta, gal com_ushareit_listenit_gal) {
        this.f14723a = com_ushareit_listenit_gta;
        this.f14724b = com_ushareit_listenit_gal;
    }

    public void mo2608a(View view, int i) {
        gla a;
        this.f14723a.m22737X();
        if (this.f14723a.ay) {
            if (this.f14723a.f14696f.m22701c() > i) {
                a = this.f14723a.f14696f.m22693a(i);
            } else {
                return;
            }
        } else if (this.f14723a.f14695e.getCount() > i) {
            a = this.f14723a.f14695e.m22723a(i);
        } else {
            return;
        }
        if (a instanceof glg) {
            glg com_ushareit_listenit_glg = (glg) a;
            if (com_ushareit_listenit_glg.f14348p == 0) {
                if (this.f14723a.ay) {
                    gyp.m23281b(com_ushareit_listenit_glg);
                    gyp.m23274a((glg) a);
                    fii.m19311c(this.f14723a.m1326l(), "search");
                } else {
                    List c = this.f14723a.f14695e.m22730c();
                    gyp.m23278a(c, (glg) c.get(i), this.f14724b.mo2565a(), "");
                    fii.m19311c(this.f14723a.m1326l(), gyn.m23181a(this.f14724b.mo2565a()) + "_" + "playone");
                }
                gyn.m23222c(this.f14723a.m1326l());
                return;
            }
            m22788a(com_ushareit_listenit_glg);
            return;
        }
        fji com_ushareit_listenit_fwf = new fwf(this.f14724b.mo2578a(a), true);
        com_ushareit_listenit_fwf.mo2604c(a.mo2562c());
        if (a instanceof gkv) {
            com_ushareit_listenit_fwf.m21192a(a);
        }
        gyn.m23186a(this.f14723a.m1326l(), com_ushareit_listenit_fwf);
        fii.m19288a(this.f14723a.m1328m(), this.f14724b.mo2565a(), a);
    }

    private void m22788a(glg com_ushareit_listenit_glg) {
        if (!gef.m21805a().m21835e()) {
            m22790c(com_ushareit_listenit_glg);
        } else if (flw.m19819a().m19812e(com_ushareit_listenit_glg)) {
            flw.m19819a().m19840c(com_ushareit_listenit_glg);
        } else if (flw.m19819a().m19814g(com_ushareit_listenit_glg)) {
            flw.m19819a().m19831a(com_ushareit_listenit_glg);
        } else if (flw.m19819a().m19813f(com_ushareit_listenit_glg)) {
            flw.m19819a().m19837b(com_ushareit_listenit_glg);
        } else if (com_ushareit_listenit_glg.f14352t > 0) {
            m22789b(com_ushareit_listenit_glg);
        } else {
            m22790c(com_ushareit_listenit_glg);
        }
    }

    private void m22789b(glg com_ushareit_listenit_glg) {
        BasePopupView menuPopupView = new MenuPopupView(this.f14723a.m1326l(), new gjy(this.f14723a.m1328m(), com_ushareit_listenit_glg), com_ushareit_listenit_glg);
        menuPopupView.setTitle(this.f14723a.m1329n().getString(C0349R.string.sync_song_item_menu_title));
        fyi com_ushareit_listenit_fyi = new fyi(menuPopupView);
        com_ushareit_listenit_fyi.m21347a(new gtx(this));
        gyn.m23197a(this.f14723a.m1328m(), com_ushareit_listenit_fyi);
    }

    private void m22790c(glg com_ushareit_listenit_glg) {
        BasePopupView confirmPopupView = new ConfirmPopupView(this.f14723a.m1326l());
        confirmPopupView.m25554a().setTitle((int) C0349R.string.sync_song_item_menu_title);
        confirmPopupView.m25556d().setContent((int) C0349R.string.sync_song_item_menu_content);
        confirmPopupView.setConfirmListener(new gty(this, com_ushareit_listenit_glg));
        gyn.m23197a(this.f14723a.m1328m(), new fyi(confirmPopupView));
    }

    public void mo2610b(gla com_ushareit_listenit_gla) {
        this.f14723a.m22737X();
        BasePopupView menuPopupView = new MenuPopupView(this.f14723a.m1326l(), this.f14724b.mo2566b(), com_ushareit_listenit_gla);
        menuPopupView.setTitle(com_ushareit_listenit_gla.mo2562c());
        fyi com_ushareit_listenit_fyi = new fyi(menuPopupView);
        com_ushareit_listenit_fyi.m21347a(new gtz(this));
        gyn.m23197a(this.f14723a.m1328m(), com_ushareit_listenit_fyi);
    }
}
