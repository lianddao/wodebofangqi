package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import com.ushareit.listenit.popupview.MenuPopupView;
import java.util.List;

class fwq extends fdw {
    final /* synthetic */ fwf f13633a;

    fwq(fwf com_ushareit_listenit_fwf) {
        this.f13633a = com_ushareit_listenit_fwf;
    }

    public void mo2608a(View view, int i) {
        gla b = this.f13633a.f13617e.m18923b(i);
        if (b instanceof glg) {
            List b2;
            if (this.f13633a.ao.mo2565a() == 17) {
                b2 = this.f13633a.f13617e.m18924b();
                gyp.m23278a(b2, (glg) b2.get(i), this.f13633a.ao.mo2565a(), this.f13633a.c);
                gyn.m23222c(this.f13633a.m1326l());
                fii.m19311c(this.f13633a.m1326l(), gyn.m23181a(this.f13633a.ao.mo2565a()) + "_" + "playone");
                return;
            }
            glg com_ushareit_listenit_glg = (glg) b;
            if (com_ushareit_listenit_glg.f14348p == 0) {
                b2 = this.f13633a.f13617e.m18924b();
                gyp.m23278a(b2, (glg) b2.get(i), this.f13633a.ao.mo2565a(), this.f13633a.c);
                gyn.m23222c(this.f13633a.m1326l());
                fii.m19311c(this.f13633a.m1326l(), gyn.m23181a(this.f13633a.ao.mo2565a()) + "_" + "playone");
                return;
            }
            m21207a(com_ushareit_listenit_glg);
        } else if (!(b instanceof fsi)) {
            fji com_ushareit_listenit_fwf = new fwf(this.f13633a.ao.mo2578a(b), true);
            com_ushareit_listenit_fwf.mo2604c(b.mo2562c());
            if (b instanceof fsg) {
                com_ushareit_listenit_fwf.m21192a(b);
            }
            gyn.m23186a(this.f13633a.m1326l(), com_ushareit_listenit_fwf);
        }
    }

    private void m21207a(glg com_ushareit_listenit_glg) {
        if (!gef.m21805a().m21835e()) {
            m21209c(com_ushareit_listenit_glg);
        } else if (flw.m19819a().m19812e(com_ushareit_listenit_glg)) {
            flw.m19819a().m19840c(com_ushareit_listenit_glg);
        } else if (flw.m19819a().m19814g(com_ushareit_listenit_glg)) {
            flw.m19819a().m19831a(com_ushareit_listenit_glg);
        } else if (flw.m19819a().m19813f(com_ushareit_listenit_glg)) {
            flw.m19819a().m19837b(com_ushareit_listenit_glg);
        } else if (com_ushareit_listenit_glg.f14352t > 0) {
            m21208b(com_ushareit_listenit_glg);
        } else {
            m21209c(com_ushareit_listenit_glg);
        }
    }

    private void m21208b(glg com_ushareit_listenit_glg) {
        BasePopupView menuPopupView = new MenuPopupView(this.f13633a.m1326l(), new gjy(this.f13633a.m1328m(), com_ushareit_listenit_glg), com_ushareit_listenit_glg);
        menuPopupView.setTitle(this.f13633a.m1329n().getString(C0349R.string.sync_song_item_menu_title));
        fyi com_ushareit_listenit_fyi = new fyi(menuPopupView);
        com_ushareit_listenit_fyi.m21347a(new fwr(this));
        gyn.m23197a(this.f13633a.m1328m(), com_ushareit_listenit_fyi);
    }

    private void m21209c(glg com_ushareit_listenit_glg) {
        BasePopupView confirmPopupView = new ConfirmPopupView(this.f13633a.m1326l());
        confirmPopupView.m25554a().setTitle((int) C0349R.string.sync_song_item_menu_title);
        confirmPopupView.m25556d().setContent((int) C0349R.string.sync_song_item_menu_content);
        confirmPopupView.setConfirmListener(new fws(this, com_ushareit_listenit_glg));
        gyn.m23197a(this.f13633a.m1328m(), new fyi(confirmPopupView));
    }

    public void mo2609a(gla com_ushareit_listenit_gla) {
        this.f13633a.ac();
    }

    public void mo2610b(gla com_ushareit_listenit_gla) {
        BasePopupView menuPopupView = new MenuPopupView(this.f13633a.m1326l(), this.f13633a.ao.mo2566b(), com_ushareit_listenit_gla);
        menuPopupView.setTitle(com_ushareit_listenit_gla.mo2562c());
        menuPopupView.setParentName(this.f13633a.c);
        fyi com_ushareit_listenit_fyi = new fyi(menuPopupView);
        com_ushareit_listenit_fyi.m21347a(new fwt(this));
        gyn.m23197a(this.f13633a.m1328m(), com_ushareit_listenit_fyi);
    }
}
