package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.ads.C0074z;
import com.facebook.ads.af;
import com.facebook.ads.ao;

public class fga extends esj {
    public fga(esa com_ushareit_listenit_esa) {
        super(com_ushareit_listenit_esa);
    }

    public int mo2369a(ese com_ushareit_listenit_ese) {
        if (VERSION.SDK_INT < 15) {
            return 9002;
        }
        if (com_ushareit_listenit_ese == null || TextUtils.isEmpty(com_ushareit_listenit_ese.f11684a) || !com_ushareit_listenit_ese.f11684a.equals("facebook")) {
            return 9003;
        }
        return 0;
    }

    protected void mo2370a(ese com_ushareit_listenit_ese, int i) {
        ffl com_ushareit_listenit_ffl = (ffl) com_ushareit_listenit_ese;
        String str = com_ushareit_listenit_ffl.f12605j;
        Object obj = -1;
        switch (str.hashCode()) {
            case 105:
                if (str.equals("i")) {
                    obj = 1;
                    break;
                }
                break;
            case 110:
                if (str.equals("n")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                af afVar = new af(this.b.m17691a(), com_ushareit_listenit_ese.f11686c);
                afVar.m896a(new fgc(this, com_ushareit_listenit_ese, System.currentTimeMillis()));
                afVar.m898a(ao.f573e);
                fie.m19236a(com_ushareit_listenit_ese.f11686c);
                return;
            case 1:
                C0074z c0074z = new C0074z(this.b.m17691a(), com_ushareit_listenit_ffl.c);
                c0074z.m1169a(new fgb(this, com_ushareit_listenit_ese, System.currentTimeMillis()));
                c0074z.m1168a();
                fie.m19243b(com_ushareit_listenit_ese.f11686c);
                return;
            default:
                return;
        }
    }
}
