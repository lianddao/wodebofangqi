package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.View;
import com.umeng.analytics.pro.C0277j;

class ftp implements hfs {
    final /* synthetic */ ftl f13491a;

    ftp(ftl com_ushareit_listenit_ftl) {
        this.f13491a = com_ushareit_listenit_ftl;
    }

    public void g_() {
        this.f13491a.m1328m().setRequestedOrientation(0);
        m20971c();
        this.f13491a.am = true;
    }

    private void m20971c() {
        View decorView = this.f13491a.m1328m().getWindow().getDecorView();
        if (VERSION.SDK_INT >= 16) {
            int i = 1798;
            if (VERSION.SDK_INT >= 19) {
                i = 5894;
            }
            decorView.setSystemUiVisibility(i);
        }
    }

    public void mo2592b() {
        this.f13491a.m1328m().setRequestedOrientation(1);
        m20972d();
        this.f13491a.am = false;
    }

    private void m20972d() {
        View decorView = this.f13491a.m1328m().getWindow().getDecorView();
        if (VERSION.SDK_INT >= 16) {
            decorView.setSystemUiVisibility(C0277j.f3694e);
        }
    }
}
