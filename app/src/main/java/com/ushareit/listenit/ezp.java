package com.ushareit.listenit;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public abstract class ezp {
    private List<Pair<String, String>> f12228a = new ArrayList();
    private long f12229b = -1;
    private long f12230c = -1;

    public abstract void mo2341a();

    public final void m18593a(String str, String str2) {
        this.f12228a.add(new Pair(str, str2));
    }

    public final List<Pair<String, String>> m18594c() {
        return this.f12228a;
    }

    public final void m18592a(long j, long j2) {
        this.f12229b = j;
        this.f12230c = j2;
    }

    public final Pair<Long, Long> m18595d() {
        return new Pair(Long.valueOf(this.f12229b), Long.valueOf(this.f12230c));
    }
}
