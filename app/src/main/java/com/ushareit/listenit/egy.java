package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.MoPubBrowser;

public class egy implements OnClickListener {
    final /* synthetic */ MoPubBrowser f11057a;

    public egy(MoPubBrowser moPubBrowser) {
        this.f11057a = moPubBrowser;
    }

    public void onClick(View view) {
        this.f11057a.f2131a.reload();
    }
}
