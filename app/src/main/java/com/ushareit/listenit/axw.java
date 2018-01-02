package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.ads.internal.view.C0052n;
import com.facebook.ads.internal.view.p003d.p004b.C0043k;

public class axw implements OnTouchListener {
    final /* synthetic */ C0052n f5633a;
    final /* synthetic */ C0043k f5634b;

    public axw(C0043k c0043k, C0052n c0052n) {
        this.f5634b = c0043k;
        this.f5633a = c0052n;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            return true;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        if (this.f5633a.getState() == ayk.PREPARED) {
            this.f5633a.mo151d();
            return true;
        } else if (this.f5633a.getState() == ayk.IDLE) {
            this.f5633a.mo151d();
            return true;
        } else if (this.f5633a.getState() == ayk.PAUSED) {
            this.f5633a.mo151d();
            return true;
        } else if (this.f5633a.getState() == ayk.STARTED) {
            this.f5633a.m1111e();
            return true;
        } else if (this.f5633a.getState() != ayk.PLAYBACK_COMPLETED) {
            return false;
        } else {
            this.f5633a.mo151d();
            return true;
        }
    }
}
