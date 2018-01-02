package com.ushareit.listenit;

import com.ushareit.listenit.cutter.view.TouchWaveformView;

public class fqc implements fqj {
    final /* synthetic */ TouchWaveformView f13227a;

    public fqc(TouchWaveformView touchWaveformView) {
        this.f13227a = touchWaveformView;
    }

    public void mo2533a(float f) {
        this.f13227a.f9079C = true;
        this.f13227a.f9081E = f;
        this.f13227a.f9106u = this.f13227a.f9102q;
        this.f13227a.f9099n = 0;
        this.f13227a.f9077A = this.f13227a.getCurrentTime();
    }

    public void mo2535b(float f) {
        this.f13227a.f9102q = this.f13227a.m12861d((int) (((float) this.f13227a.f9106u) + (this.f13227a.f9081E - f)));
        this.f13227a.m12906b();
    }

    public void mo2537c(float f) {
        this.f13227a.f9079C = false;
        this.f13227a.f9101p = this.f13227a.f9102q;
        long t = this.f13227a.getCurrentTime() - this.f13227a.f9077A;
        if (this.f13227a.f9089d == null || t >= 200 || Math.abs(f - this.f13227a.f9081E) >= 10.0f) {
            this.f13227a.f9078B = true;
            return;
        }
        this.f13227a.f9078B = false;
        if (this.f13227a.f9089d.m12916a()) {
            this.f13227a.f9089d.m12917b();
        } else {
            this.f13227a.f9089d.m12913a((int) (this.f13227a.f9081E + ((float) this.f13227a.f9102q)));
        }
    }

    public void mo2538d(float f) {
        this.f13227a.f9078B = true;
        this.f13227a.f9079C = false;
        this.f13227a.f9101p = this.f13227a.f9102q;
        this.f13227a.f9099n = (int) (-f);
        this.f13227a.m12906b();
    }

    public void mo2532a() {
        this.f13227a.f9100o = this.f13227a.f9086a.getMeasuredWidth();
        if (this.f13227a.f9101p != this.f13227a.f9102q && !this.f13227a.f9080D) {
            this.f13227a.m12906b();
        } else if (this.f13227a.f9089d != null && this.f13227a.f9089d.m12916a()) {
            this.f13227a.m12906b();
        } else if (this.f13227a.f9099n != 0) {
            this.f13227a.m12906b();
        }
    }

    public void mo2534b() {
        this.f13227a.f9086a.m12942c();
        this.f13227a.f9097l = this.f13227a.f9086a.getStart();
        this.f13227a.f9098m = this.f13227a.f9086a.getEnd();
        this.f13227a.f9096k = this.f13227a.f9086a.m12945f();
        this.f13227a.f9102q = this.f13227a.f9086a.getOffset();
        this.f13227a.f9101p = this.f13227a.f9102q;
        this.f13227a.m12906b();
    }

    public void mo2536c() {
        this.f13227a.f9086a.m12944e();
        this.f13227a.f9097l = this.f13227a.f9086a.getStart();
        this.f13227a.f9098m = this.f13227a.f9086a.getEnd();
        this.f13227a.f9096k = this.f13227a.f9086a.m12945f();
        this.f13227a.f9102q = this.f13227a.f9086a.getOffset();
        this.f13227a.f9101p = this.f13227a.f9102q;
        this.f13227a.m12906b();
    }
}
