package com.ushareit.listenit;

import android.os.Process;
import android.util.SparseArray;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicBoolean;

final class dnp extends Thread {
    private final ReferenceQueue<ceo<?>> f10047a;
    private final SparseArray<dno> f10048b;
    private final AtomicBoolean f10049c = new AtomicBoolean();

    public dnp(ReferenceQueue<ceo<?>> referenceQueue, SparseArray<dno> sparseArray) {
        super("GoogleApiCleanup");
        this.f10047a = referenceQueue;
        this.f10048b = sparseArray;
    }

    public void run() {
        this.f10049c.set(true);
        Process.setThreadPriority(10);
        while (this.f10049c.get()) {
            try {
                dno com_ushareit_listenit_dno = (dno) this.f10047a.remove();
                this.f10048b.remove(com_ushareit_listenit_dno.f10046b);
                com_ushareit_listenit_dno.m15097a();
            } catch (InterruptedException e) {
            } finally {
                this.f10049c.set(false);
            }
        }
    }
}
