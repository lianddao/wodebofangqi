package com.ushareit.listenit;

import android.net.Uri;
import com.google.firebase.auth.api.model.GetTokenResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class cmp extends ebj {
    private GetTokenResponse f8454a;
    private cmn f8455b;
    private String f8456c;
    private String f8457d = "com.google.firebase.auth.internal.DefaultFirebaseUser";
    private List<cmn> f8458e;
    private List<String> f8459f;
    private Map<String, cmn> f8460g;
    private String f8461h = "2";
    private boolean f8462i;
    private dao f8463j = clr.m11613a();

    public cmp(eah com_ushareit_listenit_eah, List<? extends ebq> list) {
        cfi.m11080a((Object) com_ushareit_listenit_eah);
        this.f8456c = com_ushareit_listenit_eah.m16624b();
        mo1434a((List) list);
    }

    public cmp m11722a(String str) {
        this.f8461h = str;
        return this;
    }

    public cmp m11723a(boolean z) {
        this.f8462i = z;
        return this;
    }

    public ebj mo1434a(List<? extends ebq> list) {
        cfi.m11080a((Object) list);
        this.f8458e = new ArrayList(list.size());
        this.f8459f = new ArrayList(list.size());
        this.f8460g = new fq();
        for (int i = 0; i < list.size(); i++) {
            cmn com_ushareit_listenit_cmn = new cmn((ebq) list.get(i));
            if (com_ushareit_listenit_cmn.mo1429b().equals("firebase")) {
                this.f8455b = com_ushareit_listenit_cmn;
            } else {
                this.f8459f.add(com_ushareit_listenit_cmn.mo1429b());
            }
            this.f8458e.add(com_ushareit_listenit_cmn);
            this.f8460g.put(com_ushareit_listenit_cmn.mo1429b(), com_ushareit_listenit_cmn);
        }
        if (this.f8455b == null) {
            this.f8455b = (cmn) this.f8458e.get(0);
        }
        return this;
    }

    public String mo1428a() {
        return this.f8455b.mo1428a();
    }

    public void mo1435a(GetTokenResponse getTokenResponse) {
        this.f8454a = (GetTokenResponse) cfi.m11080a((Object) getTokenResponse);
    }

    public /* synthetic */ ebj mo1436b(boolean z) {
        return m11723a(z);
    }

    public String mo1429b() {
        return this.f8455b.mo1429b();
    }

    public String mo1430c() {
        return this.f8455b.mo1430c();
    }

    public Uri mo1431d() {
        return this.f8455b.mo1431d();
    }

    public String mo1432e() {
        return this.f8455b.mo1432e();
    }

    public boolean mo1433f() {
        return this.f8455b.mo1433f();
    }

    public eah mo1437g() {
        return eah.m16606a(this.f8456c);
    }

    public List<cmn> mo1438h() {
        return this.f8458e;
    }

    public boolean mo1439i() {
        return this.f8462i;
    }

    public List<? extends ebq> mo1440j() {
        return this.f8458e;
    }

    public GetTokenResponse mo1441k() {
        return this.f8454a;
    }

    public String mo1442l() {
        return mo1441k().m2509c();
    }

    public String mo1443m() {
        return this.f8463j.m13661a(this.f8454a);
    }
}
