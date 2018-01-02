package com.ushareit.listenit;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.firebase.auth.api.model.GetTokenResponse;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import java.util.List;

public class cmr {
    private Context f8465a;
    private String f8466b;
    private SharedPreferences f8467c;
    private dao f8468d;
    private dbf f8469e = new dbf();

    public cmr(Context context, String str, dao com_ushareit_listenit_dao) {
        cfi.m11080a((Object) context);
        this.f8466b = cfi.m11082a(str);
        this.f8465a = context.getApplicationContext();
        String format = String.format("com.google.firebase.auth.api.Store.%s", new Object[]{this.f8466b});
        this.f8468d = (dao) cfi.m11080a((Object) com_ushareit_listenit_dao);
        this.f8467c = this.f8465a.getSharedPreferences(format, 0);
    }

    private cmp m11742a(dbd com_ushareit_listenit_dbd) {
        String c = com_ushareit_listenit_dbd.m13718b("cachedTokenState").mo1703c();
        String c2 = com_ushareit_listenit_dbd.m13718b("applicationName").mo1703c();
        boolean g = com_ushareit_listenit_dbd.m13718b("anonymous").mo1707g();
        String str = "2";
        dba b = com_ushareit_listenit_dbd.m13718b("version");
        String c3 = (b == null || b.m13698k()) ? str : b.mo1703c();
        dax c4 = com_ushareit_listenit_dbd.m13719c("userInfos");
        int a = c4.m13703a();
        List arrayList = new ArrayList(a);
        for (int i = 0; i < a; i++) {
            arrayList.add((cmn) this.f8468d.m13654a(c4.m13704a(i), cmn.class));
        }
        cmp com_ushareit_listenit_cmp = new cmp(eah.m16606a(c2), arrayList);
        if (!TextUtils.isEmpty(c)) {
            com_ushareit_listenit_cmp.mo1435a((GetTokenResponse) this.f8468d.m13658a(c, GetTokenResponse.class));
        }
        ((cmp) com_ushareit_listenit_cmp.mo1436b(g)).m11722a(c3);
        return com_ushareit_listenit_cmp;
    }

    private static dba m11743c(String str) {
        return new dbf().m13722a(str);
    }

    private String m11744d(ebj com_ushareit_listenit_ebj) {
        dbd com_ushareit_listenit_dbd = new dbd();
        if (!cmp.class.isAssignableFrom(com_ushareit_listenit_ebj.getClass())) {
            return null;
        }
        cmp com_ushareit_listenit_cmp = (cmp) com_ushareit_listenit_ebj;
        com_ushareit_listenit_dbd.m13716a("cachedTokenState", com_ushareit_listenit_cmp.mo1443m());
        com_ushareit_listenit_dbd.m13716a("applicationName", com_ushareit_listenit_cmp.mo1437g().m16624b());
        com_ushareit_listenit_dbd.m13716a(VastExtensionXmlManager.TYPE, "com.google.firebase.auth.internal.DefaultFirebaseUser");
        if (com_ushareit_listenit_cmp.mo1438h() != null) {
            dba com_ushareit_listenit_dax = new dax();
            List h = com_ushareit_listenit_cmp.mo1438h();
            for (int i = 0; i < h.size(); i++) {
                com_ushareit_listenit_dax.m13705a(m11743c(this.f8468d.m13661a((cmn) h.get(i))));
            }
            com_ushareit_listenit_dbd.m13714a("userInfos", com_ushareit_listenit_dax);
        }
        com_ushareit_listenit_dbd.m13715a("anonymous", Boolean.valueOf(com_ushareit_listenit_cmp.mo1439i()));
        com_ushareit_listenit_dbd.m13716a("version", "2");
        return com_ushareit_listenit_dbd.toString();
    }

    public ebj m11745a() {
        ebj com_ushareit_listenit_ebj = null;
        String b = m11753b("com.google.firebase.auth.FIREBASE_USER");
        if (!TextUtils.isEmpty(b)) {
            try {
                dbd l = this.f8469e.m13722a(b).m13699l();
                if (l.m13717a(VastExtensionXmlManager.TYPE)) {
                    if ("com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(l.m13718b(VastExtensionXmlManager.TYPE).mo1703c())) {
                        com_ushareit_listenit_ebj = m11742a(l);
                    }
                }
            } catch (dbj e) {
            }
        }
        return com_ushareit_listenit_ebj;
    }

    public <T> T m11746a(String str, Class<T> cls) {
        String b = m11753b(str);
        return TextUtils.isEmpty(b) ? null : this.f8468d.m13658a(b, (Class) cls);
    }

    public void m11747a(ebj com_ushareit_listenit_ebj) {
        cfi.m11080a((Object) com_ushareit_listenit_ebj);
        String d = m11744d(com_ushareit_listenit_ebj);
        if (!TextUtils.isEmpty(d)) {
            m11751a("com.google.firebase.auth.FIREBASE_USER", d);
        }
    }

    public void m11748a(ebj com_ushareit_listenit_ebj, GetTokenResponse getTokenResponse) {
        cfi.m11080a((Object) com_ushareit_listenit_ebj);
        cfi.m11080a((Object) getTokenResponse);
        m11750a(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{com_ushareit_listenit_ebj.mo1428a()}), (Object) getTokenResponse);
    }

    public void m11749a(String str) {
        this.f8467c.edit().remove(str).apply();
    }

    public void m11750a(String str, Object obj) {
        this.f8467c.edit().putString(str, this.f8468d.m13661a(obj)).apply();
    }

    public void m11751a(String str, String str2) {
        this.f8467c.edit().putString(str, str2).apply();
    }

    public GetTokenResponse m11752b(ebj com_ushareit_listenit_ebj) {
        cfi.m11080a((Object) com_ushareit_listenit_ebj);
        return (GetTokenResponse) m11746a(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{com_ushareit_listenit_ebj.mo1428a()}), GetTokenResponse.class);
    }

    public String m11753b(String str) {
        return this.f8467c.getString(str, null);
    }

    public void m11754b() {
        m11749a("com.google.firebase.auth.FIREBASE_USER");
    }

    public void m11755c(ebj com_ushareit_listenit_ebj) {
        cfi.m11080a((Object) com_ushareit_listenit_ebj);
        m11749a(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{com_ushareit_listenit_ebj.mo1428a()}));
    }
}
