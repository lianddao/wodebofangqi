package com.ushareit.listenit;

import android.view.View;

class fxr implements of {
    final /* synthetic */ fxp f13698a;
    private int f13699b = 0;

    fxr(fxp com_ushareit_listenit_fxp) {
        this.f13698a = com_ushareit_listenit_fxp;
    }

    public void mo2613a(int i) {
        if (i == 1) {
            gyn.m23214b((ak) this.f13698a.m1326l());
        } else if (i == 0) {
            if (this.f13698a.f13690c.m110j(this.f13698a.f13691d)) {
                gyn.m23214b((ak) this.f13698a.m1326l());
                if (this.f13698a.f13693f != null) {
                    this.f13698a.f13693f.run();
                }
            } else {
                gyn.m23194a((ak) this.f13698a.m1326l());
            }
        }
        if (!this.f13698a.f13690c.m110j(this.f13698a.f13691d)) {
            if (this.f13699b == 1 && i != 1) {
                esr.m17808a(this.f13698a.m1328m(), "UF_MainOpenDrawer", "slide_drawer");
                if (fqk.m20381g()) {
                    fir.m19376a();
                }
            }
            this.f13699b = i;
        }
    }

    public void mo2616b(View view) {
        if (this.f13698a.m1326l() != null) {
            gyn.m23194a((ak) this.f13698a.m1326l());
            if (this.f13698a.f13692e != null) {
                this.f13698a.f13692e.mo2616b(view);
            }
            exw.m18457e("fdsfs", "onDrawerClosed");
        }
    }

    public void mo2615a(View view, float f) {
    }

    public void mo2614a(View view) {
        if (this.f13698a.f13692e != null) {
            this.f13698a.f13692e.mo2614a(view);
        }
    }
}
