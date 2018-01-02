package com.ushareit.listenit;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdView;
import java.util.Date;
import java.util.Set;

public abstract class beg implements bzj, bzn, cal, dkr {
    protected AdView f1417a;
    protected buc f1418b;
    final cak f1419c = new beh(this);
    private btv f1420d;
    private Context f1421e;
    private buc f1422f;
    private cam f1423g;

    public abstract Bundle mo234a(Bundle bundle, Bundle bundle2);

    btw m2027a(Context context, String str) {
        return new btw(context, str);
    }

    btx m2028a(Context context, bzg com_ushareit_listenit_bzg, Bundle bundle, Bundle bundle2) {
        btz com_ushareit_listenit_btz = new btz();
        Date a = com_ushareit_listenit_bzg.mo1875a();
        if (a != null) {
            com_ushareit_listenit_btz.m9853a(a);
        }
        int b = com_ushareit_listenit_bzg.mo1876b();
        if (b != 0) {
            com_ushareit_listenit_btz.m9849a(b);
        }
        Set<String> c = com_ushareit_listenit_bzg.mo1877c();
        if (c != null) {
            for (String a2 : c) {
                com_ushareit_listenit_btz.m9852a(a2);
            }
        }
        Location d = com_ushareit_listenit_bzg.mo1878d();
        if (d != null) {
            com_ushareit_listenit_btz.m9850a(d);
        }
        if (com_ushareit_listenit_bzg.mo1880f()) {
            com_ushareit_listenit_btz.m9855b(bwt.m10268a().m10468a(context));
        }
        if (com_ushareit_listenit_bzg.mo1879e() != -1) {
            com_ushareit_listenit_btz.m9854a(com_ushareit_listenit_bzg.mo1879e() == 1);
        }
        com_ushareit_listenit_btz.m9856b(com_ushareit_listenit_bzg.mo1881g());
        com_ushareit_listenit_btz.m9851a(AdMobAdapter.class, mo234a(bundle, bundle2));
        return com_ushareit_listenit_btz.m9848a();
    }

    public String mo235a(Bundle bundle) {
        return bundle.getString("pubid");
    }

    public void mo221a() {
        if (this.f1417a != null) {
            this.f1417a.mo247c();
            this.f1417a = null;
        }
        if (this.f1418b != null) {
            this.f1418b = null;
        }
        if (this.f1420d != null) {
            this.f1420d = null;
        }
        if (this.f1422f != null) {
            this.f1422f = null;
        }
    }

    public void mo222a(Context context, bzg com_ushareit_listenit_bzg, String str, cam com_ushareit_listenit_cam, Bundle bundle, Bundle bundle2) {
        this.f1421e = context.getApplicationContext();
        this.f1423g = com_ushareit_listenit_cam;
        this.f1423g.mo1229a(this);
    }

    public void mo223a(Context context, bzk com_ushareit_listenit_bzk, Bundle bundle, bua com_ushareit_listenit_bua, bzg com_ushareit_listenit_bzg, Bundle bundle2) {
        this.f1417a = new AdView(context);
        this.f1417a.setAdSize(new bua(com_ushareit_listenit_bua.m9862b(), com_ushareit_listenit_bua.m9860a()));
        this.f1417a.setAdUnitId(mo235a(bundle));
        this.f1417a.setAdListener(new bek(this, com_ushareit_listenit_bzk));
        this.f1417a.mo245a(m2028a(context, com_ushareit_listenit_bzg, bundle2, bundle));
    }

    public void mo224a(Context context, bzm com_ushareit_listenit_bzm, Bundle bundle, bzg com_ushareit_listenit_bzg, Bundle bundle2) {
        this.f1418b = new buc(context);
        this.f1418b.m9870a(mo235a(bundle));
        this.f1418b.m9867a(new bel(this, com_ushareit_listenit_bzm));
        this.f1418b.m9868a(m2028a(context, com_ushareit_listenit_bzg, bundle2, bundle));
    }

    public void mo225a(Context context, bzo com_ushareit_listenit_bzo, Bundle bundle, bzs com_ushareit_listenit_bzs, Bundle bundle2) {
        buw com_ushareit_listenit_bem = new bem(this, com_ushareit_listenit_bzo);
        btw a = m2027a(context, bundle.getString("pubid")).m9842a((btu) com_ushareit_listenit_bem);
        buq h = com_ushareit_listenit_bzs.mo1900h();
        if (h != null) {
            a.m9843a(h);
        }
        if (com_ushareit_listenit_bzs.mo1901i()) {
            a.m9844a((buu) com_ushareit_listenit_bem);
        }
        if (com_ushareit_listenit_bzs.mo1902j()) {
            a.m9845a(com_ushareit_listenit_bem);
        }
        this.f1420d = a.m9841a();
        this.f1420d.m9840a(m2028a(context, com_ushareit_listenit_bzs, bundle2, bundle));
    }

    public void mo226a(bzg com_ushareit_listenit_bzg, Bundle bundle, Bundle bundle2) {
        if (this.f1421e == null || this.f1423g == null) {
            bze.m10488b("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.f1422f = new buc(this.f1421e);
        this.f1422f.m9871a(true);
        this.f1422f.m9870a(mo235a(bundle));
        this.f1422f.m9869a(this.f1419c);
        this.f1422f.m9868a(m2028a(this.f1421e, com_ushareit_listenit_bzg, bundle2, bundle));
    }

    public void mo227b() {
        if (this.f1417a != null) {
            this.f1417a.mo246b();
        }
    }

    public void mo228c() {
        if (this.f1417a != null) {
            this.f1417a.mo244a();
        }
    }

    public View mo229d() {
        return this.f1417a;
    }

    public void mo230e() {
        this.f1418b.m9873c();
    }

    public Bundle mo231f() {
        return new bzi().m10501a(1).m10500a();
    }

    public void mo232g() {
        this.f1422f.m9873c();
    }

    public boolean mo233h() {
        return this.f1423g != null;
    }
}
