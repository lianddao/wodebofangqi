package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.ads.internal.view.p000a.C0019a;

public final class avb implements OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setBackgroundColor(C0019a.f637d);
                break;
            case 1:
                view.setBackgroundColor(0);
                break;
        }
        return false;
    }
}
