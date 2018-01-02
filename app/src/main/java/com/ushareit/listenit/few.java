package com.ushareit.listenit;

import android.view.ViewGroup;
import com.ushareit.listenit.lockscreen.view.ChargeLockScreenView;

public class few {
    private String f12560a = "ChargerLockAdController";
    private ChargeLockScreenView f12561b;
    private boolean f12562c;
    private final gcg f12563d = new fey(this);

    public few(ChargeLockScreenView chargeLockScreenView) {
        this.f12561b = chargeLockScreenView;
        gcd.m21661a().m21670a(this.f12563d);
        this.f12563d.mo2364b();
    }

    private void m19043b() {
        if (this.f12561b != null) {
            fet.m19037g(this.f12561b.getContext(), new fex(this, 20000));
        }
    }

    public boolean m19047a(ViewGroup viewGroup) {
        return viewGroup != null && viewGroup.getChildCount() > 0;
    }

    public void m19046a() {
        this.f12562c = true;
        gcd.m21661a().m21675b(this.f12563d);
    }
}
