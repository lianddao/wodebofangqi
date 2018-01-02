package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.listenit.service.PlayService;

public class gur extends hhw {
    final /* synthetic */ Intent f14759a;
    final /* synthetic */ int f14760b;
    final /* synthetic */ int f14761c;
    final /* synthetic */ PlayService f14762d;

    public gur(PlayService playService, Intent intent, int i, int i2) {
        this.f14762d = playService;
        this.f14759a = intent;
        this.f14760b = i;
        this.f14761c = i2;
    }

    public void execute() {
        guw.m22831a().m22847b(this.f14762d.getApplicationContext(), this.f14762d.f16448b);
    }

    public void callback() {
        this.f14762d.m26068a(this.f14759a, this.f14760b, this.f14761c);
    }
}
