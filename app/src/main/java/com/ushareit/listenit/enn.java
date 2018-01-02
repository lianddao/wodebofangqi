package com.ushareit.listenit;

import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.NativeImageHelper;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class enn implements ImageListener {
    final /* synthetic */ AtomicInteger f11316a;
    final /* synthetic */ AtomicBoolean f11317b;
    final /* synthetic */ NativeImageHelper.ImageListener f11318c;

    public enn(AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, NativeImageHelper.ImageListener imageListener) {
        this.f11316a = atomicInteger;
        this.f11317b = atomicBoolean;
        this.f11318c = imageListener;
    }

    public void onResponse(ImageContainer imageContainer, boolean z) {
        if (imageContainer.getBitmap() != null && this.f11316a.decrementAndGet() == 0 && !this.f11317b.get()) {
            this.f11318c.onImagesCached();
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        MoPubLog.m2754d("Failed to download a native ads image:", volleyError);
        boolean andSet = this.f11317b.getAndSet(true);
        this.f11316a.decrementAndGet();
        if (!andSet) {
            this.f11318c.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
        }
    }
}
