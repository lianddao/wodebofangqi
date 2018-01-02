package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.NormalPlayerMenu;

public class gqs implements OnClickListener {
    final /* synthetic */ NormalPlayerMenu f14568a;

    public gqs(NormalPlayerMenu normalPlayerMenu) {
        this.f14568a = normalPlayerMenu;
    }

    public void onClick(View view) {
        glg o = gyp.m23301o();
        if (o != null) {
            gla com_ushareit_listenit_gkv = new gkv(o.f14340h, o.f14339g, o.f14343k, 0, 0);
            fji com_ushareit_listenit_fwf = new fwf(new gai(com_ushareit_listenit_gkv), true);
            com_ushareit_listenit_fwf.mo2604c(com_ushareit_listenit_gkv.mo2562c());
            com_ushareit_listenit_fwf.m21192a(com_ushareit_listenit_gkv);
            gyn.m23211b(this.f14568a.getContext(), com_ushareit_listenit_fwf);
            hhx.m23869a(new gqt(this), 0, 200);
            fii.m19288a(this.f14568a.getContext(), 6, com_ushareit_listenit_gkv);
        }
    }
}
