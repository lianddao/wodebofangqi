package com.ushareit.listenit;

public class hhq extends Thread {
    private volatile boolean f15470a = false;

    public hhq(Runnable runnable) {
        super(runnable);
    }

    public void m23865a() {
        this.f15470a = false;
    }

    public boolean isInterrupted() {
        return super.isInterrupted() || this.f15470a;
    }

    public void interrupt() {
        this.f15470a = true;
        super.interrupt();
    }
}
