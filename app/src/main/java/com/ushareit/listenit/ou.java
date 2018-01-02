package com.ushareit.listenit;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class ou extends Animation {
    final /* synthetic */ ox f16079a;
    final /* synthetic */ ot f16080b;

    ou(ot otVar, ox oxVar) {
        this.f16080b = otVar;
        this.f16079a = oxVar;
    }

    public void applyTransformation(float f, Transformation transformation) {
        if (this.f16080b.f16067a) {
            this.f16080b.m25370b(f, this.f16079a);
            return;
        }
        float a = this.f16080b.m25363a(this.f16079a);
        float g = this.f16079a.m25405g();
        float f2 = this.f16079a.m25404f();
        float k = this.f16079a.m25409k();
        this.f16080b.m25367a(f, this.f16079a);
        if (f <= 0.5f) {
            float f3 = 0.8f - a;
            this.f16079a.m25394b(f2 + (ot.f16066c.getInterpolation(f / 0.5f) * f3));
        }
        if (f > 0.5f) {
            this.f16079a.m25397c(((0.8f - a) * ot.f16066c.getInterpolation((f - 0.5f) / 0.5f)) + g);
        }
        this.f16079a.m25400d((0.25f * f) + k);
        this.f16080b.m25379c((216.0f * f) + (1080.0f * (this.f16080b.f16075k / 5.0f)));
    }
}
