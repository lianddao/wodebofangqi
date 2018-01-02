package com.ushareit.listenit;

import com.facebook.internal.C0093a;
import com.facebook.internal.C0115w;
import com.facebook.internal.y$com.facebook.internal.z;
import com.facebook.share.internal.LikeContent;

class bbr extends z {
    final /* synthetic */ bbp f5869b;

    private bbr(bbp com_ushareit_listenit_bbp) {
        this.f5869b = com_ushareit_listenit_bbp;
        super(com_ushareit_listenit_bbp);
    }

    public boolean m7618a(LikeContent likeContent) {
        return likeContent != null && bbp.m7612e();
    }

    public C0093a m7620b(LikeContent likeContent) {
        C0093a d = this.f5869b.mo831d();
        C0115w.m1723a(d, new bbs(this, likeContent), bbp.m7615h());
        return d;
    }
}
