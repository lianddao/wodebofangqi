package com.ushareit.listenit;

import java.lang.ref.WeakReference;

class dnh extends dnv {
    private WeakReference<dnb> f10010a;

    dnh(dnb com_ushareit_listenit_dnb) {
        this.f10010a = new WeakReference(com_ushareit_listenit_dnb);
    }

    public void mo1955a() {
        dnb com_ushareit_listenit_dnb = (dnb) this.f10010a.get();
        if (com_ushareit_listenit_dnb != null) {
            com_ushareit_listenit_dnb.m15001s();
        }
    }
}
