package com.ushareit.listenit;

class eac implements Runnable {
    final /* synthetic */ dzo f10746a;
    final /* synthetic */ eab f10747b;

    eac(eab com_ushareit_listenit_eab, dzo com_ushareit_listenit_dzo) {
        this.f10747b = com_ushareit_listenit_eab;
        this.f10746a = com_ushareit_listenit_dzo;
    }

    public void run() {
        synchronized (this.f10747b.f10744b) {
            if (this.f10747b.f10745c != null) {
                this.f10747b.f10745c.mo1448a(this.f10746a.mo2131c());
            }
        }
    }
}
