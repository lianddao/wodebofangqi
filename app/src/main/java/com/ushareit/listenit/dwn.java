package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0277j;
import java.lang.reflect.InvocationTargetException;

public class dwn extends dyt {
    static final String f10478a = String.valueOf(cjb.f8146b / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean f10479b;

    dwn(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    public int m16002A() {
        return 2048;
    }

    int m16003B() {
        return 500;
    }

    public long m16004C() {
        return (long) ((Integer) dwz.f10525m.m16179b()).intValue();
    }

    public long m16005D() {
        return (long) ((Integer) dwz.f10527o.m16179b()).intValue();
    }

    int m16006E() {
        return 25;
    }

    int m16007F() {
        return 50;
    }

    long m16008G() {
        return C0154a.f2954j;
    }

    long m16009H() {
        return 60000;
    }

    long m16010I() {
        return 61000;
    }

    long m16011J() {
        return ((Long) dwz.f10512G.m16179b()).longValue();
    }

    public String m16012K() {
        return "google_app_measurement.db";
    }

    public String m16013L() {
        return "google_app_measurement2.db";
    }

    public long m16014M() {
        return 9683;
    }

    public boolean m16015N() {
        return false;
    }

    public boolean m16016O() {
        if (this.f10479b == null) {
            synchronized (this) {
                if (this.f10479b == null) {
                    ApplicationInfo applicationInfo = mo2090q().getApplicationInfo();
                    String b = civ.m11418b();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(b);
                        this.f10479b = Boolean.valueOf(z);
                    }
                    if (this.f10479b == null) {
                        this.f10479b = Boolean.TRUE;
                        mo2096w().m16242f().m16263a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f10479b.booleanValue();
    }

    public boolean m16017P() {
        if (m16015N()) {
            return false;
        }
        Boolean g = m16044g("firebase_analytics_collection_deactivated");
        return g != null && g.booleanValue();
    }

    public Boolean m16018Q() {
        return m16015N() ? null : m16044g("firebase_analytics_collection_enabled");
    }

    public boolean m16019R() {
        return dnw.m15143b();
    }

    public long m16020S() {
        return ((Long) dwz.f10509D.m16179b()).longValue();
    }

    public long m16021T() {
        return ((Long) dwz.f10538z.m16179b()).longValue();
    }

    public long m16022U() {
        return 1000;
    }

    public long m16023V() {
        return Math.max(0, ((Long) dwz.f10517e.m16179b()).longValue());
    }

    public int m16024W() {
        return Math.max(0, ((Integer) dwz.f10523k.m16179b()).intValue());
    }

    public int m16025X() {
        return Math.max(1, ((Integer) dwz.f10524l.m16179b()).intValue());
    }

    public String m16026Y() {
        return (String) dwz.f10531s.m16179b();
    }

    public long m16027Z() {
        return ((Long) dwz.f10518f.m16179b()).longValue();
    }

    public int m16028a(String str) {
        return Math.max(0, Math.min(1000000, m16034b(str, dwz.f10526n)));
    }

    public long m16029a(String str, dxa<Long> com_ushareit_listenit_dxa_java_lang_Long) {
        if (str == null) {
            return ((Long) com_ushareit_listenit_dxa_java_lang_Long.m16179b()).longValue();
        }
        Object a = mo2093t().m16343a(str, com_ushareit_listenit_dxa_java_lang_Long.m16178a());
        if (TextUtils.isEmpty(a)) {
            return ((Long) com_ushareit_listenit_dxa_java_lang_Long.m16179b()).longValue();
        }
        try {
            return ((Long) com_ushareit_listenit_dxa_java_lang_Long.m16177a(Long.valueOf(Long.valueOf(a).longValue()))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) com_ushareit_listenit_dxa_java_lang_Long.m16179b()).longValue();
        }
    }

    String m16030a() {
        return (String) dwz.f10515c.m16179b();
    }

    public String m16031a(String str, String str2) {
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) dwz.f10519g.m16179b()).encodedAuthority((String) dwz.f10520h.m16179b());
        String str3 = "config/app/";
        String valueOf = String.valueOf(str);
        encodedAuthority.path(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3)).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(m16014M()));
        return builder.build().toString();
    }

    public long aa() {
        return Math.max(0, ((Long) dwz.f10532t.m16179b()).longValue());
    }

    public long ab() {
        return Math.max(0, ((Long) dwz.f10534v.m16179b()).longValue());
    }

