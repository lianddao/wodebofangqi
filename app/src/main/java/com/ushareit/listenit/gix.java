package com.ushareit.listenit;

import com.ushareit.listenit.main.AdFlashView;
import com.ushareit.listenit.main.StartupActivity;

public class gix extends fen {
    final /* synthetic */ boolean f14182a;
    final /* synthetic */ AdFlashView f14183b;
    final /* synthetic */ StartupActivity f14184c;

    public gix(StartupActivity startupActivity, long j, boolean z, AdFlashView adFlashView) {
        this.f14184c = startupActivity;
        this.f14182a = z;
        this.f14183b = adFlashView;
        super(j);
    }

    public void mo2360b(ffl com_ushareit_listenit_ffl, esi com_ushareit_listenit_esi) {
        if (!this.f14182a) {
            this.f14183b.setVisibility(0);
            this.f14183b.setFlashCallback(this.f14184c.f15916o);
        }
        this.f14183b.m24801a(com_ushareit_listenit_ffl, com_ushareit_listenit_esi);
    }

    public void mo2361g() {
        if (this.f14182a) {
            this.f14184c.finish();
        } else {
            this.f14184c.m24848p();
        }
    }
}
