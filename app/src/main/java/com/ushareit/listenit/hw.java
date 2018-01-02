package com.ushareit.listenit;

import android.view.MotionEvent;

class hw implements ib {
    hw() {
    }

    public int mo2800a(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        return -1;
    }

    public int mo2802b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float mo2803c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float mo2804d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public int mo2799a(MotionEvent motionEvent) {
        return 1;
    }

    public int mo2801b(MotionEvent motionEvent) {
        return 0;
    }

    public float mo2805e(MotionEvent motionEvent, int i) {
        return 0.0f;
    }
}
