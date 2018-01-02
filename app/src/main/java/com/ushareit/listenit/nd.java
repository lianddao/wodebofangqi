package com.ushareit.listenit;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class nd implements nj {
    final /* synthetic */ na f15981a;
    final /* synthetic */ nc f15982b;

    nd(nc ncVar, na naVar) {
        this.f15982b = ncVar;
        this.f15981a = naVar;
    }

    public boolean mo2946a(int i, int i2, Bundle bundle) {
        return this.f15981a.m25148a(i, i2, bundle);
    }

    public List<Object> mo2945a(String str, int i) {
        List a = this.f15981a.m25147a(str, i);
        List<Object> arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((mh) a.get(i2)).m24883a());
        }
        return arrayList;
    }

    public Object mo2944a(int i) {
        mh a = this.f15981a.m25145a(i);
        if (a == null) {
            return null;
        }
        return a.m24883a();
    }
}
