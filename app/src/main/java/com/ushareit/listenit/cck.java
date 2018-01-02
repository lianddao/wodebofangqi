package com.ushareit.listenit;

public class cck {
    static int f8128a = 31;
    private int f8129b = 1;

    public int m10828a() {
        return this.f8129b;
    }

    public cck m10829a(Object obj) {
        this.f8129b = (obj == null ? 0 : obj.hashCode()) + (this.f8129b * f8128a);
        return this;
    }

    public cck m10830a(boolean z) {
        this.f8129b = (z ? 1 : 0) + (this.f8129b * f8128a);
        return this;
    }
}
