package com.ushareit.listenit;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

public final class aiu implements Runnable {
    final /* synthetic */ ArrayList f4452a;
    final /* synthetic */ aje f4453b;

    public aiu(ArrayList arrayList, aje com_ushareit_listenit_aje) {
        this.f4452a = arrayList;
        this.f4453b = com_ushareit_listenit_aje;
    }

    public void run() {
        Iterator it = this.f4452a.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((aix) pair.first).mo166a((ajh) pair.second);
        }
        for (ajf a : this.f4453b.m5763e()) {
            a.mo634a(this.f4453b);
        }
    }
}
