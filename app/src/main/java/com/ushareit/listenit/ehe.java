package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;

public enum ehe extends UrlAction {
    public ehe(String str, int i, boolean z) {
        super(str, i, z);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return "mopubnativebrowser".equalsIgnoreCase(uri.getScheme());
    }

    protected void mo2161a(Context context, Uri uri, UrlHandler urlHandler, String str) {
        String str2 = "Unable to load mopub native browser url: " + uri;
        try {
            Intents.launchIntentForUserClick(context, Intents.intentForNativeBrowserScheme(uri), str2);
        } catch (UrlParseException e) {
            throw new IntentNotResolvableException(str2 + "\n\t" + e.getMessage());
        }
    }
}
