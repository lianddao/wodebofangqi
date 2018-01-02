package com.ushareit.listenit;

import java.util.concurrent.Executor;

final class eaf<TResult> extends dzo<TResult> {
    private final Object f10751a = new Object();
    private final eae<TResult> f10752b = new eae();
    private boolean f10753c;
    private TResult f10754d;
    private Exception f10755e;

    eaf() {
    }

    private void m16589e() {
        cfi.m11086a(this.f10753c, (Object) "Task is not yet complete");
    }

    private void m16590f() {
        cfi.m11086a(!this.f10753c, (Object) "Task is already complete");
    }

    private void m16591g() {
        synchronized (this.f10751a) {
            if (this.f10753c) {
                this.f10752b.m16587a((dzo) this);
                return;
            }
        }
    }

    public dzo<TResult> mo2124a(dzk<TResult> com_ushareit_listenit_dzk_TResult) {
        return mo2126a(dzq.f10727a, (dzk) com_ushareit_listenit_dzk_TResult);
    }

    public dzo<TResult> mo2125a(dzm<? super TResult> com_ushareit_listenit_dzm__super_TResult) {
        return mo2128a(dzq.f10727a, (dzm) com_ushareit_listenit_dzm__super_TResult);
    }

    public dzo<TResult> mo2126a(Executor executor, dzk<TResult> com_ushareit_listenit_dzk_TResult) {
        this.f10752b.m16588a(new dzx(executor, com_ushareit_listenit_dzk_TResult));
        m16591g();
        return this;
    }

    public dzo<TResult> mo2127a(Executor executor, dzl com_ushareit_listenit_dzl) {
        this.f10752b.m16588a(new dzz(executor, com_ushareit_listenit_dzl));
        m16591g();
        return this;
    }

    public dzo<TResult> mo2128a(Executor executor, dzm<? super TResult> com_ushareit_listenit_dzm__super_TResult) {
        this.f10752b.m16588a(new eab(executor, com_ushareit_listenit_dzm__super_TResult));
        m16591g();
        return this;
    }

    public void m16597a(Exception exception) {
        cfi.m11081a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f10751a) {
            m16590f();
            this.f10753c = true;
            this.f10755e = exception;
        }
        this.f10752b.m16587a((dzo) this);
    }

    public void m16598a(TResult tResult) {
        synchronized (this.f10751a) {
            m16590f();
            this.f10753c = true;
            this.f10754d = tResult;
        }
        this.f10752b.m16587a((dzo) this);
    }

    public boolean mo2129a() {
        boolean z;
        synchronized (this.f10751a) {
            z = this.f10753c;
        }
        return z;
    }

    public boolean mo2130b() {
        boolean z;
        synchronized (this.f10751a) {
            z = this.f10753c && this.f10755e == null;
        }
        return z;
    }

    public TResult mo2131c() {
        TResult tResult;
        synchronized (this.f10751a) {
            m16589e();
            if (this.f10755e != null) {
                throw new dzn(this.f10755e);
            }
            tResult = this.f10754d;
        }
        return tResult;
    }

    public Exception mo2132d() {
        Exception exception;
        synchronized (this.f10751a) {
            exception = this.f10755e;
        }
        return exception;
    }
}
