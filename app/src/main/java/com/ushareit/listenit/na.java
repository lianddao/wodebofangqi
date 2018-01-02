package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class na {
    private static final nb f15979a;
    private final Object f15980b;

    static {
        if (VERSION.SDK_INT >= 19) {
            f15979a = new ne();
        } else if (VERSION.SDK_INT >= 16) {
            f15979a = new nc();
        } else {
            f15979a = new ng();
        }
    }

    public na() {
        this.f15980b = f15979a.mo2943a(this);
    }

    public na(Object obj) {
        this.f15980b = obj;
    }

    public Object m25146a() {
        return this.f15980b;
    }

    public mh m25145a(int i) {
        return null;
    }

    public boolean m25148a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<mh> m25147a(String str, int i) {
        return null;
    }

    public mh m25149b(int i) {
        return null;
    }
}
