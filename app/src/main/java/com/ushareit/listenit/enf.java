package com.ushareit.listenit;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.AdRendererRegistry;
import com.mopub.nativeads.MoPubAdRenderer;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.RequestParameters;
import java.util.ArrayList;
import java.util.List;

public class enf {
    @VisibleForTesting
    static final int[] f11294a = new int[]{1000, 3000, 5000, 25000, 60000, 300000};
    @VisibleForTesting
    boolean f11295b;
    @VisibleForTesting
    boolean f11296c;
    @VisibleForTesting
    int f11297d;
    @VisibleForTesting
    int f11298e;
    private final List<eoa<NativeAd>> f11299f;
    private final Handler f11300g;
    private final Runnable f11301h;
    private final MoPubNativeNetworkListener f11302i;
    private eni f11303j;
    private RequestParameters f11304k;
    private MoPubNative f11305l;
    private final AdRendererRegistry f11306m;

    public enf() {
        this(new ArrayList(1), new Handler(), new AdRendererRegistry());
    }

    @VisibleForTesting
    enf(List<eoa<NativeAd>> list, Handler handler, AdRendererRegistry adRendererRegistry) {
        this.f11299f = list;
        this.f11300g = handler;
        this.f11301h = new eng(this);
        this.f11306m = adRendererRegistry;
        this.f11302i = new enh(this);
        this.f11297d = 0;
        m17200e();
    }

    public int m17192a() {
        return this.f11306m.getAdRendererCount();
    }

    public int getViewTypeForAd(NativeAd nativeAd) {
        return this.f11306m.getViewTypeForAd(nativeAd);
    }

    public void m17194a(MoPubAdRenderer moPubAdRenderer) {
        this.f11306m.registerAdRenderer(moPubAdRenderer);
        if (this.f11305l != null) {
            this.f11305l.registerAdRenderer(moPubAdRenderer);
        }
    }

    public MoPubAdRenderer getAdRendererForViewType(int i) {
        return this.f11306m.getRendererForViewType(i);
    }

    public void m17196a(eni com_ushareit_listenit_eni) {
        this.f11303j = com_ushareit_listenit_eni;
    }

    public void m17193a(Activity activity, String str, RequestParameters requestParameters) {
        m17195a(requestParameters, new MoPubNative(activity, str, this.f11302i));
    }

    @VisibleForTesting
    void m17195a(RequestParameters requestParameters, MoPubNative moPubNative) {
        m17197b();
        for (MoPubAdRenderer registerAdRenderer : this.f11306m.getRendererIterable()) {
            moPubNative.registerAdRenderer(registerAdRenderer);
        }
        this.f11304k = requestParameters;
        this.f11305l = moPubNative;
        m17202g();
    }

    public void m17197b() {
        if (this.f11305l != null) {
            this.f11305l.destroy();
            this.f11305l = null;
        }
        this.f11304k = null;
        for (eoa com_ushareit_listenit_eoa : this.f11299f) {
            ((NativeAd) com_ushareit_listenit_eoa.f11355a).destroy();
        }
        this.f11299f.clear();
        this.f11300g.removeMessages(0);
        this.f11295b = false;
        this.f11297d = 0;
        m17200e();
    }

    public NativeAd m17198c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!(this.f11295b || this.f11296c)) {
            this.f11300g.post(this.f11301h);
        }
        while (!this.f11299f.isEmpty()) {
            eoa com_ushareit_listenit_eoa = (eoa) this.f11299f.remove(0);
            if (uptimeMillis - com_ushareit_listenit_eoa.f11356b < 900000) {
                return (NativeAd) com_ushareit_listenit_eoa.f11355a;
            }
        }
        return null;
    }

    @VisibleForTesting
    void m17199d() {
        if (this.f11298e < f11294a.length - 1) {
            this.f11298e++;
        }
    }

    @VisibleForTesting
    void m17200e() {
        this.f11298e = 0;
    }

    @VisibleForTesting
    int m17201f() {
        if (this.f11298e >= f11294a.length) {
            this.f11298e = f11294a.length - 1;
        }
        return f11294a[this.f11298e];
    }

    @VisibleForTesting
    void m17202g() {
        if (!this.f11295b && this.f11305l != null && this.f11299f.size() < 1) {
            this.f11295b = true;
            this.f11305l.makeRequest(this.f11304k, Integer.valueOf(this.f11297d));
        }
    }
}
