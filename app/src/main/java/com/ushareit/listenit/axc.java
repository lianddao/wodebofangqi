package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;

class axc extends apo<awi> {
    final /* synthetic */ awx f5608a;

    axc(awx com_ushareit_listenit_awx) {
        this.f5608a = com_ushareit_listenit_awx;
    }

    public Class<awi> mo708a() {
        return awi.class;
    }

    public void m7285a(awi com_ushareit_listenit_awi) {
        if (this.f5608a.f5599d != null && com_ushareit_listenit_awi.m7260b().getAction() == 0) {
            this.f5608a.f5596a.removeCallbacksAndMessages(null);
            this.f5608a.f5597b.setVisibility(0);
            this.f5608a.f5597b.animate().alpha(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT).setDuration(500).setListener(new axd(this));
        }
    }
}
