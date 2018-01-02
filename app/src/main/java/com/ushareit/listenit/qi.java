package com.ushareit.listenit;

import android.content.Context;
import android.view.View;

public class qi implements qm {
    public void mo3005a(qj qjVar, Context context, int i, float f, float f2, float f3) {
        qjVar.setBackgroundDrawable(new sy(i, f));
        View view = (View) qjVar;
        view.setClipToOutline(true);
        view.setElevation(f2);
        mo3007b(qjVar, f3);
    }

    public void mo3004a(qj qjVar, float f) {
        ((sy) qjVar.getBackground()).m26228a(f);
    }

    public void mo3003a() {
    }

    public void mo3007b(qj qjVar, float f) {
        ((sy) qjVar.getBackground()).m26229a(f, qjVar.getUseCompatPadding(), qjVar.getPreventCornerOverlap());
        mo3012f(qjVar);
    }

    public float mo3002a(qj qjVar) {
        return ((sy) qjVar.getBackground()).m26227a();
    }

    public float mo3006b(qj qjVar) {
        return mo3010d(qjVar) * 2.0f;
    }

    public float mo3008c(qj qjVar) {
        return mo3010d(qjVar) * 2.0f;
    }

    public float mo3010d(qj qjVar) {
        return ((sy) qjVar.getBackground()).m26230b();
    }

    public void mo3009c(qj qjVar, float f) {
        ((View) qjVar).setElevation(f);
    }

    public float mo3011e(qj qjVar) {
        return ((View) qjVar).getElevation();
    }

    public void mo3012f(qj qjVar) {
        if (qjVar.getUseCompatPadding()) {
            float a = mo3002a(qjVar);
            float d = mo3010d(qjVar);
            int ceil = (int) Math.ceil((double) sz.m26233b(a, d, qjVar.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) sz.m26231a(a, d, qjVar.getPreventCornerOverlap()));
            qjVar.setShadowPadding(ceil, ceil2, ceil, ceil2);
            return;
        }
        qjVar.setShadowPadding(0, 0, 0, 0);
    }

    public void mo3013g(qj qjVar) {
        mo3007b(qjVar, mo3002a(qjVar));
    }

    public void mo3014h(qj qjVar) {
        mo3007b(qjVar, mo3002a(qjVar));
    }
}
