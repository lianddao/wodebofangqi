package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.Constants;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import java.net.URISyntaxException;

public enum ehj extends UrlAction {
    public ehj(String str, int i, boolean z) {
        super(str, i, z);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return !TextUtils.isEmpty(uri.getScheme());
    }

    protected void mo2161a(Context context, Uri uri, UrlHandler urlHandler, String str) {
        if (Constants.INTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
            try {
                Intents.launchApplicationIntent(context, Intent.parseUri(uri.toString(), 1));
                return;
            } catch (URISyntaxException e) {
                throw new IntentNotResolvableException("Intent uri had invalid syntax: " + uri.toString());
            }
        }
        Intents.launchApplicationUrl(context, uri);
    }
}
