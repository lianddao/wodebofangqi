package com.ushareit.listenit;

import java.util.concurrent.Future;

class fav extends fau {
    private int f12351a = 100;

    public fav(int i, int i2) {
        super(i);
        this.f12351a = i2;
    }

    public Future<?> mo2346a(Runnable runnable, long j, int i, String str) {
        if (getQueue().size() > this.f12351a) {
            try {
                getQueue().take();
            } catch (InterruptedException e) {
                exw.m18456d("TaskHelper", e.toString());
            }
        }
        return super.mo2346a(runnable, j, i, str);
    }
}
