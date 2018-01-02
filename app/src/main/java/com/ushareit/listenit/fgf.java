package com.ushareit.listenit;

import android.app.Activity;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.nativeads.FacebookAdRenderer;
import com.mopub.nativeads.GooglePlayServicesAdRenderer;
import com.mopub.nativeads.MoPubAdRenderer;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.MoPubStaticNativeAdRenderer;
import com.mopub.nativeads.RequestParameters;
import com.mopub.nativeads.RequestParameters.NativeAdAsset;
import com.mopub.nativeads.ViewBinder;
import com.mopub.nativeads.ViewBinder.Builder;
import java.util.EnumSet;

public class fgf extends esj {
    public fgf(esa com_ushareit_listenit_esa) {
        super(com_ushareit_listenit_esa);
    }

    public int mo2369a(ese com_ushareit_listenit_ese) {
        if (VERSION.SDK_INT < 9) {
            return 9002;
        }
        if (!m19151b()) {
            return 9004;
        }
        if (com_ushareit_listenit_ese == null || TextUtils.isEmpty(com_ushareit_listenit_ese.f11684a) || !com_ushareit_listenit_ese.f11684a.startsWith("mopub")) {
            return 9003;
        }
        return 0;
    }

    protected void mo2370a(ese com_ushareit_listenit_ese, int i) {
        ffl com_ushareit_listenit_ffl = (ffl) com_ushareit_listenit_ese;
        String str = com_ushareit_listenit_ffl.f12605j;
        int i2 = -1;
        switch (str.hashCode()) {
            case 105:
                if (str.equals("i")) {
                    i2 = 1;
                    break;
                }
                break;
            case 110:
                if (str.equals("n")) {
                    i2 = 0;
                    break;
                }
                break;
        }
        switch (i2) {
            case 0:
                MoPubNative moPubNative = new MoPubNative(this.b.m17691a(), com_ushareit_listenit_ffl.c, new fgi(this, com_ushareit_listenit_ese, System.currentTimeMillis()));
                ViewBinder build = new Builder(0).build();
                MoPubAdRenderer facebookAdRenderer = new FacebookAdRenderer(build);
                MoPubAdRenderer googlePlayServicesAdRenderer = new GooglePlayServicesAdRenderer(build);
                MoPubAdRenderer moPubStaticNativeAdRenderer = new MoPubStaticNativeAdRenderer(build);
                moPubNative.registerAdRenderer(facebookAdRenderer);
                moPubNative.registerAdRenderer(googlePlayServicesAdRenderer);
                moPubNative.registerAdRenderer(moPubStaticNativeAdRenderer);
                moPubNative.makeRequest(new RequestParameters.Builder().desiredAssets(EnumSet.of(NativeAdAsset.TITLE, new NativeAdAsset[]{NativeAdAsset.TEXT, NativeAdAsset.CALL_TO_ACTION_TEXT, NativeAdAsset.MAIN_IMAGE, NativeAdAsset.ICON_IMAGE, NativeAdAsset.STAR_RATING})).build());
                return;
            case 1:
                MoPubInterstitial moPubInterstitial = new MoPubInterstitial((Activity) this.b.m17691a(), com_ushareit_listenit_ffl.c);
                moPubInterstitial.setInterstitialAdListener(new fgg(this, com_ushareit_listenit_ese, System.currentTimeMillis()));
                fie.m19267g(com_ushareit_listenit_ese.f11686c);
                moPubInterstitial.load();
                return;
            default:
                return;
        }
    }

    private boolean m19151b() {
        return cdd.m10887a().mo1287a(eys.m18562a()) == 0;
    }
}
