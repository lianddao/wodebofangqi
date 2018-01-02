package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import java.util.LinkedList;

public class eph {
    final /* synthetic */ ImageLoader f11425a;
    private final Request<?> f11426b;
    private Bitmap f11427c;
    private VolleyError f11428d;
    private final LinkedList<ImageContainer> f11429e = new LinkedList();

    public eph(ImageLoader imageLoader, Request<?> request, ImageContainer imageContainer) {
        this.f11425a = imageLoader;
        this.f11426b = request;
        this.f11429e.add(imageContainer);
    }

    public void setError(VolleyError volleyError) {
        this.f11428d = volleyError;
    }

    public VolleyError getError() {
        return this.f11428d;
    }

    public void addContainer(ImageContainer imageContainer) {
        this.f11429e.add(imageContainer);
    }

    public boolean removeContainerAndCancelIfNecessary(ImageContainer imageContainer) {
        this.f11429e.remove(imageContainer);
        if (this.f11429e.size() != 0) {
            return false;
        }
        this.f11426b.cancel();
        return true;
    }
}
