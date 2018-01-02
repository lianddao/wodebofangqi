package com.ushareit.listenit;

import android.os.Handler;

public abstract class gbi extends Handler implements Runnable {
    private boolean f13842a = false;
    private long f13843b = Long.MIN_VALUE;
    private long f13844c = this.f13843b;
    private long f13845d = this.f13843b;
    private long f13846e = this.f13843b;

    public void m21576a(long j) {
        this.f13844c = j;
        this.f13846e = this.f13844c;
        this.f13845d = System.currentTimeMillis();
        m21574b(j);
    }

    public void m21575a() {
        m21573b();
        this.f13844c = this.f13843b;
        this.f13845d = this.f13843b;
        this.f13846e = this.f13843b;
    }

    private void m21574b(long j) {
        if (!this.f13842a) {
            postDelayed(this, j);
            this.f13842a = true;
        }
    }

    private void m21573b() {
        removeCallbacks(this);
        this.f13842a = false;
    }
}
