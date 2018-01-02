package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;

class qt implements Runnable {
    final /* synthetic */ ArrayList f16359a;
    final /* synthetic */ qs f16360b;

    qt(qs qsVar, ArrayList arrayList) {
        this.f16360b = qsVar;
        this.f16359a = arrayList;
    }

    public void run() {
        Iterator it = this.f16359a.iterator();
        while (it.hasNext()) {
            rc rcVar = (rc) it.next();
            this.f16360b.m25882b(rcVar.f16391a, rcVar.f16392b, rcVar.f16393c, rcVar.f16394d, rcVar.f16395e);
        }
        this.f16359a.clear();
        this.f16360b.f16353g.remove(this.f16359a);
    }
}
