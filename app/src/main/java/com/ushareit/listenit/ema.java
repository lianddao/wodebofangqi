package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.mraid.MraidVideoViewController;

public class ema implements OnClickListener {
    final /* synthetic */ MraidVideoViewController f11241a;

    public ema(MraidVideoViewController mraidVideoViewController) {
        this.f11241a = mraidVideoViewController;
    }

    public void onClick(View view) {
        this.f11241a.m2847g().onFinish();
    }
}
