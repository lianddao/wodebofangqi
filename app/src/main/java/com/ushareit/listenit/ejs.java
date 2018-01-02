package com.ushareit.listenit;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.mobileads.VastVideoConfig;

public class ejs implements ResultActions {
    final /* synthetic */ Context f11148a;
    final /* synthetic */ Integer f11149b;
    final /* synthetic */ VastVideoConfig f11150c;

    public ejs(VastVideoConfig vastVideoConfig, Context context, Integer num) {
        this.f11150c = vastVideoConfig;
        this.f11148a = context;
        this.f11149b = num;
    }

    public void urlHandlingSucceeded(String str, UrlAction urlAction) {
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
            bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, this.f11150c.f2458y);
            Class cls = MoPubBrowser.class;
            Intent startActivityIntent = Intents.getStartActivityIntent(this.f11148a, cls, bundle);
            try {
                if (this.f11148a instanceof Activity) {
                    Preconditions.checkNotNull(this.f11149b);
                    ((Activity) this.f11148a).startActivityForResult(startActivityIntent, this.f11149b.intValue());
                    return;
                }
                Intents.startActivity(this.f11148a, startActivityIntent);
            } catch (ActivityNotFoundException e) {
                MoPubLog.m2753d("Activity " + cls.getName() + " not found. Did you " + "declare it in your AndroidManifest.xml?");
            } catch (IntentNotResolvableException e2) {
                MoPubLog.m2753d("Activity " + cls.getName() + " not found. Did you " + "declare it in your AndroidManifest.xml?");
            }
        }
    }

    public void urlHandlingFailed(String str, UrlAction urlAction) {
    }
}
