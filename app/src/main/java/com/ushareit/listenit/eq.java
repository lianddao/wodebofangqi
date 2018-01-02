package com.ushareit.listenit;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class eq {
    static final es f11482a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f11482a = new ey();
        } else if (i >= 21) {
            f11482a = new ex();
        } else if (i >= 19) {
            f11482a = new ew();
        } else if (i >= 17) {
            f11482a = new ev();
        } else if (i >= 11) {
            f11482a = new eu();
        } else if (i >= 5) {
            f11482a = new et();
        } else {
            f11482a = new er();
        }
    }

    public static boolean m17350a(Drawable drawable) {
        return f11482a.mo2269a(drawable);
    }

    public static boolean m17351a(Drawable drawable, int i) {
        return f11482a.mo2270a(drawable, i);
    }
}
