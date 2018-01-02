package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fwo implements OnClickListener {
    final /* synthetic */ fwf f13631a;

    fwo(fwf com_ushareit_listenit_fwf) {
        this.f13631a = com_ushareit_listenit_fwf;
    }

    public void onClick(View view) {
        if (this.f13631a.f13617e.getCount() != 0) {
            if (this.f13631a.ao.mo2565a() == 17) {
                gyp.m23283b(this.f13631a.f13617e.m18924b(), 17, this.f13631a.c);
            } else {
                gyp.m23283b(this.f13631a.f13617e.m18924b(), this.f13631a.ao.mo2565a(), this.f13631a.c);
            }
            fii.m19311c(this.f13631a.m1326l(), gyn.m23181a(this.f13631a.ao.mo2565a()) + "_" + "playall");
        }
    }
}
