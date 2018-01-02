package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.ads.internal.view.C0052n;

public class azo implements OnTouchListener {
    final /* synthetic */ C0052n f5737a;

    public azo(C0052n c0052n) {
        this.f5737a = c0052n;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f5737a.f827a.m6616a(new awi(view, motionEvent));
        return true;
    }
}
