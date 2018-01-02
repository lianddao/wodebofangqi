package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.MenuPopupView;
import java.util.List;

class fvx extends fdw {
    final /* synthetic */ fvs f13607a;

    fvx(fvs com_ushareit_listenit_fvs) {
        this.f13607a = com_ushareit_listenit_fvs;
    }

    public void mo2608a(View view, int i) {
        gla b = this.f13607a.f13597e.m18923b(i);
        if (b instanceof glg) {
            glg com_ushareit_listenit_glg = (glg) b;
            if (com_ushareit_listenit_glg.f14348p == 0) {
                List b2 = this.f13607a.f13597e.m18924b();
                gyp.m23278a(b2, (glg) b2.get(i), this.f13607a.f13599g.mo2565a(), "");
                gyn.m23222c(this.f13607a.m1326l());
                fii.m19311c(this.f13607a.m1326l(), gyn.m23181a(this.f13607a.f13599g.mo2565a()) + "_" + "playone");
                return;
            }
            this.f13607a.m21121a(com_ushareit_listenit_glg);
            return;
        }
        fji com_ushareit_listenit_fwf = new fwf(this.f13607a.f13599g.mo2578a(b), true);
        com_ushareit_listenit_fwf.mo2604c(b.mo2562c());
        if (b instanceof gkv) {
            com_ushareit_listenit_fwf.m21192a(b);
        }
        gyn.m23186a(this.f13607a.m1326l(), com_ushareit_listenit_fwf);
        fii.m19288a(this.f13607a.m1328m(), this.f13607a.f13599g.mo2565a(), b);
    }

    public void mo2610b(gla com_ushareit_listenit_gla) {
        BasePopupView menuPopupView = new MenuPopupView(this.f13607a.m1326l(), this.f13607a.f13599g.mo2566b(), com_ushareit_listenit_gla);
        menuPopupView.setTitle(com_ushareit_listenit_gla.mo2562c());
        fyi com_ushareit_listenit_fyi = new fyi(menuPopupView);
        com_ushareit_listenit_fyi.m21347a(new fvy(this));
        gyn.m23197a(this.f13607a.m1328m(), com_ushareit_listenit_fyi);
    }
}
