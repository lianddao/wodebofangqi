package com.ushareit.listenit;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.ushareit.listenit.cutter.view.WaveformView;

public class fqh extends SimpleOnGestureListener {
    final /* synthetic */ WaveformView f13231a;

    public fqh(WaveformView waveformView) {
        this.f13231a = waveformView;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f13231a.f9155y.mo2538d(f);
        return true;
    }
}
