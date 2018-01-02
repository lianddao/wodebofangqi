package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

public final class cfh {
    private final List<String> f8216a;
    private final Object f8217b;

    private cfh(Object obj) {
        this.f8217b = cfi.m11080a(obj);
        this.f8216a = new ArrayList();
    }

    public cfh m11079a(String str, Object obj) {
        List list = this.f8216a;
        String str2 = (String) cfi.m11080a((Object) str);
        String valueOf = String.valueOf(String.valueOf(obj));
        list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
        return this;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(100).append(this.f8217b.getClass().getSimpleName()).append('{');
        int size = this.f8216a.size();
        for (int i = 0; i < size; i++) {
            append.append((String) this.f8216a.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
