package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mopub.common.util.Visibility;
import com.mopub.mobileads.MoPubView;

public class eiy extends BroadcastReceiver {
    final /* synthetic */ MoPubView f11107a;

    public eiy(MoPubView moPubView) {
        this.f11107a = moPubView;
    }

    public void onReceive(Context context, Intent intent) {
        if (Visibility.isScreenVisible(this.f11107a.f2379e) && intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                this.f11107a.setAdVisibility(0);
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.f11107a.setAdVisibility(8);
            }
        }
    }
}
