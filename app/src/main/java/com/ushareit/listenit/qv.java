package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;

class qv implements Runnable {
    final /* synthetic */ ArrayList f16363a;
    final /* synthetic */ qs f16364b;

    qv(qs qsVar, ArrayList arrayList) {
        this.f16364b = qsVar;
        this.f16363a = arrayList;
    }

    public void run() {
        Iterator it = this.f16363a.iterator();
        while (it.hasNext()) {
            this.f16364b.m25891u((sv) it.next());
        }
        this.f16363a.clear();
        this.f16364b.f16352f.remove(this.f16363a);
    }
}
