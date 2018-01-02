package com.ushareit.listenit;

class dzy implements Runnable {
    final /* synthetic */ dzo f10736a;
    final /* synthetic */ dzx f10737b;

    dzy(dzx com_ushareit_listenit_dzx, dzo com_ushareit_listenit_dzo) {
        this.f10737b = com_ushareit_listenit_dzx;
        this.f10736a = com_ushareit_listenit_dzo;
    }

    public void run() {
        synchronized (this.f10737b.f10734b) {
            if (this.f10737b.f10735c != null) {
                this.f10737b.f10735c.mo2397a(this.f10736a);
            }
        }
    }
}
