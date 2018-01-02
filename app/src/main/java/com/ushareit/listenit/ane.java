package com.ushareit.listenit;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class ane implements Runnable {
    final /* synthetic */ ArrayList f4920a;
    final /* synthetic */ anc f4921b;
    final /* synthetic */ and f4922c;

    ane(and com_ushareit_listenit_and, ArrayList arrayList, anc com_ushareit_listenit_anc) {
        this.f4922c = com_ushareit_listenit_and;
        this.f4920a = arrayList;
        this.f4921b = com_ushareit_listenit_anc;
    }

    public void run() {
        Throwable e;
        List<Future> arrayList = new ArrayList(this.f4920a.size());
        Iterator it = this.f4920a.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f4922c.f4916c.submit((Callable) it.next()));
        }
        try {
            for (Future future : arrayList) {
                future.get();
            }
        } catch (InterruptedException e2) {
            e = e2;
            Log.e(and.f4914a, "Exception while executing cache downloads.", e);
            this.f4922c.f4915b.post(new anf(this));
        } catch (ExecutionException e3) {
            e = e3;
            Log.e(and.f4914a, "Exception while executing cache downloads.", e);
            this.f4922c.f4915b.post(new anf(this));
        }
        this.f4922c.f4915b.post(new anf(this));
    }
}
