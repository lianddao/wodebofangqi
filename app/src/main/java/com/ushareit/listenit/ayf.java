package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.ads.internal.view.p003d.p005c.C0047a;

public class ayf implements OnTouchListener {
    final /* synthetic */ C0047a f5643a;

    public ayf(C0047a c0047a) {
        this.f5643a = c0047a;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f5643a.f757h != null && motionEvent.getAction() == 1) {
            if (this.f5643a.f757h.isShowing()) {
                this.f5643a.f757h.hide();
            } else {
                this.f5643a.f757h.show();
            }
        }
        return true;
    }
}
