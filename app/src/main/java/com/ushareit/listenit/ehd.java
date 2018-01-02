package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.util.Intents;

public enum ehd extends UrlAction {
    public ehd(String str, int i, boolean z) {
        super(str, i, z);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        String scheme = uri.getScheme();
        return "tel".equalsIgnoreCase(scheme) || "voicemail".equalsIgnoreCase(scheme) || "sms".equalsIgnoreCase(scheme) || "mailto".equalsIgnoreCase(scheme) || "geo".equalsIgnoreCase(scheme) || "google.streetview".equalsIgnoreCase(scheme);
    }

    protected void mo2161a(Context context, Uri uri, UrlHandler urlHandler, String str) {
        Intents.launchActionViewIntent(context, uri, "Could not handle intent with URI: " + uri + "\n\tIs " + "this intent supported on your phone?");
    }
}
