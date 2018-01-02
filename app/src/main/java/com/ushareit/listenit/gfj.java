package com.ushareit.listenit;

import android.util.Pair;
import android.view.View;
import com.ushareit.listenit.cloudsync.CloudSyncService;
import com.ushareit.listenit.login.UserProfileActivity;

public class gfj extends fjw {
    final /* synthetic */ UserProfileActivity f14027a;

    public gfj(UserProfileActivity userProfileActivity) {
        this.f14027a = userProfileActivity;
    }

    public void mo2389a(View view) {
        Pair a = eyw.m18568a(this.f14027a);
        boolean booleanValue = ((Boolean) a.first).booleanValue();
        if (((Boolean) a.second).booleanValue()) {
            if (fkb.m19610a().m19649g()) {
                CloudSyncService.m11590a(1);
            } else {
                CloudSyncService.m11598d();
            }
        } else if (!booleanValue) {
            heb.m23596a((int) C0349R.string.sync_net_offline, 0).show();
        } else if (fkb.m19610a().m19649g()) {
            this.f14027a.m24668u();
        } else {
            CloudSyncService.m11598d();
        }
    }
}
