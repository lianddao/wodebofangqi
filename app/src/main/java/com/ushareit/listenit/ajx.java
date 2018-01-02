package com.ushareit.listenit;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.C0017i;
import com.facebook.ads.C0060k;
import com.mopub.mobileads.FacebookInterstitial;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ajx implements ase {
    private static final String f4543b = ajx.class.getSimpleName();
    private static final Handler f4544h = new Handler(Looper.getMainLooper());
    private static boolean f4545i = false;
    protected akn f4546a;
    private final Context f4547c;
    private final String f4548d;
    private final arz f4549e;
    private final asa f4550f;
    private final Handler f4551g = new Handler();
    private final Runnable f4552j;
    private final Runnable f4553k;
    private volatile boolean f4554l;
    private boolean f4555m;
    private volatile boolean f4556n;
    private aku f4557o;
    private aku f4558p;
    private View f4559q;
    private aok f4560r;
    private aom f4561s;
    private ano f4562t;
    private anb f4563u;
    private C0060k f4564v;
    private int f4565w;
    private final akm f4566x;
    private boolean f4567y;
    private final apa f4568z;

    public ajx(Context context, String str, ano com_ushareit_listenit_ano, arz com_ushareit_listenit_arz, C0060k c0060k, anb com_ushareit_listenit_anb, int i, boolean z) {
        this.f4547c = context;
        this.f4548d = str;
        this.f4562t = com_ushareit_listenit_ano;
        this.f4549e = com_ushareit_listenit_arz;
        this.f4564v = c0060k;
        this.f4563u = com_ushareit_listenit_anb;
        this.f4565w = i;
        this.f4566x = new akm();
        this.f4550f = new asa(context);
        this.f4550f.m6960a((ase) this);
        this.f4552j = new akk(this);
        this.f4553k = new akl(this);
        this.f4555m = z;
        m5850h();
        try {
            CookieManager.getInstance();
            if (VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
            }
        } catch (Throwable e) {
            Log.w(f4543b, "Failed to initialize CookieManager.", e);
        }
        anm.m6391a(context).m6392a();
        this.f4568z = apb.m6565a(context);
    }

    private Map<String, String> m5830a(long j) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("delay", String.valueOf(System.currentTimeMillis() - j));
        return hashMap;
    }

    private void m5834a(aku com_ushareit_listenit_aku) {
        if (com_ushareit_listenit_aku != null) {
            com_ushareit_listenit_aku.mo674b();
        }
    }

    private void m5835a(akv com_ushareit_listenit_akv, aok com_ushareit_listenit_aok, Map<String, Object> map) {
        Runnable com_ushareit_listenit_aki = new aki(this, com_ushareit_listenit_akv);
        this.f4551g.postDelayed(com_ushareit_listenit_aki, (long) com_ushareit_listenit_aok.m6458a().m6471i());
        com_ushareit_listenit_akv.mo705a(this.f4547c, this.f4564v, new akj(this, com_ushareit_listenit_aki), map);
    }

    private void m5836a(akx com_ushareit_listenit_akx, aok com_ushareit_listenit_aok, Map<String, Object> map) {
        Runnable com_ushareit_listenit_ajz = new ajz(this, com_ushareit_listenit_akx);
        this.f4551g.postDelayed(com_ushareit_listenit_ajz, (long) com_ushareit_listenit_aok.m6458a().m6471i());
        com_ushareit_listenit_akx.mo710a(this.f4547c, new aka(this, com_ushareit_listenit_ajz), map, this.f4568z);
    }

    private void m5837a(aml com_ushareit_listenit_aml, aok com_ushareit_listenit_aok, Map<String, Object> map) {
        com_ushareit_listenit_aml.mo706a(this.f4547c, new akg(this), map, this.f4568z);
    }

    private void m5838a(amp com_ushareit_listenit_amp, aok com_ushareit_listenit_aok, aog com_ushareit_listenit_aog, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        Runnable com_ushareit_listenit_akb = new akb(this, com_ushareit_listenit_amp, currentTimeMillis, com_ushareit_listenit_aog);
        this.f4551g.postDelayed(com_ushareit_listenit_akb, (long) com_ushareit_listenit_aok.m6458a().m6471i());
        com_ushareit_listenit_amp.mo670a(this.f4547c, new akc(this, com_ushareit_listenit_akb, currentTimeMillis, com_ushareit_listenit_aog), this.f4568z, map);
    }

    private void m5839a(amr com_ushareit_listenit_amr, aok com_ushareit_listenit_aok, Map<String, Object> map) {
        com_ushareit_listenit_amr.mo730a(this.f4547c, new akh(this), map);
    }

    private void m5840a(List<String> list, Map<String, String> map) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                new aux(map).execute(new String[]{str});
            }
        }
    }

    private void m5850h() {
        if (!this.f4555m) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f4547c.registerReceiver(this.f4566x, intentFilter);
            this.f4567y = true;
        }
    }

    private void m5852i() {
        if (this.f4567y) {
            try {
                this.f4547c.unregisterReceiver(this.f4566x);
                this.f4567y = false;
            } catch (Throwable e) {
                att.m7141a(atq.m7138a(e, "Error unregistering screen state receiever"));
            }
        }
    }

    private arz m5855j() {
        return this.f4549e != null ? this.f4549e : this.f4564v == null ? arz.NATIVE : this.f4564v == C0060k.f876b ? arz.INTERSTITIAL : arz.BANNER;
    }

    private void m5857k() {
        this.f4561s = new aom(this.f4547c, this.f4548d, this.f4564v, this.f4562t, this.f4563u, this.f4565w, C0017i.m962a(this.f4547c));
        this.f4550f.m6959a(this.f4561s);
    }

    private synchronized void m5858l() {
        f4544h.post(new akf(this));
    }

    private void m5860m() {
        this.f4557o = null;
        aok com_ushareit_listenit_aok = this.f4560r;
        aog c = com_ushareit_listenit_aok.m6461c();
        if (c == null) {
            this.f4546a.mo79a(ajw.NO_FILL.m5822a(""));
            m5863n();
            return;
        }
        String a = c.m6451a();
        aku a2 = alh.m6046a(a, com_ushareit_listenit_aok.m6458a().m6463a());
        if (a2 == null) {
            Log.e(f4543b, "Adapter does not exist: " + a);
            m5858l();
        } else if (m5855j() != a2.mo668a()) {
            this.f4546a.mo79a(ajw.INTERNAL_ERROR.m5822a(""));
        } else {
            this.f4557o = a2;
            Map hashMap = new HashMap();
            aol a3 = com_ushareit_listenit_aok.m6458a();
            hashMap.put("data", c.m6453b());
            hashMap.put("definition", a3);
            if (this.f4561s == null) {
                this.f4546a.mo79a(ajw.UNKNOWN_ERROR.m5822a("environment is empty"));
                return;
            }
            switch (ake.f4588a[a2.mo668a().ordinal()]) {
                case 1:
                    m5836a((akx) a2, com_ushareit_listenit_aok, hashMap);
                    return;
                case 2:
                    m5835a((akv) a2, com_ushareit_listenit_aok, hashMap);
                    return;
                case 3:
                    m5838a((amp) a2, com_ushareit_listenit_aok, c, hashMap);
                    return;
                case 4:
                    m5837a((aml) a2, com_ushareit_listenit_aok, hashMap);
                    return;
                case 5:
                    hashMap.put(FacebookInterstitial.PLACEMENT_ID_KEY, this.f4548d);
                    m5839a((amr) a2, com_ushareit_listenit_aok, hashMap);
                    return;
                default:
                    Log.e(f4543b, "attempt unexpected adapter type");
                    return;
            }
        }
    }

    private void m5863n() {
        if (!this.f4555m && !this.f4554l) {
            switch (ake.f4588a[m5855j().ordinal()]) {
                case 1:
                    if (!auk.m7204a(this.f4547c)) {
                        this.f4551g.postDelayed(this.f4553k, 1000);
                        break;
                    }
                    break;
                case 2:
                    boolean a = aru.m6918a(this.f4559q, this.f4560r == null ? 1 : this.f4560r.m6458a().m6467e()).m6938a();
                    if (!(this.f4559q == null || a)) {
                        this.f4551g.postDelayed(this.f4553k, 1000);
                        return;
                    }
                default:
                    return;
            }
            long b = this.f4560r == null ? 30000 : this.f4560r.m6458a().m6464b();
            if (b > 0) {
                this.f4551g.postDelayed(this.f4552j, b);
                this.f4554l = true;
            }
        }
    }

    private void m5865o() {
        if (this.f4554l) {
            this.f4551g.removeCallbacks(this.f4552j);
            this.f4554l = false;
        }
    }

    private Handler m5866p() {
        return !m5867q() ? this.f4551g : f4544h;
    }

    private static synchronized boolean m5867q() {
        boolean z;
        synchronized (ajx.class) {
            z = f4545i;
        }
        return z;
    }

    public aol m5868a() {
        return this.f4560r == null ? null : this.f4560r.m6458a();
    }

    public void m5869a(akn com_ushareit_listenit_akn) {
        this.f4546a = com_ushareit_listenit_akn;
    }

    public synchronized void mo640a(amu com_ushareit_listenit_amu) {
        m5866p().post(new akd(this, com_ushareit_listenit_amu));
    }

    public synchronized void mo641a(asj com_ushareit_listenit_asj) {
        m5866p().post(new ajy(this, com_ushareit_listenit_asj));
    }

    public void m5872b() {
        m5857k();
    }

    public void m5873c() {
        if (this.f4558p == null) {
            throw new IllegalStateException("no adapter ready to start");
        } else if (this.f4556n) {
            throw new IllegalStateException("ad already started");
        } else {
            this.f4556n = true;
            switch (ake.f4588a[this.f4558p.mo668a().ordinal()]) {
                case 1:
                    ((akx) this.f4558p).mo711c();
                    return;
                case 2:
                    if (this.f4559q != null) {
                        this.f4546a.mo77a(this.f4559q);
                        m5863n();
                        return;
                    }
                    return;
                case 3:
                    amp com_ushareit_listenit_amp = (amp) this.f4558p;
                    if (com_ushareit_listenit_amp.mo677d()) {
                        this.f4546a.mo91a(com_ushareit_listenit_amp);
                        return;
                    }
                    throw new IllegalStateException("ad is not ready or already displayed");
                case 4:
                    ((aml) this.f4558p).mo707f();
                    return;
                case 5:
                    ((amr) this.f4558p).mo731d();
                    return;
                default:
                    Log.e(f4543b, "start unexpected adapter type");
                    return;
            }
        }
    }

    public void m5874d() {
        m5852i();
        if (this.f4556n) {
            m5865o();
            m5834a(this.f4558p);
            this.f4559q = null;
            this.f4556n = false;
        }
    }

    public void m5875e() {
        if (this.f4556n) {
            m5865o();
        }
    }

    public void m5876f() {
        if (this.f4556n) {
            m5863n();
        }
    }

    public aku m5877g() {
        return this.f4558p;
    }
}
