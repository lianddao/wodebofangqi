package com.ushareit.listenit;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public final class cea {
    private Account f8164a;
    private final Set<Scope> f8165b = new HashSet();
    private final Set<Scope> f8166c = new HashSet();
    private int f8167d;
    private View f8168e;
    private String f8169f;
    private String f8170g;
    private final Map<cdj<?>, cgt> f8171h = new fq();
    private final Context f8172i;
    private final Map<cdj<?>, cdk> f8173j = new fq();
    private doc f8174k;
    private int f8175l = -1;
    private cec f8176m;
    private Looper f8177n;
    private cdd f8178o = cdd.m10887a();
    private cdp<? extends dsb, dsc> f8179p = drx.f10281c;
    private final ArrayList<ceb> f8180q = new ArrayList();
    private final ArrayList<cec> f8181r = new ArrayList();

    public cea(Context context) {
        this.f8172i = context;
        this.f8177n = context.getMainLooper();
        this.f8169f = context.getPackageName();
        this.f8170g = context.getClass().getName();
    }

    private static <C extends cdt, O> C m10950a(cdp<C, O> com_ushareit_listenit_cdp_C__O, Object obj, Context context, Looper looper, cgs com_ushareit_listenit_cgs, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        return com_ushareit_listenit_cdp_C__O.mo1238a(context, looper, com_ushareit_listenit_cgs, obj, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
    }

    private static <C extends cdv, O> cfn m10951a(cdw<C, O> com_ushareit_listenit_cdw_C__O, Object obj, Context context, Looper looper, cgs com_ushareit_listenit_cgs, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        return new cfn(context, looper, com_ushareit_listenit_cdw_C__O.m10918b(), com_ushareit_listenit_ceb, com_ushareit_listenit_cec, com_ushareit_listenit_cgs, com_ushareit_listenit_cdw_C__O.m10919b(obj));
    }

    private void m10952a(cdz com_ushareit_listenit_cdz) {
        dlq.m14802a(this.f8174k).m14805a(this.f8175l, com_ushareit_listenit_cdz, this.f8176m);
    }

    private cdz m10953c() {
        cgs a = m10959a();
        cdj com_ushareit_listenit_cdj = null;
        Map f = a.m11185f();
        Map fqVar = new fq();
        Map fqVar2 = new fq();
        ArrayList arrayList = new ArrayList();
        cdj com_ushareit_listenit_cdj2 = null;
        for (cdj com_ushareit_listenit_cdj3 : this.f8173j.keySet()) {
            cdj com_ushareit_listenit_cdj32;
            cdt a2;
            cdj com_ushareit_listenit_cdj4;
            Object obj = this.f8173j.get(com_ushareit_listenit_cdj32);
            int i = 0;
            if (f.get(com_ushareit_listenit_cdj32) != null) {
                i = ((cgt) f.get(com_ushareit_listenit_cdj32)).f8271b ? 1 : 2;
            }
            fqVar.put(com_ushareit_listenit_cdj32, Integer.valueOf(i));
            ceb com_ushareit_listenit_dme = new dme(com_ushareit_listenit_cdj32, i);
            arrayList.add(com_ushareit_listenit_dme);
            cdj com_ushareit_listenit_cdj5;
            if (com_ushareit_listenit_cdj32.m10912e()) {
                cdw c = com_ushareit_listenit_cdj32.m10910c();
                com_ushareit_listenit_cdj5 = c.m10569a() == 1 ? com_ushareit_listenit_cdj32 : com_ushareit_listenit_cdj2;
                a2 = m10951a(c, obj, this.f8172i, this.f8177n, a, com_ushareit_listenit_dme, (cec) com_ushareit_listenit_dme);
                com_ushareit_listenit_cdj4 = com_ushareit_listenit_cdj5;
            } else {
                cdp b = com_ushareit_listenit_cdj32.m10909b();
                com_ushareit_listenit_cdj5 = b.m10569a() == 1 ? com_ushareit_listenit_cdj32 : com_ushareit_listenit_cdj2;
                a2 = m10950a(b, obj, this.f8172i, this.f8177n, a, com_ushareit_listenit_dme, (cec) com_ushareit_listenit_dme);
                com_ushareit_listenit_cdj4 = com_ushareit_listenit_cdj5;
            }
            fqVar2.put(com_ushareit_listenit_cdj32.m10911d(), a2);
            if (!a2.mo1279d()) {
                com_ushareit_listenit_cdj32 = com_ushareit_listenit_cdj;
            } else if (com_ushareit_listenit_cdj != null) {
                String valueOf = String.valueOf(com_ushareit_listenit_cdj32.m10913f());
                String valueOf2 = String.valueOf(com_ushareit_listenit_cdj.m10913f());
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
            }
            com_ushareit_listenit_cdj2 = com_ushareit_listenit_cdj4;
            com_ushareit_listenit_cdj = com_ushareit_listenit_cdj32;
        }
        if (com_ushareit_listenit_cdj != null) {
            if (com_ushareit_listenit_cdj2 != null) {
                valueOf = String.valueOf(com_ushareit_listenit_cdj.m10913f());
                valueOf2 = String.valueOf(com_ushareit_listenit_cdj2.m10913f());
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
            }
            cfi.m11087a(this.f8164a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", com_ushareit_listenit_cdj.m10913f());
            cfi.m11087a(this.f8165b.equals(this.f8166c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", com_ushareit_listenit_cdj.m10913f());
        }
        return new dnb(this.f8172i, new ReentrantLock(), this.f8177n, a, this.f8178o, this.f8179p, fqVar, this.f8180q, this.f8181r, fqVar2, this.f8175l, dnb.m14992a(fqVar2.values(), true), arrayList);
    }

    public cea m10954a(Handler handler) {
        cfi.m11081a((Object) handler, (Object) "Handler must not be null");
        this.f8177n = handler.getLooper();
        return this;
    }

    public cea m10955a(cdj<? extends cdn> com_ushareit_listenit_cdj__extends_com_ushareit_listenit_cdn) {
        cfi.m11081a((Object) com_ushareit_listenit_cdj__extends_com_ushareit_listenit_cdn, (Object) "Api must not be null");
        this.f8173j.put(com_ushareit_listenit_cdj__extends_com_ushareit_listenit_cdn, null);
        Collection a = com_ushareit_listenit_cdj__extends_com_ushareit_listenit_cdn.m10908a().mo1239a(null);
        this.f8166c.addAll(a);
        this.f8165b.addAll(a);
        return this;
    }

    public <O extends cdl> cea m10956a(cdj<O> com_ushareit_listenit_cdj_O, O o) {
        cfi.m11081a((Object) com_ushareit_listenit_cdj_O, (Object) "Api must not be null");
        cfi.m11081a((Object) o, (Object) "Null options are not permitted for this Api");
        this.f8173j.put(com_ushareit_listenit_cdj_O, o);
        Collection a = com_ushareit_listenit_cdj_O.m10908a().mo1239a(o);
        this.f8166c.addAll(a);
        this.f8165b.addAll(a);
        return this;
    }

    public cea m10957a(ceb com_ushareit_listenit_ceb) {
        cfi.m11081a((Object) com_ushareit_listenit_ceb, (Object) "Listener must not be null");
        this.f8180q.add(com_ushareit_listenit_ceb);
        return this;
    }

    public cea m10958a(cec com_ushareit_listenit_cec) {
        cfi.m11081a((Object) com_ushareit_listenit_cec, (Object) "Listener must not be null");
        this.f8181r.add(com_ushareit_listenit_cec);
        return this;
    }

    public cgs m10959a() {
        dsc com_ushareit_listenit_dsc = dsc.f10288a;
        if (this.f8173j.containsKey(drx.f10285g)) {
            com_ushareit_listenit_dsc = (dsc) this.f8173j.get(drx.f10285g);
        }
        return new cgs(this.f8164a, this.f8165b, this.f8171h, this.f8167d, this.f8168e, this.f8169f, this.f8170g, com_ushareit_listenit_dsc);
    }

    public cdz m10960b() {
        cfi.m11090b(!this.f8173j.isEmpty(), "must call addApi() to add at least one API");
        cdz c = m10953c();
        synchronized (cdz.f8158a) {
            cdz.f8158a.add(c);
        }
        if (this.f8175l >= 0) {
            m10952a(c);
        }
        return c;
    }
}
