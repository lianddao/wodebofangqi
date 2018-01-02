package com.ushareit.listenit;

public final class bsj {
    private boolean f7607a;

    public synchronized boolean m9668a() {
        boolean z = true;
        synchronized (this) {
            if (this.f7607a) {
                z = false;
            } else {
                this.f7607a = true;
                notifyAll();
            }
        }
        return z;
    }

    public synchronized boolean m9669b() {
        boolean z;
        z = this.f7607a;
        this.f7607a = false;
        return z;
    }

    public synchronized void m9670c() {
        while (!this.f7607a) {
            wait();
        }
    }
}
