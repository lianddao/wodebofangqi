package com.ushareit.listenit;

import com.mopub.mobileads.MraidActivity;
import com.mopub.mraid.MraidController.UseCustomCloseListener;

public class ejb implements UseCustomCloseListener {
    final /* synthetic */ MraidActivity f11111a;

    public ejb(MraidActivity mraidActivity) {
        this.f11111a = mraidActivity;
    }

    public void useCustomCloseChanged(boolean z) {
        if (z) {
            this.f11111a.m2868c();
        } else {
            this.f11111a.m2867b();
        }
    }
}
