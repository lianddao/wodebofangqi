package com.ushareit.listenit;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public final class bvi {
    public static final String f7791a = bwt.m10268a().m10469a("emulator");
    private final Date f7792b;
    private final String f7793c;
    private final int f7794d;
    private final Set<String> f7795e;
    private final Location f7796f;
    private final boolean f7797g;
    private final Bundle f7798h;
    private final Map<Class<? extends Object>, Object> f7799i;
    private final String f7800j;
    private final String f7801k;
    private final can f7802l;
    private final int f7803m;
    private final Set<String> f7804n;
    private final Bundle f7805o;
    private final Set<String> f7806p;
    private final boolean f7807q;

    public bvi(bvj com_ushareit_listenit_bvj) {
        this(com_ushareit_listenit_bvj, null);
    }

    public bvi(bvj com_ushareit_listenit_bvj, can com_ushareit_listenit_can) {
        this.f7792b = com_ushareit_listenit_bvj.f7814g;
        this.f7793c = com_ushareit_listenit_bvj.f7815h;
        this.f7794d = com_ushareit_listenit_bvj.f7816i;
        this.f7795e = Collections.unmodifiableSet(com_ushareit_listenit_bvj.f7808a);
        this.f7796f = com_ushareit_listenit_bvj.f7817j;
        this.f7797g = com_ushareit_listenit_bvj.f7818k;
        this.f7798h = com_ushareit_listenit_bvj.f7809b;
        this.f7799i = Collections.unmodifiableMap(com_ushareit_listenit_bvj.f7810c);
        this.f7800j = com_ushareit_listenit_bvj.f7819l;
        this.f7801k = com_ushareit_listenit_bvj.f7820m;
        this.f7802l = com_ushareit_listenit_can;
        this.f7803m = com_ushareit_listenit_bvj.f7821n;
        this.f7804n = Collections.unmodifiableSet(com_ushareit_listenit_bvj.f7811d);
        this.f7805o = com_ushareit_listenit_bvj.f7812e;
        this.f7806p = Collections.unmodifiableSet(com_ushareit_listenit_bvj.f7813f);
        this.f7807q = com_ushareit_listenit_bvj.f7822o;
    }

    public Bundle m9967a(Class<? extends bzh> cls) {
        return this.f7798h.getBundle(cls.getName());
    }

    public Date m9968a() {
        return this.f7792b;
    }

    public boolean m9969a(Context context) {
        return this.f7804n.contains(bwt.m10268a().m10468a(context));
    }

    public String m9970b() {
        return this.f7793c;
    }

    public int m9971c() {
        return this.f7794d;
    }

    public Set<String> m9972d() {
        return this.f7795e;
    }

    public Location m9973e() {
        return this.f7796f;
    }

    public boolean m9974f() {
        return this.f7797g;
    }

    public String m9975g() {
        return this.f7800j;
    }

    public String m9976h() {
        return this.f7801k;
    }

    public can m9977i() {
        return this.f7802l;
    }

    public Map<Class<? extends Object>, Object> m9978j() {
        return this.f7799i;
    }

    public Bundle m9979k() {
        return this.f7798h;
    }

    public int m9980l() {
        return this.f7803m;
    }

    public Bundle m9981m() {
        return this.f7805o;
    }

    public Set<String> m9982n() {
        return this.f7806p;
    }

    public boolean m9983o() {
        return this.f7807q;
    }
}
