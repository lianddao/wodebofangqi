package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;

class ejh implements ResultActions {
    final /* synthetic */ String f11128a;
    final /* synthetic */ Context f11129b;
    final /* synthetic */ ejg f11130c;

    ejh(ejg com_ushareit_listenit_ejg, String str, Context context) {
        this.f11130c = com_ushareit_listenit_ejg;
        this.f11128a = str;
        this.f11129b = context;
    }

    public void urlHandlingSucceeded(String str, UrlAction urlAction) {
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
            if (!TextUtils.isEmpty(this.f11128a)) {
                bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, this.f11128a);
            }
            try {
                Intents.startActivity(this.f11129b, Intents.getStartActivityIntent(this.f11129b, MoPubBrowser.class, bundle));
            } catch (IntentNotResolvableException e) {
                MoPubLog.m2753d(e.getMessage());
            }
        }
    }

    public void urlHandlingFailed(String str, UrlAction urlAction) {
    }
}
