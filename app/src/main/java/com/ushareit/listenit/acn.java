package com.ushareit.listenit;

import java.util.Queue;

class acn {
    private final Queue<up> f4123a = afu.m5496a(0);

    acn() {
    }

    public synchronized up m5216a(byte[] bArr) {
        up upVar;
        upVar = (up) this.f4123a.poll();
        if (upVar == null) {
            upVar = new up();
        }
        return upVar.m26580a(bArr);
    }

    public synchronized void m5217a(up upVar) {
        upVar.m26581a();
        this.f4123a.offer(upVar);
    }
}
