package com.ushareit.listenit;

import java.util.ArrayList;

class erx {
    int f11644a;
    ArrayList<erw> f11645b;

    erx(int i, ArrayList<erw> arrayList) {
        this.f11644a = i;
        this.f11645b = arrayList;
    }

    boolean m17649a(int i) {
        if (!((this.f11644a & i) == 0 || this.f11645b == null)) {
            int size = this.f11645b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((erw) this.f11645b.get(i2)).f11641a == i) {
                    this.f11645b.remove(i2);
                    this.f11644a &= i ^ -1;
                    return true;
                }
            }
        }
        return false;
    }
}
