package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.mopub.volley.toolbox.ImageLoader.ImageCache;

public final class eoo implements ImageCache {
    final /* synthetic */ fw f11395a;

    public eoo(fw fwVar) {
        this.f11395a = fwVar;
    }

    public Bitmap getBitmap(String str) {
        return (Bitmap) this.f11395a.get(str);
    }

    public void putBitmap(String str, Bitmap bitmap) {
        this.f11395a.put(str, bitmap);
    }
}
