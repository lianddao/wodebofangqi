package com.ushareit.listenit;

import com.facebook.ads.internal.view.p003d.p004b.C0040h;

public class axo extends apo<awd> {
    final /* synthetic */ C0040h f5624a;

    public axo(C0040h c0040h) {
        this.f5624a = c0040h;
    }

    public Class<awd> mo708a() {
        return awd.class;
    }

    public void m7302a(awd com_ushareit_listenit_awd) {
        if (!this.f5624a.f713f.get()) {
            int b = this.f5624a.f710c - (this.f5624a.getVideoView().getCurrentPosition() / 1000);
            if (b > 0) {
                this.f5624a.f709b.setText(this.f5624a.f711d + ' ' + b);
                return;
            }
            this.f5624a.f709b.setText(this.f5624a.f712e);
            this.f5624a.f713f.set(true);
        }
    }
}
