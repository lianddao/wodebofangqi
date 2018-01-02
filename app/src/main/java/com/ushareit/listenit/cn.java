package com.ushareit.listenit;

import android.app.Notification;
import android.os.Bundle;

class cn extends cj {
    cn() {
    }

    public Notification mo1308a(ca caVar, cb cbVar) {
        bu deVar = new de(caVar.f7982a, caVar.f7980F, caVar.f7983b, caVar.f7984c, caVar.f7989h, caVar.f7987f, caVar.f7990i, caVar.f7985d, caVar.f7986e, caVar.f7988g, caVar.f7997p, caVar.f7998q, caVar.f7999r, caVar.f7993l, caVar.f7991j, caVar.f7995n, caVar.f8004w, caVar.f8006y, caVar.f8000s, caVar.f8001t, caVar.f8002u, caVar.f7977C, caVar.f7978D);
        bv.m9933b((bt) deVar, caVar.f8003v);
        bv.m9935c(deVar, caVar.f7994m);
        Notification a = cbVar.m10593a(caVar, deVar);
        if (caVar.f7994m != null) {
            caVar.f7994m.mo1286a(mo1309a(a));
        }
        return a;
    }

    public Bundle mo1309a(Notification notification) {
        return dd.m13823a(notification);
    }
}
