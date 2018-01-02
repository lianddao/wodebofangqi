package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.MenuPopupView;
import java.util.List;

class gug extends fdw {
    final /* synthetic */ gua f14741a;
    private gal f14742b;

    public gug(gua com_ushareit_listenit_gua, gal com_ushareit_listenit_gal) {
        this.f14741a = com_ushareit_listenit_gua;
        this.f14742b = com_ushareit_listenit_gal;
    }

    public void mo2608a(View view, int i) {
        this.f14741a.m22707U();
        if (this.f14741a.f14730e.m22723a(i) instanceof glg) {
            if (this.f14742b.mo2565a() == 19) {
                List c = this.f14741a.f14730e.m22730c();
                gyp.m23278a(c, (glg) c.get(i), this.f14742b.mo2565a(), "");
                gyn.m23222c(this.f14741a.m1326l());
                fii.m19311c(this.f14741a.m1326l(), gyn.m23181a(this.f14742b.mo2565a()) + "_" + "playone");
            }
            fiv.m19447d(eys.m18562a());
        }
    }

    public void mo2610b(gla com_ushareit_listenit_gla) {
        this.f14741a.m22707U();
        BasePopupView menuPopupView = new MenuPopupView(this.f14741a.m1326l(), this.f14742b.mo2566b(), com_ushareit_listenit_gla);
        menuPopupView.setTitle(com_ushareit_listenit_gla.mo2562c());
        gyn.m23197a(this.f14741a.m1328m(), new fyi(menuPopupView));
    }
}
