package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Pair;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class esa {
    private Context f11665a;
    private esp f11666b = null;
    private List<esj> f11667c = null;
    private erz f11668d = new erz();
    private AtomicBoolean f11669e = new AtomicBoolean(false);
    private eyn f11670f = null;
    private final eyn f11671g = new eyn(Boolean.valueOf(false), true, 10000);
    private AtomicBoolean f11672h = new AtomicBoolean(false);
    private BroadcastReceiver f11673i = new esb(this);

    public esa(Context context) {
        this.f11665a = context;
    }

    public void m17693a(Context context) {
        this.f11665a = context;
    }

    public Context m17691a() {
        return this.f11665a;
    }

    public void m17694a(esp com_ushareit_listenit_esp) {
        this.f11666b = com_ushareit_listenit_esp;
    }

    public List<esj> m17695b() {
        if (this.f11667c == null) {
            this.f11667c = this.f11666b.mo2359a(this);
        }
        return this.f11667c;
    }

    public erz m17697c() {
        return this.f11668d;
    }

    public Pair<Boolean, Boolean> m17698d() {
        return m17692a(false);
    }

    public Pair<Boolean, Boolean> m17692a(boolean z) {
        if (this.f11670f == null) {
            this.f11670f = new eyn(eyw.m18568a(this.f11665a), false, 1000);
        } else if (z || this.f11670f.m18556a()) {
            this.f11670f.m18555a(eyw.m18568a(this.f11665a));
        }
        return this.f11670f.m18559d();
    }

    public boolean m17699e() {
        return m17696b(false);
    }

    public boolean m17696b(boolean z) {
        Pair a = m17692a(z);
        return ((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue();
    }

    Boolean m17700f() {
        Pair a = m17692a(true);
        if (!euo.m18017a(this.f11665a, "ad_chk_reachable", true)) {
            boolean z;
            if (((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        } else if (((Boolean) a.first).booleanValue()) {
            return Boolean.valueOf(true);
        } else {
            if (!((Boolean) a.second).booleanValue()) {
                return Boolean.valueOf(false);
            }
            if (this.f11671g.m18556a()) {
                return null;
            }
            return this.f11671g.m18557b();
        }
    }

    boolean m17701g() {
        boolean booleanValue;
        synchronized (this.f11671g) {
            if (this.f11671g.m18556a()) {
                this.f11671g.m18555a(Boolean.valueOf(m17690j()));
            }
            booleanValue = this.f11671g.m18557b().booleanValue();
        }
        return booleanValue;
    }

    private boolean m17690j() {
        boolean a = eyw.m18569a();
        esh.m17764a(this.f11665a, a);
        return a;
    }

    public void m17702h() {
        if (this.f11669e.compareAndSet(false, true)) {
            try {
                this.f11672h.set(true);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.f11665a.registerReceiver(this.f11673i, intentFilter);
                exw.m18449b("AD.Context", "registerNetListener");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m17703i() {
        if (this.f11669e.compareAndSet(true, false)) {
            try {
                this.f11665a.unregisterReceiver(this.f11673i);
                exw.m18449b("AD.Context", "unregisterNetListener");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
