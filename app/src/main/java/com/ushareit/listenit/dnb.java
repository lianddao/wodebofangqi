package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class dnb extends cdz implements dob {
    final Queue<dlu<?, ?>> f9975a = new LinkedList();
    dnu f9976b;
    final Map<cdr<?>, cdt> f9977c;
    Set<Scope> f9978d = new HashSet();
    final cgs f9979e;
    final Map<cdj<?>, Integer> f9980f;
    final cdp<? extends dsb, dsc> f9981g;
    Set<dot> f9982h = null;
    final dow f9983i;
    private final Lock f9984j;
    private final chd f9985k;
    private doa f9986l = null;
    private final int f9987m;
    private final Context f9988n;
    private final Looper f9989o;
    private volatile boolean f9990p;
    private long f9991q = 120000;
    private long f9992r = 5000;
    private final dng f9993s;
    private final cdd f9994t;
    private final doj f9995u = new doj();
    private final ArrayList<dme> f9996v;
    private Integer f9997w = null;
    private final che f9998x = new dnc(this);

    public dnb(Context context, Lock lock, Looper looper, cgs com_ushareit_listenit_cgs, cdd com_ushareit_listenit_cdd, cdp<? extends dsb, dsc> com_ushareit_listenit_cdp__extends_com_ushareit_listenit_dsb__com_ushareit_listenit_dsc, Map<cdj<?>, Integer> map, List<ceb> list, List<cec> list2, Map<cdr<?>, cdt> map2, int i, int i2, ArrayList<dme> arrayList) {
        this.f9988n = context;
        this.f9984j = lock;
        this.f9985k = new chd(looper, this.f9998x);
        this.f9989o = looper;
        this.f9993s = new dng(this, looper);
        this.f9994t = com_ushareit_listenit_cdd;
        this.f9987m = i;
        if (this.f9987m >= 0) {
            this.f9997w = Integer.valueOf(i2);
        }
        this.f9980f = map;
        this.f9977c = map2;
        this.f9996v = arrayList;
        this.f9983i = new dow(this.f9977c);
        for (ceb a : list) {
            this.f9985k.m11216a(a);
        }
        for (cec a2 : list2) {
            this.f9985k.m11217a(a2);
        }
        this.f9979e = com_ushareit_listenit_cgs;
        this.f9981g = com_ushareit_listenit_cdp__extends_com_ushareit_listenit_dsb__com_ushareit_listenit_dsc;
    }

    public static int m14992a(Iterable<cdt> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (cdt com_ushareit_listenit_cdt : iterable) {
            if (com_ushareit_listenit_cdt.mo1936j()) {
                i2 = 1;
            }
            i = com_ushareit_listenit_cdt.mo1279d() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    private void m14993a(cdz com_ushareit_listenit_cdz, dop com_ushareit_listenit_dop, boolean z) {
        dpj.f10134c.mo2019a(com_ushareit_listenit_cdz).mo1272a(new dnf(this, com_ushareit_listenit_dop, z, com_ushareit_listenit_cdz));
    }

    static String m14996b(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void m14999c(int i) {
        if (this.f9997w == null) {
            this.f9997w = Integer.valueOf(i);
        } else if (this.f9997w.intValue() != i) {
            String valueOf = String.valueOf(m14996b(i));
            String valueOf2 = String.valueOf(m14996b(this.f9997w.intValue()));
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.f9986l == null) {
            Object obj = null;
            Object obj2 = null;
            for (cdt com_ushareit_listenit_cdt : this.f9977c.values()) {
                if (com_ushareit_listenit_cdt.mo1936j()) {
                    obj2 = 1;
                }
                obj = com_ushareit_listenit_cdt.mo1279d() ? 1 : obj;
            }
            switch (this.f9997w.intValue()) {
                case 1:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (obj2 != null) {
                        this.f9986l = dmg.m14841a(this.f9988n, this, this.f9984j, this.f9989o, this.f9994t, this.f9977c, this.f9979e, this.f9980f, this.f9981g, this.f9996v);
                        return;
                    }
                    break;
            }
            this.f9986l = new dnj(this.f9988n, this, this.f9984j, this.f9989o, this.f9994t, this.f9977c, this.f9979e, this.f9980f, this.f9981g, this.f9996v, this);
        }
    }

    private void m15000r() {
        this.f9985k.m11218b();
        this.f9986l.mo1959a();
    }

    private void m15001s() {
        this.f9984j.lock();
        try {
            if (m15028l()) {
                m15000r();
            }
            this.f9984j.unlock();
        } catch (Throwable th) {
            this.f9984j.unlock();
        }
    }

    private void m15002t() {
        this.f9984j.lock();
        try {
            if (m15030n()) {
                m15000r();
            }
            this.f9984j.unlock();
        } catch (Throwable th) {
            this.f9984j.unlock();
        }
    }

    public <C extends cdt> C mo1996a(cdr<C> com_ushareit_listenit_cdr_C) {
        Object obj = (cdt) this.f9977c.get(com_ushareit_listenit_cdr_C);
        cfi.m11081a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends cdq, R extends ceg, T extends dlu<R, A>> T mo1997a(T t) {
        cfi.m11090b(t.mo1275b() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f9977c.containsKey(t.mo1275b());
        String f = t.mo1276c() != null ? t.mo1276c().m10913f() : "the API";
        cfi.m11090b(containsKey, new StringBuilder(String.valueOf(f).length() + 65).append("GoogleApiClient is not configured to use ").append(f).append(" required for this call.").toString());
        this.f9984j.lock();
        try {
            if (this.f9986l == null) {
                this.f9975a.add(t);
            } else {
                t = this.f9986l.mo1958a((dlu) t);
                this.f9984j.unlock();
            }
            return t;
        } finally {
            this.f9984j.unlock();
        }
    }

    public void mo1998a(int i) {
        boolean z = true;
        this.f9984j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            cfi.m11090b(z, "Illegal sign-in mode: " + i);
            m14999c(i);
            m15000r();
        } finally {
            this.f9984j.unlock();
        }
    }

    public void mo1968a(int i, boolean z) {
        if (i == 1 && !z) {
            m15029m();
        }
        this.f9983i.m15209b();
        this.f9985k.m11213a(i);
        this.f9985k.m11212a();
        if (i == 2) {
            m15000r();
        }
    }

    public void mo1969a(Bundle bundle) {
        while (!this.f9975a.isEmpty()) {
            mo2002b((dlu) this.f9975a.remove());
        }
        this.f9985k.m11214a(bundle);
    }

    public void mo1970a(ConnectionResult connectionResult) {
        if (!this.f9994t.mo1292a(this.f9988n, connectionResult.m2236c())) {
            m15030n();
        }
        if (!m15028l()) {
            this.f9985k.m11215a(connectionResult);
            this.f9985k.m11212a();
        }
    }

    public void mo1971a(ceb com_ushareit_listenit_ceb) {
        this.f9985k.m11216a(com_ushareit_listenit_ceb);
    }

    public void mo1972a(cec com_ushareit_listenit_cec) {
        this.f9985k.m11217a(com_ushareit_listenit_cec);
    }

    public void mo1999a(dot com_ushareit_listenit_dot) {
        this.f9984j.lock();
        try {
            if (this.f9982h == null) {
                this.f9982h = new HashSet();
            }
            this.f9982h.add(com_ushareit_listenit_dot);
        } finally {
            this.f9984j.unlock();
        }
    }

    public void mo1973a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f9988n);
        printWriter.append(str).append("mResuming=").print(this.f9990p);
        printWriter.append(" mWorkQueue.size()=").print(this.f9975a.size());
        this.f9983i.m15208a(printWriter);
        if (this.f9986l != null) {
            this.f9986l.mo1960a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public boolean mo2000a(doo com_ushareit_listenit_doo) {
        return this.f9986l != null && this.f9986l.mo1961a(com_ushareit_listenit_doo);
    }

    public Context mo2001b() {
        return this.f9988n;
    }

    <C extends cdt> C m15015b(cdr<?> com_ushareit_listenit_cdr_) {
        Object obj = (cdt) this.f9977c.get(com_ushareit_listenit_cdr_);
        cfi.m11081a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends cdq, T extends dlu<? extends ceg, A>> T mo2002b(T t) {
        cfi.m11090b(t.mo1275b() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f9977c.containsKey(t.mo1275b());
        String f = t.mo1276c() != null ? t.mo1276c().m10913f() : "the API";
        cfi.m11090b(containsKey, new StringBuilder(String.valueOf(f).length() + 65).append("GoogleApiClient is not configured to use ").append(f).append(" required for this call.").toString());
        this.f9984j.lock();
        try {
            if (this.f9986l == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (m15028l()) {
                this.f9975a.add(t);
                while (!this.f9975a.isEmpty()) {
                    dma com_ushareit_listenit_dma = (dlu) this.f9975a.remove();
                    this.f9983i.m15206a(com_ushareit_listenit_dma);
                    com_ushareit_listenit_dma.m10810c(Status.f1688c);
                }
            } else {
                t = this.f9986l.mo1963b(t);
                this.f9984j.unlock();
            }
            return t;
        } finally {
            this.f9984j.unlock();
        }
    }

    public void mo1974b(ceb com_ushareit_listenit_ceb) {
        this.f9985k.m11219b(com_ushareit_listenit_ceb);
    }

    public void mo1975b(cec com_ushareit_listenit_cec) {
        this.f9985k.m11220b(com_ushareit_listenit_cec);
    }

    public void mo2003b(dot com_ushareit_listenit_dot) {
        this.f9984j.lock();
        try {
            if (this.f9982h == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f9982h.remove(com_ushareit_listenit_dot)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!m15031o()) {
                this.f9986l.mo1966f();
            }
            this.f9984j.unlock();
        } catch (Throwable th) {
            this.f9984j.unlock();
        }
    }

    public Looper mo2004c() {
        return this.f9989o;
    }

    public void mo2005d() {
        if (this.f9986l != null) {
            this.f9986l.mo1967g();
        }
    }

    public void mo1976e() {
        boolean z = false;
        this.f9984j.lock();
        try {
            if (this.f9987m >= 0) {
                if (this.f9997w != null) {
                    z = true;
                }
                cfi.m11086a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f9997w == null) {
                this.f9997w = Integer.valueOf(m14992a(this.f9977c.values(), false));
            } else if (this.f9997w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            mo1998a(this.f9997w.intValue());
        } finally {
            this.f9984j.unlock();
        }
    }

    public ConnectionResult mo1977f() {
        boolean z = true;
        cfi.m11086a(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.f9984j.lock();
        try {
            if (this.f9987m >= 0) {
                if (this.f9997w == null) {
                    z = false;
                }
                cfi.m11086a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f9997w == null) {
                this.f9997w = Integer.valueOf(m14992a(this.f9977c.values(), false));
            } else if (this.f9997w.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m14999c(this.f9997w.intValue());
            this.f9985k.m11218b();
            ConnectionResult b = this.f9986l.mo1962b();
            return b;
        } finally {
            this.f9984j.unlock();
        }
    }

    public void mo1978g() {
        this.f9984j.lock();
        try {
            this.f9983i.m15205a();
            if (this.f9986l != null) {
                this.f9986l.mo1964c();
            }
            this.f9995u.m15163a();
            for (dlu com_ushareit_listenit_dlu : this.f9975a) {
                com_ushareit_listenit_dlu.m10791a(null);
                com_ushareit_listenit_dlu.m10796e();
            }
            this.f9975a.clear();
            if (this.f9986l != null) {
                m15030n();
                this.f9985k.m11212a();
                this.f9984j.unlock();
            }
        } finally {
            this.f9984j.unlock();
        }
    }

    public ced<Status> mo1979h() {
        cfi.m11086a(mo1980i(), (Object) "GoogleApiClient is not connected yet.");
        cfi.m11086a(this.f9997w.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        ced com_ushareit_listenit_dop = new dop(this);
        if (this.f9977c.containsKey(dpj.f10132a)) {
            m14993a(this, com_ushareit_listenit_dop, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            cdz b = new cea(this.f9988n).m10955a(dpj.f10133b).m10957a(new dnd(this, atomicReference, com_ushareit_listenit_dop)).m10958a(new dne(this, com_ushareit_listenit_dop)).m10954a(this.f9993s).m10960b();
            atomicReference.set(b);
            b.mo1976e();
        }
        return com_ushareit_listenit_dop;
    }

    public boolean mo1980i() {
        return this.f9986l != null && this.f9986l.mo1965d();
    }

    public void m15027k() {
        mo1978g();
        mo1976e();
    }

    boolean m15028l() {
        return this.f9990p;
    }

    void m15029m() {
        if (!m15028l()) {
            this.f9990p = true;
            if (this.f9976b == null) {
                this.f9976b = this.f9994t.m10896a(this.f9988n.getApplicationContext(), new dnh(this));
            }
            this.f9993s.sendMessageDelayed(this.f9993s.obtainMessage(1), this.f9991q);
            this.f9993s.sendMessageDelayed(this.f9993s.obtainMessage(2), this.f9992r);
        }
    }

    boolean m15030n() {
        if (!m15028l()) {
            return false;
        }
        this.f9990p = false;
        this.f9993s.removeMessages(2);
        this.f9993s.removeMessages(1);
        if (this.f9976b != null) {
            this.f9976b.m15137a();
            this.f9976b = null;
        }
        return true;
    }

    boolean m15031o() {
        boolean z = false;
        this.f9984j.lock();
        try {
            if (this.f9982h != null) {
                if (!this.f9982h.isEmpty()) {
                    z = true;
                }
                this.f9984j.unlock();
            }
            return z;
        } finally {
            this.f9984j.unlock();
        }
    }

    String m15032p() {
        Writer stringWriter = new StringWriter();
        mo1973a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public int m15033q() {
        return System.identityHashCode(this);
    }
}
