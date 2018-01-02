package com.ushareit.listenit;

import android.content.Context;
import com.facebook.ads.C0017i;
import com.facebook.ads.C0059j;
import com.facebook.ads.C0060k;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class aom {
    private static final ExecutorService f5063g = Executors.newSingleThreadExecutor();
    private static String f5064h = null;
    private static aul f5065i = auk.m7203a();
    protected String f5066a;
    protected arz f5067b;
    protected aoi f5068c;
    public Context f5069d;
    public ano f5070e;
    public boolean f5071f;
    private anb f5072j;
    private int f5073k;
    private C0060k f5074l;

    public aom(Context context, String str, C0060k c0060k, ano com_ushareit_listenit_ano, anb com_ushareit_listenit_anb, int i, boolean z) {
        this.f5066a = str;
        this.f5074l = c0060k;
        this.f5070e = com_ushareit_listenit_ano;
        this.f5068c = aoi.m6457a(com_ushareit_listenit_ano);
        this.f5072j = com_ushareit_listenit_anb;
        this.f5073k = i;
        this.f5071f = z;
        m6473a(context);
    }

    private void m6473a(Context context) {
        this.f5069d = context;
        aop.m6483a();
        aor.m6486a(context);
        m6477g();
        f5063g.submit(new aon(this, context));
    }

    private void m6474a(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    private static Map<String, String> m6475b(Context context) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("SDK", "android");
        hashMap.put("SDK_VERSION", "4.23.0");
        hashMap.put("LOCALE", Locale.getDefault().toString());
        float f = context.getResources().getDisplayMetrics().density;
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        hashMap.put("DENSITY", String.valueOf(f));
        hashMap.put("SCREEN_WIDTH", String.valueOf((int) (((float) i) / f)));
        hashMap.put("SCREEN_HEIGHT", String.valueOf((int) (((float) i2) / f)));
        hashMap.put("IDFA", aor.f5100o);
        hashMap.put("IDFA_FLAG", aor.f5101p ? "0" : "1");
        hashMap.put("ATTRIBUTION_ID", aor.f5099n);
        hashMap.put("ID_SOURCE", aor.f5102q);
        hashMap.put("OS", "Android");
        hashMap.put("OSVERS", aor.f5086a);
        hashMap.put("BUNDLE", aor.f5089d);
        hashMap.put("APPNAME", aor.f5090e);
        hashMap.put("APPVERS", aor.f5091f);
        hashMap.put("APPBUILD", String.valueOf(aor.f5092g));
        hashMap.put("CARRIER", aor.f5094i);
        hashMap.put("MAKE", aor.f5087b);
        hashMap.put("MODEL", aor.f5088c);
        hashMap.put("ROOTED", String.valueOf(f5065i.f5511d));
        hashMap.put("COPPA", String.valueOf(C0017i.m966e()));
        hashMap.put("INSTALLER", aor.f5093h);
        hashMap.put("SDK_CAPABILITY", anl.m6389b());
        hashMap.put("NETWORK_TYPE", String.valueOf(auv.m7234c(context).f5548g));
        hashMap.put("REQUEST_TIME", atz.m7159a(System.currentTimeMillis()));
        hashMap.put("SESSION_TIME", atz.m7158a(aop.m6484b()));
        hashMap.put("SESSION_ID", aop.m6485c());
        return hashMap;
    }

    private void m6477g() {
        if (this.f5068c == null) {
            this.f5068c = aoi.UNKNOWN;
        }
        switch (aoo.f5077a[this.f5068c.ordinal()]) {
            case 1:
                this.f5067b = arz.INTERSTITIAL;
                return;
            case 2:
                this.f5067b = arz.BANNER;
                return;
            case 3:
                this.f5067b = arz.NATIVE;
                return;
            case 4:
                this.f5067b = arz.REWARDED_VIDEO;
                return;
            default:
                this.f5067b = arz.UNKNOWN;
                return;
        }
    }

    public String m6478a() {
        return this.f5066a;
    }

    public aoi m6479b() {
        return this.f5068c;
    }

    public C0060k m6480c() {
        return this.f5074l;
    }

    public int m6481d() {
        return this.f5073k;
    }

    public Map<String, String> m6482e() {
        Map<String, String> hashMap = new HashMap();
        m6474a(hashMap, "PLACEMENT_ID", this.f5066a);
        if (this.f5067b != arz.UNKNOWN) {
            m6474a(hashMap, "PLACEMENT_TYPE", this.f5067b.toString().toLowerCase());
        }
        for (Entry entry : m6475b(this.f5069d).entrySet()) {
            m6474a(hashMap, (String) entry.getKey(), (String) entry.getValue());
        }
        if (this.f5074l != null) {
            m6474a(hashMap, "WIDTH", String.valueOf(this.f5074l.m1124a()));
            m6474a(hashMap, "HEIGHT", String.valueOf(this.f5074l.m1125b()));
        }
        m6474a(hashMap, "ADAPTERS", alh.m6047a(this.f5067b));
        if (this.f5070e != null) {
            m6474a(hashMap, "TEMPLATE_ID", String.valueOf(this.f5070e.m6394a()));
        }
        if (this.f5072j != null) {
            m6474a(hashMap, "REQUEST_TYPE", String.valueOf(this.f5072j.m6366a()));
        }
        if (this.f5071f) {
            m6474a(hashMap, "TEST_MODE", "1");
        }
        if (C0017i.m967f() != C0059j.DEFAULT) {
            m6474a(hashMap, "DEMO_AD_ID", C0017i.m967f().m1123a());
        }
        if (this.f5073k != 0) {
            m6474a(hashMap, "NUM_ADS_REQUESTED", String.valueOf(this.f5073k));
        }
        String d = C0017i.m965d();
        if (d != null) {
            m6474a(hashMap, "MEDIATION_SERVICE", d);
        }
        m6474a(hashMap, "CLIENT_EVENTS", att.m7140a());
        if (f5064h != null) {
            m6474a(hashMap, "AFP", f5064h);
        }
        m6474a(hashMap, "UNITY", String.valueOf(atz.m7171a(this.f5069d)));
        m6474a(hashMap, "KG_RESTRICTED", String.valueOf(atp.m7133b(this.f5069d)));
        return hashMap;
    }
}
