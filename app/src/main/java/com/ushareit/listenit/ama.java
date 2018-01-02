package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ama implements OnTouchListener {
    final /* synthetic */ aly f4763a;

    ama(aly com_ushareit_listenit_aly) {
        this.f4763a = com_ushareit_listenit_aly;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f4763a.f4746v == null) {
                this.f4763a.f4734j.finish();
            } else if (this.f4763a.f4746v.m1031a()) {
                if (!(this.f4763a.f4746v.getSkipSeconds() == 0 || this.f4763a.a == null)) {
                    this.f4763a.a.m1112f();
                }
                if (this.f4763a.a != null) {
                    this.f4763a.a.m1113g();
                }
                this.f4763a.f4734j.finish();
            }
        }
        return true;
    }
}
