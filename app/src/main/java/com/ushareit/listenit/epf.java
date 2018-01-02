package com.ushareit.listenit;

import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;

public class epf implements ErrorListener {
    final /* synthetic */ String f11422a;
    final /* synthetic */ ImageLoader f11423b;

    public epf(ImageLoader imageLoader, String str) {
        this.f11423b = imageLoader;
        this.f11422a = str;
    }

    public void onErrorResponse(VolleyError volleyError) {
        this.f11423b.m3335a(this.f11422a, volleyError);
    }
}
