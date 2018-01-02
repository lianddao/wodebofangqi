package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;

public enum ehb extends UrlAction {
    public ehb(String str, int i, boolean z) {
        super(str, i, z);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return false;
    }

    protected void mo2161a(Context context, Uri uri, UrlHandler urlHandler, String str) {
    }
}
