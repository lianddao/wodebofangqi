package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.NormalPlayerMenu;

public class gqh implements OnClickListener {
    final /* synthetic */ NormalPlayerMenu f14555a;

    public gqh(NormalPlayerMenu normalPlayerMenu) {
        this.f14555a = normalPlayerMenu;
    }

    public void onClick(View view) {
        glg o = gyp.m23301o();
        if (o != null) {
            gla com_ushareit_listenit_gkw = new gkw(o.f14339g, o.f14340h, o.f14343k, 0, 0);
            fji com_ushareit_listenit_fwf = new fwf(new gak(com_ushareit_listenit_gkw), true);
            com_ushareit_listenit_fwf.mo2604c(com_ushareit_listenit_gkw.mo2562c());
            com_ushareit_listenit_fwf.m21192a(com_ushareit_listenit_gkw);
            gyn.m23211b(this.f14555a.getContext(), com_ushareit_listenit_fwf);
            hhx.m23869a(new gqi(this), 0, 200);
            fii.m19288a(this.f14555a.getContext(), 5, com_ushareit_listenit_gkw);
        }
    }
}
