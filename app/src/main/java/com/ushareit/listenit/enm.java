package com.ushareit.listenit;

import android.view.View;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.nativeads.NativeClickHandler;
import com.mopub.nativeads.SpinningProgressView;

public class enm implements ResultActions {
    final /* synthetic */ View f11313a;
    final /* synthetic */ SpinningProgressView f11314b;
    final /* synthetic */ NativeClickHandler f11315c;

    public enm(NativeClickHandler nativeClickHandler, View view, SpinningProgressView spinningProgressView) {
        this.f11315c = nativeClickHandler;
        this.f11313a = view;
        this.f11314b = spinningProgressView;
    }

    public void urlHandlingSucceeded(String str, UrlAction urlAction) {
        m17206a();
        this.f11315c.f2713c = false;
    }

    public void urlHandlingFailed(String str, UrlAction urlAction) {
        m17206a();
        this.f11315c.f2713c = false;
    }

    private void m17206a() {
        if (this.f11313a != null) {
            this.f11314b.m3283a();
        }
    }
}
