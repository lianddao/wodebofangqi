package com.ushareit.listenit;

import android.content.Context;

public class bvn {
    private static bvn f7862a;
    private static final Object f7863b = new Object();
    private bya f7864c;

    private bvn() {
    }

    public static bvn m10055a() {
        bvn com_ushareit_listenit_bvn;
        synchronized (f7863b) {
            if (f7862a == null) {
                f7862a = new bvn();
            }
            com_ushareit_listenit_bvn = f7862a;
        }
        return com_ushareit_listenit_bvn;
    }

    public void m10056a(Context context, String str, bvo com_ushareit_listenit_bvo) {
        synchronized (f7863b) {
            if (this.f7864c != null) {
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            } else {
                try {
                    this.f7864c = bwt.m10270b().m10226a(context);
                    this.f7864c.mo1155a();
                    if (str != null) {
                        this.f7864c.mo1158a(str);
                    }
                } catch (Throwable e) {
                    bze.m10491c("Fail to initialize or set applicationCode on mobile ads setting manager", e);
                }
            }
        }
    }
}
