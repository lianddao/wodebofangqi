package com.ushareit.listenit;

import android.os.Looper;
import android.util.Log;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class vr implements wb, wf, xx {
    private final Map<uv, vx> f17062a;
    private final wd f17063b;
    private final xw f17064c;
    private final vs f17065d;
    private final Map<uv, WeakReference<we<?>>> f17066e;
    private final wl f17067f;
    private final vt f17068g;
    private ReferenceQueue<we<?>> f17069h;

    public vr(xw xwVar, xh xhVar, ExecutorService executorService, ExecutorService executorService2) {
        this(xwVar, xhVar, executorService, executorService2, null, null, null, null, null);
    }

    vr(xw xwVar, xh xhVar, ExecutorService executorService, ExecutorService executorService2, Map<uv, vx> map, wd wdVar, Map<uv, WeakReference<we<?>>> map2, vs vsVar, wl wlVar) {
        this.f17064c = xwVar;
        this.f17068g = new vt(xhVar);
        if (map2 == null) {
            map2 = new HashMap();
        }
        this.f17066e = map2;
        if (wdVar == null) {
            wdVar = new wd();
        }
        this.f17063b = wdVar;
        if (map == null) {
            map = new HashMap();
        }
        this.f17062a = map;
        if (vsVar == null) {
            vsVar = new vs(executorService, executorService2, this);
        }
        this.f17065d = vsVar;
        if (wlVar == null) {
            wlVar = new wl();
        }
        this.f17067f = wlVar;
        xwVar.mo3143a((xx) this);
    }

    public <T, Z, R> vu m26740a(uv uvVar, int i, int i2, vc<T> vcVar, aeb<T, Z> com_ushareit_listenit_aeb_T__Z, uz<Z> uzVar, adb<Z, R> com_ushareit_listenit_adb_Z__R, tv tvVar, boolean z, vq vqVar, ael com_ushareit_listenit_ael) {
        afu.m5497a();
        long a = afq.m5477a();
        uv a2 = this.f17063b.m26768a(vcVar.mo586b(), uvVar, i, i2, com_ushareit_listenit_aeb_T__Z.mo561a(), com_ushareit_listenit_aeb_T__Z.mo562b(), uzVar, com_ushareit_listenit_aeb_T__Z.mo564d(), com_ushareit_listenit_adb_Z__R, com_ushareit_listenit_aeb_T__Z.mo563c());
        wk b = m26739b(a2, z);
        if (b != null) {
            com_ushareit_listenit_ael.mo597a(b);
            if (Log.isLoggable("Engine", 2)) {
                m26738a("Loaded resource from cache", a, a2);
            }
            return null;
        }
        b = m26736a(a2, z);
        if (b != null) {
            com_ushareit_listenit_ael.mo597a(b);
            if (Log.isLoggable("Engine", 2)) {
                m26738a("Loaded resource from active resources", a, a2);
            }
            return null;
        }
        vx vxVar = (vx) this.f17062a.get(a2);
        if (vxVar != null) {
            vxVar.m26758a(com_ushareit_listenit_ael);
            if (Log.isLoggable("Engine", 2)) {
                m26738a("Added to existing load", a, a2);
            }
            return new vu(com_ushareit_listenit_ael, vxVar);
        }
        vx a3 = this.f17065d.m26746a(a2, z);
        wg wgVar = new wg(a3, new vm(a2, i, i2, vcVar, com_ushareit_listenit_aeb_T__Z, uzVar, com_ushareit_listenit_adb_Z__R, this.f17068g, vqVar, tvVar), tvVar);
        this.f17062a.put(a2, a3);
        a3.m26758a(com_ushareit_listenit_ael);
        a3.m26759a(wgVar);
        if (Log.isLoggable("Engine", 2)) {
            m26738a("Started new load", a, a2);
        }
        return new vu(com_ushareit_listenit_ael, a3);
    }

    private static void m26738a(String str, long j, uv uvVar) {
        Log.v("Engine", str + " in " + afq.m5476a(j) + "ms, key: " + uvVar);
    }

    private we<?> m26736a(uv uvVar, boolean z) {
        if (!z) {
            return null;
        }
        we<?> weVar;
        WeakReference weakReference = (WeakReference) this.f17066e.get(uvVar);
        if (weakReference != null) {
            weVar = (we) weakReference.get();
            if (weVar != null) {
                weVar.m26774e();
            } else {
                this.f17066e.remove(uvVar);
            }
        } else {
            weVar = null;
        }
        return weVar;
    }

    private we<?> m26739b(uv uvVar, boolean z) {
        if (!z) {
            return null;
        }
        we<?> a = m26735a(uvVar);
        if (a == null) {
            return a;
        }
        a.m26774e();
        this.f17066e.put(uvVar, new vw(uvVar, a, m26737a()));
        return a;
    }

    private we<?> m26735a(uv uvVar) {
        wk a = this.f17064c.mo3141a(uvVar);
        if (a == null) {
            return null;
        }
        if (a instanceof we) {
            return (we) a;
        }
        return new we(a, true);
    }

    public void m26743a(wk wkVar) {
        afu.m5497a();
        if (wkVar instanceof we) {
            ((we) wkVar).m26775f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void mo3109a(uv uvVar, we<?> weVar) {
        afu.m5497a();
        if (weVar != null) {
            weVar.m26769a(uvVar, this);
            if (weVar.m26770a()) {
                this.f17066e.put(uvVar, new vw(uvVar, weVar, m26737a()));
            }
        }
        this.f17062a.remove(uvVar);
    }

    public void mo3110a(vx vxVar, uv uvVar) {
        afu.m5497a();
        if (vxVar.equals((vx) this.f17062a.get(uvVar))) {
            this.f17062a.remove(uvVar);
        }
    }

    public void mo3112b(wk<?> wkVar) {
        afu.m5497a();
        this.f17067f.m27115a(wkVar);
    }

    public void mo3111b(uv uvVar, we weVar) {
        afu.m5497a();
        this.f17066e.remove(uvVar);
        if (weVar.m26770a()) {
            this.f17064c.mo3145b(uvVar, weVar);
        } else {
            this.f17067f.m27115a(weVar);
        }
    }

    private ReferenceQueue<we<?>> m26737a() {
        if (this.f17069h == null) {
            this.f17069h = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new vv(this.f17066e, this.f17069h));
        }
        return this.f17069h;
    }
}
