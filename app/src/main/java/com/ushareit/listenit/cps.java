package com.ushareit.listenit;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class cps {
    private final ScheduledExecutorService f8657a;
    private final cvy f8658b;
    private final long f8659c;
    private final long f8660d;
    private final double f8661e;
    private final double f8662f;
    private final Random f8663g;
    private ScheduledFuture<?> f8664h;
    private long f8665i;
    private boolean f8666j;

    private cps(ScheduledExecutorService scheduledExecutorService, cvy com_ushareit_listenit_cvy, long j, long j2, double d, double d2) {
        this.f8663g = new Random();
        this.f8666j = true;
        this.f8657a = scheduledExecutorService;
        this.f8658b = com_ushareit_listenit_cvy;
        this.f8659c = j;
        this.f8660d = j2;
        this.f8662f = d;
        this.f8661e = d2;
    }

    public void m12214a() {
        this.f8666j = true;
        this.f8665i = 0;
    }

    public void m12215a(Runnable runnable) {
        long j = 0;
        Runnable com_ushareit_listenit_cpt = new cpt(this, runnable);
        if (this.f8664h != null) {
            this.f8658b.m13093a("Cancelling previous scheduled retry", new Object[0]);
            this.f8664h.cancel(false);
            this.f8664h = null;
        }
        if (!this.f8666j) {
            if (this.f8665i == 0) {
                this.f8665i = this.f8659c;
            } else {
                this.f8665i = Math.min((long) (((double) this.f8665i) * this.f8662f), this.f8660d);
            }
            j = (long) (((1.0d - this.f8661e) * ((double) this.f8665i)) + ((this.f8661e * ((double) this.f8665i)) * this.f8663g.nextDouble()));
        }
        this.f8666j = false;
        this.f8658b.m13093a("Scheduling retry in %dms", Long.valueOf(j));
        this.f8664h = this.f8657a.schedule(com_ushareit_listenit_cpt, j, TimeUnit.MILLISECONDS);
    }

    public void m12216b() {
        this.f8665i = this.f8660d;
    }

    public void m12217c() {
        if (this.f8664h != null) {
            this.f8658b.m13093a("Cancelling existing retry attempt", new Object[0]);
            this.f8664h.cancel(false);
            this.f8664h = null;
        } else {
            this.f8658b.m13093a("No existing retry attempt to cancel", new Object[0]);
        }
        this.f8665i = 0;
    }
}
