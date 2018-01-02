package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.NormalPlayerMenu;
import com.ushareit.listenit.popupview.SelectAlbumPopupView;

public class gqr implements OnClickListener {
    final /* synthetic */ NormalPlayerMenu f14567a;

    public gqr(NormalPlayerMenu normalPlayerMenu) {
        this.f14567a = normalPlayerMenu;
    }

    public void onClick(View view) {
        gyn.m23197a((ak) this.f14567a.getContext(), new fyi(new SelectAlbumPopupView(this.f14567a.getContext(), ((fjf) this.f14567a.getContext()).m4860n().mo2465v(), "NormalPlayerMenu")));
        this.f14567a.m25608a();
    }
}
