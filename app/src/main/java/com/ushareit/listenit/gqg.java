package com.ushareit.listenit;

import com.ushareit.listenit.popupview.NormalPlayerMenu;

public class gqg implements Runnable {
    final /* synthetic */ NormalPlayerMenu f14554a;

    public gqg(NormalPlayerMenu normalPlayerMenu) {
        this.f14554a = normalPlayerMenu;
    }

    public void run() {
        int width = this.f14554a.f16236b.getWidth();
        if (width > 0) {
            gyn.m23213b(this.f14554a.f16237c, width);
            gyn.m23213b(this.f14554a.f16238d, width);
            gyn.m23213b(this.f14554a.f16239e, width);
        }
    }
}
