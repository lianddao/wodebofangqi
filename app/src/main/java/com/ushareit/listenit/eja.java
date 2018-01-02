package com.ushareit.listenit;

import android.view.View;
import com.mopub.common.IntentActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseBroadcastReceiver;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mraid.MraidController.MraidListener;

public class eja implements MraidListener {
    final /* synthetic */ MraidActivity f11110a;

    public eja(MraidActivity mraidActivity) {
        this.f11110a = mraidActivity;
    }

    public void onLoaded(View view) {
        this.f11110a.f2388b.loadJavascript(eik.WEB_VIEW_DID_APPEAR.m17083a());
    }

    public void onFailedToLoad() {
        MoPubLog.m2753d("MraidActivity failed to load. Finishing the activity");
        BaseBroadcastReceiver.m2823a(this.f11110a, this.f11110a.m2866a().longValue(), IntentActions.ACTION_INTERSTITIAL_FAIL);
        this.f11110a.finish();
    }

    public void onClose() {
        this.f11110a.f2388b.loadJavascript(eik.WEB_VIEW_DID_CLOSE.m17083a());
        this.f11110a.finish();
    }

    public void onExpand() {
    }

    public void onOpen() {
        BaseBroadcastReceiver.m2823a(this.f11110a, this.f11110a.m2866a().longValue(), IntentActions.ACTION_INTERSTITIAL_CLICK);
    }
}
