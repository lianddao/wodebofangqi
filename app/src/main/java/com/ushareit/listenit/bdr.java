package com.ushareit.listenit;

import com.facebook.internal.C0093a;
import com.facebook.internal.C0115w;
import com.facebook.internal.y$com.facebook.internal.z;
import com.facebook.share.model.ShareContent;

class bdr extends z {
    final /* synthetic */ bdp f5955b;

    private bdr(bdp com_ushareit_listenit_bdp) {
        this.f5955b = com_ushareit_listenit_bdp;
        super(com_ushareit_listenit_bdp);
    }

    public boolean m7844a(ShareContent shareContent) {
        return shareContent != null && bdp.m7838a(shareContent.getClass());
    }

    public C0093a m7846b(ShareContent shareContent) {
        bcd.m7681a(shareContent);
        C0093a d = this.f5955b.mo831d();
        boolean e = this.f5955b.mo851e();
        this.f5955b.m1740b();
        C0115w.m1723a(d, new bds(this, d, shareContent, e), bdp.m7840c(shareContent.getClass()));
        return d;
    }
}
