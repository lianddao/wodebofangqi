package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.measurement.internal.AppMetadata;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class dxe extends duy {
    private static final X500Principal f10543a = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String f10544b;
    private String f10545c;
    private int f10546d;
    private String f10547e;
    private String f10548f;
    private long f10549g;
    private String f10550h;

    dxe(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    int m16195A() {
        m15696c();
        return this.f10546d;
    }

    String m16196B() {
        m15696c();
        return this.f10547e;
    }

    long m16197C() {
        return mo2098y().m16014M();
    }

    long m16198D() {
        m15696c();
        return this.f10549g;
    }

    boolean m16199E() {
        try {
            PackageInfo packageInfo = mo2090q().getPackageManager().getPackageInfo(mo2090q().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(f10543a);
            }
        } catch (CertificateException e) {
            mo2096w().m16242f().m16264a("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            mo2096w().m16242f().m16264a("Package name not found", e2);
        }
        return true;
    }

    AppMetadata m16200a(String str) {
        return new AppMetadata(m16203f(), m16204g(), m16223z(), (long) m16195A(), m16196B(), m16197C(), m16198D(), str, this.n.m16423E(), !mo2097x().f10604m, mo2097x().m16322g());
    }

    protected void m16201a(Status status) {
        if (status == null) {
            mo2096w().m16242f().m16263a("GoogleService failed to initialize (no status)");
        } else {
            mo2096w().m16242f().m16265a("GoogleService failed to initialize, status", Integer.valueOf(status.m2259h()), status.m2254c());
        }
    }

    protected void mo2080e() {
        String str = "unknown";
        String str2 = "Unknown";
        int i = Integer.MIN_VALUE;
        String str3 = "Unknown";
        String packageName = mo2090q().getPackageName();
        PackageManager packageManager = mo2090q().getPackageManager();
        if (packageManager == null) {
            mo2096w().m16242f().m16263a("PackageManager is null, app identity information might be inaccurate");
        } else {
            str = packageManager.getInstallerPackageName(packageName);
            if (str == null) {
                str = "manual_install";
            } else if ("com.android.vending".equals(str)) {
                str = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(mo2090q().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str3 = applicationLabel.toString();
                    }
                    str2 = packageInfo.versionName;
                    i = packageInfo.versionCode;
                }
            } catch (NameNotFoundException e) {
                mo2096w().m16242f().m16264a("Error retrieving package info: appName", str3);
            }
        }
        this.f10544b = packageName;
        this.f10547e = str;
        this.f10545c = str2;
        this.f10546d = i;
        this.f10548f = str3;
        this.f10549g = 0;
        MessageDigest j = dwk.m15938j("MD5");
        if (j == null) {
            mo2096w().m16242f().m16263a("Could not get MD5 instance");
            this.f10549g = -1;
        } else if (packageManager != null) {
            try {
                if (!m16199E()) {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(mo2090q().getPackageName(), 64);
                    if (packageInfo2.signatures != null && packageInfo2.signatures.length > 0) {
                        this.f10549g = dwk.m15936c(j.digest(packageInfo2.signatures[0].toByteArray()));
                    }
                }
            } catch (NameNotFoundException e2) {
                mo2096w().m16242f().m16264a("Package name not found", e2);
            }
        }
        Status a = mo2098y().m16015N() ? dnw.m15140a(mo2090q(), "-", true) : dnw.m15139a(mo2090q());
        boolean z = a != null && a.m2257f();
        if (!z) {
            m16201a(a);
        }
        if (z) {
            Boolean Q = mo2098y().m16018Q();
            if (mo2098y().m16017P()) {
                mo2096w().m16233C().m16263a("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (Q != null && !Q.booleanValue()) {
                mo2096w().m16233C().m16263a("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (Q == null && mo2098y().m16019R()) {
                mo2096w().m16233C().m16263a("Collection disabled with google_app_measurement_enable=0");
                z = false;
            } else {
                mo2096w().m16235E().m16263a("Collection enabled");
                z = true;
            }
        } else {
            z = false;
        }
        this.f10550h = "";
        if (!mo2098y().m16015N()) {
            try {
                String a2 = dnw.m15141a();
                if (TextUtils.isEmpty(a2)) {
                    a2 = "";
                }
                this.f10550h = a2;
                if (z) {
                    mo2096w().m16235E().m16265a("App package, google app id", this.f10544b, this.f10550h);
                }
            } catch (IllegalStateException e3) {
                mo2096w().m16242f().m16264a("getGoogleAppId or isMeasurementEnabled failed with exception", e3);
            }
        }
    }

    String m16203f() {
        m15696c();
        return this.f10544b;
    }

    String m16204g() {
        m15696c();
        return this.f10550h;
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

    String m16223z() {
        m15696c();
        return this.f10545c;
    }
}
