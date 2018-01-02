package com.ushareit.listenit;

import android.app.Activity;
import android.content.Intent;
import com.facebook.login.C0136r;
import com.facebook.login.C0143x;
import java.util.Arrays;

class gdq implements gev {
    private ahy f13966a;
    private C0136r f13967b;
    private geu f13968c;
    private aic<C0143x> f13969d = new gdr(this);

    gdq() {
        exw.m18454c("LOGIN.FACEBOOK", "FacebookLoginProvider()");
        this.f13966a = ahz.m5678a();
    }

    public void mo2659a(geu com_ushareit_listenit_geu) {
        this.f13968c = com_ushareit_listenit_geu;
    }

    public void mo2658a(Activity activity) {
        exw.m18454c("LOGIN.FACEBOOK", "startLogin()");
        this.f13967b = C0136r.m1871a();
        this.f13967b.m1888a(this.f13966a, this.f13969d);
        this.f13967b.m1886a(activity, Arrays.asList(new String[]{"public_profile", "email"}));
    }

    public void mo2657a(int i, int i2, Intent intent) {
        if (this.f13966a != null) {
            this.f13966a.mo187a(i, i2, intent);
        }
    }

    public void mo2656a() {
        this.f13967b.m1891b();
    }

    public void mo2660b() {
        this.f13968c = null;
    }
}
