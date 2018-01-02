package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.NormalPlayerMenu;

public class gql implements OnClickListener {
    final /* synthetic */ NormalPlayerMenu f14559a;

    public gql(NormalPlayerMenu normalPlayerMenu) {
        this.f14559a = normalPlayerMenu;
    }

    public void onClick(View view) {
        gla o = gyp.m23301o();
        if (o != null) {
            hij.m23900a(o, this.f14559a.getContext());
            fiq.m19373a(this.f14559a.getContext(), "UF_MenuShareClick", -10001, o.f14338f, "normalplayer");
            fii.m19294a(this.f14559a.getContext(), o, -10001);
            fit.m19433b(this.f14559a.getContext(), "share");
        }
        this.f14559a.m25608a();
    }
}
