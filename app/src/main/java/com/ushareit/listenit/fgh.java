package com.ushareit.listenit;

import android.view.View;
import com.mopub.nativeads.NativeAd.MoPubNativeEventListener;

class fgh implements MoPubNativeEventListener {
    final /* synthetic */ fgf f12661a;
    private ffl f12662b;
    private long f12663c;

    public fgh(fgf com_ushareit_listenit_fgf, ffl com_ushareit_listenit_ffl) {
        this.f12661a = com_ushareit_listenit_fgf;
        this.f12662b = com_ushareit_listenit_ffl;
    }

    public void onImpression(View view) {
        this.f12663c = System.currentTimeMillis();
        fie.m19247c(this.f12662b);
    }

    public void onClick(View view) {
        fie.m19259e(this.f12662b, System.currentTimeMillis() - this.f12663c);
    }
}
