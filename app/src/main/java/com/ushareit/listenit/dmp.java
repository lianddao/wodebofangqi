package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.SignInResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class dmp implements dni {
    private final dnj f9935a;
    private final Lock f9936b;
    private final Context f9937c;
    private final cjb f9938d;
    private ConnectionResult f9939e;
    private int f9940f;
    private int f9941g = 0;
    private int f9942h;
    private final Bundle f9943i = new Bundle();
    private final Set<cdr> f9944j = new HashSet();
    private dsb f9945k;
    private int f9946l;
    private boolean f9947m;
    private boolean f9948n;
    private chm f9949o;
    private boolean f9950p;
    private boolean f9951q;
    private final cgs f9952r;
    private final Map<cdj<?>, Integer> f9953s;
    private final cdp<? extends dsb, dsc> f9954t;
    private ArrayList<Future<?>> f9955u = new ArrayList();

    public dmp(dnj com_ushareit_listenit_dnj, cgs com_ushareit_listenit_cgs, Map<cdj<?>, Integer> map, cjb com_ushareit_listenit_cjb, cdp<? extends dsb, dsc> com_ushareit_listenit_cdp__extends_com_ushareit_listenit_dsb__com_ushareit_listenit_dsc, Lock lock, Context context) {
        this.f9935a = com_ushareit_listenit_dnj;
        this.f9952r = com_ushareit_listenit_cgs;
        this.f9953s = map;
        this.f9938d = com_ushareit_listenit_cjb;
        this.f9954t = com_ushareit_listenit_cdp__extends_com_ushareit_listenit_dsb__com_ushareit_listenit_dsc;
        this.f9936b = lock;
        this.f9937c = context;
    }

    private void m14921a(SignInResponse signInResponse) {
        if (m14931b(0)) {
            ConnectionResult a = signInResponse.m2460a();
            if (a.m2235b()) {
                ResolveAccountResponse b = signInResponse.m2461b();
                ConnectionResult b2 = b.m2283b();
                if (b2.m2235b()) {
                    this.f9948n = true;
                    this.f9949o = b.m2282a();
                    this.f9950p = b.m2284c();
                    this.f9951q = b.m2285d();
                    m14939e();
                    return;
                }
                String valueOf = String.valueOf(b2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                m14936c(b2);
            } else if (m14932b(a)) {
                m14946h();
                m14939e();
            } else {
                m14936c(a);
            }
        }
    }

    private void m14925a(boolean z) {
        if (this.f9945k != null) {
            if (this.f9945k.m10644h() && z) {
                this.f9945k.mo1281f();
            }
            this.f9945k.mo2075g();
            this.f9949o = null;
        }
    }

    private boolean m14926a(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || m14927a(connectionResult)) ? this.f9939e == null || i < this.f9940f : false;
    }

    private boolean m14927a(ConnectionResult connectionResult) {
        return connectionResult.m2234a() || this.f9938d.mo1294b(connectionResult.m2236c()) != null;
    }

    private void m14930b(ConnectionResult connectionResult, cdj<?> com_ushareit_listenit_cdj_, int i) {
        if (i != 2) {
            int a = com_ushareit_listenit_cdj_.m10908a().m10569a();
            if (m14926a(a, i, connectionResult)) {
                this.f9939e = connectionResult;
                this.f9940f = a;
            }
        }
        this.f9935a.f10012b.put(com_ushareit_listenit_cdj_.m10911d(), connectionResult);
    }

    private boolean m14931b(int i) {
        if (this.f9941g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f9935a.f10017g.m15032p());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", "mRemainingConnections=" + this.f9942h);
        valueOf = String.valueOf(m14934c(this.f9941g));
        String valueOf2 = String.valueOf(m14934c(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("GoogleApiClient connecting is in step ").append(valueOf).append(" but received callback for step ").append(valueOf2).toString(), new Exception());
        m14936c(new ConnectionResult(8, null));
        return false;
    }

    private boolean m14932b(ConnectionResult connectionResult) {
        return this.f9946l != 2 ? this.f9946l == 1 && !connectionResult.m2234a() : true;
    }

    private String m14934c(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void m14936c(ConnectionResult connectionResult) {
        m14947i();
        m14925a(!connectionResult.m2234a());
        this.f9935a.m15048a(connectionResult);
        this.f9935a.f10018h.mo1970a(connectionResult);
    }

    private boolean m14938d() {
        this.f9942h--;
        if (this.f9942h > 0) {
            return false;
        }
        if (this.f9942h < 0) {
            Log.w("GoogleApiClientConnecting", this.f9935a.f10017g.m15032p());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m14936c(new ConnectionResult(8, null));
            return false;
        } else if (this.f9939e == null) {
            return true;
        } else {
            this.f9935a.f10016f = this.f9940f;
            m14936c(this.f9939e);
            return false;
        }
    }

    private void m14939e() {
        if (this.f9942h == 0) {
            if (!this.f9947m || this.f9948n) {
                m14942f();
            }
        }
    }

    private void m14942f() {
        ArrayList arrayList = new ArrayList();
        this.f9941g = 1;
        this.f9942h = this.f9935a.f10011a.size();
        for (cdr com_ushareit_listenit_cdr : this.f9935a.f10011a.keySet()) {
            if (!this.f9935a.f10012b.containsKey(com_ushareit_listenit_cdr)) {
                arrayList.add((cdt) this.f9935a.f10011a.get(com_ushareit_listenit_cdr));
            } else if (m14938d()) {
                m14944g();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f9955u.add(dnm.m15064a().submit(new dmv(this, arrayList)));
        }
    }

    private void m14944g() {
        this.f9935a.m15061h();
        dnm.m15064a().execute(new dmq(this));
        if (this.f9945k != null) {
            if (this.f9950p) {
                this.f9945k.mo2120a(this.f9949o, this.f9951q);
            }
            m14925a(false);
        }
        for (cdr com_ushareit_listenit_cdr : this.f9935a.f10012b.keySet()) {
            ((cdt) this.f9935a.f10011a.get(com_ushareit_listenit_cdr)).mo2075g();
        }
        this.f9935a.f10018h.mo1969a(this.f9943i.isEmpty() ? null : this.f9943i);
    }

    private void m14946h() {
        this.f9947m = false;
        this.f9935a.f10017g.f9978d = Collections.emptySet();
        for (cdr com_ushareit_listenit_cdr : this.f9944j) {
            if (!this.f9935a.f10012b.containsKey(com_ushareit_listenit_cdr)) {
                this.f9935a.f10012b.put(com_ushareit_listenit_cdr, new ConnectionResult(17, null));
            }
        }
    }

    private void m14947i() {
        Iterator it = this.f9955u.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f9955u.clear();
    }

    private Set<Scope> m14949j() {
        if (this.f9952r == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.f9952r.m11183d());
        Map f = this.f9952r.m11185f();
        for (cdj com_ushareit_listenit_cdj : f.keySet()) {
            if (!this.f9935a.f10012b.containsKey(com_ushareit_listenit_cdj.m10911d())) {
                hashSet.addAll(((cgt) f.get(com_ushareit_listenit_cdj)).f8270a);
            }
        }
        return hashSet;
    }

    public <A extends cdq, R extends ceg, T extends dlu<R, A>> T mo1981a(T t) {
        this.f9935a.f10017g.f9975a.add(t);
        return t;
    }

    public void mo1982a() {
        this.f9935a.f10012b.clear();
        this.f9947m = false;
        this.f9939e = null;
        this.f9941g = 0;
        this.f9946l = 2;
        this.f9948n = false;
        this.f9950p = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (cdj com_ushareit_listenit_cdj : this.f9953s.keySet()) {
            cdt com_ushareit_listenit_cdt = (cdt) this.f9935a.f10011a.get(com_ushareit_listenit_cdj.m10911d());
            int intValue = ((Integer) this.f9953s.get(com_ushareit_listenit_cdj)).intValue();
            int i2 = (com_ushareit_listenit_cdj.m10908a().m10569a() == 1 ? 1 : 0) | i;
            if (com_ushareit_listenit_cdt.mo1936j()) {
                this.f9947m = true;
                if (intValue < this.f9946l) {
                    this.f9946l = intValue;
                }
                if (intValue != 0) {
                    this.f9944j.add(com_ushareit_listenit_cdj.m10911d());
                }
            }
            hashMap.put(com_ushareit_listenit_cdt, new dmr(this, com_ushareit_listenit_cdj, intValue));
            i = i2;
        }
        if (i != 0) {
            this.f9947m = false;
        }
        if (this.f9947m) {
            this.f9952r.m11180a(Integer.valueOf(this.f9935a.f10017g.m15033q()));
            ceb com_ushareit_listenit_dmy = new dmy();
            this.f9945k = (dsb) this.f9954t.mo1238a(this.f9937c, this.f9935a.f10017g.mo2004c(), this.f9952r, this.f9952r.m11188i(), com_ushareit_listenit_dmy, com_ushareit_listenit_dmy);
        }
        this.f9942h = this.f9935a.f10011a.size();
        this.f9955u.add(dnm.m15064a().submit(new dms(this, hashMap)));
    }

    public void mo1983a(int i) {
        m14936c(new ConnectionResult(8, null));
    }

    public void mo1984a(Bundle bundle) {
        if (m14931b(1)) {
            if (bundle != null) {
                this.f9943i.putAll(bundle);
            }
            if (m14938d()) {
                m14944g();
            }
        }
    }

    public void mo1985a(ConnectionResult connectionResult, cdj<?> com_ushareit_listenit_cdj_, int i) {
        if (m14931b(1)) {
            m14930b(connectionResult, com_ushareit_listenit_cdj_, i);
            if (m14938d()) {
                m14944g();
            }
        }
    }

    public <A extends cdq, T extends dlu<? extends ceg, A>> T mo1986b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public boolean mo1987b() {
        m14947i();
        m14925a(true);
        this.f9935a.m15048a(null);
        return true;
    }

    public void mo1988c() {
    }
}
