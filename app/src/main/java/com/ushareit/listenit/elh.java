package com.ushareit.listenit;

import android.os.Handler;
import android.view.View;

public class elh {
    int f11207a;
    private final View[] f11208b;
    private final Handler f11209c;
    private Runnable f11210d;
    private final Runnable f11211e;

    private elh(Handler handler, View[] viewArr) {
        this.f11211e = new eli(this);
        this.f11209c = handler;
        this.f11208b = viewArr;
    }

    private void m17147b() {
        this.f11207a--;
        if (this.f11207a == 0 && this.f11210d != null) {
            this.f11210d.run();
            this.f11210d = null;
        }
    }

    public void m17150a(Runnable runnable) {
        this.f11210d = runnable;
        this.f11207a = this.f11208b.length;
        this.f11209c.post(this.f11211e);
    }

    void m17149a() {
        this.f11209c.removeCallbacks(this.f11211e);
        this.f11210d = null;
    }
}
