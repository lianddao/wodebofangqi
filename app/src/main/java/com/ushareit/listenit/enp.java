package com.ushareit.listenit;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;

public final class enp implements OnClickListener {
    final /* synthetic */ Context f11320a;
    final /* synthetic */ String f11321b;

    public enp(Context context, String str) {
        this.f11320a = context;
        this.f11321b = str;
    }

    public void onClick(View view) {
        new Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).build().handleUrl(this.f11320a, this.f11321b);
    }
}
