package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.fragments.ScanFragment;

public class fzc implements OnClickListener {
    final /* synthetic */ ScanFragment f13753a;

    public fzc(ScanFragment scanFragment) {
        this.f13753a = scanFragment;
    }

    public void onClick(View view) {
        if (grr.m22621a().m22648d()) {
            fio.m19368c(this.f13753a.m1326l(), "finish");
        } else {
            fio.m19368c(this.f13753a.m1326l(), "background_run");
        }
        if (this.f13753a.aj != null) {
            this.f13753a.aj.mo2683a();
        }
    }
}
