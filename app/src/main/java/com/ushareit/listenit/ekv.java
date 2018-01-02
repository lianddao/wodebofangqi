package com.ushareit.listenit;

import com.mopub.mraid.MraidBridge;
import com.mopub.mraid.MraidJavascriptCommand;

public class ekv implements elv {
    final /* synthetic */ MraidJavascriptCommand f11188a;
    final /* synthetic */ MraidBridge f11189b;

    public ekv(MraidBridge mraidBridge, MraidJavascriptCommand mraidJavascriptCommand) {
        this.f11189b = mraidBridge;
        this.f11188a = mraidJavascriptCommand;
    }

    public void onFailure(ekx com_ushareit_listenit_ekx) {
        this.f11189b.m3051a(this.f11188a, com_ushareit_listenit_ekx.getMessage());
    }
}
