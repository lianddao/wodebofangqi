package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.List;

public class gef {
    private ebj f13985a;
    private get f13986b;
    private geq f13987c;
    private String f13988d;
    private gev f13989e;
    private boolean f13990f;
    private geu f13991g;

    public static gef m21805a() {
        return ger.f14010a;
    }

    public void m21830b() {
        if (m21838h() && m21835e()) {
            try {
                FirebaseAuth.m2463a().m2475a(new geg(this));
            } catch (Throwable e) {
                exw.m18450b("LOGIN.CONTROLLER", "init error=", e);
            }
        }
    }

    public void m21829a(boolean z) {
        this.f13990f = z;
    }

    private void m21816i() {
        if (this.f13990f) {
            this.f13990f = false;
            FirebaseAuth.m2463a().m2484e();
        }
    }

    public void m21822a(Activity activity) {
        exw.m18454c("LOGIN.CONTROLLER", "signInGoogle()");
        m21816i();
        this.f13988d = "google.com";
        this.f13989e = new gds();
        this.f13989e.mo2659a(this.f13991g);
        this.f13989e.mo2658a(activity);
    }

    public void m21831b(Activity activity) {
        exw.m18454c("LOGIN.CONTROLLER", "signInFacebook()");
        m21816i();
        this.f13988d = "facebook.com";
        this.f13989e = new gdq();
        this.f13989e.mo2659a(this.f13991g);
        this.f13989e.mo2658a(activity);
    }

    public void m21824a(get com_ushareit_listenit_get) {
        this.f13986b = com_ushareit_listenit_get;
    }

    public void m21833c() {
        this.f13986b = null;
    }

    public void m21827a(String str, String str2, get com_ushareit_listenit_get) {
        m21816i();
        FirebaseAuth.m2463a().m2473a(str, str2).mo2124a(new geh(this, str2, com_ushareit_listenit_get));
    }

    public void m21828a(String str, String str2, String str3, ges com_ushareit_listenit_ges) {
        m21816i();
        FirebaseAuth.m2463a().m2480b(str, str3).mo2124a(new gei(this, str2, str3, com_ushareit_listenit_ges));
    }

    public void m21834d() {
        FirebaseAuth.m2463a().m2484e();
        exw.m18454c("LOGIN.CONTROLLER", "provider:" + (this.f13989e == null ? "null" : "false"));
        if (this.f13989e != null) {
            this.f13989e.mo2656a();
        } else {
            String H = gvj.m22868H(eys.m18562a());
            exw.m18454c("LOGIN.CONTROLLER", "providerId=" + H);
            if (H.equals("google.com")) {
                this.f13989e = new gds();
                this.f13989e.mo2656a();
            }
        }
        gvj.m22933d(eys.m18562a(), false);
        m21817j();
    }

    private void m21817j() {
        exw.m18443a("LOGIN.CONTROLLER", "inLogoutState");
        fle.m19717b().m19749o();
        fle.m19717b().m19731c();
        for (glg com_ushareit_listenit_glg : fqs.m20466d()) {
            frf.m20668c(com_ushareit_listenit_glg, 0);
            frf.m20645a(com_ushareit_listenit_glg, 0);
        }
        List<glc> m = fqs.m20480m();
        List arrayList = new ArrayList(m.size());
        for (glc com_ushareit_listenit_glc : m) {
            arrayList.add(com_ushareit_listenit_glc.f14283c);
        }
        frd.m20606a(arrayList, 0);
        frd.m20607a(arrayList, 0);
    }

    public void m21826a(String str, get com_ushareit_listenit_get) {
        FirebaseAuth.m2463a().m2479b(str).mo2124a(new gek(this, com_ushareit_listenit_get));
    }

    public boolean m21835e() {
        return gvj.m22867G(eys.m18562a());
    }

    public String m21836f() {
        return gvj.m22871J(eys.m18562a());
    }

    public String m21837g() {
        return gvj.m22870I(eys.m18562a());
    }

    public void m21823a(geq com_ushareit_listenit_geq) {
        this.f13987c = com_ushareit_listenit_geq;
    }

    public void m21825a(String str) {
        if (!fbb.m18763c(str)) {
            FirebaseAuth.m2463a().m2472a(str).mo2124a(new gel(this, str));
        }
    }

    public void m21821a(int i, int i2, Intent intent) {
        if (this.f13989e != null) {
            this.f13989e.mo2657a(i, i2, intent);
        }
    }

    void m21832b(String str, get com_ushareit_listenit_get) {
        if (this.f13985a != null) {
            this.f13985a.m11707a(new ebr().m16664a(str).m16663a()).mo2124a(new gem(this, com_ushareit_listenit_get));
        }
    }

    public boolean m21838h() {
        return m21820m() && m21819l();
    }

    private String m21818k() {
        return gvj.m22872K(eys.m18562a());
    }

    private void m21811b(String str) {
        Context a = eys.m18562a();
        gvj.m22933d(a, true);
        gvj.m22950f(a, this.f13988d);
        gvj.m22958g(a, this.f13985a.mo1428a());
        gvj.m22966h(a, this.f13985a.mo1430c());
        gvj.m22991k(a, this.f13985a.mo1432e());
        String uri = (this.f13985a.mo1431d() == null || fbb.m18763c(this.f13985a.mo1431d().toString())) ? "" : this.f13985a.mo1431d().toString();
        gvj.m22898a(a, this.f13985a.mo1428a(), uri);
        this.f13985a.m11712c(false).mo2125a(new gen(this));
        gvj.m22974i(a, str);
    }

    private boolean m21819l() {
        return cdd.m10887a().mo1287a(eys.m18562a()) == 0;
    }

    private boolean m21820m() {
        return VERSION.SDK_INT >= 9;
    }

    private gef() {
        this.f13990f = false;
        this.f13991g = new gep(this);
    }

    private void m21807a(eat com_ushareit_listenit_eat) {
        exw.m18454c("LOGIN.CONTROLLER", "signInFirebase()");
        FirebaseAuth.m2463a().m2469a(com_ushareit_listenit_eat).mo2124a(new geo(this));
    }
}
