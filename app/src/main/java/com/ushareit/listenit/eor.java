package com.ushareit.listenit;

import com.mopub.common.logging.MoPubLog;
import com.mopub.network.TrackingRequest.Listener;
import com.mopub.volley.VolleyError;

public final class eor implements Listener {
    final /* synthetic */ Listener f11399a;
    final /* synthetic */ String f11400b;

    public eor(Listener listener, String str) {
        this.f11399a = listener;
        this.f11400b = str;
    }

    public void onResponse(String str) {
        MoPubLog.m2753d("Successfully hit tracking endpoint: " + str);
        if (this.f11399a != null) {
            this.f11399a.onResponse(str);
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        MoPubLog.m2753d("Failed to hit tracking endpoint: " + this.f11400b);
        if (this.f11399a != null) {
            this.f11399a.onErrorResponse(volleyError);
        }
    }
}
