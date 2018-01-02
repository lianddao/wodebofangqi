package com.ushareit.listenit;

import android.os.MessageQueue.IdleHandler;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

class vv implements IdleHandler {
    private final Map<uv, WeakReference<we<?>>> f17077a;
    private final ReferenceQueue<we<?>> f17078b;

    public vv(Map<uv, WeakReference<we<?>>> map, ReferenceQueue<we<?>> referenceQueue) {
        this.f17077a = map;
        this.f17078b = referenceQueue;
    }

    public boolean queueIdle() {
        vw vwVar = (vw) this.f17078b.poll();
        if (vwVar != null) {
            this.f17077a.remove(vwVar.f17079a);
        }
        return true;
    }
}
