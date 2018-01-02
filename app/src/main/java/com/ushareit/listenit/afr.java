package com.ushareit.listenit;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class afr<T, Y> {
    private final LinkedHashMap<T, Y> f4276a = new LinkedHashMap(100, 0.75f, true);
    private int f4277b;
    private final int f4278c;
    private int f4279d = 0;

    public afr(int i) {
        this.f4278c = i;
        this.f4277b = i;
    }

    protected int mo3140a(Y y) {
        return 1;
    }

    protected void mo3144a(T t, Y y) {
    }

    public int m5482b() {
        return this.f4279d;
    }

    public Y m5483b(T t) {
        return this.f4276a.get(t);
    }

    public Y m5484b(T t, Y y) {
        if (mo3140a(y) >= this.f4277b) {
            mo3144a(t, y);
            return null;
        }
        Y put = this.f4276a.put(t, y);
        if (y != null) {
            this.f4279d += mo3140a(y);
        }
        if (put != null) {
            this.f4279d -= mo3140a(put);
        }
        m5478c();
        return put;
    }

    public Y m5486c(T t) {
        Y remove = this.f4276a.remove(t);
        if (remove != null) {
            this.f4279d -= mo3140a(remove);
        }
        return remove;
    }

    public void m5480a() {
        m5485b(0);
    }

    protected void m5485b(int i) {
        while (this.f4279d > i) {
            Entry entry = (Entry) this.f4276a.entrySet().iterator().next();
            Object value = entry.getValue();
            this.f4279d -= mo3140a(value);
            Object key = entry.getKey();
            this.f4276a.remove(key);
            mo3144a(key, value);
        }
    }

    private void m5478c() {
        m5485b(this.f4277b);
    }
}
