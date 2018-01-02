package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.equalizer.EqualizerActivity;
import com.ushareit.listenit.widget.SeekArc;

public class ftx implements hea {
    final /* synthetic */ EqualizerActivity f13504a;

    public ftx(EqualizerActivity equalizerActivity) {
        this.f13504a = equalizerActivity;
    }

    public void mo2595a(SeekArc seekArc, int i, boolean z) {
        fum.m20996a().m21018g(i);
        erj.m17571b(this.f13504a.f11556F, (float) (((int) (((float) this.f13504a.f11554D.getSweepAngle()) * ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT * ((float) i)) / ((float) this.f13504a.f11554D.getMax())))) + this.f13504a.f11554D.getStartAngle()));
        this.f13504a.f11567Q.m22282g(i);
    }

    public void mo2594a(SeekArc seekArc) {
    }

    public void mo2596b(SeekArc seekArc) {
        fik.m19341a(this.f13504a, "bassboost_drag", "" + this.f13504a.f11554D.getProgress());
    }
}
