package com.ushareit.listenit;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import com.facebook.appevents.C0075a;
import java.lang.ref.WeakReference;

public class ListenItApp extends C0348e {
    private WeakReference<gum> f3971a;
    private int f3972b;
    private ColorStateList f3973c;
    private boolean f3974d = false;
    private int f3975e = 0;
    private boolean f3976f = false;
    private boolean f3977g = false;

    public void onCreate() {
        super.onCreate();
        exw.m18442a("LI.");
        gyr.m23308a(getApplicationContext());
        fql.m20388a(this);
        eys.m18563a(this);
        if (fql.m20390b()) {
            eyb.m18466a();
        }
        esr.m17806a((Context) this, new fhz());
        exo.m18424a();
        m4928k();
        m4929l();
    }

    public void onConfigurationChanged(Configuration configuration) {
        gyr.m23308a(getApplicationContext());
        super.onConfigurationChanged(configuration);
    }

    private void m4928k() {
        this.f3972b = gvj.aa(this);
        this.f3973c = gzd.m23359b(gvj.ac(this));
    }

    public gum m4930a() {
        return this.f3971a != null ? (gum) this.f3971a.get() : null;
    }

    public void m4932a(gum com_ushareit_listenit_gum) {
        this.f3971a = new WeakReference(com_ushareit_listenit_gum);
    }

    public void m4931a(int i) {
        this.f3972b = i;
    }

    public int m4934b() {
        return this.f3972b;
    }

    public void m4935b(int i) {
        this.f3973c = gzd.m23359b(i);
    }

    public ColorStateList m4937c() {
        return this.f3973c;
    }

    public void m4933a(boolean z) {
        this.f3974d = z;
    }

    public boolean m4938d() {
        return this.f3974d;
    }

    public synchronized void m4939e() {
        if (m4943i()) {
            if (this.f3976f) {
                esr.m17825d(eys.m18562a());
                this.f3976f = false;
            }
        }
    }

    public synchronized void m4940f() {
        if (m4943i() && this.f3971a != null && this.f3971a.get() != null && ((gum) this.f3971a.get()).mo2425a()) {
            if (this.f3976f) {
                esr.m17825d(eys.m18562a());
                this.f3976f = false;
            }
            if (!this.f3976f) {
                esr.m17823c(eys.m18562a());
                this.f3976f = true;
            }
        }
    }

    public synchronized void m4941g() {
        this.f3975e++;
    }

    public synchronized void m4942h() {
        this.f3975e--;
    }

    public synchronized boolean m4943i() {
        return this.f3975e == 0;
    }

    public boolean m4944j() {
        return this.f3977g;
    }

    public void m4936b(boolean z) {
        this.f3977g = z;
    }

    private void m4929l() {
        ail.m5700a(getApplicationContext());
        ail.m5703a("507254669466735");
        C0075a.m1182a((Context) this, "507254669466735");
    }
}
