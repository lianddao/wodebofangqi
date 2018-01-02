package com.ushareit.listenit;

class etu implements Runnable {
    final /* synthetic */ eto f11846a;
    final /* synthetic */ ets f11847b;

    etu(ets com_ushareit_listenit_ets, eto com_ushareit_listenit_eto) {
        this.f11847b = com_ushareit_listenit_ets;
        this.f11846a = com_ushareit_listenit_eto;
    }

    public void run() {
        this.f11847b.m17949b(this.f11846a);
        eua com_ushareit_listenit_eua = eua.DEFAULT;
        switch (etx.f11851a[this.f11846a.m17910c().ordinal()]) {
            case 1:
                if (!etk.m17900a(this.f11846a.m17912e())) {
                    com_ushareit_listenit_eua = eua.PAGE_IN_EVENT;
                    break;
                } else {
                    com_ushareit_listenit_eua = eua.IN_HOMEPAGE;
                    break;
                }
            case 2:
                com_ushareit_listenit_eua = eua.PAGE_OUT_EVENT;
                break;
            default:
                com_ushareit_listenit_eua = eua.CUSTOM_EVENT;
                break;
        }
        this.f11847b.m17951c(com_ushareit_listenit_eua);
    }
}
