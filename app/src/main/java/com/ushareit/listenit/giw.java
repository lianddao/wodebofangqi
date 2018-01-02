package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.listenit.main.StartupActivity;
import com.ushareit.listenit.service.PlayService;

public class giw extends hhw {
    final /* synthetic */ StartupActivity f14181a;

    public giw(StartupActivity startupActivity) {
        this.f14181a = startupActivity;
    }

    public void execute() {
        fqs.m20474h();
        guw.m22831a().m22846b();
    }

    public void callback() {
        if (!this.f14181a.f15915n) {
            eys.m18562a().startService(new Intent(eys.m18562a(), PlayService.class));
        }
    }
}
