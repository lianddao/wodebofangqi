package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class dqi {
    private long f10161a = 43200;
    private Map<String, String> f10162b;
    private int f10163c;

    public dqh m15276a() {
        return new dqh();
    }

    public dqi m15277a(int i) {
        this.f10163c = i;
        return this;
    }

    public dqi m15278a(long j) {
        this.f10161a = j;
        return this;
    }

    public dqi m15279a(String str, String str2) {
        if (this.f10162b == null) {
            this.f10162b = new HashMap();
        }
        this.f10162b.put(str, str2);
        return this;
    }
}
