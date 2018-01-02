package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class vx implements wh {
    private static final vz f17080a = new vz();
    private static final Handler f17081b = new Handler(Looper.getMainLooper(), new wa());
    private final List<ael> f17082c;
    private final vz f17083d;
    private final wb f17084e;
    private final uv f17085f;
    private final ExecutorService f17086g;
    private final ExecutorService f17087h;
    private final boolean f17088i;
    private boolean f17089j;
    private wk<?> f17090k;
    private boolean f17091l;
    private Exception f17092m;
    private boolean f17093n;
    private Set<ael> f17094o;
    private wg f17095p;
    private we<?> f17096q;
    private volatile Future<?> f17097r;

    public vx(uv uvVar, ExecutorService executorService, ExecutorService executorService2, boolean z, wb wbVar) {
        this(uvVar, executorService, executorService2, z, wbVar, f17080a);
    }

    public vx(uv uvVar, ExecutorService executorService, ExecutorService executorService2, boolean z, wb wbVar, vz vzVar) {
        this.f17082c = new ArrayList();
        this.f17085f = uvVar;
        this.f17086g = executorService;
        this.f17087h = executorService2;
        this.f17088i = z;
        this.f17084e = wbVar;
        this.f17083d = vzVar;
    }

    public void m26759a(wg wgVar) {
        this.f17095p = wgVar;
        this.f17097r = this.f17086g.submit(wgVar);
    }

    public void mo3114b(wg wgVar) {
        this.f17097r = this.f17087h.submit(wgVar);
    }

    public void m26758a(ael com_ushareit_listenit_ael) {
        afu.m5497a();
        if (this.f17091l) {
            com_ushareit_listenit_ael.mo597a(this.f17096q);
        } else if (this.f17093n) {
            com_ushareit_listenit_ael.mo598a(this.f17092m);
        } else {
            this.f17082c.add(com_ushareit_listenit_ael);
        }
    }

    public void m26762b(ael com_ushareit_listenit_ael) {
        afu.m5497a();
        if (this.f17091l || this.f17093n) {
            m26755c(com_ushareit_listenit_ael);
            return;
        }
        this.f17082c.remove(com_ushareit_listenit_ael);
        if (this.f17082c.isEmpty()) {
            m26757a();
        }
    }

    private void m26755c(ael com_ushareit_listenit_ael) {
        if (this.f17094o == null) {
            this.f17094o = new HashSet();
        }
        this.f17094o.add(com_ushareit_listenit_ael);
    }

    private boolean m26756d(ael com_ushareit_listenit_ael) {
        return this.f17094o != null && this.f17094o.contains(com_ushareit_listenit_ael);
    }

    void m26757a() {
        if (!this.f17093n && !this.f17091l && !this.f17089j) {
            this.f17095p.m26783a();
            Future future = this.f17097r;
            if (future != null) {
                future.cancel(true);
            }
            this.f17089j = true;
            this.f17084e.mo3110a(this, this.f17085f);
        }
    }

    public void mo597a(wk<?> wkVar) {
        this.f17090k = wkVar;
        f17081b.obtainMessage(1, this).sendToTarget();
    }

    private void m26752b() {
        if (this.f17089j) {
            this.f17090k.mo555d();
        } else if (this.f17082c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else {
            this.f17096q = this.f17083d.m26764a(this.f17090k, this.f17088i);
            this.f17091l = true;
            this.f17096q.m26774e();
            this.f17084e.mo3109a(this.f17085f, this.f17096q);
            for (ael com_ushareit_listenit_ael : this.f17082c) {
                if (!m26756d(com_ushareit_listenit_ael)) {
                    this.f17096q.m26774e();
                    com_ushareit_listenit_ael.mo597a(this.f17096q);
                }
            }
            this.f17096q.m26775f();
        }
    }

    public void mo598a(Exception exception) {
        this.f17092m = exception;
        f17081b.obtainMessage(2, this).sendToTarget();
    }

    private void m26754c() {
        if (!this.f17089j) {
            if (this.f17082c.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            this.f17093n = true;
            this.f17084e.mo3109a(this.f17085f, null);
            for (ael com_ushareit_listenit_ael : this.f17082c) {
                if (!m26756d(com_ushareit_listenit_ael)) {
                    com_ushareit_listenit_ael.mo598a(this.f17092m);
                }
            }
        }
    }
}
