package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;

public abstract class etd {
    private boolean f11770a;
    private boolean f11771b;

    public abstract void mo2287a(Context context, String str);

    public abstract void mo2288a(Context context, String str, String str2);

    public abstract void mo2289a(Context context, String str, HashMap<String, String> hashMap);

    public abstract void mo2290a(Context context, Throwable th);

    public abstract void mo2292c();

    public abstract void mo2294d(Context context);

    public abstract void mo2295e(Context context);

    public etd(boolean z, boolean z2) {
        this.f11770a = z;
        this.f11771b = z2;
    }

    public boolean m17850a() {
        return this.f11770a;
    }

    public boolean m17852b() {
        return this.f11771b;
    }

    public void mo2384a(Context context) {
    }

    public void mo2291b(Context context) {
    }

    public boolean mo2293c(Context context) {
        return false;
    }
}
