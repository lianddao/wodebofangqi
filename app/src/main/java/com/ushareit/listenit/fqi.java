package com.ushareit.listenit;

import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.ushareit.listenit.cutter.view.WaveformView;

public class fqi extends SimpleOnScaleGestureListener {
    final /* synthetic */ WaveformView f13232a;

    public fqi(WaveformView waveformView) {
        this.f13232a = waveformView;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        Log.v("cutter", "ScaleBegin " + this.f13232a.m12919a(scaleGestureDetector));
        this.f13232a.f9154x = Math.abs(this.f13232a.m12919a(scaleGestureDetector));
        return true;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float abs = Math.abs(this.f13232a.m12919a(scaleGestureDetector));
        Log.v("cutter", "Scale " + (abs - this.f13232a.f9154x));
        if (abs - this.f13232a.f9154x > 40.0f) {
            this.f13232a.f9155y.mo2534b();
            this.f13232a.f9154x = abs;
        }
        if (abs - this.f13232a.f9154x < -40.0f) {
            this.f13232a.f9155y.mo2536c();
            this.f13232a.f9154x = abs;
        }
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        Log.v("cutter", "ScaleEnd " + this.f13232a.m12919a(scaleGestureDetector));
    }
}
