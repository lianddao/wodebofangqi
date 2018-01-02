package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.NormalPlayerMenu;
import com.ushareit.listenit.sleep.SleepPopupView;

public class gqk implements OnClickListener {
    final /* synthetic */ NormalPlayerMenu f14558a;

    public gqk(NormalPlayerMenu normalPlayerMenu) {
        this.f14558a = normalPlayerMenu;
    }

    public void onClick(View view) {
        gyn.m23197a((ak) this.f14558a.getContext(), new fyi(new SleepPopupView(this.f14558a.getContext())));
        fit.m19433b(this.f14558a.getContext(), "sleep_timer");
        this.f14558a.m25608a();
    }
}
