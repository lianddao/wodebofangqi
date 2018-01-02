package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.main.navigation.NavigationView;
import com.ushareit.listenit.popupview.RatePopupView;

public class gjp implements OnClickListener {
    final /* synthetic */ NavigationView f14203a;

    public gjp(NavigationView navigationView) {
        this.f14203a = navigationView;
    }

    public void onClick(View view) {
        gyn.m23197a((ak) this.f14203a.f15919c, new fyi(new RatePopupView(this.f14203a.f15919c)));
    }
}
