package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

public abstract class erl {
    private static final WeakHashMap<View, erl> f11603a = new WeakHashMap(0);

    public abstract erl mo2271a(float f);

    public abstract erl mo2272a(long j);

    public abstract erl mo2273a(Interpolator interpolator);

    public abstract erl mo2274a(epl com_ushareit_listenit_epl);

    public abstract erl mo2275b(float f);

    public abstract erl mo2276c(float f);

    public abstract erl mo2277d(float f);

    public abstract erl mo2278e(float f);

    public static erl m17583a(View view) {
        erl com_ushareit_listenit_erl = (erl) f11603a.get(view);
        if (com_ushareit_listenit_erl == null) {
            int intValue = Integer.valueOf(VERSION.SDK).intValue();
            if (intValue >= 14) {
                com_ushareit_listenit_erl = new err(view);
            } else if (intValue >= 11) {
                com_ushareit_listenit_erl = new erm(view);
            } else {
                com_ushareit_listenit_erl = new ert(view);
            }
            f11603a.put(view, com_ushareit_listenit_erl);
        }
        return com_ushareit_listenit_erl;
    }
}
