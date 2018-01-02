package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;

public abstract class fl {
    private final fl f12887a;

    public abstract Uri mo2483a();

    public abstract fl mo2484a(String str);

    public abstract fl mo2485a(String str, String str2);

    public abstract String mo2486b();

    public abstract boolean mo2487c(String str);

    public abstract long mo2488d();

    public abstract boolean mo2489e();

    public abstract boolean mo2490f();

    public abstract boolean mo2491g();

    public abstract boolean mo2492h();

    public abstract fl[] mo2493i();

    fl(fl flVar) {
        this.f12887a = flVar;
    }

    public static fl m19695a(Context context, Uri uri) {
        if (VERSION.SDK_INT >= 19) {
            return new fo(null, context, uri);
        }
        return null;
    }

    public static fl m19696b(Context context, Uri uri) {
        if (VERSION.SDK_INT >= 21) {
            return new fp(null, context, fn.m19958a(uri));
        }
        return null;
    }

    public static boolean m19697c(Context context, Uri uri) {
        if (VERSION.SDK_INT >= 19) {
            return fm.m19857a(context, uri);
        }
        return false;
    }

    public fl m19703c() {
        return this.f12887a;
    }

    public fl m19701b(String str) {
        for (fl flVar : mo2493i()) {
            if (str.equals(flVar.mo2486b())) {
                return flVar;
            }
        }
        return null;
    }
}
