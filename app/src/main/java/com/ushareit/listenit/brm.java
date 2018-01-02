package com.ushareit.listenit;

import android.os.Handler;
import android.os.SystemClock;

public final class brm implements brd, bsf<Object> {
    private final Handler f7519a;
    private final bre f7520b;
    private final bsw f7521c;
    private int f7522d;
    private long f7523e;
    private long f7524f;
    private long f7525g;
    private long f7526h;
    private long f7527i;

    public brm() {
        this(null, null);
    }

    public brm(Handler handler, bre com_ushareit_listenit_bre) {
        this(handler, com_ushareit_listenit_bre, 2000);
    }

    public brm(Handler handler, bre com_ushareit_listenit_bre, int i) {
        this.f7519a = handler;
        this.f7520b = com_ushareit_listenit_bre;
        this.f7521c = new bsw(i);
        this.f7527i = -1;
    }

    public synchronized long mo1095a() {
        return this.f7527i;
    }

    public synchronized void mo1098a(Object obj, brk com_ushareit_listenit_brk) {
        if (this.f7522d == 0) {
            this.f7523e = SystemClock.elapsedRealtime();
        }
        this.f7522d++;
    }

    public synchronized void mo1097a(Object obj, int i) {
        this.f7524f += (long) i;
    }

    public synchronized void mo1096a(Object obj) {
        bsg.m9658b(this.f7522d > 0);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = (int) (elapsedRealtime - this.f7523e);
        this.f7525g += (long) i;
        this.f7526h += this.f7524f;
        if (i > 0) {
            this.f7521c.m9746a((int) Math.sqrt((double) this.f7524f), (float) ((this.f7524f * 8000) / ((long) i)));
            if (this.f7525g >= 2000 || this.f7526h >= 524288) {
                float a = this.f7521c.m9745a(0.5f);
                this.f7527i = Float.isNaN(a) ? -1 : (long) a;
            }
        }
        m9595a(i, this.f7524f, this.f7527i);
        int i2 = this.f7522d - 1;
        this.f7522d = i2;
        if (i2 > 0) {
            this.f7523e = elapsedRealtime;
        }
        this.f7524f = 0;
    }

    private void m9595a(int i, long j, long j2) {
        if (this.f7519a != null && this.f7520b != null) {
            this.f7519a.post(new brn(this, i, j, j2));
        }
    }
}
