package com.ushareit.listenit;

import android.view.View;

public class tb {
    public static int m26249a(ss ssVar, ro roVar, View view, View view2, sh shVar, boolean z, boolean z2) {
        if (shVar.m323s() == 0 || ssVar.m26205e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (ssVar.m26205e() - Math.max(shVar.m288d(view), shVar.m288d(view2))) - 1) : Math.max(0, Math.min(shVar.m288d(view), shVar.m288d(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(roVar.mo3031b(view2) - roVar.mo3029a(view))) / ((float) (Math.abs(shVar.m288d(view) - shVar.m288d(view2)) + 1)))) + ((float) (roVar.mo3032c() - roVar.mo3029a(view))));
    }

    public static int m26248a(ss ssVar, ro roVar, View view, View view2, sh shVar, boolean z) {
        if (shVar.m323s() == 0 || ssVar.m26205e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(shVar.m288d(view) - shVar.m288d(view2)) + 1;
        }
        return Math.min(roVar.mo3037f(), roVar.mo3031b(view2) - roVar.mo3029a(view));
    }

    public static int m26250b(ss ssVar, ro roVar, View view, View view2, sh shVar, boolean z) {
        if (shVar.m323s() == 0 || ssVar.m26205e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return ssVar.m26205e();
        }
        return (int) ((((float) (roVar.mo3031b(view2) - roVar.mo3029a(view))) / ((float) (Math.abs(shVar.m288d(view) - shVar.m288d(view2)) + 1))) * ((float) ssVar.m26205e()));
    }
}
