package com.ushareit.listenit;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.umeng.analytics.C0154a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class dyf {
    private static volatile dyf f10658a;
    private List<Long> f10659A;
    private int f10660B;
    private int f10661C;
    private final Context f10662b;
    private final dwn f10663c;
    private final dxr f10664d;
    private final dxg f10665e;
    private final dya f10666f;
    private final dvx f10667g;
    private final dxz f10668h;
    private final AppMeasurement f10669i;
    private final eap f10670j;
    private final dwk f10671k;
    private final dwo f10672l;
    private final dxj f10673m;
    private final cio f10674n;
    private final dvg f10675o;
    private final dwu f10676p;
    private final dva f10677q;
    private final dxe f10678r;
    private final dxo f10679s;
    private final dwg f10680t;
    private final dwm f10681u;
    private final boolean f10682v;
    private boolean f10683w;
    private Boolean f10684x;
    private FileLock f10685y;
    private FileChannel f10686z;

    dyf(duz com_ushareit_listenit_duz) {
        cfi.m11080a((Object) com_ushareit_listenit_duz);
        this.f10662b = com_ushareit_listenit_duz.f10366a;
        this.f10674n = com_ushareit_listenit_duz.m15712m(this);
        this.f10663c = com_ushareit_listenit_duz.m15699a(this);
        dxr b = com_ushareit_listenit_duz.m15701b(this);
        b.m15697d();
        this.f10664d = b;
        dxg c = com_ushareit_listenit_duz.m15702c(this);
        c.m15697d();
        this.f10665e = c;
        m16455f().m16233C().m16264a("App measurement is starting up, version", Long.valueOf(m16452d().m16014M()));
        m16455f().m16233C().m16263a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        m16455f().m16234D().m16263a("Debug-level message logging enabled");
        m16455f().m16234D().m16264a("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
        this.f10671k = com_ushareit_listenit_duz.m15709j(this);
        dwu o = com_ushareit_listenit_duz.m15714o(this);
        o.m15697d();
        this.f10676p = o;
        dxe p = com_ushareit_listenit_duz.m15715p(this);
        p.m15697d();
        this.f10678r = p;
        String f = p.m16203f();
        if (m16464o().m15980m(f)) {
            m16455f().m16233C().m16263a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop firebase.analytics.debug-mode .none.");
        } else {
            dxi C = m16455f().m16233C();
            String str = "To enable faster debug mode event logging run:\n  adb shell setprop firebase.analytics.debug-mode ";
            f = String.valueOf(f);
            C.m16263a(f.length() != 0 ? str.concat(f) : new String(str));
        }
        dwo k = com_ushareit_listenit_duz.m15710k(this);
        k.m15697d();
        this.f10672l = k;
        dwm s = com_ushareit_listenit_duz.m15718s(this);
        s.m15697d();
        this.f10681u = s;
        dxj l = com_ushareit_listenit_duz.m15711l(this);
        l.m15697d();
        this.f10673m = l;
        dvg n = com_ushareit_listenit_duz.m15713n(this);
        n.m15697d();
        this.f10675o = n;
        dva i = com_ushareit_listenit_duz.m15708i(this);
        i.m15697d();
        this.f10677q = i;
        dwg r = com_ushareit_listenit_duz.m15717r(this);
        r.m15697d();
        this.f10680t = r;
        this.f10679s = com_ushareit_listenit_duz.m15716q(this);
        this.f10669i = com_ushareit_listenit_duz.m15707h(this);
        this.f10670j = com_ushareit_listenit_duz.m15706g(this);
        dvx e = com_ushareit_listenit_duz.m15704e(this);
        e.m15697d();
        this.f10667g = e;
        dxz f2 = com_ushareit_listenit_duz.m15705f(this);
        f2.m15697d();
        this.f10668h = f2;
        dya d = com_ushareit_listenit_duz.m15703d(this);
        d.m15697d();
        this.f10666f = d;
        if (this.f10660B != this.f10661C) {
            m16455f().m16242f().m16265a("Not all components initialized", Integer.valueOf(this.f10660B), Integer.valueOf(this.f10661C));
        }
        this.f10682v = true;
        if (!(this.f10663c.m16015N() || m16422D())) {
            if (!(this.f10662b.getApplicationContext() instanceof Application)) {
                m16455f().m16262z().m16263a("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                m16461l().m15758f();
            } else {
                m16455f().m16234D().m16263a("Not tracking deep linking pre-ICS");
            }
        }
        this.f10666f.m16380a(new dyg(this));
    }

    private boolean m16405M() {
        m16475z();
        return this.f10659A != null;
    }

    private boolean m16406N() {
        m16475z();
        m16432a();
        return m16465p().m16086I() || !TextUtils.isEmpty(m16465p().m16080C());
    }

    private void m16407O() {
        m16475z();
        m16432a();
        if (!m16430L()) {
            return;
        }
        if (m16448b() && m16406N()) {
            long P = m16408P();
            if (P == 0) {
                m16472w().m16299b();
                m16473x().m15893f();
                return;
            } else if (m16466q().m16274f()) {
                long a = m16454e().f10596e.m16328a();
                long aa = m16452d().aa();
                if (!m16464o().m15950a(a, aa)) {
                    P = Math.max(P, a + aa);
                }
                m16472w().m16299b();
                P -= m16468s().mo1370a();
                if (P <= 0) {
                    P = m16452d().ad();
                }
                m16455f().m16235E().m16264a("Upload scheduled in approximately ms", Long.valueOf(P));
                m16473x().m15891a(P);
                return;
            } else {
                m16472w().m16298a();
                m16473x().m15893f();
                return;
            }
        }
        m16472w().m16299b();
        m16473x().m15893f();
    }

    private long m16408P() {
        long a = m16468s().mo1370a();
        long ag = m16452d().ag();
        Object obj = (m16465p().m16087J() || m16465p().m16081D()) ? 1 : null;
        long ac = obj != null ? m16452d().ac() : m16452d().ab();
        long a2 = m16454e().f10594c.m16328a();
        long a3 = m16454e().f10595d.m16328a();
        long max = Math.max(m16465p().m16084G(), m16465p().m16085H());
        if (max == 0) {
            return 0;
        }
        max = a - Math.abs(max - a);
        a3 = a - Math.abs(a3 - a);
        a2 = Math.max(a - Math.abs(a2 - a), a3);
        a = max + ag;
        if (obj != null && a2 > 0) {
            a = Math.min(max, a2) + ac;
        }
        if (!m16464o().m15950a(a2, ac)) {
            a = a2 + ac;
        }
        if (a3 == 0 || a3 < max) {
            return a;
        }
        for (int i = 0; i < m16452d().ai(); i++) {
            a += ((long) (1 << i)) * m16452d().ah();
            if (a > a3) {
                return a;
            }
        }
        return 0;
    }

    public static dyf m16409a(Context context) {
        cfi.m11080a((Object) context);
        cfi.m11080a(context.getApplicationContext());
        if (f10658a == null) {
            synchronized (dyf.class) {
                if (f10658a == null) {
                    f10658a = new duz(context).m15700a();
                }
            }
        }
        return f10658a;
    }

    private void m16410a(int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        m16475z();
        m16432a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.f10659A;
        this.f10659A = null;
        if ((i == 200 || i == 204) && th == null) {
            m16454e().f10594c.m16329a(m16468s().mo1370a());
            m16454e().f10595d.m16329a(0);
            m16407O();
            m16455f().m16235E().m16265a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            m16465p().m16121f();
            try {
                for (Long longValue : list) {
                    m16465p().m16093a(longValue.longValue());
                }
                m16465p().m16122g();
                if (m16466q().m16274f() && m16406N()) {
                    m16427I();
                } else {
                    m16407O();
                }
            } finally {
                m16465p().m16127z();
            }
        } else {
            m16455f().m16235E().m16265a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            m16454e().f10595d.m16329a(m16468s().mo1370a());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                m16454e().f10596e.m16329a(m16468s().mo1370a());
            }
            m16407O();
        }
    }

    private void m16412a(dyt com_ushareit_listenit_dyt) {
        if (com_ushareit_listenit_dyt == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private void m16413a(List<Long> list) {
        cfi.m11089b(!list.isEmpty());
        if (this.f10659A != null) {
            m16455f().m16242f().m16263a("Set uploading progress before finishing the previous upload");
        } else {
            this.f10659A = new ArrayList(list);
        }
    }

    private boolean m16414a(dwv com_ushareit_listenit_dwv) {
        if (com_ushareit_listenit_dwv.f10500f == null) {
            return false;
        }
        Iterator it = com_ushareit_listenit_dwv.f10500f.iterator();
        while (it.hasNext()) {
            if ("_r".equals((String) it.next())) {
                return true;
            }
        }
        return m16459j().m16348c(com_ushareit_listenit_dwv.f10495a, com_ushareit_listenit_dwv.f10496b) && m16465p().m16089a(m16424F(), com_ushareit_listenit_dwv.f10495a, false, false, false, false, false).f10489e < ((long) m16452d().m16036c(com_ushareit_listenit_dwv.f10495a));
    }

    private boolean m16415a(String str, long j) {
        m16465p().m16121f();
        try {
            dyf com_ushareit_listenit_dyf = this;
            dyj com_ushareit_listenit_dyj = new dyj();
            m16465p().m16102a(str, j, (dwq) com_ushareit_listenit_dyj);
            if (com_ushareit_listenit_dyj.m16480a()) {
                m16465p().m16122g();
                m16465p().m16127z();
                return false;
            }
            int i;
            boolean z = false;
            dru com_ushareit_listenit_dru = com_ushareit_listenit_dyj.f10690a;
            com_ushareit_listenit_dru.f10246b = new drr[com_ushareit_listenit_dyj.f10692c.size()];
            int i2 = 0;
            int i3 = 0;
            while (i3 < com_ushareit_listenit_dyj.f10692c.size()) {
                boolean z2;
                if (m16459j().m16346b(com_ushareit_listenit_dyj.f10690a.f10259p, ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10226b)) {
                    m16455f().m16262z().m16264a("Dropping blacklisted raw event", ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10226b);
                    m16464o().m15945a(11, "_ev", ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10226b, 0);
                    i = i2;
                    z2 = z;
                } else {
                    int i4;
                    boolean z3;
                    if (m16459j().m16348c(com_ushareit_listenit_dyj.f10690a.f10259p, ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10226b)) {
                        drs[] com_ushareit_listenit_drsArr;
                        drs com_ushareit_listenit_drs;
                        drr com_ushareit_listenit_drr;
                        Object obj = null;
                        Object obj2 = null;
                        if (((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10225a == null) {
                            ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10225a = new drs[0];
                        }
                        drs[] com_ushareit_listenit_drsArr2 = ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10225a;
                        int length = com_ushareit_listenit_drsArr2.length;
                        int i5 = 0;
                        while (i5 < length) {
                            Object obj3;
                            drs com_ushareit_listenit_drs2 = com_ushareit_listenit_drsArr2[i5];
                            if ("_c".equals(com_ushareit_listenit_drs2.f10231a)) {
                                com_ushareit_listenit_drs2.f10233c = Long.valueOf(1);
                                obj = 1;
                                obj3 = obj2;
                            } else if ("_r".equals(com_ushareit_listenit_drs2.f10231a)) {
                                com_ushareit_listenit_drs2.f10233c = Long.valueOf(1);
                                obj3 = 1;
                            } else {
                                obj3 = obj2;
                            }
                            i5++;
                            obj2 = obj3;
                        }
                        if (obj == null) {
                            m16455f().m16235E().m16264a("Marking event as conversion", ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10226b);
                            com_ushareit_listenit_drsArr = (drs[]) Arrays.copyOf(((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10225a, ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10225a.length + 1);
                            com_ushareit_listenit_drs = new drs();
                            com_ushareit_listenit_drs.f10231a = "_c";
                            com_ushareit_listenit_drs.f10233c = Long.valueOf(1);
                            com_ushareit_listenit_drsArr[com_ushareit_listenit_drsArr.length - 1] = com_ushareit_listenit_drs;
                            ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10225a = com_ushareit_listenit_drsArr;
                        }
                        if (obj2 == null) {
                            m16455f().m16235E().m16264a("Marking event as real-time", ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10226b);
                            com_ushareit_listenit_drsArr = (drs[]) Arrays.copyOf(((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10225a, ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10225a.length + 1);
                            com_ushareit_listenit_drs = new drs();
                            com_ushareit_listenit_drs.f10231a = "_r";
                            com_ushareit_listenit_drs.f10233c = Long.valueOf(1);
                            com_ushareit_listenit_drsArr[com_ushareit_listenit_drsArr.length - 1] = com_ushareit_listenit_drs;
                            ((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10225a = com_ushareit_listenit_drsArr;
                        }
                        boolean a = dwk.m15932a(((drr) com_ushareit_listenit_dyj.f10692c.get(i3)).f10226b);
                        if (m16465p().m16089a(m16424F(), com_ushareit_listenit_dyj.f10690a.f10259p, false, false, false, false, true).f10489e > ((long) m16452d().m16036c(com_ushareit_listenit_dyj.f10690a.f10259p))) {
                            com_ushareit_listenit_drr = (drr) com_ushareit_listenit_dyj.f10692c.get(i3);
                            i4 = 0;
                            while (i4 < com_ushareit_listenit_drr.f10225a.length) {
                                if ("_r".equals(com_ushareit_listenit_drr.f10225a[i4].f10231a)) {
                                    obj2 = new drs[(com_ushareit_listenit_drr.f10225a.length - 1)];
                                    if (i4 > 0) {
                                        System.arraycopy(com_ushareit_listenit_drr.f10225a, 0, obj2, 0, i4);
                                    }
                                    if (i4 < obj2.length) {
                                        System.arraycopy(com_ushareit_listenit_drr.f10225a, i4 + 1, obj2, i4, obj2.length - i4);
                                    }
                                    com_ushareit_listenit_drr.f10225a = obj2;
                                } else {
                                    i4++;
                                }
                            }
                        } else {
                            z = true;
                        }
                        if (a && m16465p().m16089a(m16424F(), com_ushareit_listenit_dyj.f10690a.f10259p, false, false, true, false, false).f10487c > ((long) m16452d().m16033b(com_ushareit_listenit_dyj.f10690a.f10259p))) {
                            m16455f().m16262z().m16263a("Too many conversions. Not logging as conversion.");
                            com_ushareit_listenit_drr = (drr) com_ushareit_listenit_dyj.f10692c.get(i3);
                            Object obj4 = null;
                            drs com_ushareit_listenit_drs3 = null;
                            drs[] com_ushareit_listenit_drsArr3 = com_ushareit_listenit_drr.f10225a;
                            int length2 = com_ushareit_listenit_drsArr3.length;
                            int i6 = 0;
                            while (i6 < length2) {
                                com_ushareit_listenit_drs = com_ushareit_listenit_drsArr3[i6];
                                if ("_c".equals(com_ushareit_listenit_drs.f10231a)) {
                                    obj2 = obj4;
                                } else if ("_err".equals(com_ushareit_listenit_drs.f10231a)) {
                                    drs com_ushareit_listenit_drs4 = com_ushareit_listenit_drs3;
                                    int i7 = 1;
                                    com_ushareit_listenit_drs = com_ushareit_listenit_drs4;
                                } else {
                                    com_ushareit_listenit_drs = com_ushareit_listenit_drs3;
                                    obj2 = obj4;
                                }
                                i6++;
                                obj4 = obj2;
                                com_ushareit_listenit_drs3 = com_ushareit_listenit_drs;
                            }
                            if (obj4 != null && com_ushareit_listenit_drs3 != null) {
                                com_ushareit_listenit_drsArr3 = new drs[(com_ushareit_listenit_drr.f10225a.length - 1)];
                                i5 = 0;
                                drs[] com_ushareit_listenit_drsArr4 = com_ushareit_listenit_drr.f10225a;
                                int length3 = com_ushareit_listenit_drsArr4.length;
                                i6 = 0;
                                while (i6 < length3) {
                                    drs com_ushareit_listenit_drs5 = com_ushareit_listenit_drsArr4[i6];
                                    if (com_ushareit_listenit_drs5 != com_ushareit_listenit_drs3) {
                                        i4 = i5 + 1;
                                        com_ushareit_listenit_drsArr3[i5] = com_ushareit_listenit_drs5;
                                    } else {
                                        i4 = i5;
                                    }
                                    i6++;
                                    i5 = i4;
                                }
                                com_ushareit_listenit_drr.f10225a = com_ushareit_listenit_drsArr3;
                                z3 = z;
                                i4 = i2 + 1;
                                com_ushareit_listenit_dru.f10246b[i2] = (drr) com_ushareit_listenit_dyj.f10692c.get(i3);
                                i = i4;
                                z2 = z3;
                            } else if (com_ushareit_listenit_drs3 != null) {
                                com_ushareit_listenit_drs3.f10231a = "_err";
                                com_ushareit_listenit_drs3.f10233c = Long.valueOf(10);
                                z3 = z;
                                i4 = i2 + 1;
                                com_ushareit_listenit_dru.f10246b[i2] = (drr) com_ushareit_listenit_dyj.f10692c.get(i3);
                                i = i4;
                                z2 = z3;
                            } else {
                                m16455f().m16242f().m16263a("Did not find conversion parameter. Error not tracked");
                            }
                        }
                    }
                    z3 = z;
                    i4 = i2 + 1;
                    com_ushareit_listenit_dru.f10246b[i2] = (drr) com_ushareit_listenit_dyj.f10692c.get(i3);
                    i = i4;
                    z2 = z3;
                }
                i3++;
                i2 = i;
                z = z2;
            }
            if (i2 < com_ushareit_listenit_dyj.f10692c.size()) {
                com_ushareit_listenit_dru.f10246b = (drr[]) Arrays.copyOf(com_ushareit_listenit_dru.f10246b, i2);
            }
            com_ushareit_listenit_dru.f10239B = m16416a(com_ushareit_listenit_dyj.f10690a.f10259p, com_ushareit_listenit_dyj.f10690a.f10247c, com_ushareit_listenit_dru.f10246b);
            com_ushareit_listenit_dru.f10249e = com_ushareit_listenit_dru.f10246b[0].f10227c;
            com_ushareit_listenit_dru.f10250f = com_ushareit_listenit_dru.f10246b[0].f10227c;
            for (i = 1; i < com_ushareit_listenit_dru.f10246b.length; i++) {
                drr com_ushareit_listenit_drr2 = com_ushareit_listenit_dru.f10246b[i];
                if (com_ushareit_listenit_drr2.f10227c.longValue() < com_ushareit_listenit_dru.f10249e.longValue()) {
                    com_ushareit_listenit_dru.f10249e = com_ushareit_listenit_drr2.f10227c;
                }
                if (com_ushareit_listenit_drr2.f10227c.longValue() > com_ushareit_listenit_dru.f10250f.longValue()) {
                    com_ushareit_listenit_dru.f10250f = com_ushareit_listenit_drr2.f10227c;
                }
            }
            String str2 = com_ushareit_listenit_dyj.f10690a.f10259p;
            dux b = m16465p().m16108b(str2);
            if (b == null) {
                m16455f().m16242f().m16263a("Bundling raw events w/o app info");
            } else {
                long h = b.m15652h();
                com_ushareit_listenit_dru.f10252i = h != 0 ? Long.valueOf(h) : null;
                long g = b.m15650g();
                if (g != 0) {
                    h = g;
                }
                com_ushareit_listenit_dru.f10251h = h != 0 ? Long.valueOf(h) : null;
                b.m15669r();
                com_ushareit_listenit_dru.f10267x = Integer.valueOf((int) b.m15666o());
                b.m15632a(com_ushareit_listenit_dru.f10249e.longValue());
                b.m15636b(com_ushareit_listenit_dru.f10250f.longValue());
                m16465p().m16096a(b);
            }
            com_ushareit_listenit_dru.f10268y = m16455f().m16236F();
            m16465p().m16095a(com_ushareit_listenit_dru, z);
            m16465p().m16105a(com_ushareit_listenit_dyj.f10691b);
            m16465p().m16125i(str2);
            m16465p().m16122g();
            return true;
        } finally {
            m16465p().m16127z();
        }
    }

    private drq[] m16416a(String str, drw[] com_ushareit_listenit_drwArr, drr[] com_ushareit_listenit_drrArr) {
        cfi.m11082a(str);
        return m16474y().m16000a(str, com_ushareit_listenit_drrArr, com_ushareit_listenit_drwArr);
    }

    private void m16417b(duy com_ushareit_listenit_duy) {
        if (com_ushareit_listenit_duy == null) {
            throw new IllegalStateException("Component not created");
        } else if (!com_ushareit_listenit_duy.m15694a()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void m16418c(AppMetadata appMetadata) {
        Object obj = 1;
        m16475z();
        m16432a();
        cfi.m11080a((Object) appMetadata);
        cfi.m11082a(appMetadata.f1886b);
        dux b = m16465p().m16108b(appMetadata.f1886b);
        String b2 = m16454e().m16316b(appMetadata.f1886b);
        Object obj2 = null;
        if (b == null) {
            dux com_ushareit_listenit_dux = new dux(this, appMetadata.f1886b);
            com_ushareit_listenit_dux.m15633a(m16454e().m16321f());
            com_ushareit_listenit_dux.m15640c(b2);
            b = com_ushareit_listenit_dux;
            obj2 = 1;
        } else if (!b2.equals(b.m15644e())) {
            b.m15640c(b2);
            b.m15633a(m16454e().m16321f());
            int i = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f1887c) || appMetadata.f1887c.equals(b.m15641d()))) {
            b.m15637b(appMetadata.f1887c);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f1896l) || appMetadata.f1896l.equals(b.m15647f()))) {
            b.m15643d(appMetadata.f1896l);
            obj2 = 1;
        }
        if (!(appMetadata.f1890f == 0 || appMetadata.f1890f == b.m15660l())) {
            b.m15642d(appMetadata.f1890f);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f1888d) || appMetadata.f1888d.equals(b.m15654i()))) {
            b.m15646e(appMetadata.f1888d);
            obj2 = 1;
        }
        if (appMetadata.f1895k != b.m15656j()) {
            b.m15639c(appMetadata.f1895k);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f1889e) || appMetadata.f1889e.equals(b.m15658k()))) {
            b.m15649f(appMetadata.f1889e);
            obj2 = 1;
        }
        if (appMetadata.f1891g != b.m15662m()) {
            b.m15645e(appMetadata.f1891g);
            obj2 = 1;
        }
        if (appMetadata.f1893i != b.m15665n()) {
            b.m15634a(appMetadata.f1893i);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            m16465p().m16096a(b);
        }
    }

    FileChannel m16419A() {
        return this.f10686z;
    }

    void m16420B() {
        m16475z();
        m16432a();
        if (m16430L() && m16421C()) {
            m16442a(m16431a(m16419A()), m16471v().m16195A());
        }
    }

    boolean m16421C() {
        m16475z();
        try {
            this.f10686z = new RandomAccessFile(new File(m16467r().getFilesDir(), this.f10672l.m16079B()), "rw").getChannel();
            this.f10685y = this.f10686z.tryLock();
            if (this.f10685y != null) {
                m16455f().m16235E().m16263a("Storage concurrent access okay");
                return true;
            }
            m16455f().m16242f().m16263a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            m16455f().m16242f().m16264a("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            m16455f().m16242f().m16264a("Failed to access storage lock file", e2);
        }
    }

    public boolean m16422D() {
        return false;
    }

    public boolean m16423E() {
        boolean z = false;
        m16475z();
        m16432a();
        if (m16452d().m16017P()) {
            return false;
        }
        Boolean Q = m16452d().m16018Q();
        if (Q != null) {
            z = Q.booleanValue();
        } else if (!m16452d().m16019R()) {
            z = true;
        }
        return m16454e().m16319c(z);
    }

    long m16424F() {
        return ((((m16468s().mo1370a() + m16454e().m16323z()) / 1000) / 60) / 60) / 24;
    }

    void m16425G() {
        if (m16452d().m16015N()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    void m16426H() {
        if (!m16452d().m16015N()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    public void m16427I() {
        Map map = null;
        int i = 0;
        m16475z();
        m16432a();
        if (!m16452d().m16015N()) {
            Boolean B = m16454e().m16311B();
            if (B == null) {
                m16455f().m16262z().m16263a("Upload data called on the client side before use of service was decided");
                return;
            } else if (B.booleanValue()) {
                m16455f().m16242f().m16263a("Upload called in the client side when service should be used");
                return;
            }
        }
        if (m16405M()) {
            m16455f().m16262z().m16263a("Uploading requested multiple times");
        } else if (m16466q().m16274f()) {
            long a = m16468s().mo1370a();
            m16444a(a - m16452d().m16027Z());
            long a2 = m16454e().f10594c.m16328a();
            if (a2 != 0) {
                m16455f().m16234D().m16264a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(a - a2)));
            }
            String C = m16465p().m16080C();
            if (TextUtils.isEmpty(C)) {
                String b = m16465p().m16110b(a - m16452d().m16027Z());
                if (!TextUtils.isEmpty(b)) {
                    dux b2 = m16465p().m16108b(b);
                    if (b2 != null) {
                        String a3 = m16452d().m16031a(b2.m15641d(), b2.m15638c());
                        try {
                            URL url = new URL(a3);
                            m16455f().m16235E().m16264a("Fetching remote configuration", b2.m15635b());
                            drn a4 = m16459j().m16342a(b2.m15635b());
                            CharSequence b3 = m16459j().m16345b(b2.m15635b());
                            if (!(a4 == null || TextUtils.isEmpty(b3))) {
                                map = new fq();
                                map.put("If-Modified-Since", b3);
                            }
                            m16466q().m16271a(b, url, map, new dyi(this));
                            return;
                        } catch (MalformedURLException e) {
                            m16455f().m16242f().m16264a("Failed to parse config URL. Not fetching", a3);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            List<Pair> a5 = m16465p().m16092a(C, m16452d().m16045h(C), m16452d().m16047i(C));
            if (!a5.isEmpty()) {
                dru com_ushareit_listenit_dru;
                Object obj;
                List subList;
                for (Pair pair : a5) {
                    com_ushareit_listenit_dru = (dru) pair.first;
                    if (!TextUtils.isEmpty(com_ushareit_listenit_dru.f10263t)) {
                        obj = com_ushareit_listenit_dru.f10263t;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    for (int i2 = 0; i2 < a5.size(); i2++) {
                        com_ushareit_listenit_dru = (dru) ((Pair) a5.get(i2)).first;
                        if (!TextUtils.isEmpty(com_ushareit_listenit_dru.f10263t) && !com_ushareit_listenit_dru.f10263t.equals(obj)) {
                            subList = a5.subList(0, i2);
                            break;
                        }
                    }
                }
                subList = a5;
                drt com_ushareit_listenit_drt = new drt();
                com_ushareit_listenit_drt.f10236a = new dru[subList.size()];
                List arrayList = new ArrayList(subList.size());
                while (i < com_ushareit_listenit_drt.f10236a.length) {
                    com_ushareit_listenit_drt.f10236a[i] = (dru) ((Pair) subList.get(i)).first;
                    arrayList.add((Long) ((Pair) subList.get(i)).second);
                    com_ushareit_listenit_drt.f10236a[i].f10262s = Long.valueOf(m16452d().m16014M());
                    com_ushareit_listenit_drt.f10236a[i].f10248d = Long.valueOf(a);
                    com_ushareit_listenit_drt.f10236a[i].f10238A = Boolean.valueOf(m16452d().m16015N());
                    i++;
                }
                Object b4 = m16455f().m16240a(2) ? dwk.m15935b(com_ushareit_listenit_drt) : null;
                byte[] a6 = m16464o().m15957a(com_ushareit_listenit_drt);
                String Y = m16452d().m16026Y();
                try {
                    URL url2 = new URL(Y);
                    m16413a(arrayList);
                    m16454e().f10595d.m16329a(a);
                    Object obj2 = "?";
                    if (com_ushareit_listenit_drt.f10236a.length > 0) {
                        obj2 = com_ushareit_listenit_drt.f10236a[0].f10259p;
                    }
                    m16455f().m16235E().m16266a("Uploading data. app, uncompressed size, data", obj2, Integer.valueOf(a6.length), b4);
                    m16466q().m16272a(C, url2, a6, null, new dyh(this));
                } catch (MalformedURLException e2) {
                    m16455f().m16242f().m16264a("Failed to parse upload URL. Not uploading", Y);
                }
            }
        } else {
            m16455f().m16262z().m16263a("Network not connected, ignoring upload request");
            m16407O();
        }
    }

    void m16428J() {
        this.f10661C++;
    }

    void m16429K() {
        m16475z();
        m16432a();
        if (!this.f10683w) {
            m16455f().m16233C().m16263a("This instance being marked as an uploader");
            m16420B();
        }
        this.f10683w = true;
    }

    boolean m16430L() {
        m16475z();
        m16432a();
        return this.f10683w || m16422D();
    }

    int m16431a(FileChannel fileChannel) {
        int i = 0;
        m16475z();
        if (fileChannel == null || !fileChannel.isOpen()) {
            m16455f().m16242f().m16263a("Bad chanel to read from");
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0);
                int read = fileChannel.read(allocate);
                if (read == 4) {
                    allocate.flip();
                    i = allocate.getInt();
                } else if (read != -1) {
                    m16455f().m16262z().m16264a("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
            } catch (IOException e) {
                m16455f().m16242f().m16264a("Failed to read from channel", e);
            }
        }
        return i;
    }

    void m16432a() {
        if (!this.f10682v) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    void m16433a(AppMetadata appMetadata) {
        m16475z();
        m16432a();
        cfi.m11082a(appMetadata.f1886b);
        m16418c(appMetadata);
    }

    void m16434a(AppMetadata appMetadata, long j) {
        dux b = m16465p().m16108b(appMetadata.f1886b);
        if (!(b == null || b.m15641d() == null || b.m15641d().equals(appMetadata.f1887c))) {
            m16455f().m16262z().m16263a("New GMP App Id passed in. Removing cached database data.");
            m16465p().m16123g(b.m15635b());
            b = null;
        }
        if (b != null && b.m15654i() != null && !b.m15654i().equals(appMetadata.f1888d)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", b.m15654i());
            m16435a(new EventParcel("_au", new EventParams(bundle), "auto", j), appMetadata);
        }
    }

    void m16435a(EventParcel eventParcel, AppMetadata appMetadata) {
        long nanoTime = System.nanoTime();
        m16475z();
        m16432a();
        String str = appMetadata.f1886b;
        cfi.m11082a(str);
        if (!TextUtils.isEmpty(appMetadata.f1887c)) {
            if (!appMetadata.f1893i) {
                m16418c(appMetadata);
            } else if (m16459j().m16346b(str, eventParcel.f1900b)) {
                m16455f().m16262z().m16264a("Dropping blacklisted event", eventParcel.f1900b);
                m16464o().m15945a(11, "_ev", eventParcel.f1900b, 0);
            } else {
                if (m16455f().m16240a(2)) {
                    m16455f().m16235E().m16264a("Logging event", eventParcel);
                }
                m16465p().m16121f();
                try {
                    Bundle b = eventParcel.f1901c.m2444b();
                    m16418c(appMetadata);
                    if ("_iap".equals(eventParcel.f1900b) || "ecommerce_purchase".equals(eventParcel.f1900b)) {
                        long round;
                        Object string = b.getString("currency");
                        if ("ecommerce_purchase".equals(eventParcel.f1900b)) {
                            double d = b.getDouble("value") * 1000000.0d;
                            if (d == 0.0d) {
                                d = ((double) b.getLong("value")) * 1000000.0d;
                            }
                            if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
                                m16455f().m16262z().m16264a("Data lost. Currency value is too big", Double.valueOf(d));
                                m16465p().m16122g();
                                m16465p().m16127z();
                                return;
                            }
                            round = Math.round(d);
                        } else {
                            round = b.getLong("value");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            String toUpperCase = string.toUpperCase(Locale.US);
                            if (toUpperCase.matches("[A-Z]{3}")) {
                                dwj com_ushareit_listenit_dwj;
                                String valueOf = String.valueOf("_ltv_");
                                toUpperCase = String.valueOf(toUpperCase);
                                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                                dwj c = m16465p().m16114c(str, concat);
                                if (c == null || !(c.f10477d instanceof Long)) {
                                    m16465p().m16099a(str, m16452d().m16040e(str) - 1);
                                    com_ushareit_listenit_dwj = new dwj(str, concat, m16468s().mo1370a(), Long.valueOf(round));
                                } else {
                                    com_ushareit_listenit_dwj = new dwj(str, concat, m16468s().mo1370a(), Long.valueOf(round + ((Long) c.f10477d).longValue()));
                                }
                                if (!m16465p().m16106a(com_ushareit_listenit_dwj)) {
                                    m16455f().m16242f().m16265a("Too many unique user properties are set. Ignoring user property.", com_ushareit_listenit_dwj.f10475b, com_ushareit_listenit_dwj.f10477d);
                                    m16464o().m15945a(9, null, null, 0);
                                }
                            }
                        }
                    }
                    boolean a = dwk.m15932a(eventParcel.f1900b);
                    boolean equals = "_err".equals(eventParcel.f1900b);
                    dwp a2 = m16465p().m16089a(m16424F(), str, true, a, false, equals, false);
                    long C = a2.f10486b - m16452d().m16004C();
                    if (C > 0) {
                        if (C % 1000 == 1) {
                            m16455f().m16242f().m16264a("Data loss. Too many events logged. count", Long.valueOf(a2.f10486b));
                        }
                        m16464o().m15945a(16, "_ev", eventParcel.f1900b, 0);
                        m16465p().m16122g();
                        return;
                    }
                    dww a3;
                    if (a) {
                        C = a2.f10485a - m16452d().m16005D();
                        if (C > 0) {
                            if (C % 1000 == 1) {
                                m16455f().m16242f().m16264a("Data loss. Too many public events logged. count", Long.valueOf(a2.f10485a));
                            }
                            m16464o().m15945a(16, "_ev", eventParcel.f1900b, 0);
                            m16465p().m16122g();
                            m16465p().m16127z();
                            return;
                        }
                    }
                    if (equals) {
                        C = a2.f10488d - ((long) m16452d().m16028a(appMetadata.f1886b));
                        if (C > 0) {
                            if (C == 1) {
                                m16455f().m16242f().m16264a("Too many error events logged. count", Long.valueOf(a2.f10488d));
                            }
                            m16465p().m16122g();
                            m16465p().m16127z();
                            return;
                        }
                    }
                    m16464o().m15947a(b, "_o", eventParcel.f1902d);
                    if (m16464o().m15980m(str)) {
                        m16464o().m15947a(b, "_dbg", Long.valueOf(1));
                        m16464o().m15947a(b, "_r", Long.valueOf(1));
                    }
                    long c2 = m16465p().m16113c(str);
                    if (c2 > 0) {
                        m16455f().m16262z().m16264a("Data lost. Too many events stored on disk, deleted", Long.valueOf(c2));
                    }
                    dwv com_ushareit_listenit_dwv = new dwv(this, eventParcel.f1902d, str, eventParcel.f1900b, eventParcel.f1903e, 0, b);
                    dww a4 = m16465p().m16090a(str, com_ushareit_listenit_dwv.f10496b);
                    if (a4 != null) {
                        com_ushareit_listenit_dwv = com_ushareit_listenit_dwv.m16159a(this, a4.f10505e);
                        a3 = a4.m16161a(com_ushareit_listenit_dwv.f10498d);
                    } else if (m16465p().m16126j(str) >= ((long) m16452d().m16003B())) {
                        m16455f().m16242f().m16265a("Too many event names used, ignoring event. name, supported count", com_ushareit_listenit_dwv.f10496b, Integer.valueOf(m16452d().m16003B()));
                        m16464o().m15945a(8, null, null, 0);
                        m16465p().m16127z();
                        return;
                    } else {
                        a3 = new dww(str, com_ushareit_listenit_dwv.f10496b, 0, 0, com_ushareit_listenit_dwv.f10498d);
                    }
                    m16465p().m16098a(a3);
                    m16439a(com_ushareit_listenit_dwv, appMetadata);
                    m16465p().m16122g();
                    if (m16455f().m16240a(2)) {
                        m16455f().m16235E().m16264a("Event recorded", com_ushareit_listenit_dwv);
                    }
                    m16465p().m16127z();
                    m16407O();
                    m16455f().m16235E().m16264a("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } finally {
                    m16465p().m16127z();
                }
            }
        }
    }

    void m16436a(EventParcel eventParcel, String str) {
        dux b = m16465p().m16108b(str);
        if (b == null || TextUtils.isEmpty(b.m15654i())) {
            m16455f().m16234D().m16264a("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = m16467r().getPackageManager().getPackageInfo(str, 0).versionName;
            if (!(b.m15654i() == null || b.m15654i().equals(str2))) {
                m16455f().m16262z().m16264a("App version does not match; dropping event", str);
                return;
            }
        } catch (NameNotFoundException e) {
            if (!"_ui".equals(eventParcel.f1900b)) {
                m16455f().m16262z().m16264a("Could not find package", str);
            }
        }
        EventParcel eventParcel2 = eventParcel;
        m16435a(eventParcel2, new AppMetadata(str, b.m15641d(), b.m15654i(), b.m15656j(), b.m15658k(), b.m15660l(), b.m15662m(), null, b.m15665n(), false, b.m15647f()));
    }

    void m16437a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        int i = 0;
        m16475z();
        m16432a();
        if (!TextUtils.isEmpty(appMetadata.f1887c)) {
            if (appMetadata.f1893i) {
                int e = m16464o().m15968e(userAttributeParcel.f1905b);
                String a;
                if (e != 0) {
                    a = m16464o().m15944a(userAttributeParcel.f1905b, m16452d().m16037d(), true);
                    if (userAttributeParcel.f1905b != null) {
                        i = userAttributeParcel.f1905b.length();
                    }
                    m16464o().m15945a(e, "_ev", a, i);
                    return;
                }
                e = m16464o().m15964c(userAttributeParcel.f1905b, userAttributeParcel.m2445a());
                if (e != 0) {
                    a = m16464o().m15944a(userAttributeParcel.f1905b, m16452d().m16037d(), true);
                    Object a2 = userAttributeParcel.m2445a();
                    if (a2 != null && ((a2 instanceof String) || (a2 instanceof CharSequence))) {
                        i = String.valueOf(a2).length();
                    }
                    m16464o().m15945a(e, "_ev", a, i);
                    return;
                }
                Object d = m16464o().m15967d(userAttributeParcel.f1905b, userAttributeParcel.m2445a());
                if (d != null) {
                    dwj com_ushareit_listenit_dwj = new dwj(appMetadata.f1886b, userAttributeParcel.f1905b, userAttributeParcel.f1906c, d);
                    m16455f().m16234D().m16265a("Setting user property", com_ushareit_listenit_dwj.f10475b, d);
                    m16465p().m16121f();
                    try {
                        m16418c(appMetadata);
                        boolean a3 = m16465p().m16106a(com_ushareit_listenit_dwj);
                        m16465p().m16122g();
                        if (a3) {
                            m16455f().m16234D().m16265a("User property set", com_ushareit_listenit_dwj.f10475b, com_ushareit_listenit_dwj.f10477d);
                        } else {
                            m16455f().m16242f().m16265a("Too many unique user properties are set. Ignoring user property.", com_ushareit_listenit_dwj.f10475b, com_ushareit_listenit_dwj.f10477d);
                            m16464o().m15945a(9, null, null, 0);
                        }
                        m16465p().m16127z();
                        return;
                    } catch (Throwable th) {
                        m16465p().m16127z();
                    }
                } else {
                    return;
                }
            }
            m16418c(appMetadata);
        }
    }

    void m16438a(duy com_ushareit_listenit_duy) {
        this.f10660B++;
    }

    void m16439a(dwv com_ushareit_listenit_dwv, AppMetadata appMetadata) {
        m16475z();
        m16432a();
        cfi.m11080a((Object) com_ushareit_listenit_dwv);
        cfi.m11080a((Object) appMetadata);
        cfi.m11082a(com_ushareit_listenit_dwv.f10495a);
        cfi.m11089b(com_ushareit_listenit_dwv.f10495a.equals(appMetadata.f1886b));
        dru com_ushareit_listenit_dru = new dru();
        com_ushareit_listenit_dru.f10245a = Integer.valueOf(1);
        com_ushareit_listenit_dru.f10253j = "android";
        com_ushareit_listenit_dru.f10259p = appMetadata.f1886b;
        com_ushareit_listenit_dru.f10258o = appMetadata.f1889e;
        com_ushareit_listenit_dru.f10260q = appMetadata.f1888d;
        com_ushareit_listenit_dru.f10241D = Integer.valueOf((int) appMetadata.f1895k);
        com_ushareit_listenit_dru.f10261r = Long.valueOf(appMetadata.f1890f);
        com_ushareit_listenit_dru.f10269z = appMetadata.f1887c;
        com_ushareit_listenit_dru.f10266w = appMetadata.f1891g == 0 ? null : Long.valueOf(appMetadata.f1891g);
        Pair a = m16454e().m16314a(appMetadata.f1886b);
        if (a != null && !TextUtils.isEmpty((CharSequence) a.first)) {
            com_ushareit_listenit_dru.f10263t = (String) a.first;
            com_ushareit_listenit_dru.f10264u = (Boolean) a.second;
        } else if (!m16470u().m16135a(this.f10662b)) {
            String string = Secure.getString(this.f10662b.getContentResolver(), "android_id");
            if (string == null) {
                m16455f().m16262z().m16263a("null secure ID");
                string = "null";
            } else if (string.isEmpty()) {
                m16455f().m16262z().m16263a("empty secure ID");
            }
            com_ushareit_listenit_dru.f10244G = string;
        }
        com_ushareit_listenit_dru.f10255l = m16470u().m16137f();
        com_ushareit_listenit_dru.f10254k = m16470u().m16138g();
        com_ushareit_listenit_dru.f10257n = Integer.valueOf((int) m16470u().m16157z());
        com_ushareit_listenit_dru.f10256m = m16470u().m16134A();
        com_ushareit_listenit_dru.f10262s = null;
        com_ushareit_listenit_dru.f10248d = null;
        com_ushareit_listenit_dru.f10249e = null;
        com_ushareit_listenit_dru.f10250f = null;
        dux b = m16465p().m16108b(appMetadata.f1886b);
        if (b == null) {
            b = new dux(this, appMetadata.f1886b);
            b.m15633a(m16454e().m16321f());
            b.m15643d(appMetadata.f1896l);
            b.m15637b(appMetadata.f1887c);
            b.m15640c(m16454e().m16316b(appMetadata.f1886b));
            b.m15648f(0);
            b.m15632a(0);
            b.m15636b(0);
            b.m15646e(appMetadata.f1888d);
            b.m15639c(appMetadata.f1895k);
            b.m15649f(appMetadata.f1889e);
            b.m15642d(appMetadata.f1890f);
            b.m15645e(appMetadata.f1891g);
            b.m15634a(appMetadata.f1893i);
            m16465p().m16096a(b);
        }
        com_ushareit_listenit_dru.f10265v = b.m15638c();
        com_ushareit_listenit_dru.f10240C = b.m15647f();
        List a2 = m16465p().m16091a(appMetadata.f1886b);
        com_ushareit_listenit_dru.f10247c = new drw[a2.size()];
        for (int i = 0; i < a2.size(); i++) {
            drw com_ushareit_listenit_drw = new drw();
            com_ushareit_listenit_dru.f10247c[i] = com_ushareit_listenit_drw;
            com_ushareit_listenit_drw.f10274b = ((dwj) a2.get(i)).f10475b;
            com_ushareit_listenit_drw.f10273a = Long.valueOf(((dwj) a2.get(i)).f10476c);
            m16464o().m15949a(com_ushareit_listenit_drw, ((dwj) a2.get(i)).f10477d);
        }
        try {
            m16465p().m16097a(com_ushareit_listenit_dwv, m16465p().m16088a(com_ushareit_listenit_dru), m16414a(com_ushareit_listenit_dwv));
        } catch (IOException e) {
            m16455f().m16242f().m16264a("Data loss. Failed to insert raw event metadata", e);
        }
    }

    void m16440a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        int i2 = 0;
        m16475z();
        m16432a();
        cfi.m11082a(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        m16465p().m16121f();
        try {
            dux b = m16465p().m16108b(str);
            int i3 = ((i == 200 || i == 204 || i == 304) && th == null) ? 1 : 0;
            if (b == null) {
                m16455f().m16262z().m16264a("App does not exist in onConfigFetched", str);
            } else if (i3 != 0 || i == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (m16459j().m16342a(str) == null && !m16459j().m16344a(str, null, null)) {
                        m16465p().m16127z();
                        return;
                    }
                } else if (!m16459j().m16344a(str, bArr, str2)) {
                    m16465p().m16127z();
                    return;
                }
                b.m15651g(m16468s().mo1370a());
                m16465p().m16096a(b);
                if (i == 404) {
                    m16455f().m16262z().m16263a("Config not found. Using empty config");
                } else {
                    m16455f().m16235E().m16265a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (m16466q().m16274f() && m16406N()) {
                    m16427I();
                } else {
                    m16407O();
                }
            } else {
                b.m15653h(m16468s().mo1370a());
                m16465p().m16096a(b);
                m16455f().m16235E().m16265a("Fetching config failed. code, error", Integer.valueOf(i), th);
                m16459j().m16347c(str);
                m16454e().f10595d.m16329a(m16468s().mo1370a());
                if (i == 503 || i == 429) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    m16454e().f10596e.m16329a(m16468s().mo1370a());
                }
                m16407O();
            }
            m16465p().m16122g();
        } finally {
            m16465p().m16127z();
        }
    }

    public void m16441a(boolean z) {
        m16407O();
    }

    boolean m16442a(int i, int i2) {
        m16475z();
        if (i > i2) {
            m16455f().m16242f().m16265a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (m16443a(i2, m16419A())) {
                m16455f().m16235E().m16265a("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                m16455f().m16242f().m16265a("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }

    boolean m16443a(int i, FileChannel fileChannel) {
        m16475z();
        if (fileChannel == null || !fileChannel.isOpen()) {
            m16455f().m16242f().m16263a("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            m16455f().m16242f().m16264a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            m16455f().m16242f().m16264a("Failed to write to channel", e);
            return false;
        }
    }

    boolean m16444a(long j) {
        return m16415a(null, j);
    }

    public void m16445b(AppMetadata appMetadata) {
        m16475z();
        m16432a();
        cfi.m11080a((Object) appMetadata);
        cfi.m11082a(appMetadata.f1886b);
        if (!TextUtils.isEmpty(appMetadata.f1887c)) {
            if (appMetadata.f1893i) {
                long a = m16468s().mo1370a();
                m16465p().m16121f();
                try {
                    m16434a(appMetadata, a);
                    m16418c(appMetadata);
                    if (m16465p().m16090a(appMetadata.f1886b, "_f") == null) {
                        m16437a(new UserAttributeParcel("_fot", a, Long.valueOf((1 + (a / C0154a.f2954j)) * C0154a.f2954j), "auto"), appMetadata);
                        m16446b(appMetadata, a);
                        m16451c(appMetadata, a);
                    } else if (appMetadata.f1894j) {
                        m16453d(appMetadata, a);
                    }
                    m16465p().m16122g();
                } finally {
                    m16465p().m16127z();
                }
            } else {
                m16418c(appMetadata);
            }
        }
    }

    void m16446b(AppMetadata appMetadata, long j) {
        m16475z();
        m16432a();
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        bundle.putLong("_r", 1);
        bundle.putLong("_uwa", 0);
        bundle.putLong("_pfo", 0);
        bundle.putLong("_sys", 0);
        bundle.putLong("_sysu", 0);
        PackageManager packageManager = m16467r().getPackageManager();
        if (packageManager == null) {
            m16455f().m16242f().m16263a("PackageManager is null, first open report might be inaccurate");
        } else {
            PackageInfo packageInfo;
            ApplicationInfo applicationInfo;
            try {
                packageInfo = packageManager.getPackageInfo(appMetadata.f1886b, 0);
            } catch (NameNotFoundException e) {
                m16455f().m16242f().m16264a("Package info is null, first open report might be inaccurate", e);
                packageInfo = null;
            }
            if (!(packageInfo == null || packageInfo.firstInstallTime == 0 || packageInfo.firstInstallTime == packageInfo.lastUpdateTime)) {
                bundle.putLong("_uwa", 1);
            }
            try {
                applicationInfo = packageManager.getApplicationInfo(appMetadata.f1886b, 0);
            } catch (NameNotFoundException e2) {
                m16455f().m16242f().m16264a("Application info is null, first open report might be inaccurate", e2);
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                if ((applicationInfo.flags & 1) != 0) {
                    bundle.putLong("_sys", 1);
                }
                if ((applicationInfo.flags & 128) != 0) {
                    bundle.putLong("_sysu", 1);
                }
            }
        }
        long h = m16465p().m16124h(appMetadata.f1886b);
        if (h != 0) {
            bundle.putLong("_pfo", h);
        }
        m16435a(new EventParcel("_f", new EventParams(bundle), "auto", j), appMetadata);
    }

    void m16447b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        m16475z();
        m16432a();
        if (!TextUtils.isEmpty(appMetadata.f1887c)) {
            if (appMetadata.f1893i) {
                m16455f().m16234D().m16264a("Removing user property", userAttributeParcel.f1905b);
                m16465p().m16121f();
                try {
                    m16418c(appMetadata);
                    m16465p().m16112b(appMetadata.f1886b, userAttributeParcel.f1905b);
                    m16465p().m16122g();
                    m16455f().m16234D().m16264a("User property removed", userAttributeParcel.f1905b);
                } finally {
                    m16465p().m16127z();
                }
            } else {
                m16418c(appMetadata);
            }
        }
    }

    protected boolean m16448b() {
        boolean z = true;
        m16432a();
        m16475z();
        if (this.f10684x == null) {
            if (m16452d().m16015N()) {
                this.f10684x = Boolean.valueOf(true);
                return true;
            }
            if (!(m16464o().m15977k("android.permission.INTERNET") && m16464o().m15977k("android.permission.ACCESS_NETWORK_STATE") && dxw.m16336a(m16467r(), false) && dvt.m15838a(m16467r(), false))) {
                z = false;
            }
            this.f10684x = Boolean.valueOf(z);
            if (this.f10684x.booleanValue()) {
                this.f10684x = Boolean.valueOf(m16464o().m15972h(m16471v().m16204g()));
            }
        }
        return this.f10684x.booleanValue();
    }

    public byte[] m16449b(EventParcel eventParcel, String str) {
        m16432a();
        m16475z();
        m16426H();
        cfi.m11080a((Object) eventParcel);
        cfi.m11082a(str);
        drt com_ushareit_listenit_drt = new drt();
        m16465p().m16121f();
        try {
            dux b = m16465p().m16108b(str);
            byte[] bArr;
            if (b == null) {
                m16455f().m16234D().m16264a("Log and bundle not available. package_name", str);
                bArr = new byte[0];
                return bArr;
            } else if (b.m15665n()) {
                long j;
                dru com_ushareit_listenit_dru = new dru();
                com_ushareit_listenit_drt.f10236a = new dru[]{com_ushareit_listenit_dru};
                com_ushareit_listenit_dru.f10245a = Integer.valueOf(1);
                com_ushareit_listenit_dru.f10253j = "android";
                com_ushareit_listenit_dru.f10259p = b.m15635b();
                com_ushareit_listenit_dru.f10258o = b.m15658k();
                com_ushareit_listenit_dru.f10260q = b.m15654i();
                com_ushareit_listenit_dru.f10241D = Integer.valueOf((int) b.m15656j());
                com_ushareit_listenit_dru.f10261r = Long.valueOf(b.m15660l());
                com_ushareit_listenit_dru.f10269z = b.m15641d();
                com_ushareit_listenit_dru.f10266w = Long.valueOf(b.m15662m());
                Pair a = m16454e().m16314a(b.m15635b());
                if (!(a == null || TextUtils.isEmpty((CharSequence) a.first))) {
                    com_ushareit_listenit_dru.f10263t = (String) a.first;
                    com_ushareit_listenit_dru.f10264u = (Boolean) a.second;
                }
                com_ushareit_listenit_dru.f10255l = m16470u().m16137f();
                com_ushareit_listenit_dru.f10254k = m16470u().m16138g();
                com_ushareit_listenit_dru.f10257n = Integer.valueOf((int) m16470u().m16157z());
                com_ushareit_listenit_dru.f10256m = m16470u().m16134A();
                com_ushareit_listenit_dru.f10265v = b.m15638c();
                com_ushareit_listenit_dru.f10240C = b.m15647f();
                List a2 = m16465p().m16091a(b.m15635b());
                com_ushareit_listenit_dru.f10247c = new drw[a2.size()];
                for (int i = 0; i < a2.size(); i++) {
                    drw com_ushareit_listenit_drw = new drw();
                    com_ushareit_listenit_dru.f10247c[i] = com_ushareit_listenit_drw;
                    com_ushareit_listenit_drw.f10274b = ((dwj) a2.get(i)).f10475b;
                    com_ushareit_listenit_drw.f10273a = Long.valueOf(((dwj) a2.get(i)).f10476c);
                    m16464o().m15949a(com_ushareit_listenit_drw, ((dwj) a2.get(i)).f10477d);
                }
                Bundle b2 = eventParcel.f1901c.m2444b();
                if ("_iap".equals(eventParcel.f1900b)) {
                    b2.putLong("_c", 1);
                    m16455f().m16234D().m16263a("Marking in-app purchase as real-time");
                    b2.putLong("_r", 1);
                }
                b2.putString("_o", eventParcel.f1902d);
                if (m16464o().m15980m(com_ushareit_listenit_dru.f10259p)) {
                    m16464o().m15947a(b2, "_dbg", Long.valueOf(1));
                    m16464o().m15947a(b2, "_r", Long.valueOf(1));
                }
                dww a3 = m16465p().m16090a(str, eventParcel.f1900b);
                if (a3 == null) {
                    m16465p().m16098a(new dww(str, eventParcel.f1900b, 1, 0, eventParcel.f1903e));
                    j = 0;
                } else {
                    j = a3.f10505e;
                    m16465p().m16098a(a3.m16161a(eventParcel.f1903e).m16160a());
                }
                dwv com_ushareit_listenit_dwv = new dwv(this, eventParcel.f1902d, str, eventParcel.f1900b, eventParcel.f1903e, j, b2);
                drr com_ushareit_listenit_drr = new drr();
                com_ushareit_listenit_dru.f10246b = new drr[]{com_ushareit_listenit_drr};
                com_ushareit_listenit_drr.f10227c = Long.valueOf(com_ushareit_listenit_dwv.f10498d);
                com_ushareit_listenit_drr.f10226b = com_ushareit_listenit_dwv.f10496b;
                com_ushareit_listenit_drr.f10228d = Long.valueOf(com_ushareit_listenit_dwv.f10499e);
                com_ushareit_listenit_drr.f10225a = new drs[com_ushareit_listenit_dwv.f10500f.m2442a()];
                Iterator it = com_ushareit_listenit_dwv.f10500f.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    drs com_ushareit_listenit_drs = new drs();
                    int i3 = i2 + 1;
                    com_ushareit_listenit_drr.f10225a[i2] = com_ushareit_listenit_drs;
                    com_ushareit_listenit_drs.f10231a = str2;
                    m16464o().m15948a(com_ushareit_listenit_drs, com_ushareit_listenit_dwv.f10500f.m2443a(str2));
                    i2 = i3;
                }
                com_ushareit_listenit_dru.f10239B = m16416a(b.m15635b(), com_ushareit_listenit_dru.f10247c, com_ushareit_listenit_dru.f10246b);
                com_ushareit_listenit_dru.f10249e = com_ushareit_listenit_drr.f10227c;
                com_ushareit_listenit_dru.f10250f = com_ushareit_listenit_drr.f10227c;
                long h = b.m15652h();
                com_ushareit_listenit_dru.f10252i = h != 0 ? Long.valueOf(h) : null;
                long g = b.m15650g();
                if (g != 0) {
                    h = g;
                }
                com_ushareit_listenit_dru.f10251h = h != 0 ? Long.valueOf(h) : null;
                b.m15669r();
                com_ushareit_listenit_dru.f10267x = Integer.valueOf((int) b.m15666o());
                com_ushareit_listenit_dru.f10262s = Long.valueOf(m16452d().m16014M());
                com_ushareit_listenit_dru.f10248d = Long.valueOf(m16468s().mo1370a());
                com_ushareit_listenit_dru.f10238A = Boolean.TRUE;
                b.m15632a(com_ushareit_listenit_dru.f10249e.longValue());
                b.m15636b(com_ushareit_listenit_dru.f10250f.longValue());
                m16465p().m16096a(b);
                m16465p().m16122g();
                m16465p().m16127z();
                try {
                    bArr = new byte[com_ushareit_listenit_drt.m13475g()];
                    dga a4 = dga.m14159a(bArr);
                    com_ushareit_listenit_drt.mo1666a(a4);
                    a4.m14204b();
                    return m16464o().m15958a(bArr);
                } catch (IOException e) {
                    m16455f().m16242f().m16264a("Data loss. Failed to bundle and serialize", e);
                    return null;
                }
            } else {
                m16455f().m16234D().m16264a("Log and bundle disabled. package_name", str);
                bArr = new byte[0];
                m16465p().m16127z();
                return bArr;
            }
        } finally {
            m16465p().m16127z();
        }
    }

    protected void m16450c() {
        m16475z();
        if (!m16422D() || (this.f10666f.m15694a() && !this.f10666f.m15695b())) {
            m16465p().m16082E();
            if (m16454e().f10594c.m16328a() == 0) {
                m16454e().f10594c.m16329a(m16468s().mo1370a());
            }
            if (m16448b()) {
                if (!(m16452d().m16015N() || TextUtils.isEmpty(m16471v().m16204g()))) {
                    String A = m16454e().m16310A();
                    if (A == null) {
                        m16454e().m16318c(m16471v().m16204g());
                    } else if (!A.equals(m16471v().m16204g())) {
                        m16455f().m16233C().m16263a("Rechecking which service to use due to a GMP App Id change");
                        m16454e().m16312C();
                        this.f10675o.m15795C();
                        this.f10675o.m15793A();
                        m16454e().m16318c(m16471v().m16204g());
                    }
                }
                if (!(m16452d().m16015N() || m16422D() || TextUtils.isEmpty(m16471v().m16204g()))) {
                    m16461l().m15759g();
                }
            } else if (m16423E()) {
                if (!m16464o().m15977k("android.permission.INTERNET")) {
                    m16455f().m16242f().m16263a("App is missing INTERNET permission");
                }
                if (!m16464o().m15977k("android.permission.ACCESS_NETWORK_STATE")) {
                    m16455f().m16242f().m16263a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!m16452d().m16015N()) {
                    if (!dxw.m16336a(m16467r(), false)) {
                        m16455f().m16242f().m16263a("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!dvt.m15838a(m16467r(), false)) {
                        m16455f().m16242f().m16263a("AppMeasurementService not registered/enabled");
                    }
                }
                if (!m16422D()) {
                    m16455f().m16242f().m16263a("Uploading is not possible. App measurement disabled");
                }
            }
            m16407O();
            return;
        }
        m16455f().m16242f().m16263a("Scheduler shutting down before Scion.start() called");
    }

    void m16451c(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        m16435a(new EventParcel("_e", new EventParams(bundle), "auto", j), appMetadata);
    }

    public dwn m16452d() {
        return this.f10663c;
    }

    void m16453d(AppMetadata appMetadata, long j) {
        m16435a(new EventParcel("_cd", new EventParams(new Bundle()), "auto", j), appMetadata);
    }

    public dxr m16454e() {
        m16412a(this.f10664d);
        return this.f10664d;
    }

    public dxg m16455f() {
        m16417b(this.f10665e);
        return this.f10665e;
    }

    public dxg m16456g() {
        return (this.f10665e == null || !this.f10665e.m15694a()) ? null : this.f10665e;
    }

    public dya m16457h() {
        m16417b(this.f10666f);
        return this.f10666f;
    }

    public dvx m16458i() {
        m16417b(this.f10667g);
        return this.f10667g;
    }

    public dxz m16459j() {
        m16417b(this.f10668h);
        return this.f10668h;
    }

    dya m16460k() {
        return this.f10666f;
    }

    public dva m16461l() {
        m16417b(this.f10677q);
        return this.f10677q;
    }

    public AppMeasurement m16462m() {
        return this.f10669i;
    }

    public eap m16463n() {
        return this.f10670j;
    }

    public dwk m16464o() {
        m16412a(this.f10671k);
        return this.f10671k;
    }

    public dwo m16465p() {
        m16417b(this.f10672l);
        return this.f10672l;
    }

    public dxj m16466q() {
        m16417b(this.f10673m);
        return this.f10673m;
    }

    public Context m16467r() {
        return this.f10662b;
    }

    public cio m16468s() {
        return this.f10674n;
    }

    public dvg m16469t() {
        m16417b(this.f10675o);
        return this.f10675o;
    }

    public dwu m16470u() {
        m16417b(this.f10676p);
        return this.f10676p;
    }

    public dxe m16471v() {
        m16417b(this.f10678r);
        return this.f10678r;
    }

    public dxo m16472w() {
        if (this.f10679s != null) {
            return this.f10679s;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public dwg m16473x() {
        m16417b(this.f10680t);
        return this.f10680t;
    }

    public dwm m16474y() {
        m16417b(this.f10681u);
        return this.f10681u;
    }

    public void m16475z() {
        m16457h().mo2083j();
    }
}
