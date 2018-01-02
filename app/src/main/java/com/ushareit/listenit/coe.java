package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;

public class coe {
    private final List<List<String>> f8542a;
    private final List<String> f8543b;

    public coe(List<List<String>> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.f8542a = list;
        this.f8543b = list2;
    }

    public List<List<String>> m12000a() {
        return Collections.unmodifiableList(this.f8542a);
    }

    public List<String> m12001b() {
        return Collections.unmodifiableList(this.f8543b);
    }
}
