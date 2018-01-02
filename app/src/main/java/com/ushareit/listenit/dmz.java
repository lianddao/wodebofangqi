package com.ushareit.listenit;

abstract class dmz implements Runnable {
    final /* synthetic */ dmp f9960b;

    private dmz(dmp com_ushareit_listenit_dmp) {
        this.f9960b = com_ushareit_listenit_dmp;
    }

    protected abstract void mo1990a();

    public void run() {
        this.f9960b.f9936b.lock();
        try {
            if (!Thread.interrupted()) {
                mo1990a();
                this.f9960b.f9936b.unlock();
            }
        } catch (RuntimeException e) {
            this.f9960b.f9935a.m15051a(e);
        } finally {
            this.f9960b.f9936b.unlock();
        }
    }
}
