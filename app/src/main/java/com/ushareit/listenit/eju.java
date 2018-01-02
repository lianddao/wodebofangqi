package com.ushareit.listenit;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.VastCompanionAdConfig;
import com.mopub.mobileads.VastVideoViewController;

public class eju extends WebViewClient {
    final /* synthetic */ VastCompanionAdConfig f11153a;
    final /* synthetic */ Context f11154b;
    final /* synthetic */ VastVideoViewController f11155c;

    public eju(VastVideoViewController vastVideoViewController, VastCompanionAdConfig vastCompanionAdConfig, Context context) {
        this.f11155c = vastVideoViewController;
        this.f11153a = vastCompanionAdConfig;
        this.f11154b = context;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.f11153a.m2907a(this.f11154b, 1, str, this.f11155c.f2487a.getDspCreativeId());
        return true;
    }
}
