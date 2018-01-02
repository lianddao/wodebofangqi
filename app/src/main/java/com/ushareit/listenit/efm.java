package com.ushareit.listenit;

import android.util.Log;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0277j;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executor;

public abstract class efm<TResult extends efs> extends efb<TResult> {
    private static final HashMap<Integer, HashSet<Integer>> f10923b = new HashMap();
    private static final HashMap<Integer, HashSet<Integer>> f10924c = new HashMap();
    protected final Object f10925a = new Object();
    private final ega<dzm<? super TResult>, TResult> f10926d = new ega(this, 128, new efn(this));
    private final ega<dzl, TResult> f10927e = new ega(this, 320, new efo(this));
    private final ega<efg<? super TResult>, TResult> f10928f = new ega(this, -465, new efp(this));
    private final ega<eff<? super TResult>, TResult> f10929g = new ega(this, 16, new efq(this));
    private int f10930h = 1;
    private TResult f10931i;

    static {
        f10923b.put(Integer.valueOf(1), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(16), Integer.valueOf(C0277j.f3694e)})));
        f10923b.put(Integer.valueOf(2), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(8), Integer.valueOf(32)})));
        f10923b.put(Integer.valueOf(4), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(8), Integer.valueOf(32)})));
        f10923b.put(Integer.valueOf(16), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(C0277j.f3694e)})));
        f10923b.put(Integer.valueOf(64), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(C0277j.f3694e)})));
        f10924c.put(Integer.valueOf(1), new HashSet(Collections.singletonList(Integer.valueOf(2))));
        f10924c.put(Integer.valueOf(2), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(4), Integer.valueOf(64), Integer.valueOf(128)})));
        f10924c.put(Integer.valueOf(4), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(4), Integer.valueOf(64), Integer.valueOf(128)})));
        f10924c.put(Integer.valueOf(8), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(16), Integer.valueOf(64), Integer.valueOf(128)})));
        f10924c.put(Integer.valueOf(32), new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(C0277j.f3694e), Integer.valueOf(64), Integer.valueOf(128)})));
    }

    protected efm() {
    }

    private String m16919a(int i) {
        switch (i) {
            case 1:
                return "INTERNAL_STATE_NOT_STARTED";
            case 2:
                return "INTERNAL_STATE_QUEUED";
            case 4:
                return "INTERNAL_STATE_IN_PROGRESS";
            case 8:
                return "INTERNAL_STATE_PAUSING";
            case 16:
                return "INTERNAL_STATE_PAUSED";
            case C0154a.f2957m /*32*/:
                return "INTERNAL_STATE_CANCELING";
            case 64:
                return "INTERNAL_STATE_FAILURE";
            case 128:
                return "INTERNAL_STATE_SUCCESS";
            case C0277j.f3694e /*256*/:
                return "INTERNAL_STATE_CANCELED";
            default:
                return "Unknown Internal State!";
        }
    }

    private TResult mo2152g() {
        if (this.f10931i != null) {
            return this.f10931i;
        }
        if (!mo2129a()) {
            return null;
        }
        if (this.f10931i == null) {
            this.f10931i = m16942o();
        }
        return this.f10931i;
    }

    public /* synthetic */ dzo mo2125a(dzm com_ushareit_listenit_dzm) {
        return m16927b(com_ushareit_listenit_dzm);
    }

    public /* synthetic */ dzo mo2127a(Executor executor, dzl com_ushareit_listenit_dzl) {
        return m16928b(executor, com_ushareit_listenit_dzl);
    }

    public /* synthetic */ dzo mo2128a(Executor executor, dzm com_ushareit_listenit_dzm) {
        return m16929b(executor, com_ushareit_listenit_dzm);
    }

    public efm<TResult> m16924a(dzl com_ushareit_listenit_dzl) {
        cfi.m11080a((Object) com_ushareit_listenit_dzl);
        this.f10927e.m17052a(null, null, com_ushareit_listenit_dzl);
        return this;
    }

    public boolean mo2129a() {
        return ((m16940m() & 128) == 0 && (m16940m() & 320) == 0) ? false : true;
    }

    boolean m16926a(int i, boolean z) {
        boolean z2;
        if (Log.isLoggable("StorageTask", 3)) {
            String valueOf = String.valueOf(m16919a(i));
            String valueOf2 = String.valueOf(m16919a(this.f10930h));
            Log.d("StorageTask", new StringBuilder((String.valueOf(valueOf).length() + 54) + String.valueOf(valueOf2).length()).append("changing internal state to: ").append(valueOf).append(" isUser: ").append(z).append(" from state:").append(valueOf2).toString());
        }
        synchronized (this.f10925a) {
            HashSet hashSet = (HashSet) (z ? f10923b : f10924c).get(Integer.valueOf(m16940m()));
            if (hashSet == null || !hashSet.contains(Integer.valueOf(i))) {
                valueOf2 = String.valueOf(m16919a(i));
                String valueOf3 = String.valueOf(m16919a(this.f10930h));
                Log.w("StorageTask", new StringBuilder((String.valueOf(valueOf2).length() + 62) + String.valueOf(valueOf3).length()).append("unable to change internal state to: ").append(valueOf2).append(" isUser: ").append(z).append(" from state:").append(valueOf3).toString());
                z2 = false;
            } else {
                this.f10930h = i;
                switch (this.f10930h) {
                    case 2:
                        efx.m17042a().m17043a(this);
                        m16943p();
                        break;
                    case 4:
                        m16944q();
                        break;
                    case 16:
                        m16945r();
                        break;
                    case 64:
                        m16946s();
                        break;
                    case 128:
                        m16947t();
                        break;
                    case C0277j.f3694e /*256*/:
                        mo2154i();
                        break;
                }
                this.f10926d.m17051a();
                this.f10927e.m17051a();
                this.f10929g.m17051a();
                this.f10928f.m17051a();
                z2 = true;
            }
        }
        return z2;
    }

    public efm<TResult> m16927b(dzm<? super TResult> com_ushareit_listenit_dzm__super_TResult) {
        cfi.m11080a((Object) com_ushareit_listenit_dzm__super_TResult);
        this.f10926d.m17052a(null, null, com_ushareit_listenit_dzm__super_TResult);
        return this;
    }

    public efm<TResult> m16928b(Executor executor, dzl com_ushareit_listenit_dzl) {
        cfi.m11080a((Object) com_ushareit_listenit_dzl);
        cfi.m11080a((Object) executor);
        this.f10927e.m17052a(null, executor, com_ushareit_listenit_dzl);
        return this;
    }

    public efm<TResult> m16929b(Executor executor, dzm<? super TResult> com_ushareit_listenit_dzm__super_TResult) {
        cfi.m11080a((Object) executor);
        cfi.m11080a((Object) com_ushareit_listenit_dzm__super_TResult);
        this.f10926d.m17052a(null, executor, com_ushareit_listenit_dzm__super_TResult);
        return this;
    }

    public boolean mo2130b() {
        return (m16940m() & 128) != 0;
    }

    public /* synthetic */ Object mo2131c() {
        return m16939l();
    }

    public Exception mo2132d() {
        return mo2152g() == null ? null : mo2152g().mo2156a();
    }

    abstract efl mo2150e();

    abstract void mo2151f();

    abstract void mo2153h();

    protected void mo2154i() {
    }

    abstract TResult mo2155j();

    boolean m16938k() {
        if (!m16926a(2, false)) {
            return false;
        }
        mo2151f();
        return true;
    }

    public TResult m16939l() {
        if (mo2152g() == null) {
            throw new IllegalStateException();
        }
        Throwable a = mo2152g().mo2156a();
        if (a == null) {
            return mo2152g();
        }
        throw new dzn(a);
    }

    int m16940m() {
        return this.f10930h;
    }

    Object m16941n() {
        return this.f10925a;
    }

    TResult m16942o() {
        TResult j;
        synchronized (this.f10925a) {
            j = mo2155j();
        }
        return j;
    }

    protected void m16943p() {
    }

    protected void m16944q() {
    }

    protected void m16945r() {
    }

    protected void m16946s() {
    }

    protected void m16947t() {
    }

    Runnable m16948u() {
        return new efr(this);
    }
}
