package com.ushareit.listenit;

import android.util.Pair;
import com.ushareit.listenit.main.MainActivity;

public class gin extends gwv {
    final /* synthetic */ MainActivity f14168a;

    public gin(MainActivity mainActivity, String str) {
        this.f14168a = mainActivity;
        super(str);
    }

    public void execute() {
        fii.m19286a(this.f14168a);
        gvj.m22895a(this.f14168a, System.currentTimeMillis());
        fiw.m19478h(this.f14168a);
        if (gef.m21805a().m21838h()) {
            fiw.m19456a(this.f14168a);
        }
        if (gyn.m23249j() > 0) {
            fiw.m19462b(this.f14168a);
        }
        if (gef.m21805a().m21835e()) {
            fiw.m19479i(this.f14168a);
        }
        esr.m17805a(this.f14168a);
        esr.m17818b(this.f14168a);
        eut.m18032a(this.f14168a);
        if (!this.f14168a.f15898B) {
            Pair a = eyw.m18568a(this.f14168a);
            if (((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue()) {
                this.f14168a.f15898B = true;
                exo.m18425a(this.f14168a, 1, false, true);
            }
        }
    }
}
