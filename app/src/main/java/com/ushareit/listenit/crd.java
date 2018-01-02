package com.ushareit.listenit;

class crd implements Runnable {
    final /* synthetic */ cvg f8775a;
    final /* synthetic */ csr f8776b;
    final /* synthetic */ crc f8777c;

    crd(crc com_ushareit_listenit_crc, cvg com_ushareit_listenit_cvg, csr com_ushareit_listenit_csr) {
        this.f8777c = com_ushareit_listenit_crc;
        this.f8775a = com_ushareit_listenit_cvg;
        this.f8776b = com_ushareit_listenit_csr;
    }

    public void run() {
        cxa a = this.f8777c.f8774a.f8738f.m12460a(this.f8775a.m13002a());
        if (!a.mo1635b()) {
            this.f8777c.f8774a.m12368a(this.f8777c.f8774a.f8748p.m12513a(this.f8775a.m13002a(), a));
            this.f8776b.mo1577a(null);
        }
    }
}
