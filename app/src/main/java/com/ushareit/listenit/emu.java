package com.ushareit.listenit;

import com.mopub.nativeads.MoPubNative;
import com.mopub.network.AdRequest.Listener;
import com.mopub.network.AdResponse;
import com.mopub.volley.VolleyError;

public class emu implements Listener {
    final /* synthetic */ MoPubNative f11279a;

    public emu(MoPubNative moPubNative) {
        this.f11279a = moPubNative;
    }

    public void onSuccess(AdResponse adResponse) {
        this.f11279a.m3188a(adResponse);
    }

    public void onErrorResponse(VolleyError volleyError) {
        this.f11279a.m3191a(volleyError);
    }
}
