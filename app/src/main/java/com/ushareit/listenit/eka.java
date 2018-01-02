package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.mobileads.VastVideoViewController;

public class eka implements OnTouchListener {
    final /* synthetic */ VastVideoViewController f11167a;

    public eka(VastVideoViewController vastVideoViewController) {
        this.f11167a = vastVideoViewController;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int c;
        if (this.f11167a.f2510x) {
            c = this.f11167a.f2485C;
        } else {
            c = this.f11167a.m3005j();
        }
        if (motionEvent.getAction() == 1) {
            this.f11167a.f2486D = true;
            this.f11167a.f2487a.handleClose(this.f11167a.m2848h(), c);
            this.f11167a.m2847g().onFinish();
        }
        return true;
    }
}
