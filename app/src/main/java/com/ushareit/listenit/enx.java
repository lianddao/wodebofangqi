package com.ushareit.listenit;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.volley.Response.Listener;

class enx implements Listener<MoPubClientPositioning> {
    final /* synthetic */ env f11345a;

    enx(env com_ushareit_listenit_env) {
        this.f11345a = com_ushareit_listenit_env;
    }

    public void onResponse(MoPubClientPositioning moPubClientPositioning) {
        this.f11345a.m17235a(moPubClientPositioning);
    }
}
