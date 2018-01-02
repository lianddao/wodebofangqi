package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.equalizer.EqualizerActivity;
import com.ushareit.listenit.widget.SeekArc;

public class ftz implements hea {
    final /* synthetic */ EqualizerActivity f13506a;

    public ftz(EqualizerActivity equalizerActivity) {
        this.f13506a = equalizerActivity;
    }

    public void mo2595a(SeekArc seekArc, int i, boolean z) {
        fum.m20996a().m21016f(i);
        erj.m17571b(this.f13506a.f11561K, (float) (((int) (((float) this.f13506a.f11559I.getSweepAngle()) * ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT * ((float) i)) / ((float) this.f13506a.f11559I.getMax())))) + this.f13506a.f11559I.getStartAngle()));
        this.f13506a.f11567Q.m22284h(i);
    }

    public void mo2594a(SeekArc seekArc) {
    }

    public void mo2596b(SeekArc seekArc) {
        fik.m19341a(this.f13506a, "virtualizer_drag", "" + this.f13506a.f11559I.getProgress());
    }
}
