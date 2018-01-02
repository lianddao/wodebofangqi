package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class iv {
    static final iy f15598a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f15598a = new ix();
        } else {
            f15598a = new iw();
        }
    }

    public static float m24121a(VelocityTracker velocityTracker, int i) {
        return f15598a.mo2810a(velocityTracker, i);
    }

    public static float m24122b(VelocityTracker velocityTracker, int i) {
        return f15598a.mo2811b(velocityTracker, i);
    }
}
