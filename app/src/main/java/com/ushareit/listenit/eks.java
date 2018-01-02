package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.mobileads.ViewGestureDetector;
import com.mopub.mraid.MraidBridge;

public class eks implements OnTouchListener {
    final /* synthetic */ ViewGestureDetector f11184a;
    final /* synthetic */ MraidBridge f11185b;

    public eks(MraidBridge mraidBridge, ViewGestureDetector viewGestureDetector) {
        this.f11185b = mraidBridge;
        this.f11184a = viewGestureDetector;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f11184a.sendTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (!view.hasFocus()) {
                    view.requestFocus();
                    break;
                }
                break;
        }
        return false;
    }
}
