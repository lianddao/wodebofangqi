package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.mobileads.VastWebView;

public class ekf implements OnTouchListener {
    final /* synthetic */ VastWebView f11176a;
    private boolean f11177b;

    public ekf(VastWebView vastWebView) {
        this.f11176a = vastWebView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f11177b = true;
                break;
            case 1:
                if (this.f11177b) {
                    this.f11177b = false;
                    if (this.f11176a.f2516b != null) {
                        this.f11176a.f2516b.onVastWebViewClick();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
