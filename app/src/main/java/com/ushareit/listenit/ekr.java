package com.ushareit.listenit;

import com.mopub.mobileads.ViewGestureDetector.UserClickListener;
import com.mopub.mraid.MraidBridge;

public class ekr implements UserClickListener {
    final /* synthetic */ MraidBridge f11183a;

    public ekr(MraidBridge mraidBridge) {
        this.f11183a = mraidBridge;
    }

    public void onUserClick() {
        this.f11183a.f2570g = true;
    }

    public void onResetUserClick() {
        this.f11183a.f2570g = false;
    }

    public boolean wasClicked() {
        return this.f11183a.f2570g;
    }
}
