package com.ushareit.listenit;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

class gds implements gev {
    private cdz f13971a = new cea(eys.m18562a()).m10956a(cap.f8029f, new cbx(GoogleSignInOptions.f1652d).m10724b().m10723a("324317734102-9salvc20dtdkp8op9vc89e3litjpma48.apps.googleusercontent.com").m10726d()).m10960b();
    private geu f13972b;

    gds() {
        this.f13971a.mo1976e();
    }

    public void mo2659a(geu com_ushareit_listenit_geu) {
        this.f13972b = com_ushareit_listenit_geu;
    }

    public void mo2658a(Activity activity) {
        activity.startActivityForResult(cap.f8034k.mo1267a(this.f13971a), 20);
    }

    public void mo2657a(int i, int i2, Intent intent) {
        exw.m18454c("LOGIN.GOOGLE", "onActivityResult:" + i);
        if (i == 20) {
            cby a = cap.f8034k.mo1268a(intent);
            if (a == null || !a.m10729c()) {
                if (this.f13972b != null) {
                    if (intent != null) {
                        a = cap.f8034k.mo1268a(intent);
                    } else {
                        a = null;
                    }
                    this.f13972b.mo2667a("google failure " + (a != null ? a.mo260b() : ""));
                }
                this.f13972b = null;
                return;
            }
            exw.m18454c("LOGIN.GOOGLE", "google login success");
            GoogleSignInAccount a2 = a.m10727a();
            if (a2 != null) {
                eat a3 = ebn.m16658a(a2.m2196b(), null);
                if (this.f13972b != null) {
                    this.f13972b.mo2666a(a3);
                }
            }
        }
    }

    public void mo2660b() {
        this.f13972b = null;
    }

    public void mo2656a() {
        if (this.f13971a.mo1980i()) {
            exw.m18454c("LOGIN.GOOGLE", "Google logout isConnected");
            cap.f8034k.mo1269b(this.f13971a).mo1272a(new gdt(this));
            return;
        }
        exw.m18454c("LOGIN.GOOGLE", "Google logout is not connected");
        this.f13971a.mo1976e();
        this.f13971a.mo1971a(new gdu(this));
    }
}
