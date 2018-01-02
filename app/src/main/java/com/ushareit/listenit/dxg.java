package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;

public class dxg extends duy {
    private final String f10551a = mo2098y().m16030a();
    private final char f10552b;
    private final long f10553c = mo2098y().m16014M();
    private final dxi f10554d;
    private final dxi f10555e;
    private final dxi f10556f;
    private final dxi f10557g;
    private final dxi f10558h;
    private final dxi f10559i;
    private final dxi f10560j;
    private final dxi f10561k;
    private final dxi f10562l;

    dxg(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
        if (mo2098y().m16016O()) {
            this.f10552b = mo2098y().m16015N() ? 'P' : 'C';
        } else {
            this.f10552b = mo2098y().m16015N() ? 'p' : 'c';
        }
        this.f10554d = new dxi(this, 6, false, false);
        this.f10555e = new dxi(this, 6, true, false);
        this.f10556f = new dxi(this, 6, false, true);
        this.f10557g = new dxi(this, 5, false, false);
        this.f10558h = new dxi(this, 5, true, false);
        this.f10559i = new dxi(this, 5, false, true);
        this.f10560j = new dxi(this, 4, false, false);
        this.f10561k = new dxi(this, 3, false, false);
        this.f10562l = new dxi(this, 2, false, false);
    }

    private static String m16228a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    static String m16229a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String a = m16228a(AppMeasurement.class.getCanonicalName());
                String a2 = m16228a(dyf.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = m16228a(className);
                            if (className.equals(a) || className.equals(a2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    static String m16230a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object a = m16229a(z, obj);
        Object a2 = m16229a(z, obj2);
        Object a3 = m16229a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    public dxi m16231A() {
        return this.f10558h;
    }

    public dxi m16232B() {
        return this.f10559i;
    }

    public dxi m16233C() {
        return this.f10560j;
    }

    public dxi m16234D() {
        return this.f10561k;
    }

    public dxi m16235E() {
        return this.f10562l;
    }

    public String m16236F() {
        Pair a = mo2097x().f10593b.m16333a();
        if (a == null || a == dxr.f10592a) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(a.second));
        String str = (String) a.first;
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    protected void m16237a(int i, String str) {
        Log.println(i, this.f10551a, str);
    }

    public void m16238a(int i, String str, Object obj, Object obj2, Object obj3) {
        cfi.m11080a((Object) str);
        dya k = this.n.m16460k();
        if (k == null) {
            m16237a(6, "Scheduler not set. Not logging error/warn.");
        } else if (!k.m15694a()) {
            m16237a(6, "Scheduler not initialized. Not logging error/warn.");
        } else if (k.m15695b()) {
            m16237a(6, "Scheduler shutdown. Not logging error/warn.");
        } else {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String valueOf = String.valueOf("1");
            char charAt = "01VDIWEA?".charAt(i);
            char c = this.f10552b;
            long j = this.f10553c;
            String valueOf2 = String.valueOf(m16230a(true, str, obj, obj2, obj3));
            valueOf = new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
            if (valueOf.length() > 1024) {
                valueOf = str.substring(0, 1024);
            }
            k.m16380a(new dxh(this, valueOf));
        }
    }

    protected void m16239a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && m16240a(i)) {
            m16237a(i, m16230a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            m16238a(i, str, obj, obj2, obj3);
        }
    }

    protected boolean m16240a(int i) {
        return Log.isLoggable(this.f10551a, i);
    }

    protected void mo2080e() {
    }

    public dxi m16242f() {
        return this.f10554d;
    }

    public dxi m16243g() {
        return this.f10555e;
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

    public dxi m16262z() {
        return this.f10557g;
    }
}
