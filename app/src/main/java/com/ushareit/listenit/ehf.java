package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.util.Intents;

public enum ehf extends UrlAction {
    public ehf(String str, int i, boolean z) {
        super(str, i, z);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        String scheme = uri.getScheme();
        String host = uri.getHost();
        return "play.google.com".equalsIgnoreCase(host) || "market.android.com".equalsIgnoreCase(host) || "market".equalsIgnoreCase(scheme) || uri.toString().toLowerCase().startsWith("play.google.com/") || uri.toString().toLowerCase().startsWith("market.android.com/");
    }

    protected void mo2161a(Context context, Uri uri, UrlHandler urlHandler, String str) {
        Intents.launchApplicationUrl(context, uri);
    }
}
