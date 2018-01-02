package com.ushareit.listenit;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class dmg implements doa {
    private final Context f9912a;
    private final dnb f9913b;
    private final Looper f9914c;
    private final dnj f9915d;
    private final dnj f9916e;
    private final Map<cdr<?>, dnj> f9917f;
    private final Set<doo> f9918g = Collections.newSetFromMap(new WeakHashMap());
    private final cdt f9919h;
    private Bundle f9920i;
    private ConnectionResult f9921j = null;
    private ConnectionResult f9922k = null;
    private boolean f9923l = false;
    private final Lock f9924m;
    private int f9925n = 0;

    private dmg(Context context, dnb com_ushareit_listenit_dnb, Lock lock, Looper looper, cjb com_ushareit_listenit_cjb, Map<cdr<?>, cdt> map, Map<cdr<?>, cdt> map2, cgs com_ushareit_listenit_cgs, cdp<? extends dsb, dsc> com_ushareit_listenit_cdp__extends_com_ushareit_listenit_dsb__com_ushareit_listenit_dsc, cdt com_ushareit_listenit_cdt, ArrayList<dme> arrayList, ArrayList<dme> arrayList2, Map<cdj<?>, Integer> map3, Map<cdj<?>, Integer> map4) {
        this.f9912a = context;
        this.f9913b = com_ushareit_listenit_dnb;
        this.f9924m = lock;
        this.f9914c = looper;
        this.f9919h = com_ushareit_listenit_cdt;
        this.f9915d = new dnj(context, this.f9913b, lock, looper, com_ushareit_listenit_cjb, map2, null, map4, null, arrayList2, new dmi());
        this.f9916e = new dnj(context, this.f9913b, lock, looper, com_ushareit_listenit_cjb, map, com_ushareit_listenit_cgs, map3, com_ushareit_listenit_cdp__extends_com_ushareit_listenit_dsb__com_ushareit_listenit_dsc, arrayList, new dmj());
        Map fqVar = new fq();
        for (cdr put : map2.keySet()) {
            fqVar.put(put, this.f9915d);
        }
        for (cdr put2 : map.keySet()) {
            fqVar.put(put2, this.f9916e);
        }
        this.f9917f = Collections.unmodifiableMap(fqVar);
    }

    public static dmg m14841a(Context context, dnb com_ushareit_listenit_dnb, Lock lock, Looper looper, cjb com_ushareit_listenit_cjb, Map<cdr<?>, cdt> map, cgs com_ushareit_listenit_cgs, Map<cdj<?>, Integer> map2, cdp<? extends dsb, dsc> com_ushareit_listenit_cdp__extends_com_ushareit_listenit_dsb__com_ushareit_listenit_dsc, ArrayList<dme> arrayList) {
        cdt com_ushareit_listenit_cdt = null;
        Map fqVar = new fq();
        Map fqVar2 = new fq();
        for (Entry entry : map.entrySet()) {
            cdt com_ushareit_listenit_cdt2 = (cdt) entry.getValue();
            if (com_ushareit_listenit_cdt2.mo1279d()) {
                com_ushareit_listenit_cdt = com_ushareit_listenit_cdt2;
            }
            if (com_ushareit_listenit_cdt2.mo1936j()) {
                fqVar.put((cdr) entry.getKey(), com_ushareit_listenit_cdt2);
            } else {
                fqVar2.put((cdr) entry.getKey(), com_ushareit_listenit_cdt2);
            }
        }
        cfi.m11086a(!fqVar.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map fqVar3 = new fq();
        Map fqVar4 = new fq();
        for (cdj com_ushareit_listenit_cdj : map2.keySet()) {
            cdr d = com_ushareit_listenit_cdj.m10911d();
            if (fqVar.containsKey(d)) {
                fqVar3.put(com_ushareit_listenit_cdj, (Integer) map2.get(com_ushareit_listenit_cdj));
            } else if (fqVar2.containsKey(d)) {
                fqVar4.put(com_ushareit_listenit_cdj, (Integer) map2.get(com_ushareit_listenit_cdj));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            dme com_ushareit_listenit_dme = (dme) it.next();
            if (fqVar3.containsKey(com_ushareit_listenit_dme.f9909a)) {
                arrayList2.add(com_ushareit_listenit_dme);
            } else if (fqVar4.containsKey(com_ushareit_listenit_dme.f9909a)) {
                arrayList3.add(com_ushareit_listenit_dme);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        return new dmg(context, com_ushareit_listenit_dnb, lock, looper, com_ushareit_listenit_cjb, fqVar, fqVar2, com_ushareit_listenit_cgs, com_ushareit_listenit_cdp__extends_com_ushareit_listenit_dsb__com_ushareit_listenit_dsc, com_ushareit_listenit_cdt, arrayList2, arrayList3, fqVar3, fqVar4);
    }

    private void m14843a(int i, boolean z) {
        this.f9913b.mo1968a(i, z);
        this.f9922k = null;
        this.f9921j = null;
    }

    private void m14844a(Bundle bundle) {
        if (this.f9920i == null) {
            this.f9920i = bundle;
        } else if (bundle != null) {
            this.f9920i.putAll(bundle);
        }
    }

    private void m14845a(ConnectionResult connectionResult) {
        switch (this.f9925n) {
            case 1:
                break;
            case 2:
                this.f9913b.mo1970a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m14860l();
        this.f9925n = 0;
    }

    private static boolean m14851b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.m2235b();
    }

    private boolean m14852c(dlu<? extends ceg, ? extends cdq> com_ushareit_listenit_dlu__extends_com_ushareit_listenit_ceg___extends_com_ushareit_listenit_cdq) {
        cdr b = com_ushareit_listenit_dlu__extends_com_ushareit_listenit_ceg___extends_com_ushareit_listenit_cdq.mo1275b();
        cfi.m11090b(this.f9917f.containsKey(b), "GoogleApiClient is not configured to use the API required for this call.");
        return ((dnj) this.f9917f.get(b)).equals(this.f9916e);
    }

    private void m14857i() {
        this.f9922k = null;
        this.f9921j = null;
        this.f9915d.mo1959a();
        this.f9916e.mo1959a();
    }

    private void m14858j() {
        if (m14851b(this.f9921j)) {
            if (m14851b(this.f9922k) || m14861m()) {
                m14859k();
            } else if (this.f9922k == null) {
            } else {
                if (this.f9925n == 1) {
                    m14860l();
                    return;
                }
                m14845a(this.f9922k);
                this.f9915d.mo1964c();
            }
        } else if (this.f9921j != null && m14851b(this.f9922k)) {
            this.f9916e.mo1964c();
            m14845a(this.f9921j);
        } else if (this.f9921j != null && this.f9922k != null) {
            ConnectionResult connectionResult = this.f9921j;
            if (this.f9916e.f10016f < this.f9915d.f10016f) {
                connectionResult = this.f9922k;
            }
            m14845a(connectionResult);
        }
    }

    private void m14859k() {
        switch (this.f9925n) {
            case 1:
                break;
            case 2:
                this.f9913b.mo1969a(this.f9920i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        m14860l();
        this.f9925n = 0;
    }

    private void m14860l() {
        for (doo u : this.f9918g) {
            u.mo1266u();
        }
        this.f9918g.clear();
    }

    private boolean m14861m() {
        return this.f9922k != null && this.f9922k.m2236c() == 4;
    }

    private PendingIntent m14862n() {
        return this.f9919h == null ? null : PendingIntent.getActivity(this.f9912a, this.f9913b.m15033q(), this.f9919h.mo1280e(), 134217728);
    }

    public <A extends cdq, R extends ceg, T extends dlu<R, A>> T mo1958a(T t) {
        if (!m14852c((dlu) t)) {
            return this.f9915d.mo1958a((dlu) t);
        }
        if (!m14861m()) {
            return this.f9916e.mo1958a((dlu) t);
        }
        t.m10810c(new Status(4, null, m14862n()));
        return t;
    }

    public void mo1959a() {
        this.f9925n = 2;
        this.f9923l = false;
        m14857i();
    }

    public void mo1960a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f9916e.mo1960a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f9915d.mo1960a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public boolean mo1961a(doo com_ushareit_listenit_doo) {
        this.f9924m.lock();
        try {
            if ((m14871e() || mo1965d()) && !m14874h()) {
                this.f9918g.add(com_ushareit_listenit_doo);
                if (this.f9925n == 0) {
                    this.f9925n = 1;
                }
                this.f9922k = null;
                this.f9916e.mo1959a();
                return true;
            }
            this.f9924m.unlock();
            return false;
        } finally {
            this.f9924m.unlock();
        }
    }

    public ConnectionResult mo1962b() {
        throw new UnsupportedOperationException();
    }

    public <A extends cdq, T extends dlu<? extends ceg, A>> T mo1963b(T t) {
        if (!m14852c((dlu) t)) {
            return this.f9915d.mo1963b((dlu) t);
        }
        if (!m14861m()) {
            return this.f9916e.mo1963b((dlu) t);
        }
        t.m10810c(new Status(4, null, m14862n()));
        return t;
    }

    public void mo1964c() {
        this.f9922k = null;
        this.f9921j = null;
        this.f9925n = 0;
        this.f9915d.mo1964c();
        this.f9916e.mo1964c();
        m14860l();
    }

    public boolean mo1965d() {
        boolean z = true;
        this.f9924m.lock();
        try {
            if (!(this.f9915d.mo1965d() && (m14874h() || m14861m() || this.f9925n == 1))) {
                z = false;
            }
            this.f9924m.unlock();
            return z;
        } catch (Throwable th) {
            this.f9924m.unlock();
        }
    }

    public boolean m14871e() {
        this.f9924m.lock();
        try {
            boolean z = this.f9925n == 2;
            this.f9924m.unlock();
            return z;
        } catch (Throwable th) {
            this.f9924m.unlock();
        }
    }

    public void mo1966f() {
        this.f9915d.mo1966f();
        this.f9916e.mo1966f();
    }

    public void mo1967g() {
        this.f9924m.lock();
        try {
            boolean e = m14871e();
            this.f9916e.mo1964c();
            this.f9922k = new ConnectionResult(4);
            if (e) {
                new Handler(this.f9914c).post(new dmh(this));
            } else {
                m14860l();
            }
            this.f9924m.unlock();
        } catch (Throwable th) {
            this.f9924m.unlock();
        }
    }

    public boolean m14874h() {
        return this.f9916e.mo1965d();
    }
}
