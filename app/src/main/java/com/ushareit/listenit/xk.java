package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

final class xk {
    private final Map<uv, xm> f17529a = new HashMap();
    private final xn f17530b = new xn();

    xk() {
    }

    void m27201a(uv uvVar) {
        xm xmVar;
        synchronized (this) {
            xmVar = (xm) this.f17529a.get(uvVar);
            if (xmVar == null) {
                xmVar = this.f17530b.m27203a();
                this.f17529a.put(uvVar, xmVar);
            }
            xmVar.f17532b++;
        }
        xmVar.f17531a.lock();
    }

    void m27202b(uv uvVar) {
        xm xmVar;
        synchronized (this) {
            xmVar = (xm) this.f17529a.get(uvVar);
            if (xmVar == null || xmVar.f17532b <= 0) {
                int i;
                StringBuilder append = new StringBuilder().append("Cannot release a lock that is not held, key: ").append(uvVar).append(", interestedThreads: ");
                if (xmVar == null) {
                    i = 0;
                } else {
                    i = xmVar.f17532b;
                }
                throw new IllegalArgumentException(append.append(i).toString());
            }
            int i2 = xmVar.f17532b - 1;
            xmVar.f17532b = i2;
            if (i2 == 0) {
                xm xmVar2 = (xm) this.f17529a.remove(uvVar);
                if (xmVar2.equals(xmVar)) {
                    this.f17530b.m27204a(xmVar2);
                } else {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + xmVar + ", but actually removed: " + xmVar2 + ", key: " + uvVar);
                }
            }
        }
        xmVar.f17531a.unlock();
    }
}
