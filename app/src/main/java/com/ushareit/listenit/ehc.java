package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;

public enum ehc extends UrlAction {
    public ehc(String str, int i, boolean z) {
        super(str, i, z);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return "about".equalsIgnoreCase(uri.getScheme());
    }

    protected void mo2161a(Context context, Uri uri, UrlHandler urlHandler, String str) {
        MoPubLog.m2753d("Link to about page ignored.");
    }
}
