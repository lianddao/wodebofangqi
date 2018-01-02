package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.MoPubBrowser;

public class egx implements OnClickListener {
    final /* synthetic */ MoPubBrowser f11056a;

    public egx(MoPubBrowser moPubBrowser) {
        this.f11056a = moPubBrowser;
    }

    public void onClick(View view) {
        if (this.f11056a.f2131a.canGoForward()) {
            this.f11056a.f2131a.goForward();
        }
    }
}
