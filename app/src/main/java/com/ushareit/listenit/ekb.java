package com.ushareit.listenit;

import android.content.Context;
import com.mopub.mobileads.VastVideoViewController;
import com.mopub.network.TrackingRequest;

public class ekb implements eke {
    final /* synthetic */ ejg f11168a;
    final /* synthetic */ Context f11169b;
    final /* synthetic */ VastVideoViewController f11170c;

    public ekb(VastVideoViewController vastVideoViewController, ejg com_ushareit_listenit_ejg, Context context) {
        this.f11170c = vastVideoViewController;
        this.f11168a = com_ushareit_listenit_ejg;
        this.f11169b = context;
    }

    public void onVastWebViewClick() {
        TrackingRequest.makeVastTrackingHttpRequest(this.f11168a.m17112f(), null, Integer.valueOf(this.f11170c.m3005j()), this.f11170c.m3010o(), this.f11169b);
        this.f11168a.m17107a(this.f11170c.m2848h(), null, this.f11170c.f2487a.getDspCreativeId());
    }
}
