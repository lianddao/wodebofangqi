package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hdf implements erf {
    final /* synthetic */ NormalPlayerView f15207a;

    public hdf(NormalPlayerView normalPlayerView) {
        this.f15207a = normalPlayerView;
    }

    public void mo2279a(eqy com_ushareit_listenit_eqy) {
        float floatValue = ((Float) com_ushareit_listenit_eqy.m17399k()).floatValue();
        erj.m17570a(this.f15207a.f17314a, (0.3f * floatValue) + 0.7f);
        erj.m17570a(this.f15207a.f17339z, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - floatValue);
    }
}
