package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class dnj implements dmf, doa {
    final Map<cdr<?>, cdt> f10011a;
    final Map<cdr<?>, ConnectionResult> f10012b = new HashMap();
    final cgs f10013c;
    final Map<cdj<?>, Integer> f10014d;
    final cdp<? extends dsb, dsc> f10015e;
    int f10016f;
    final dnb f10017g;
    final dob f10018h;
    private final Lock f10019i;
    private final Condition f10020j;
    private final Context f10021k;
    private final cjb f10022l;
    private final dnl f10023m;
    private volatile dni f10024n;
    private ConnectionResult f10025o = null;

    public dnj(Context context, dnb com_ushareit_listenit_dnb, Lock lock, Looper looper, cjb com_ushareit_listenit_cjb, Map<cdr<?>, cdt> map, cgs com_ushareit_listenit_cgs, Map<cdj<?>, Integer> map2, cdp<? extends dsb, dsc> com_ushareit_listenit_cdp__extends_com_ushareit_listenit_dsb__com_ushareit_listenit_dsc, ArrayList<dme> arrayList, dob com_ushareit_listenit_dob) {
        this.f10021k = context;
        this.f10019i = lock;
        this.f10022l = com_ushareit_listenit_cjb;
        this.f10011a = map;
        this.f10013c = com_ushareit_listenit_cgs;
        this.f10014d = map2;
        this.f10015e = com_ushareit_listenit_cdp__extends_com_ushareit_listenit_dsb__com_ushareit_listenit_dsc;
        this.f10017g = com_ushareit_listenit_dnb;
        this.f10018h = com_ushareit_listenit_dob;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((dme) it.next()).m14828a((dmf) this);
        }
        this.f10023m = new dnl(this, looper);
        this.f10020j = lock.newCondition();
        this.f10024n = new dna(this);
    }

    public <A extends cdq, R extends ceg, T extends dlu<R, A>> T mo1958a(T t) {
        t.m10800i();
        return this.f10024n.mo1981a((dlu) t);
    }

    public void mo1959a() {
        this.f10024n.mo1988c();
    }

    public void mo1956a(int i) {
        this.f10019i.lock();
        try {
            this.f10024n.mo1983a(i);
        } finally {
            this.f10019i.unlock();
        }
    }

    public void mo1957a(Bundle bundle) {
        this.f10019i.lock();
        try {
            this.f10024n.mo1984a(bundle);
        } finally {
            this.f10019i.unlock();
        }
    }

    void m15048a(ConnectionResult connectionResult) {
        this.f10019i.lock();
        try {
            this.f10025o = connectionResult;
            this.f10024n = new dna(this);
            this.f10024n.mo1982a();
            this.f10020j.signalAll();
        } finally {
            this.f10019i.unlock();
        }
    }

    public void mo2009a(ConnectionResult connectionResult, cdj<?> com_ushareit_listenit_cdj_, int i) {
        this.f10019i.lock();
        try {
            this.f10024n.mo1985a(connectionResult, com_ushareit_listenit_cdj_, i);
        } finally {
            this.f10019i.unlock();
        }
    }

    void m15050a(dnk com_ushareit_listenit_dnk) {
        this.f10023m.sendMessage(this.f10023m.obtainMessage(1, com_ushareit_listenit_dnk));
    }

    void m15051a(RuntimeException runtimeException) {
        this.f10023m.sendMessage(this.f10023m.obtainMessage(2, runtimeException));
    }

    public void mo1960a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f10024n);
        for (cdj com_ushareit_listenit_cdj : this.f10014d.keySet()) {
            printWriter.append(str).append(com_ushareit_listenit_cdj.m10913f()).println(":");
            ((cdt) this.f10011a.get(com_ushareit_listenit_cdj.m10911d())).m10640a(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public boolean mo1961a(doo com_ushareit_listenit_doo) {
        return false;
    }

    public ConnectionResult mo1962b() {
        mo1959a();
        while (m15063j()) {
            try {
                this.f10020j.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return mo1965d() ? ConnectionResult.f1674a : this.f10025o != null ? this.f10025o : new ConnectionResult(13, null);
    }

    public <A extends cdq, T extends dlu<? extends ceg, A>> T mo1963b(T t) {
        t.m10800i();
        return this.f10024n.mo1986b(t);
    }

    public void mo1964c() {
        if (this.f10024n.mo1987b()) {
            this.f10012b.clear();
        }
    }

    public boolean mo1965d() {
        return this.f10024n instanceof dmm;
    }

    void m15058e() {
        this.f10019i.lock();
        try {
            this.f10024n = new dmp(this, this.f10013c, this.f10014d, this.f10022l, this.f10015e, this.f10019i, this.f10021k);
            this.f10024n.mo1982a();
            this.f10020j.signalAll();
        } finally {
            this.f10019i.unlock();
        }
    }

    public void mo1966f() {
        if (mo1965d()) {
            ((dmm) this.f10024n).m14915d();
        }
    }

    public void mo1967g() {
    }

    void m15061h() {
        this.f10019i.lock();
        try {
            this.f10017g.m15030n();
            this.f10024n = new dmm(this);
            this.f10024n.mo1982a();
            this.f10020j.signalAll();
        } finally {
            this.f10019i.unlock();
        }
    }

    void m15062i() {
        for (cdt g : this.f10011a.values()) {
            g.mo2075g();
        }
    }

    public boolean m15063j() {
        return this.f10024n instanceof dmp;
    }
}
