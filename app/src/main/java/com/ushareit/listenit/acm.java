package com.ushareit.listenit;

import java.util.Queue;

class acm {
    private final Queue<ul> f4122a = afu.m5496a(0);

    acm() {
    }

    public synchronized ul m5214a(um umVar) {
        ul ulVar;
        ulVar = (ul) this.f4122a.poll();
        if (ulVar == null) {
            ulVar = new ul(umVar);
        }
        return ulVar;
    }

    public synchronized void m5215a(ul ulVar) {
        ulVar.m26563g();
        this.f4122a.offer(ulVar);
    }
}
