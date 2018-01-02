package com.ushareit.listenit;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.VastVideoViewController;

public class ekc extends WebViewClient {
    final /* synthetic */ ejg f11171a;
    final /* synthetic */ VastVideoViewController f11172b;

    public ekc(VastVideoViewController vastVideoViewController, ejg com_ushareit_listenit_ejg) {
        this.f11172b = vastVideoViewController;
        this.f11171a = com_ushareit_listenit_ejg;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.f11171a.m17107a(this.f11172b.m2848h(), str, this.f11172b.f2487a.getDspCreativeId());
        return true;
    }
}
