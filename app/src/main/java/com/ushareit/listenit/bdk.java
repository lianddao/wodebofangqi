package com.ushareit.listenit;

import com.facebook.share.widget.LikeView;

public class bdk implements bbb {
    final /* synthetic */ LikeView f5936a;
    private boolean f5937b;

    private bdk(LikeView likeView) {
        this.f5936a = likeView;
    }

    public void m7829a() {
        this.f5937b = true;
    }

    public void mo823a(bak com_ushareit_listenit_bak, aif com_ushareit_listenit_aif) {
        if (!this.f5937b) {
            if (com_ushareit_listenit_bak != null) {
                if (!com_ushareit_listenit_bak.m7567e()) {
                    com_ushareit_listenit_aif = new aif("Cannot use LikeView. The device may not be supported.");
                }
                this.f5936a.m1994a(com_ushareit_listenit_bak);
                this.f5936a.m1998c();
            }
            if (!(com_ushareit_listenit_aif == null || this.f5936a.f1404h == null)) {
                this.f5936a.f1404h.m7833a(com_ushareit_listenit_aif);
            }
            this.f5936a.f1406j = null;
        }
    }
}
