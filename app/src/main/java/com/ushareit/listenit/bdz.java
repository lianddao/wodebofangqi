package com.ushareit.listenit;

import com.facebook.internal.C0093a;
import com.facebook.internal.C0115w;
import com.facebook.internal.y$com.facebook.internal.z;
import com.facebook.share.model.ShareContent;

class bdz extends z {
    final /* synthetic */ bdv f5972b;

    private bdz(bdv com_ushareit_listenit_bdv) {
        this.f5972b = com_ushareit_listenit_bdv;
        super(com_ushareit_listenit_bdv);
    }

    public Object m7870a() {
        return bdy.NATIVE;
    }

    public boolean m7871a(ShareContent shareContent) {
        return shareContent != null && bdv.m7859e(shareContent.getClass());
    }

    public C0093a m7873b(ShareContent shareContent) {
        this.f5972b.m7851a(this.f5972b.m1740b(), shareContent, bdy.NATIVE);
        bcd.m7695b(shareContent);
        C0093a d = this.f5972b.mo831d();
        C0115w.m1723a(d, new bea(this, d, shareContent, this.f5972b.mo851e()), bdv.m7861g(shareContent.getClass()));
        return d;
    }
}
