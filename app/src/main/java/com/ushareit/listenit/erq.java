package com.ushareit.listenit;

import java.util.ArrayList;

class erq {
    int f11621a;
    ArrayList<erp> f11622b;

    erq(int i, ArrayList<erp> arrayList) {
        this.f11621a = i;
        this.f11622b = arrayList;
    }

    boolean m17616a(int i) {
        if (!((this.f11621a & i) == 0 || this.f11622b == null)) {
            int size = this.f11622b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((erp) this.f11622b.get(i2)).f11618a == i) {
                    this.f11622b.remove(i2);
                    this.f11621a &= i ^ -1;
                    return true;
                }
            }
        }
        return false;
    }
}
