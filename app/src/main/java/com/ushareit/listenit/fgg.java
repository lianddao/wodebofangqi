package com.ushareit.listenit;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener;
import com.umeng.analytics.C0154a;
import java.util.ArrayList;
import java.util.List;

class fgg implements InterstitialAdListener {
    final /* synthetic */ fgf f12656a;
    private ese f12657b;
    private long f12658c;
    private long f12659d;
    private boolean f12660e = false;

    public fgg(fgf com_ushareit_listenit_fgf, ese com_ushareit_listenit_ese, long j) {
        this.f12656a = com_ushareit_listenit_fgf;
        this.f12657b = com_ushareit_listenit_ese;
        this.f12658c = j;
    }

    public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {
        List arrayList = new ArrayList();
        arrayList.add(new esi(this.f12657b.f11684a, this.f12657b.f11686c, C0154a.f2954j, moPubInterstitial, ((ffl) this.f12657b).f12607l));
        this.f12656a.m17785a(this.f12657b, arrayList);
        fie.m19274l(this.f12657b.f11686c, System.currentTimeMillis() - this.f12658c);
    }

    public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {
        fie.m19266f(this.f12657b.f11686c, moPubErrorCode != null ? moPubErrorCode.toString() : "");
    }

    public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {
        this.f12659d = System.currentTimeMillis();
        fie.m19269h(this.f12657b.f11686c);
        fie.m19253d((ffl) this.f12657b);
    }

    public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {
        fie.m19275m(this.f12657b.f11686c, System.currentTimeMillis() - this.f12659d);
        fie.m19258e((ffl) this.f12657b);
        this.f12660e = true;
    }

    public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
        fie.m19276n(this.f12657b.f11686c, System.currentTimeMillis() - this.f12659d);
        if (!this.f12660e) {
            fie.m19263f((ffl) this.f12657b);
        }
    }
}
