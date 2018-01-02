package com.ushareit.listenit;

import com.mopub.mobileads.AdViewController;
import com.mopub.network.AdRequest.Listener;
import com.mopub.network.AdResponse;
import com.mopub.volley.VolleyError;

public class eid implements Listener {
    final /* synthetic */ AdViewController f11076a;

    public eid(AdViewController adViewController) {
        this.f11076a = adViewController;
    }

    public void onSuccess(AdResponse adResponse) {
        this.f11076a.m2805a(adResponse);
    }

    public void onErrorResponse(VolleyError volleyError) {
        this.f11076a.m2806a(volleyError);
    }
}
