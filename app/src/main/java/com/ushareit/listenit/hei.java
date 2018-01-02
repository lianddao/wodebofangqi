package com.ushareit.listenit;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class hei extends SimpleOnGestureListener {
    final /* synthetic */ heh f15277a;

    hei(heh com_ushareit_listenit_heh) {
        this.f15277a = com_ushareit_listenit_heh;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f15277a.f15255d && this.f15277a.f15256e) {
            int width = this.f15277a.f15274w.getWidth() / 5;
            if (f > this.f15277a.f15269r) {
                if (this.f15277a.f15275x > (-width)) {
                    this.f15277a.f15274w.m27092a(true, f);
                }
            } else if (f < (-this.f15277a.f15269r) && this.f15277a.f15275x < width) {
                this.f15277a.f15274w.m27092a(true, f);
            }
            this.f15277a.f15256e = false;
        }
        return false;
    }
}
