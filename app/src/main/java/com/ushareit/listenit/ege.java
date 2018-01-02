package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Drawables;
import java.util.EnumSet;

public class ege extends WebViewClient {
    private static final EnumSet<UrlAction> f11028a = EnumSet.of(UrlAction.HANDLE_PHONE_SCHEME, new UrlAction[]{UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK});
    private MoPubBrowser f11029b;

    public ege(MoPubBrowser moPubBrowser) {
        this.f11029b = moPubBrowser;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        MoPubLog.m2753d("MoPubBrowser error: " + str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new Builder().withSupportedUrlActions(f11028a).withoutMoPubBrowser().withResultActions(new egf(this)).build().handleResolvedUrl(this.f11029b.getApplicationContext(), str, true, null);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f11029b.getForwardButton().setImageDrawable(Drawables.UNRIGHT_ARROW.createDrawable(this.f11029b));
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f11029b.getBackButton().setImageDrawable(webView.canGoBack() ? Drawables.LEFT_ARROW.createDrawable(this.f11029b) : Drawables.UNLEFT_ARROW.createDrawable(this.f11029b));
        this.f11029b.getForwardButton().setImageDrawable(webView.canGoForward() ? Drawables.RIGHT_ARROW.createDrawable(this.f11029b) : Drawables.UNRIGHT_ARROW.createDrawable(this.f11029b));
    }
}
