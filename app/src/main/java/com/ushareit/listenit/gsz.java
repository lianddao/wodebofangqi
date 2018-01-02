package com.ushareit.listenit;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class gsz {
    private SparseArray<ArrayList<? extends gla>> f14689a = new SparseArray();
    private String f14690b = "";

    public void m22733a(int i, ArrayList<? extends gla> arrayList) {
        this.f14689a.put(i, arrayList);
    }

    public void m22732a() {
        this.f14689a.clear();
    }

    public ArrayList<gla> m22731a(int i, String str) {
        this.f14690b = str;
        ArrayList<gla> arrayList = new ArrayList();
        if (this.f14689a.indexOfKey(i) < 0) {
            return arrayList;
        }
        for (gla com_ushareit_listenit_gla : (List) this.f14689a.get(i)) {
            if (gyn.m23203a(com_ushareit_listenit_gla.mo2562c(), str)) {
                arrayList.add(com_ushareit_listenit_gla);
            }
        }
        return arrayList;
    }

    public String m22734b() {
        return this.f14690b;
    }
}
