package com.ushareit.listenit;

import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

final class arh {
    private final AtomicInteger f5230a = new AtomicInteger(0);
    private final String f5231b;
    private volatile aqz f5232c;
    private final List<aqw> f5233d = new CopyOnWriteArrayList();
    private final aqw f5234e;
    private final aqx f5235f;

    public arh(String str, aqx com_ushareit_listenit_aqx) {
        this.f5231b = (String) arl.m6900a(str);
        this.f5235f = (aqx) arl.m6900a(com_ushareit_listenit_aqx);
        this.f5234e = new ari(str, this.f5233d);
    }

    private synchronized void m6881c() {
        this.f5232c = this.f5232c == null ? m6883e() : this.f5232c;
    }

    private synchronized void m6882d() {
        if (this.f5230a.decrementAndGet() <= 0) {
            this.f5232c.m6837a();
            this.f5232c = null;
        }
    }

    private aqz m6883e() {
        aqz com_ushareit_listenit_aqz = new aqz(new arj(this.f5231b), new aqn(this.f5235f.m6823a(this.f5231b), this.f5235f.f5195c));
        com_ushareit_listenit_aqz.m6846a(this.f5234e);
        return com_ushareit_listenit_aqz;
    }

    public void m6884a() {
        this.f5233d.clear();
        if (this.f5232c != null) {
            this.f5232c.m6846a(null);
            this.f5232c.m6837a();
            this.f5232c = null;
        }
        this.f5230a.set(0);
    }

    public void m6885a(aqy com_ushareit_listenit_aqy, Socket socket) {
        m6881c();
        try {
            this.f5230a.incrementAndGet();
            this.f5232c.m6847a(com_ushareit_listenit_aqy, socket);
        } finally {
            m6882d();
        }
    }

    public int m6886b() {
        return this.f5230a.get();
    }
}
