package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import com.ushareit.listenit.popupview.NormalPlayerMenu;

public class gqm implements OnClickListener {
    final /* synthetic */ NormalPlayerMenu f14560a;

    public gqm(NormalPlayerMenu normalPlayerMenu) {
        this.f14560a = normalPlayerMenu;
    }

    public void onClick(View view) {
        ConfirmPopupView confirmPopupView = new ConfirmPopupView(this.f14560a.getContext());
        this.f14560a.m25610a(confirmPopupView);
        confirmPopupView.setConfirmListener(new gqn(this, confirmPopupView));
        gyn.m23197a((ak) this.f14560a.getContext(), new fyi(confirmPopupView));
        this.f14560a.m25608a();
    }
}
