package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.main.navigation.NavigationView;

public class gji implements OnClickListener {
    final /* synthetic */ NavigationView f14196a;

    public gji(NavigationView navigationView) {
        this.f14196a = navigationView;
    }

    public void onClick(View view) {
        boolean z = ((ListenItApp) eys.m18562a()).m4934b() != 1;
        if (z) {
            gzd.m23369g(gzd.m23364e());
            gzd.m23367f(1);
        } else {
            gzd.m23367f(gzd.m23366f());
        }
        hhf.m23855a();
        if (gwk.m23063a().m23078f()) {
            this.f14196a.f15918b.setBackgroundResource(C0349R.drawable.navigation_sleep_countdown_bg, C0349R.drawable.navigation_sleep_countdown_bg_night);
        }
        fii.m19298a(this.f14196a.getContext(), z);
        if (this.f14196a.f15927k != null) {
            this.f14196a.f15927k.onClick(view);
        }
    }
}
