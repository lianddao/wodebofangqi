package com.ushareit.listenit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ezv {
    protected final int f12264a;
    protected final int f12265b;
    protected int f12266c;
    protected final BlockingQueue<ezu> f12267d = new LinkedBlockingQueue();
    protected final BlockingQueue<ezu> f12268e = new LinkedBlockingQueue();

    public ezv(int i, int i2) {
        this.f12264a = i;
        this.f12265b = i2;
    }

    public final ezu m18644a(int i) {
        if (this.f12268e.isEmpty() && this.f12266c < this.f12265b) {
            this.f12268e.add(ezu.m18643a(this.f12264a));
            this.f12266c++;
        }
        return (ezu) this.f12268e.poll((long) i, TimeUnit.MILLISECONDS);
    }

    public final void m18645a(ezu com_ushareit_listenit_ezu) {
        this.f12267d.add(com_ushareit_listenit_ezu);
    }

    public final ezu m18646b(int i) {
        return (ezu) this.f12267d.poll((long) i, TimeUnit.MILLISECONDS);
    }

    public final void m18647b(ezu com_ushareit_listenit_ezu) {
        this.f12268e.add(com_ushareit_listenit_ezu);
    }
}
