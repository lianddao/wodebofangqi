package com.ushareit.listenit;

import android.content.Context;
import com.mopub.common.IntentActions;
import com.mopub.mobileads.VastCompanionAdConfig;
import com.mopub.mobileads.VastVideoViewController;
import com.mopub.network.TrackingRequest;

public class ekd implements eke {
    final /* synthetic */ VastCompanionAdConfig f11173a;
    final /* synthetic */ Context f11174b;
    final /* synthetic */ VastVideoViewController f11175c;

    public ekd(VastVideoViewController vastVideoViewController, VastCompanionAdConfig vastCompanionAdConfig, Context context) {
        this.f11175c = vastVideoViewController;
        this.f11173a = vastCompanionAdConfig;
        this.f11174b = context;
    }

    public void onVastWebViewClick() {
        this.f11175c.m2839a(IntentActions.ACTION_INTERSTITIAL_CLICK);
        TrackingRequest.makeVastTrackingHttpRequest(this.f11173a.getClickTrackers(), null, Integer.valueOf(this.f11175c.f2485C), null, this.f11174b);
        this.f11173a.m2907a(this.f11174b, 1, null, this.f11175c.f2487a.getDspCreativeId());
    }
}
