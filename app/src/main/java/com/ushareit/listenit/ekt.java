package com.ushareit.listenit;

import com.mopub.mraid.MraidBridge;
import com.mopub.mraid.MraidBridge.MraidWebView.OnVisibilityChangedListener;

public class ekt implements OnVisibilityChangedListener {
    final /* synthetic */ MraidBridge f11186a;

    public ekt(MraidBridge mraidBridge) {
        this.f11186a = mraidBridge;
    }

    public void onVisibilityChanged(boolean z) {
        if (this.f11186a.f2568e != null) {
            this.f11186a.f2568e.onVisibilityChanged(z);
        }
    }
}
