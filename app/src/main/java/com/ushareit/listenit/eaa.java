package com.ushareit.listenit;

class eaa implements Runnable {
    final /* synthetic */ dzo f10741a;
    final /* synthetic */ dzz f10742b;

    eaa(dzz com_ushareit_listenit_dzz, dzo com_ushareit_listenit_dzo) {
        this.f10742b = com_ushareit_listenit_dzz;
        this.f10741a = com_ushareit_listenit_dzo;
    }

    public void run() {
        synchronized (this.f10742b.f10739b) {
            if (this.f10742b.f10740c != null) {
                this.f10742b.f10740c.mo1447a(this.f10741a.mo2132d());
            }
        }
    }
}
