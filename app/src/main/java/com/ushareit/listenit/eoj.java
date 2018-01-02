package com.ushareit.listenit;

import com.mopub.network.MoPubRequestQueue;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue.RequestFilter;

public class eoj implements RequestFilter {
    final /* synthetic */ Object f11376a;
    final /* synthetic */ MoPubRequestQueue f11377b;

    public eoj(MoPubRequestQueue moPubRequestQueue, Object obj) {
        this.f11377b = moPubRequestQueue;
        this.f11376a = obj;
    }

    public boolean apply(Request<?> request) {
        return request.getTag() == this.f11376a;
    }
}
