package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class fjf extends ak {
    private static boolean f3908n = false;
    public static int f3909u = 0;
    private final String f3910o = getClass().getSimpleName();
    private boolean f3911p = false;
    private List<fju> f3912q = new CopyOnWriteArrayList();
    private ListenItApp f3913r;
    public boolean f3914v = false;
    public gum f3915w;
    public boolean f3916x = true;

    public abstract void mo541k();

    public void onCreate(Bundle bundle) {
        exw.m18443a(this.f3910o, this.f3910o + ".onCreate()");
        super.onCreate(bundle);
        gzc.m23341a((Activity) this, (int) C0349R.color.common_actionbar_color);
        setVolumeControlStream(3);
        this.f3913r = (ListenItApp) getApplication();
        eve.m18153a().m18155a(System.currentTimeMillis());
        if (this.f3916x) {
            mo539h();
        }
        f3909u++;
    }

    public static void m4854l() {
        f3908n = true;
    }

    public boolean m4859m() {
        return this.f3911p;
    }

    public void onStart() {
        super.onStart();
        if (this.f3910o.equals("LockScreenActivity")) {
            gcd.m21661a().m21674b(true);
        }
        this.f3913r.m4939e();
        this.f3913r.m4941g();
        if (!(this.f3910o.equals("StartupActivity") || this.f3910o.equals("LockScreenActivity") || gcd.m21661a().m21677c() || !this.f3911p || f3908n || !fem.m18978i())) {
            if (fem.m18970a() && fet.m19029c()) {
                gyj.m23152d(this);
                fem.f12543a = 0;
            } else if (fem.m18973d() && fet.m19032d()) {
                fet.m19030d(this);
                fem.f12543a = 0;
            }
        }
        if (this.f3911p) {
            fii.m19301b();
        }
        if (f3908n) {
            f3908n = false;
        }
    }

    public void onResume() {
        exw.m18443a(this.f3910o, this.f3910o + ".onResume()");
        super.onResume();
        esr.m17823c(this);
    }

    public void onPause() {
        exw.m18443a(this.f3910o, this.f3910o + ".onPause()");
        super.onPause();
        esr.m17825d(this);
    }

    public void onStop() {
        ((ListenItApp) getApplication()).m4942h();
        fus.m21026a().m21044b();
        fie.m19233a();
        this.f3911p = this.f3913r.m4943i();
        if (this.f3911p && !this.f3910o.equals("LockScreenActivity")) {
            fem.f12543a++;
        }
        if (!(!this.f3911p || this.f3910o.equals("LockScreenActivity") || f3908n)) {
            if (fem.m18970a()) {
                if (!fet.m19029c()) {
                    fet.m19017a((Context) this);
                }
            } else if (fem.m18973d() && !fet.m19032d()) {
                fet.m19033e(this);
            }
        }
        if (this.f3911p) {
            this.f3913r.m4940f();
        }
        if (this.f3910o.equals("LockScreenActivity")) {
            gcd.m21661a().m21674b(false);
        }
        super.onStop();
    }

    public void onDestroy() {
        exw.m18443a(this.f3910o, this.f3910o + ".onDestroy()");
        if (this.f3916x) {
            mo540i();
        }
        f3909u--;
        m4861o();
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }

    private void mo539h() {
        gys.m23312a(getApplicationContext(), new fjg(this));
    }

    private void mo540i() {
        gys.m23311a(getApplicationContext());
        this.f3915w = null;
    }

    public gum m4860n() {
        return this.f3915w;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return fus.m21026a().m21043a(i, this, this.f3915w) || super.onKeyDown(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (fju a : this.f3912q) {
            a.mo2624a(i, i2, intent);
        }
    }

    public void m4855a(fju com_ushareit_listenit_fju) {
        if (com_ushareit_listenit_fju != null && !this.f3912q.contains(com_ushareit_listenit_fju)) {
            this.f3912q.add(0, com_ushareit_listenit_fju);
        }
    }

    public void m4856b(fju com_ushareit_listenit_fju) {
        if (com_ushareit_listenit_fju != null && !this.f3912q.contains(com_ushareit_listenit_fju)) {
            this.f3912q.add(com_ushareit_listenit_fju);
        }
    }

    public void m4857c(fju com_ushareit_listenit_fju) {
        if (com_ushareit_listenit_fju != null && this.f3912q.contains(com_ushareit_listenit_fju)) {
            this.f3912q.remove(com_ushareit_listenit_fju);
        }
    }

    public void m4861o() {
        this.f3912q.clear();
    }
}
