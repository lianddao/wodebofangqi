package com.ushareit.listenit;

import java.util.ArrayDeque;
import java.util.Queue;

class xn {
    private final Queue<xm> f17533a;

    private xn() {
        this.f17533a = new ArrayDeque();
    }

    xm m27203a() {
        synchronized (this.f17533a) {
            xm xmVar = (xm) this.f17533a.poll();
        }
        if (xmVar == null) {
            return new xm();
        }
        return xmVar;
    }

    void m27204a(xm xmVar) {
        synchronized (this.f17533a) {
            if (this.f17533a.size() < 10) {
                this.f17533a.offer(xmVar);
            }
        }
    }
}
