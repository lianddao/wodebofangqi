package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.MoPubBrowser;

public class egw implements OnClickListener {
    final /* synthetic */ MoPubBrowser f11055a;

    public egw(MoPubBrowser moPubBrowser) {
        this.f11055a = moPubBrowser;
    }

    public void onClick(View view) {
        if (this.f11055a.f2131a.canGoBack()) {
            this.f11055a.f2131a.goBack();
        }
    }
}
