package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

public class akt extends ako {
    private static final String f4614a = akt.class.getSimpleName();
    private final Context f4615b;
    private final String f4616c;
    private final Uri f4617d;

    public akt(Context context, String str, Uri uri) {
        this.f4615b = context;
        this.f4616c = str;
        this.f4617d = uri;
    }

    public atr mo666a() {
        return atr.OPEN_LINK;
    }

    public void mo667b() {
        try {
            Log.w("REDIRECTACTION: ", this.f4617d.toString());
            atz.m7168a(this.f4615b, this.f4617d, this.f4616c);
        } catch (Throwable e) {
            Log.d(f4614a, "Failed to open link url: " + this.f4617d.toString(), e);
        }
    }
}
