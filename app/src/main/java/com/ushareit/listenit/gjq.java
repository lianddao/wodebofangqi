package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.main.navigation.NavigationView;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gjq implements OnClickListener {
    final /* synthetic */ NavigationView f14204a;

    public gjq(NavigationView navigationView) {
        this.f14204a = navigationView;
    }

    public void onClick(View view) {
        this.f14204a.m24853a(new Intent(this.f14204a.f15919c, UserSettingsActivity.class));
        fii.m19297a(this.f14204a.f15919c, "settings", "from_navigation");
    }
}
