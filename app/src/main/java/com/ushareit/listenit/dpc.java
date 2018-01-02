package com.ushareit.listenit;

import android.os.Binder;

public abstract class dpc<T> {
    private static final Object f10125c = new Object();
    private static dph f10126d = null;
    private static int f10127e = 0;
    private static String f10128f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String f10129a;
    protected final T f10130b;
    private T f10131g = null;

    protected dpc(String str, T t) {
        this.f10129a = str;
        this.f10130b = t;
    }

    public static dpc<Integer> m15217a(String str, Integer num) {
        return new dpf(str, num);
    }

    public static dpc<Long> m15218a(String str, Long l) {
        return new dpe(str, l);
    }

    public static dpc<String> m15219a(String str, String str2) {
        return new dpg(str, str2);
    }

    public static dpc<Boolean> m15220a(String str, boolean z) {
        return new dpd(str, Boolean.valueOf(z));
    }

    public final T m15222a() {
        T a;
        long clearCallingIdentity;
        try {
            a = mo2017a(this.f10129a);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            a = mo2017a(this.f10129a);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return a;
    }

    protected abstract T mo2017a(String str);
}
