package com.ushareit.listenit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.view.p000a.C0023d;

public class avg extends WebViewClient {
    final /* synthetic */ C0023d f5564a;

    public avg(C0023d c0023d) {
        this.f5564a = c0023d;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f5564a.f654c != null) {
            this.f5564a.f654c.mo809c(str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.f5564a.f654c != null) {
            this.f5564a.f654c.mo807a(str);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        if (!C0023d.f653b.contains(parse.getScheme())) {
            try {
                this.f5564a.getContext().startActivity(new Intent("android.intent.action.VIEW", parse));
                return true;
            } catch (Throwable e) {
                Log.w(C0023d.f652a, "Activity not found to handle URI.", e);
            } catch (Throwable e2) {
                Log.e(C0023d.f652a, "Unknown exception occurred when trying to handle URI.", e2);
            }
        }
        return false;
    }
}
