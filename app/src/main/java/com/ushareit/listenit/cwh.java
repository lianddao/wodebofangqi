package com.ushareit.listenit;

class cwh extends cnu<cwc, cxa> {
    boolean f9261a = false;
    final /* synthetic */ cwi f9262b;
    final /* synthetic */ cwf f9263c;

    cwh(cwf com_ushareit_listenit_cwf, cwi com_ushareit_listenit_cwi) {
        this.f9263c = com_ushareit_listenit_cwf;
        this.f9262b = com_ushareit_listenit_cwi;
    }

    public void m13174a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        if (!this.f9261a && com_ushareit_listenit_cwc.m13143a(cwc.m13142c()) > 0) {
            this.f9261a = true;
            this.f9262b.mo1574a(cwc.m13142c(), this.f9263c.mo1640f());
        }
        this.f9262b.mo1574a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa);
    }

    public /* synthetic */ void mo1573a(Object obj, Object obj2) {
        m13174a((cwc) obj, (cxa) obj2);
    }
}
