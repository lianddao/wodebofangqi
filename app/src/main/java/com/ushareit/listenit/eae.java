package com.ushareit.listenit;

import java.util.ArrayDeque;
import java.util.Queue;

class eae<TResult> {
    private final Object f10748a = new Object();
    private Queue<ead<TResult>> f10749b;
    private boolean f10750c;

    eae() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m16587a(com.ushareit.listenit.dzo<TResult> r3) {
        /*
        r2 = this;
        r1 = r2.f10748a;
        monitor-enter(r1);
        r0 = r2.f10749b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f10750c;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = 1;
        r2.f10750c = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x0011:
        r1 = r2.f10748a;
        monitor-enter(r1);
        r0 = r2.f10749b;	 Catch:{ all -> 0x0023 }
        r0 = r0.poll();	 Catch:{ all -> 0x0023 }
        r0 = (com.ushareit.listenit.ead) r0;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0029;
    L_0x001e:
        r0 = 0;
        r2.f10750c = r0;	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r0.mo2123a(r3);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.eae.a(com.ushareit.listenit.dzo):void");
    }

    public void m16588a(ead<TResult> com_ushareit_listenit_ead_TResult) {
        synchronized (this.f10748a) {
            if (this.f10749b == null) {
                this.f10749b = new ArrayDeque();
            }
            this.f10749b.add(com_ushareit_listenit_ead_TResult);
        }
    }
}
