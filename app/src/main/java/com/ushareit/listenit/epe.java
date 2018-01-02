package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.toolbox.ImageLoader;

public class epe implements Listener<Bitmap> {
    final /* synthetic */ String f11420a;
    final /* synthetic */ ImageLoader f11421b;

    public epe(ImageLoader imageLoader, String str) {
        this.f11421b = imageLoader;
        this.f11420a = str;
    }

    public void onResponse(Bitmap bitmap) {
        this.f11421b.m3334a(this.f11420a, bitmap);
    }
}
