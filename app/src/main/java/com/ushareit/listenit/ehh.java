package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;

public enum ehh extends UrlAction {
    public ehh(String str, int i, boolean z) {
        super(str, i, z);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        Preconditions.checkNotNull(uri);
        return "mopubshare".equalsIgnoreCase(uri.getScheme()) && "tweet".equalsIgnoreCase(uri.getHost());
    }

    protected void mo2161a(Context context, Uri uri, UrlHandler urlHandler, String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        String str2 = "Share via";
        String str3 = "Could not handle share tweet intent with URI " + uri;
        try {
            Intents.launchIntentForUserClick(context, Intent.createChooser(Intents.intentForShareTweet(uri), "Share via"), str3);
        } catch (UrlParseException e) {
            throw new IntentNotResolvableException(str3 + "\n\t" + e.getMessage());
        }
    }
}
