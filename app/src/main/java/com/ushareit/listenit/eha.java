package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.UrlHandler.MoPubSchemeListener;
import com.mopub.exceptions.IntentNotResolvableException;

public enum eha extends UrlAction {
    public eha(String str, int i, boolean z) {
        super(str, i, z);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return "mopub".equalsIgnoreCase(uri.getScheme());
    }

    protected void mo2161a(Context context, Uri uri, UrlHandler urlHandler, String str) {
        String host = uri.getHost();
        MoPubSchemeListener a = urlHandler.m2707a();
        if ("finishLoad".equalsIgnoreCase(host)) {
            a.onFinishLoad();
        } else if ("close".equalsIgnoreCase(host)) {
            a.onClose();
        } else if ("failLoad".equalsIgnoreCase(host)) {
            a.onFailLoad();
        } else {
            throw new IntentNotResolvableException("Could not handle MoPub Scheme url: " + uri);
        }
    }
}
