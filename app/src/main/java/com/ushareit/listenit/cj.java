package com.ushareit.listenit;

import android.app.Notification;
import android.os.Bundle;

class cj implements cf {
    cj() {
    }

    public Notification mo1308a(ca caVar, cb cbVar) {
        Notification a = cw.m13097a(caVar.f7980F, caVar.f7982a, caVar.f7983b, caVar.f7984c, caVar.f7985d);
        if (caVar.f7991j > 0) {
            a.flags |= 128;
        }
        if (caVar.f7977C != null) {
            a.contentView = caVar.f7977C;
        }
        return a;
    }

    public Bundle mo1309a(Notification notification) {
        return null;
    }
}
