package com.ushareit.listenit;

import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.VastVideoConfig;

public class ejl implements ekk {
    final /* synthetic */ VastVideoConfig f11133a;
    final /* synthetic */ VastManager f11134b;

    public ejl(VastManager vastManager, VastVideoConfig vastVideoConfig) {
        this.f11134b = vastManager;
        this.f11133a = vastVideoConfig;
    }

    public void onComplete(boolean z) {
        if (z && this.f11134b.m2925a(this.f11133a)) {
            this.f11134b.f2414a.onVastVideoConfigurationPrepared(this.f11133a);
            return;
        }
        MoPubLog.m2753d("Failed to download VAST video.");
        this.f11134b.f2414a.onVastVideoConfigurationPrepared(null);
    }
}
