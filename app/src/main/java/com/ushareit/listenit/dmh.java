package com.ushareit.listenit;

class dmh implements Runnable {
    final /* synthetic */ dmg f9926a;

    dmh(dmg com_ushareit_listenit_dmg) {
        this.f9926a = com_ushareit_listenit_dmg;
    }

    public void run() {
        this.f9926a.f9924m.lock();
        try {
            this.f9926a.m14858j();
        } finally {
            this.f9926a.f9924m.unlock();
        }
    }
}
