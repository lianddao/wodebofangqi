package com.ushareit.listenit;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import com.ushareit.browser.BrowserActivity;

public class eum extends WebChromeClient {
    final /* synthetic */ BrowserActivity f11896a;
    private View f11897b;

    private eum(BrowserActivity browserActivity) {
        this.f11896a = browserActivity;
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        exw.m18449b("BrowserActivity", "onShowCustomView, requestedOrientation : " + i);
        onShowCustomView(view, customViewCallback);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        if (this.f11896a.f3942z != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        this.f11896a.f3942z = view;
        this.f11896a.f3934n.setVisibility(8);
        this.f11896a.f3917A.setVisibility(0);
        this.f11896a.f3917A.addView(view);
        this.f11896a.f3918B = customViewCallback;
    }

    public View getVideoLoadingProgressView() {
        if (this.f11897b == null) {
            this.f11897b = LayoutInflater.from(this.f11896a).inflate(C0349R.layout.browser_video_progress, null);
        }
        return this.f11897b;
    }

    public void onHideCustomView() {
        super.onHideCustomView();
        if (this.f11896a.f3942z != null) {
            this.f11896a.f3934n.setVisibility(0);
            this.f11896a.f3917A.setVisibility(8);
            this.f11896a.f3942z.setVisibility(8);
            this.f11896a.f3917A.removeView(this.f11896a.f3942z);
            this.f11896a.f3918B.onCustomViewHidden();
            this.f11896a.f3942z = null;
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (TextUtils.isEmpty(this.f11896a.f3940t)) {
            this.f11896a.f3921E.setText(str);
        }
    }

    public void onProgressChanged(WebView webView, int i) {
        this.f11896a.f3929M.setProgress(i);
        if (i == 100) {
            this.f11896a.f3929M.setVisibility(8);
        }
        super.onProgressChanged(webView, i);
    }
}
