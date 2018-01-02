package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hdd implements erf {
    final /* synthetic */ NormalPlayerView f15205a;

    public hdd(NormalPlayerView normalPlayerView) {
        this.f15205a = normalPlayerView;
    }

    public void mo2279a(eqy com_ushareit_listenit_eqy) {
        float floatValue = ((Float) com_ushareit_listenit_eqy.m17399k()).floatValue();
        erj.m17570a(this.f15205a.f17314a, 0.7f + (0.3f * floatValue));
        erj.m17570a(this.f15205a.f17339z, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - floatValue);
    }
}
