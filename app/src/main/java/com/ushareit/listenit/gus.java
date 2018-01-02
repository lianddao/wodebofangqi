package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.listenit.cloudsync.CloudSyncService;
import com.ushareit.listenit.service.CommonService;
import com.ushareit.listenit.service.PlayService;

public class gus extends hhv {
    final /* synthetic */ PlayService f14763a;

    public gus(PlayService playService) {
        this.f14763a = playService;
    }

    public void e_() {
        try {
            Intent intent = new Intent(this.f14763a, CommonService.class);
            intent.putExtra("StartType", gul.AppDestory.m22821a());
            this.f14763a.startService(intent);
            if (gef.m21805a().m21835e()) {
                CloudSyncService.m11596c();
            }
        } catch (Exception e) {
        }
    }
}
