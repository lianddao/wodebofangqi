package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.Constants;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.util.Intents;

public enum ehg extends UrlAction {
    public ehg(String str, int i, boolean z) {
        super(str, i, z);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        String scheme = uri.getScheme();
        return Constants.HTTP.equalsIgnoreCase(scheme) || Constants.HTTPS.equalsIgnoreCase(scheme);
    }

    protected void mo2161a(Context context, Uri uri, UrlHandler urlHandler, String str) {
        if (!urlHandler.m2708b()) {
            Intents.showMoPubBrowserForUrl(context, uri, str);
        }
    }
}
