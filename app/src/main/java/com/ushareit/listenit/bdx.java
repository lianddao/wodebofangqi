package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.internal.C0093a;
import com.facebook.internal.C0115w;
import com.facebook.internal.y$com.facebook.internal.z;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;

class bdx extends z {
    final /* synthetic */ bdv f5966b;

    private bdx(bdv com_ushareit_listenit_bdv) {
        this.f5966b = com_ushareit_listenit_bdv;
        super(com_ushareit_listenit_bdv);
    }

    public Object m7865a() {
        return bdy.FEED;
    }

    public boolean m7866a(ShareContent shareContent) {
        return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
    }

    public C0093a m7868b(ShareContent shareContent) {
        Bundle b;
        this.f5966b.m7851a(this.f5966b.m1740b(), shareContent, bdy.FEED);
        C0093a d = this.f5966b.mo831d();
        if (shareContent instanceof ShareLinkContent) {
            ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
            bcd.m7705c(shareLinkContent);
            b = bcq.m7759b(shareLinkContent);
        } else {
            b = bcq.m7756a((ShareFeedContent) shareContent);
        }
        C0115w.m1726a(d, "feed", b);
        return d;
    }
}
