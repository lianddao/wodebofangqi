package com.ushareit.listenit;

import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.RequestQueue.RequestFilter;

public class eow implements RequestFilter {
    final /* synthetic */ Object f11412a;
    final /* synthetic */ RequestQueue f11413b;

    public eow(RequestQueue requestQueue, Object obj) {
        this.f11413b = requestQueue;
        this.f11412a = obj;
    }

    public boolean apply(Request<?> request) {
        return request.getTag() == this.f11412a;
    }
}
