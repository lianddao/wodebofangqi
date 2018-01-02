package com.ushareit.listenit;

import com.mopub.network.MoPubRequestQueue;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue.RequestFilter;

public class eok implements RequestFilter {
    final /* synthetic */ Request f11378a;
    final /* synthetic */ MoPubRequestQueue f11379b;

    public eok(MoPubRequestQueue moPubRequestQueue, Request request) {
        this.f11379b = moPubRequestQueue;
        this.f11378a = request;
    }

    public boolean apply(Request<?> request) {
        return this.f11378a == request;
    }
}
