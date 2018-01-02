package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.main.navigation.NavigationView;
import com.ushareit.listenit.sleep.SleepPopupView;

public class gjo implements OnClickListener {
    final /* synthetic */ NavigationView f14202a;

    public gjo(NavigationView navigationView) {
        this.f14202a = navigationView;
    }

    public void onClick(View view) {
        gyn.m23197a((ak) this.f14202a.f15919c, new fyi(new SleepPopupView(this.f14202a.f15919c)));
    }
}
