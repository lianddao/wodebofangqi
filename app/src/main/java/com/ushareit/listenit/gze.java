package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public abstract class gze {
    private static String f12949a = "ThreadPoolTaskExecutor";
    private gxu<Object, Future<?>> f12950b = new gxu();
    private List<Object> f12951c = new ArrayList();
    private List<Object> f12952d = new ArrayList();
    private List<Object> f12953e = new CopyOnWriteArrayList();
    private ExecutorService f12954f = mo2399b();
    private gzg f12955g = new gzg(this);

    public abstract void mo2398a(Object obj);

    public abstract ExecutorService mo2399b();

    public abstract void mo2400b(Object obj);

    public abstract void mo2401c(Object obj);

    public abstract void mo2403d(Object obj);

    public synchronized void m19806a(Object obj, faw com_ushareit_listenit_faw) {
        if (!this.f12950b.containsKey(obj)) {
            if (this.f12953e.contains(obj)) {
                this.f12953e.remove(obj);
            }
            this.f12951c.add(obj);
            this.f12950b.put(obj, this.f12954f.submit(new gzf(this, obj, com_ushareit_listenit_faw)));
        }
    }

    protected boolean m19816h() {
        return this.f12950b.size() == 0;
    }

    public boolean m19812e(Object obj) {
        return obj != null ? this.f12951c.contains(obj) : false;
    }

    public boolean m19813f(Object obj) {
        return this.f12952d.contains(obj);
    }

    public boolean m19814g(Object obj) {
        return this.f12953e.contains(obj);
    }

    public int m19817i() {
        return this.f12950b.size();
    }

    public void m19815h(Object obj) {
        exw.m18457e(f12949a, "cancelTask");
        if (this.f12951c.contains(obj)) {
            this.f12951c.remove(obj);
        }
        if (this.f12952d.contains(obj)) {
            this.f12952d.remove(obj);
        }
        if (this.f12953e.contains(obj)) {
            this.f12953e.remove(obj);
        }
        m19804j(obj);
        this.f12955g.m23372c(obj);
    }

    public void m19818i(Object obj) {
        if (!this.f12953e.contains(obj)) {
            this.f12953e.add(obj);
        }
        if (this.f12951c.contains(obj)) {
            this.f12951c.remove(obj);
        }
        if (this.f12952d.contains(obj)) {
            this.f12952d.remove(obj);
        }
        m19804j(obj);
        this.f12955g.m23371b(obj);
    }

    private synchronized void m19804j(Object obj) {
        exw.m18457e(f12949a, "removeTask");
        Future future = (Future) this.f12950b.get(obj);
        this.f12950b.remove(obj);
        if (future != null) {
            future.cancel(true);
        }
    }

    public synchronized void mo2402d() {
        exw.m18457e(f12949a, "cancelAllTasks:" + this.f12950b.size());
        for (Entry value : this.f12950b.entrySet()) {
            Future future = (Future) value.getValue();
            if (future != null) {
                future.cancel(true);
            }
        }
        this.f12950b.clear();
        this.f12951c.clear();
        this.f12952d.clear();
        this.f12953e.clear();
    }
}
