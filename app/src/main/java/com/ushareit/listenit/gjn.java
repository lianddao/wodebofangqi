package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;
import com.ushareit.listenit.main.navigation.NavigationView;

public class gjn implements OnClickListener {
    final /* synthetic */ NavigationView f14201a;

    public gjn(NavigationView navigationView) {
        this.f14201a = navigationView;
    }

    public void onClick(View view) {
        this.f14201a.m24853a(new Intent(this.f14201a.f15919c, EqualizerActivity.class));
        fii.m19297a(this.f14201a.f15919c, "equalizer", "from_navigation");
    }
}
