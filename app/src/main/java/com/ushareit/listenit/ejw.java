package com.ushareit.listenit;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.mopub.mobileads.VastVideoViewController;

public class ejw implements OnGlobalLayoutListener {
    final /* synthetic */ Activity f11157a;
    final /* synthetic */ VastVideoViewController f11158b;

    public ejw(VastVideoViewController vastVideoViewController, Activity activity) {
        this.f11158b = vastVideoViewController;
        this.f11157a = activity;
    }

    public void onGlobalLayout() {
        this.f11158b.f2501o = this.f11158b.m2990a(this.f11157a);
        this.f11158b.f2503q.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
