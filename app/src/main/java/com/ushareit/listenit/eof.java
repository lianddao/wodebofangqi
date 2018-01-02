package com.ushareit.listenit;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;

public class eof {
    private final Rect f11372a = new Rect();

    boolean m17257a(long j, int i) {
        return SystemClock.uptimeMillis() - j >= ((long) i);
    }

    boolean m17258a(View view, View view2, int i) {
        if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || !view2.getGlobalVisibleRect(this.f11372a)) {
            return false;
        }
        long height = ((long) this.f11372a.height()) * ((long) this.f11372a.width());
        long height2 = ((long) view2.getHeight()) * ((long) view2.getWidth());
        if (height2 <= 0 || height * 100 < height2 * ((long) i)) {
            return false;
        }
        return true;
    }
}
