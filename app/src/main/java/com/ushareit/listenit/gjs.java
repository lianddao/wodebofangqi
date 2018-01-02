package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.cutter.AudioCutterActivity;
import com.ushareit.listenit.main.navigation.NavigationView;

public class gjs implements OnClickListener {
    final /* synthetic */ NavigationView f14206a;

    public gjs(NavigationView navigationView) {
        this.f14206a = navigationView;
    }

    public void onClick(View view) {
        this.f14206a.m24853a(new Intent(this.f14206a.f15919c, AudioCutterActivity.class));
        fii.m19297a(this.f14206a.f15919c, "audio cutter", "from_navigation");
    }
}
