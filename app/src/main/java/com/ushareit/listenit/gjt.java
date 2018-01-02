package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.main.navigation.NavigationView;
import com.ushareit.listenit.nearby.view.NearbyActivity;

public class gjt implements OnClickListener {
    final /* synthetic */ NavigationView f14207a;

    public gjt(NavigationView navigationView) {
        this.f14207a = navigationView;
    }

    public void onClick(View view) {
        this.f14207a.m24853a(new Intent(this.f14207a.f15919c, NearbyActivity.class));
        this.f14207a.f15925i.setVisibility(8);
        if (this.f14207a.f15926j != null) {
            this.f14207a.f15926j.mo2617a();
        }
        fii.m19297a(this.f14207a.f15919c, "nearbyActivity", "from_navigation");
        fir.m19384c();
    }
}
