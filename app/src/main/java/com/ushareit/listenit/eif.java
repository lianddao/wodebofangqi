package com.ushareit.listenit;

import android.view.View;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubView;

public class eif implements Runnable {
    final /* synthetic */ View f11078a;
    final /* synthetic */ AdViewController f11079b;

    public eif(AdViewController adViewController, View view) {
        this.f11079b = adViewController;
        this.f11078a = view;
    }

    public void run() {
        MoPubView moPubView = this.f11079b.getMoPubView();
        if (moPubView != null) {
            moPubView.removeAllViews();
            moPubView.addView(this.f11078a, this.f11079b.m2798c(this.f11078a));
        }
    }
}
