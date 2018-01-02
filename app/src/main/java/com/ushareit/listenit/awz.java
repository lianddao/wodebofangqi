package com.ushareit.listenit;

class awz extends awa {
    final /* synthetic */ awx f5605a;

    awz(awx com_ushareit_listenit_awx) {
        this.f5605a = com_ushareit_listenit_awx;
    }

    public void m7280a(avz com_ushareit_listenit_avz) {
        if (this.f5605a.f5598c == axg.FADE_OUT_ON_PLAY) {
            this.f5605a.f5598c = null;
            this.f5605a.f5597b.animate().alpha(0.0f).setDuration(2000).setListener(new axa(this));
            return;
        }
        this.f5605a.f5596a.removeCallbacksAndMessages(null);
        this.f5605a.f5597b.clearAnimation();
        this.f5605a.f5597b.setAlpha(0.0f);
        this.f5605a.f5597b.setVisibility(8);
    }
}
