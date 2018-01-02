package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.FullScanActivity;

class gtc implements OnClickListener {
    final /* synthetic */ gta f14701a;

    gtc(gta com_ushareit_listenit_gta) {
        this.f14701a = com_ushareit_listenit_gta;
    }

    public void onClick(View view) {
        this.f14701a.m1284a(new Intent(this.f14701a.m1326l(), FullScanActivity.class));
        fii.m19316d(this.f14701a.m1326l(), "search");
        fio.m19367b(this.f14701a.m1326l(), "scan");
        fiv.m19451h(this.f14701a.m1326l());
    }
}
