package com.ushareit.listenit;

import android.app.Notification;

class ck extends cj {
    ck() {
    }

    public Notification mo1308a(ca caVar, cb cbVar) {
        Notification a = cz.m13446a(caVar.f7980F, caVar.f7982a, caVar.f7983b, caVar.f7984c, caVar.f7985d, caVar.f7986e);
        if (caVar.f7991j > 0) {
            a.flags |= 128;
        }
        if (caVar.f7977C != null) {
            a.contentView = caVar.f7977C;
        }
        return a;
    }
}
