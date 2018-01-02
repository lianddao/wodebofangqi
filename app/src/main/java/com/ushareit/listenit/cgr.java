package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

class cgr extends cgf {
    List<cgf> f8259p;

    cgr(List<cgf> list) {
        this.f8259p = list;
    }

    public cgf mo1314a(cgf com_ushareit_listenit_cgf) {
        List arrayList = new ArrayList(this.f8259p);
        arrayList.add((cgf) cfi.m11080a((Object) com_ushareit_listenit_cgf));
        return new cgr(arrayList);
    }

    public boolean mo1313b(char c) {
        for (cgf b : this.f8259p) {
            if (b.mo1313b(c)) {
                return true;
            }
        }
        return false;
    }
}
