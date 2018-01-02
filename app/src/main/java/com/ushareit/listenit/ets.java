package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ets {
    private Context f11836a;
    private BroadcastReceiver f11837b = null;
    private eud f11838c;
    private etq f11839d;
    private int f11840e;
    private ety f11841f;
    private boolean f11842g;
    private ExecutorService f11843h;
    private ExecutorService f11844i;

    public ets(Context context) {
        this.f11836a = context;
        this.f11838c = eud.m17974a(this.f11836a);
        etr.m17940a(this.f11838c);
        this.f11841f = new ety(this.f11836a);
        this.f11842g = false;
        this.f11843h = Executors.newSingleThreadExecutor();
        this.f11844i = Executors.newSingleThreadExecutor();
        this.f11837b = new ett(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (this.f11836a != null) {
            this.f11836a.registerReceiver(this.f11837b, intentFilter);
        }
    }

    public void m17954a(eto com_ushareit_listenit_eto) {
        if (com_ushareit_listenit_eto.m17910c() == etp.UnhandledException) {
            m17949b(com_ushareit_listenit_eto);
            m17951c(eua.UNHANDLE_EXCEPTION_EVENT);
            return;
        }
        this.f11843h.submit(new etu(this, com_ushareit_listenit_eto));
    }

    public void m17955a(eua com_ushareit_listenit_eua) {
        this.f11843h.submit(new etv(this, com_ushareit_listenit_eua));
    }

    public boolean m17956b(eua com_ushareit_listenit_eua) {
        return m17951c(com_ushareit_listenit_eua);
    }

    public void m17953a() {
        exw.m18443a("BeylaManager", "beyla manager will be destory!");
        this.f11843h.shutdownNow();
        this.f11844i.shutdownNow();
        if (this.f11836a != null) {
            this.f11836a.unregisterReceiver(this.f11837b);
        }
        eud.m17978b();
    }

    private etq m17943a(String str) {
        String a = euh.m18003a(this.f11836a, faj.MAC);
        Locale locale = Locale.getDefault();
        etq com_ushareit_listenit_etq = new etq(a, str, locale.getLanguage(), locale.getCountry());
        exw.m18443a("BeylaManager", "create new header entity:" + com_ushareit_listenit_etq.toString());
        this.f11838c.m17982a(com_ushareit_listenit_etq);
        this.f11840e = 1;
        return com_ushareit_listenit_etq;
    }

    private synchronized void m17949b(eto com_ushareit_listenit_eto) {
        exu.m18430a((Object) com_ushareit_listenit_eto);
        if (this.f11839d == null) {
            this.f11839d = m17943a(fbb.m18749a());
        } else {
            int i = this.f11840e + 1;
            this.f11840e = i;
            if (i > 1024) {
                this.f11839d = m17943a(this.f11839d.m17923d());
            } else if (com_ushareit_listenit_eto.m17910c() == etp.PageIn && com_ushareit_listenit_eto.m17914g() > 30000) {
                this.f11839d = m17943a(fbb.m18749a());
            }
        }
        com_ushareit_listenit_eto.m17908a(this.f11839d.m17922c());
        this.f11838c.m17981a(com_ushareit_listenit_eto);
    }

    private synchronized boolean m17951c(eua com_ushareit_listenit_eua) {
        boolean z = true;
        synchronized (this) {
            this.f11841f.m17957a(com_ushareit_listenit_eua);
            if (this.f11842g || !this.f11841f.m17959a()) {
                z = false;
            } else {
                this.f11839d = m17943a(this.f11839d == null ? fbb.m18749a() : this.f11839d.m17923d());
                this.f11842g = true;
                this.f11844i.submit(new etw(this));
            }
        }
        return z;
    }
}
