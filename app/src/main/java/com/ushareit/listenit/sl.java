package com.ushareit.listenit;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class sl {
    private SparseArray<ArrayList<sv>> f16492a = new SparseArray();
    private SparseIntArray f16493b = new SparseIntArray();
    private int f16494c = 0;

    public void m26120a() {
        this.f16492a.clear();
    }

    public sv m26119a(int i) {
        ArrayList arrayList = (ArrayList) this.f16492a.get(i);
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size() - 1;
        sv svVar = (sv) arrayList.get(size);
        arrayList.remove(size);
        return svVar;
    }

    public void m26123a(sv svVar) {
        int itemViewType = svVar.getItemViewType();
        ArrayList b = m26118b(itemViewType);
        if (this.f16493b.get(itemViewType) > b.size()) {
            svVar.m3243q();
            b.add(svVar);
        }
    }

    void m26121a(rx rxVar) {
        this.f16494c++;
    }

    void m26124b() {
        this.f16494c--;
    }

    void m26122a(rx rxVar, rx rxVar2, boolean z) {
        if (rxVar != null) {
            m26124b();
        }
        if (!z && this.f16494c == 0) {
            m26120a();
        }
        if (rxVar2 != null) {
            m26121a(rxVar2);
        }
    }

    private ArrayList<sv> m26118b(int i) {
        ArrayList<sv> arrayList = (ArrayList) this.f16492a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f16492a.put(i, arrayList);
            if (this.f16493b.indexOfKey(i) < 0) {
                this.f16493b.put(i, 5);
            }
        }
        return arrayList;
    }
}
