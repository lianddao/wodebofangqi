package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.internal.C0093a;
import com.facebook.internal.C0115w;
import com.facebook.internal.y$com.facebook.internal.z;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;

class beb extends z {
    final /* synthetic */ bdv f5977b;

    private beb(bdv com_ushareit_listenit_bdv) {
        this.f5977b = com_ushareit_listenit_bdv;
        super(com_ushareit_listenit_bdv);
    }

    public Object m7878a() {
        return bdy.WEB;
    }

    public boolean m7879a(ShareContent shareContent) {
        return shareContent != null && bdv.m7860f(shareContent.getClass());
    }

    public C0093a m7881b(ShareContent shareContent) {
        Bundle a;
        this.f5977b.m7851a(this.f5977b.m1740b(), shareContent, bdy.WEB);
        C0093a d = this.f5977b.mo831d();
        bcd.m7705c(shareContent);
        if (shareContent instanceof ShareLinkContent) {
            a = bcq.m7757a((ShareLinkContent) shareContent);
        } else {
            a = bcq.m7758a((ShareOpenGraphContent) shareContent);
        }
        C0115w.m1726a(d, m7877c(shareContent), a);
        return d;
    }

    private String m7877c(ShareContent shareContent) {
        if (shareContent instanceof ShareLinkContent) {
            return "share";
        }
        if (shareContent instanceof ShareOpenGraphContent) {
            return "share_open_graph";
        }
        return null;
    }
}
