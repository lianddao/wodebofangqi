package com.ushareit.listenit;

import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

final class agg {
    private final AtomicInteger f4325a = new AtomicInteger(0);
    private final String f4326b;
    private volatile aga f4327c;
    private final List<afx> f4328d = new CopyOnWriteArrayList();
    private final afx f4329e;
    private final afy f4330f;

    public agg(String str, afy com_ushareit_listenit_afy) {
        this.f4326b = (String) ago.m5589a((Object) str);
        this.f4330f = (afy) ago.m5589a((Object) com_ushareit_listenit_afy);
        this.f4329e = new agh(str, this.f4328d);
    }

    public void m5563a(afz com_ushareit_listenit_afz, Socket socket) {
        m5559c();
        try {
            this.f4325a.incrementAndGet();
            this.f4327c.m5535a(com_ushareit_listenit_afz, socket);
        } finally {
            m5560d();
        }
    }

    private synchronized void m5559c() {
        this.f4327c = this.f4327c == null ? m5561e() : this.f4327c;
    }

    private synchronized void m5560d() {
        if (this.f4325a.decrementAndGet() <= 0) {
            this.f4327c.m5524a();
            this.f4327c = null;
        }
    }

    public void m5562a() {
        this.f4328d.clear();
        if (this.f4327c != null) {
            this.f4327c.m5534a(null);
            this.f4327c.m5524a();
            this.f4327c = null;
        }
        this.f4325a.set(0);
    }

    public int m5564b() {
        return this.f4325a.get();
    }

    private aga m5561e() {
        aga com_ushareit_listenit_aga = new aga(new agi(this.f4326b, this.f4330f.f4290d), new agy(this.f4330f.m5509a(this.f4326b), this.f4330f.f4289c));
        com_ushareit_listenit_aga.m5534a(this.f4329e);
        return com_ushareit_listenit_aga;
    }
}
