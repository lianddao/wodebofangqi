package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public class dva extends duy {
    private dvf f10379a;
    private dus f10380b;
    private final Set<dut> f10381c = new CopyOnWriteArraySet();
    private boolean f10382d;

    protected dva(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    private String m15740A() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void m15744a(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        m15752a(str, str2, mo2089p().mo1370a(), bundle, z, z2, z3, str3);
    }

    private void m15745a(String str, String str2, Object obj, long j) {
        cfi.m11082a(str);
        cfi.m11082a(str2);
        mo2083j();
        mo2081h();
        m15696c();
        if (!this.n.m16423E()) {
            mo2096w().m16234D().m16263a("User property not set since app measurement is disabled");
        } else if (this.n.m16448b()) {
            mo2096w().m16234D().m16265a("Setting user property (FE)", str2, obj);
            mo2088o().m15797a(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    private void m15746b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        cfi.m11082a(str);
        cfi.m11082a(str2);
        cfi.m11080a((Object) bundle);
        mo2083j();
        m15696c();
        if (this.n.m16423E()) {
            if (!this.f10382d) {
                this.f10382d = true;
                m15748z();
            }
            boolean l = dwk.m15939l(str2);
            if (z && this.f10380b != null && !l) {
                mo2096w().m16234D().m16265a("Passing event to registered event handler (FE)", str2, bundle);
                this.f10380b.m15628a(str, str2, bundle, j);
                return;
            } else if (this.n.m16448b()) {
                int c = mo2092s().m15963c(str2);
                if (c != 0) {
                    this.n.m16464o().m15945a(c, "_ev", mo2092s().m15944a(str2, mo2098y().m16035c(), true), str2 != null ? str2.length() : 0);
                    return;
                }
                bundle.putString("_o", str);
                Bundle a = mo2092s().m15943a(str2, bundle, cip.m11390a("_o"), z3);
                Bundle a2 = z2 ? m15749a(a) : a;
                mo2096w().m16234D().m16265a("Logging event (FE)", str2, a2);
                mo2088o().m15796a(new EventParcel(str2, new EventParams(a2), str, j), str3);
                for (dut a3 : this.f10381c) {
                    a3.m15629a(str, str2, new Bundle(a2), j);
                }
                return;
            } else {
                return;
            }
        }
        mo2096w().m16234D().m16263a("Event not sent since app measurement is disabled");
    }

    private void m15747b(boolean z) {
        mo2083j();
        mo2081h();
        m15696c();
        mo2096w().m16234D().m16264a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        mo2097x().m16317b(z);
        mo2088o().m15801g();
    }

    private void m15748z() {
        try {
            m15751a(Class.forName(m15740A()));
        } catch (ClassNotFoundException e) {
            mo2096w().m16233C().m16263a("Tag Manager is not found and thus will not be used");
        }
    }

    Bundle m15749a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object b = mo2092s().m15960b(str, bundle.get(str));
                if (b == null) {
                    mo2096w().m16262z().m16264a("Param value can't be null", str);
                } else {
                    mo2092s().m15947a(bundle2, str, b);
                }
            }
        }
        return bundle2;
    }

    public List<UserAttributeParcel> m15750a(boolean z) {
        mo2081h();
        m15696c();
        mo2096w().m16234D().m16263a("Fetching user attributes (FE)");
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.n.m16457h().m16380a(new dve(this, atomicReference, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                mo2096w().m16262z().m16264a("Interrupted waiting for get user properties", e);
            }
        }
        List<UserAttributeParcel> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        mo2096w().m16262z().m16263a("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    public void m15751a(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{mo2090q()});
        } catch (Exception e) {
            mo2096w().m16262z().m16264a("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    protected void m15752a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        mo2095v().m16380a(new dvc(this, str, str2, j, bundle != null ? new Bundle(bundle) : new Bundle(), z, z2, z3, str3));
    }

    void m15753a(String str, String str2, long j, Object obj) {
        mo2095v().m16380a(new dvd(this, str, str2, obj, j));
    }

    public void m15754a(String str, String str2, Bundle bundle) {
        mo2081h();
        boolean z = this.f10380b == null || dwk.m15939l(str2);
        m15744a(str, str2, bundle, true, z, false, null);
    }

    public void m15755a(String str, String str2, Bundle bundle, boolean z) {
        mo2081h();
        boolean z2 = this.f10380b == null || dwk.m15939l(str2);
        m15744a(str, str2, bundle, true, z2, z, null);
    }

    public void m15756a(String str, String str2, Object obj) {
        int i = 0;
        cfi.m11082a(str);
        long a = mo2089p().mo1370a();
        int e = mo2092s().m15968e(str2);
        String a2;
        if (e != 0) {
            a2 = mo2092s().m15944a(str2, mo2098y().m16037d(), true);
            if (str2 != null) {
                i = str2.length();
            }
            this.n.m16464o().m15945a(e, "_ev", a2, i);
        } else if (obj != null) {
            e = mo2092s().m15964c(str2, obj);
            if (e != 0) {
                a2 = mo2092s().m15944a(str2, mo2098y().m16037d(), true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.n.m16464o().m15945a(e, "_ev", a2, i);
                return;
            }
            Object d = mo2092s().m15967d(str2, obj);
            if (d != null) {
                m15753a(str, str2, a, d);
            }
        } else {
            m15753a(str, str2, a, null);
        }
    }

    protected void mo2080e() {
    }

    @TargetApi(14)
    public void m15758f() {
        if (mo2090q().getApplicationContext() instanceof Application) {
            Application application = (Application) mo2090q().getApplicationContext();
            if (this.f10379a == null) {
                this.f10379a = new dvf();
            }
            application.unregisterActivityLifecycleCallbacks(this.f10379a);
            application.registerActivityLifecycleCallbacks(this.f10379a);
            mo2096w().m16235E().m16263a("Registered activity lifecycle callback");
        }
    }

    public void m15759g() {
        mo2083j();
        mo2081h();
        m15696c();
        if (this.n.m16448b()) {
            mo2088o().m15820z();
            String D = mo2097x().m16313D();
            if (!TextUtils.isEmpty(D) && !D.equals(mo2087n().m16138g())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", D);
                m15754a("auto", "_ou", bundle);
            }
        }
    }

    public /* bridge */ /* synthetic */ void mo2081h() {
        super.mo2081h();
    }

    public /* bridge */ /* synthetic */ void mo2082i() {
        super.mo2082i();
    }

    public /* bridge */ /* synthetic */ void mo2083j() {
        super.mo2083j();
    }

    public /* bridge */ /* synthetic */ dwm mo2084k() {
        return super.mo2084k();
    }

    public /* bridge */ /* synthetic */ dva mo2085l() {
        return super.mo2085l();
    }

    public /* bridge */ /* synthetic */ dxe mo2086m() {
        return super.mo2086m();
    }

    public /* bridge */ /* synthetic */ dwu mo2087n() {
        return super.mo2087n();
    }

    public /* bridge */ /* synthetic */ dvg mo2088o() {
        return super.mo2088o();
    }

    public /* bridge */ /* synthetic */ cio mo2089p() {
        return super.mo2089p();
    }

    public /* bridge */ /* synthetic */ Context mo2090q() {
        return super.mo2090q();
    }

    public /* bridge */ /* synthetic */ dwo mo2091r() {
        return super.mo2091r();
    }

    public /* bridge */ /* synthetic */ dwk mo2092s() {
        return super.mo2092s();
    }

    public /* bridge */ /* synthetic */ dxz mo2093t() {
        return super.mo2093t();
    }

    public /* bridge */ /* synthetic */ dvx mo2094u() {
        return super.mo2094u();
    }

    public /* bridge */ /* synthetic */ dya mo2095v() {
        return super.mo2095v();
    }

    public /* bridge */ /* synthetic */ dxg mo2096w() {
        return super.mo2096w();
    }

    public /* bridge */ /* synthetic */ dxr mo2097x() {
        return super.mo2097x();
    }

    public /* bridge */ /* synthetic */ dwn mo2098y() {
        return super.mo2098y();
    }
}
