package com.ushareit.listenit;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.common.IntentActions;
import com.mopub.mobileads.VastVideoViewController;

public class ejt implements OnTouchListener {
    final /* synthetic */ Activity f11151a;
    final /* synthetic */ VastVideoViewController f11152b;

    public ejt(VastVideoViewController vastVideoViewController, Activity activity) {
        this.f11152b = vastVideoViewController;
        this.f11151a = activity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.f11152b.m2984q()) {
            this.f11152b.f2486D = true;
            this.f11152b.m2839a(IntentActions.ACTION_INTERSTITIAL_CLICK);
            this.f11152b.f2487a.handleClickForResult(this.f11151a, this.f11152b.f2510x ? this.f11152b.f2485C : this.f11152b.m3005j(), 1);
        }
        return true;
    }
}
