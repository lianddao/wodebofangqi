package com.ushareit.listenit;

import android.os.Handler;
import com.mopub.common.VisibleForTesting;
import com.mopub.network.MoPubRequestQueue;
import com.mopub.volley.Request;

public class eol {
    final int f11380a;
    final Handler f11381b;
    final Runnable f11382c;
    final /* synthetic */ MoPubRequestQueue f11383d;

    public eol(MoPubRequestQueue moPubRequestQueue, Request<?> request, int i) {
        this(moPubRequestQueue, request, i, new Handler());
    }

    @VisibleForTesting
    eol(MoPubRequestQueue moPubRequestQueue, Request<?> request, int i, Handler handler) {
        this.f11383d = moPubRequestQueue;
        this.f11380a = i;
        this.f11381b = handler;
        this.f11382c = new eom(this, moPubRequestQueue, request);
    }

    public void m17259a() {
        this.f11381b.postDelayed(this.f11382c, (long) this.f11380a);
    }

    public void m17260b() {
        this.f11381b.removeCallbacks(this.f11382c);
    }
}
