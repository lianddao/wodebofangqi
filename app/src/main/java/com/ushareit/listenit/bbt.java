package com.ushareit.listenit;

import com.facebook.internal.C0093a;
import com.facebook.internal.C0115w;
import com.facebook.internal.y$com.facebook.internal.z;
import com.facebook.share.internal.LikeContent;

class bbt extends z {
    final /* synthetic */ bbp f5872b;

    private bbt(bbp com_ushareit_listenit_bbp) {
        this.f5872b = com_ushareit_listenit_bbp;
        super(com_ushareit_listenit_bbp);
    }

    public boolean m7624a(LikeContent likeContent) {
        return likeContent != null && bbp.m7613f();
    }

    public C0093a m7626b(LikeContent likeContent) {
        C0093a d = this.f5872b.mo831d();
        C0115w.m1722a(d, bbp.m7611b(likeContent), bbp.m7615h());
        return d;
    }
}
