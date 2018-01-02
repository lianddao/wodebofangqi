package com.ushareit.listenit;

import com.mopub.mobileads.MoPubConversionTracker;
import com.mopub.network.TrackingRequest.Listener;
import com.mopub.volley.VolleyError;

public class eiu implements Listener {
    final /* synthetic */ MoPubConversionTracker f11103a;

    public eiu(MoPubConversionTracker moPubConversionTracker) {
        this.f11103a = moPubConversionTracker;
    }

    public void onResponse(String str) {
        this.f11103a.f2371c.edit().putBoolean(this.f11103a.f2370b, true).commit();
    }

    public void onErrorResponse(VolleyError volleyError) {
    }
}
