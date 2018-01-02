package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.ads.internal.view.p003d.p005c.C0048b;

public class ayh implements OnTouchListener {
    final /* synthetic */ C0048b f5645a;

    public ayh(C0048b c0048b) {
        this.f5645a = c0048b;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!(this.f5645a.f787r || this.f5645a.f775e == null || motionEvent.getAction() != 1)) {
            if (this.f5645a.f775e.isShowing()) {
                this.f5645a.f775e.hide();
            } else {
                this.f5645a.f775e.show();
            }
        }
        return true;
    }
}
