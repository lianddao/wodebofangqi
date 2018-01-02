package com.ushareit.listenit;

import com.facebook.ads.internal.view.p003d.p004b.C0045o;

public class axz extends awe {
    final /* synthetic */ C0045o f5636a;

    public axz(C0045o c0045o) {
        this.f5636a = c0045o;
    }

    public void m7317a(awd com_ushareit_listenit_awd) {
        if (this.f5636a.f742f != null) {
            int duration = this.f5636a.f742f.getDuration();
            if (duration > 0) {
                this.f5636a.f739c = ((float) this.f5636a.f742f.getCurrentPosition()) / ((float) duration);
            } else {
                this.f5636a.f739c = 0.0f;
            }
            this.f5636a.postInvalidate();
        }
    }
}
