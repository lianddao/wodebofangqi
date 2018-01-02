package com.ushareit.listenit;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.mobileads.VastCompanionAdConfig;

public class eje implements ResultActions {
    final /* synthetic */ String f11114a;
    final /* synthetic */ Context f11115b;
    final /* synthetic */ int f11116c;
    final /* synthetic */ VastCompanionAdConfig f11117d;

    public eje(VastCompanionAdConfig vastCompanionAdConfig, String str, Context context, int i) {
        this.f11117d = vastCompanionAdConfig;
        this.f11114a = str;
        this.f11115b = context;
        this.f11116c = i;
    }

    public void urlHandlingSucceeded(String str, UrlAction urlAction) {
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
            if (!TextUtils.isEmpty(this.f11114a)) {
                bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, this.f11114a);
            }
            Class cls = MoPubBrowser.class;
            try {
                ((Activity) this.f11115b).startActivityForResult(Intents.getStartActivityIntent(this.f11115b, cls, bundle), this.f11116c);
            } catch (ActivityNotFoundException e) {
                MoPubLog.m2753d("Activity " + cls.getName() + " not found. Did you " + "declare it in your AndroidManifest.xml?");
            }
        }
    }

    public void urlHandlingFailed(String str, UrlAction urlAction) {
    }
}
