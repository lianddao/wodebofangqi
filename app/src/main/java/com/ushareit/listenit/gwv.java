package com.ushareit.listenit;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public abstract class gwv extends hhw {
    public gwv(String str) {
        super(str);
    }

    protected String mo2314a() {
        return gwv.class.getSimpleName();
    }

    protected ExecutorService mo2315b() {
        return new hhs(0, MoPubClientPositioning.NO_REPEAT, 60, TimeUnit.SECONDS, new SynchronousQueue());
    }

    public void callback() {
    }
}
