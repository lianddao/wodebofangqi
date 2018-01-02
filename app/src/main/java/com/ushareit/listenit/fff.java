package com.ushareit.listenit;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;

public class fff extends Handler implements gcg {
    public final FrameLayout f12583a;
    public final FrameLayout f12584b;
    public boolean f12585c;
    private int f12586d = 2;
    private int f12587e = 5;
    private Context f12588f;
    private boolean f12589g = false;

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                m19085h();
                return;
            case 2:
                m19083f();
                return;
            case 3:
                m19084g();
                return;
            default:
                return;
        }
    }

    public fff(View view) {
        this.f12588f = view.getContext();
        this.f12583a = (FrameLayout) view.findViewById(C0349R.id.next_center_card);
        this.f12584b = (FrameLayout) view.findViewById(C0349R.id.next_ad_container);
        this.f12586d = fqo.m20406C() * 1000;
        this.f12587e = fqo.m20407D() * 1000;
        gcd.m21661a().m21670a((gcg) this);
    }

    public void m19088c() {
        exw.m18454c("dzt_", "isShowLockScreenAd() = " + fem.m18974e());
        if (fem.m18974e() && !this.f12585c) {
            if (fet.m19022a()) {
                sendEmptyMessageDelayed(2, (long) this.f12586d);
                this.f12585c = true;
                return;
            }
            m19089d();
            sendEmptyMessageDelayed(3, (long) this.f12586d);
        }
    }

    private void m19083f() {
        fet.m19031d(this.f12588f, new ffg(this, (long) this.f12586d));
    }

    private void m19084g() {
        if (fet.m19022a()) {
            this.f12585c = true;
            m19083f();
        }
    }

    private void m19085h() {
        if (m19081a(this.f12584b)) {
            gzi.m23383b(this.f12584b, this.f12583a);
        }
        this.f12585c = false;
    }

    private boolean m19081a(FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 0) {
            return true;
        }
        return false;
    }

    public void m19089d() {
        fet.m19027c(this.f12588f);
    }

    public void m19090e() {
        this.f12589g = true;
        this.f12585c = false;
    }

    public void mo2363a() {
        m19088c();
    }

    public void mo2364b() {
        m19089d();
    }
}
