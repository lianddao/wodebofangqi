package com.ushareit.listenit;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class nf implements nm {
    final /* synthetic */ na f16036a;
    final /* synthetic */ ne f16037b;

    nf(ne neVar, na naVar) {
        this.f16037b = neVar;
        this.f16036a = naVar;
    }

    public boolean mo2949a(int i, int i2, Bundle bundle) {
        return this.f16036a.m25148a(i, i2, bundle);
    }

    public List<Object> mo2948a(String str, int i) {
        List a = this.f16036a.m25147a(str, i);
        List<Object> arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((mh) a.get(i2)).m24883a());
        }
        return arrayList;
    }

    public Object mo2947a(int i) {
        mh a = this.f16036a.m25145a(i);
        if (a == null) {
            return null;
        }
        return a.m24883a();
    }

    public Object mo2950b(int i) {
        mh b = this.f16036a.m25149b(i);
        if (b == null) {
            return null;
        }
        return b.m24883a();
    }
}
