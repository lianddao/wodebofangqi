package com.ushareit.listenit;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;

class dxr extends duy {
    static final Pair<String, Long> f10592a = new Pair("", Long.valueOf(0));
    public final dxv f10593b = new dxv(this, "health_monitor", mo2098y().m16023V());
    public final dxu f10594c = new dxu(this, "last_upload", 0);
    public final dxu f10595d = new dxu(this, "last_upload_attempt", 0);
    public final dxu f10596e = new dxu(this, "backoff", 0);
    public final dxu f10597f = new dxu(this, "last_delete_stale", 0);
    public final dxu f10598g = new dxu(this, "midnight_offset", 0);
    public final dxu f10599h = new dxu(this, "time_before_start", 10000);
    public final dxu f10600i = new dxu(this, "session_timeout", 1800000);
    public final dxt f10601j = new dxt(this, "start_new_session", true);
    public final dxu f10602k = new dxu(this, "last_pause_time", 0);
    public final dxu f10603l = new dxu(this, "time_active", 0);
    public boolean f10604m;
    private SharedPreferences f10605o;
    private String f10606p;
    private boolean f10607q;
    private long f10608r;
    private SecureRandom f10609s;

    dxr(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    private SecureRandom m16305E() {
        mo2083j();
        if (this.f10609s == null) {
            this.f10609s = new SecureRandom();
        }
        return this.f10609s;
    }

    private SharedPreferences m16306F() {
        mo2083j();
        m15696c();
        return this.f10605o;
    }

    String m16310A() {
        mo2083j();
        return m16306F().getString("gmp_app_id", null);
    }

    Boolean m16311B() {
        mo2083j();
        return !m16306F().contains("use_service") ? null : Boolean.valueOf(m16306F().getBoolean("use_service", false));
    }

    void m16312C() {
        boolean z = true;
        mo2083j();
        mo2096w().m16235E().m16263a("Clearing collection preferences.");
        boolean contains = m16306F().contains("measurement_enabled");
        if (contains) {
            z = m16319c(true);
        }
        Editor edit = m16306F().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            m16317b(z);
        }
    }

    protected String m16313D() {
        mo2083j();
        String string = m16306F().getString("previous_os_version", null);
        String g = mo2087n().m16138g();
        if (!(TextUtils.isEmpty(g) || g.equals(string))) {
            Editor edit = m16306F().edit();
            edit.putString("previous_os_version", g);
            edit.apply();
        }
        return string;
    }

    Pair<String, Boolean> m16314a(String str) {
        mo2083j();
        long b = mo2089p().mo1371b();
        if (this.f10606p != null && b < this.f10608r) {
            return new Pair(this.f10606p, Boolean.valueOf(this.f10607q));
        }
        this.f10608r = b + mo2098y().m16038d(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(mo2090q());
            this.f10606p = advertisingIdInfo.getId();
            if (this.f10606p == null) {
                this.f10606p = "";
            }
            this.f10607q = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            mo2096w().m16234D().m16264a("Unable to get advertising id", th);
            this.f10606p = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f10606p, Boolean.valueOf(this.f10607q));
    }

    void m16315a(boolean z) {
        mo2083j();
        mo2096w().m16235E().m16264a("Setting useService", Boolean.valueOf(z));
        Editor edit = m16306F().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    String m16316b(String str) {
        String str2 = (String) m16314a(str).first;
        if (dwk.m15938j("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, dwk.m15938j("MD5").digest(str2.getBytes()))});
    }

    void m16317b(boolean z) {
        mo2083j();
        mo2096w().m16235E().m16264a("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = m16306F().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    void m16318c(String str) {
        mo2083j();
        Editor edit = m16306F().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    boolean m16319c(boolean z) {
        mo2083j();
        return m16306F().getBoolean("measurement_enabled", z);
    }

    protected void mo2080e() {
        this.f10605o = mo2090q().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f10604m = this.f10605o.getBoolean("has_been_opened", false);
        if (!this.f10604m) {
            Editor edit = this.f10605o.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    String m16321f() {
        m16305E().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    String m16322g() {
        mo2083j();
        try {
            return een.m16846a().m16847b();
        } catch (IllegalStateException e) {
            mo2096w().m16262z().m16263a("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }

    long m16323z() {
        m15696c();
        mo2083j();
        long a = this.f10598g.m16328a();
        if (a != 0) {
            return a;
        }
        a = (long) (m16305E().nextInt(86400000) + 1);
        this.f10598g.m16329a(a);
        return a;
    }
}
