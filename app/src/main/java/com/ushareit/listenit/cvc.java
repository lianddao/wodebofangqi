package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;

class cvc implements Runnable {
    final /* synthetic */ ArrayList f9182a;
    final /* synthetic */ cvb f9183b;

    cvc(cvb com_ushareit_listenit_cvb, ArrayList arrayList) {
        this.f9183b = com_ushareit_listenit_cvb;
        this.f9182a = arrayList;
    }

    public void run() {
        Iterator it = this.f9182a.iterator();
        while (it.hasNext()) {
            cux com_ushareit_listenit_cux = (cux) it.next();
            if (this.f9183b.f9181b.m13094a()) {
                cvy a = this.f9183b.f9181b;
                String str = "Raising ";
                String valueOf = String.valueOf(com_ushareit_listenit_cux.toString());
                a.m13093a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
            }
            com_ushareit_listenit_cux.mo1612b();
        }
    }
}
