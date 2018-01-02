package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;

class qu implements Runnable {
    final /* synthetic */ ArrayList f16361a;
    final /* synthetic */ qs f16362b;

    qu(qs qsVar, ArrayList arrayList) {
        this.f16362b = qsVar;
        this.f16361a = arrayList;
    }

    public void run() {
        Iterator it = this.f16361a.iterator();
        while (it.hasNext()) {
            this.f16362b.m25877a((rb) it.next());
        }
        this.f16361a.clear();
        this.f16362b.f16354h.remove(this.f16361a);
    }
}