    public long ac() {
        return Math.max(0, ((Long) dwz.f10535w.m16179b()).longValue());
    }

    public long ad() {
        return Math.max(0, ((Long) dwz.f10536x.m16179b()).longValue());
    }

    public long ae() {
        return Math.max(0, ((Long) dwz.f10537y.m16179b()).longValue());
    }

    public long af() {
        return ((Long) dwz.f10533u.m16179b()).longValue();
    }

    public long ag() {
        return Math.max(0, ((Long) dwz.f10506A.m16179b()).longValue());
    }

    public long ah() {
        return Math.max(0, ((Long) dwz.f10507B.m16179b()).longValue());
    }

    public int ai() {
        return Math.min(20, Math.max(0, ((Integer) dwz.f10508C.m16179b()).intValue()));
    }

    public String aj() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"firebase.analytics.debug-mode", ""});
        } catch (ClassNotFoundException e) {
            mo2096w().m16242f().m16264a("Could not find SystemProperties class", e);
        } catch (NoSuchMethodException e2) {
            mo2096w().m16242f().m16264a("Could not find SystemProperties.get() method", e2);
        } catch (IllegalAccessException e3) {
            mo2096w().m16242f().m16264a("Could not access SystemProperties.get()", e3);
        } catch (InvocationTargetException e4) {
            mo2096w().m16242f().m16264a("SystemProperties.get() threw an exception", e4);
        }
        return "";
    }

    public int m16032b() {
        return 25;
    }

    public int m16033b(String str) {
        return m16034b(str, dwz.f10528p);
    }

    public int m16034b(String str, dxa<Integer> com_ushareit_listenit_dxa_java_lang_Integer) {
        if (str == null) {
            return ((Integer) com_ushareit_listenit_dxa_java_lang_Integer.m16179b()).intValue();
        }
        Object a = mo2093t().m16343a(str, com_ushareit_listenit_dxa_java_lang_Integer.m16178a());
        if (TextUtils.isEmpty(a)) {
            return ((Integer) com_ushareit_listenit_dxa_java_lang_Integer.m16179b()).intValue();
        }
        try {
            return ((Integer) com_ushareit_listenit_dxa_java_lang_Integer.m16177a(Integer.valueOf(Integer.valueOf(a).intValue()))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) com_ushareit_listenit_dxa_java_lang_Integer.m16179b()).intValue();
        }
    }

    public int m16035c() {
        return 32;
    }

    public int m16036c(String str) {
        return m16034b(str, dwz.f10529q);
    }

    public int m16037d() {
        return 24;
    }

    long m16038d(String str) {
        return m16029a(str, dwz.f10516d);
    }

    int m16039e() {
        return 24;
    }

    int m16040e(String str) {
        return m16034b(str, dwz.f10510E);
    }

    int m16041f() {
        return 36;
    }

    int m16042f(String str) {
        return Math.max(0, Math.min(2000, m16034b(str, dwz.f10511F)));
    }

    int m16043g() {
        return C0277j.f3694e;
    }

    Boolean m16044g(String str) {
        Boolean bool = null;
        cfi.m11082a(str);
        try {
            PackageManager packageManager = mo2090q().getPackageManager();
            if (packageManager == null) {
                mo2096w().m16242f().m16263a("Failed to load metadata: PackageManager is null");
            } else {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(mo2090q().getPackageName(), 128);
                if (applicationInfo == null) {
                    mo2096w().m16242f().m16263a("Failed to load metadata: ApplicationInfo is null");
                } else if (applicationInfo.metaData == null) {
                    mo2096w().m16242f().m16263a("Failed to load metadata: Metadata bundle is null");
                } else if (applicationInfo.metaData.containsKey(str)) {
                    bool = Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                }
            }
        } catch (NameNotFoundException e) {
            mo2096w().m16242f().m16264a("Failed to load metadata: Package name not found", e);
        }
        return bool;
    }

    public int m16045h(String str) {
        return m16034b(str, dwz.f10521i);
    }

    public /* bridge */ /* synthetic */ void mo2081h() {
        super.mo2081h();
    }

    public int m16047i(String str) {
        return Math.max(0, m16034b(str, dwz.f10522j));
    }

    public /* bridge */ /* synthetic */ void mo2082i() {
        super.mo2082i();
    }

    public int m16049j(String str) {
        return Math.max(0, Math.min(1000000, m16034b(str, dwz.f10530r)));
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

    public int m16066z() {
        return 36;
    }
}
