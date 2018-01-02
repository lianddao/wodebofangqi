package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.VastVideoCloseButtonWidget;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

public class ejr implements ImageListener {
    final /* synthetic */ String f11146a;
    final /* synthetic */ VastVideoCloseButtonWidget f11147b;

    public ejr(VastVideoCloseButtonWidget vastVideoCloseButtonWidget, String str) {
        this.f11147b = vastVideoCloseButtonWidget;
        this.f11146a = str;
    }

    public void onResponse(ImageContainer imageContainer, boolean z) {
        Bitmap bitmap = imageContainer.getBitmap();
        if (bitmap != null) {
            this.f11147b.f2427b.setImageBitmap(bitmap);
            return;
        }
        MoPubLog.m2753d(String.format("%s returned null bitmap", new Object[]{this.f11146a}));
    }

    public void onErrorResponse(VolleyError volleyError) {
        MoPubLog.m2754d("Failed to load image.", volleyError);
    }
}
