package com.ushareit.listenit;

import java.lang.ref.WeakReference;

class esg {
    private String f11698a;
    private esi f11699b;
    private WeakReference<eso> f11700c;

    public esg(String str, esi com_ushareit_listenit_esi, eso com_ushareit_listenit_eso) {
        this.f11698a = str;
        this.f11699b = com_ushareit_listenit_esi;
        this.f11700c = new WeakReference(com_ushareit_listenit_eso);
    }

    public void m17755a() {
        try {
            eso com_ushareit_listenit_eso = (eso) this.f11700c.get();
            if (com_ushareit_listenit_eso != null) {
                com_ushareit_listenit_eso.mo2354a(this.f11698a, this.f11699b);
            }
        } catch (Throwable th) {
            esh.m17763a(esf.f11693a.m17691a(), this.f11698a, "notifyAdClicked", th);
        }
    }

    public void m17756b() {
        try {
            eso com_ushareit_listenit_eso = (eso) this.f11700c.get();
            if (com_ushareit_listenit_eso != null) {
                com_ushareit_listenit_eso.mo2357b(this.f11698a, this.f11699b);
            }
        } catch (Throwable th) {
            esh.m17763a(esf.f11693a.m17691a(), this.f11698a, "notifyAdLeftApp", th);
        }
    }
}
