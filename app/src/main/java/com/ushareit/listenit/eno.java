package com.ushareit.listenit;

import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

public final class eno implements ImageListener {
    final /* synthetic */ ImageView f11319a;

    public eno(ImageView imageView) {
        this.f11319a = imageView;
    }

    public void onResponse(ImageContainer imageContainer, boolean z) {
        if (!z) {
            MoPubLog.m2753d("Image was not loaded immediately into your ad view. You should call preCacheImages as part of your custom event loading process.");
        }
        this.f11319a.setImageBitmap(imageContainer.getBitmap());
    }

    public void onErrorResponse(VolleyError volleyError) {
        MoPubLog.m2754d("Failed to load image.", volleyError);
        this.f11319a.setImageDrawable(null);
    }
}
