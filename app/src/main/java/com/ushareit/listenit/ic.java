package com.ushareit.listenit;

import android.view.MotionEvent;

class ic {
    public static int m24082a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m24083b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m24084c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m24085d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static int m24081a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
