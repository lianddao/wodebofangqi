package com.ushareit.listenit;

import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;

class egf implements ResultActions {
    final /* synthetic */ ege f11030a;

    egf(ege com_ushareit_listenit_ege) {
        this.f11030a = com_ushareit_listenit_ege;
    }

    public void urlHandlingSucceeded(String str, UrlAction urlAction) {
        if (urlAction.equals(UrlAction.OPEN_IN_APP_BROWSER)) {
            this.f11030a.f11029b.getWebView().loadUrl(str);
        } else {
            this.f11030a.f11029b.finish();
        }
    }

    public void urlHandlingFailed(String str, UrlAction urlAction) {
    }
}
