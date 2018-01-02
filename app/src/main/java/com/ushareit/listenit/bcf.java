package com.ushareit.listenit;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;

class bcf {
    private boolean f5895a;

    private bcf() {
        this.f5895a = false;
    }

    public void m7709a(ShareLinkContent shareLinkContent) {
        bcd.m7696b(shareLinkContent, this);
    }

    public void mo845a(SharePhotoContent sharePhotoContent) {
        bcd.m7702b(sharePhotoContent, this);
    }

    public void mo846a(ShareVideoContent shareVideoContent) {
        bcd.m7704b(shareVideoContent, this);
    }

    public void m7711a(ShareOpenGraphContent shareOpenGraphContent) {
        this.f5895a = true;
        bcd.m7698b(shareOpenGraphContent, this);
    }

    public void m7710a(ShareOpenGraphAction shareOpenGraphAction) {
        bcd.m7697b(shareOpenGraphAction, this);
    }

    public void m7712a(ShareOpenGraphObject shareOpenGraphObject) {
        bcd.m7699b(shareOpenGraphObject, this);
    }

    public void m7713a(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean z) {
        bcd.m7700b(shareOpenGraphValueContainer, this, z);
    }

    public void mo844a(SharePhoto sharePhoto) {
        bcd.m7707d(sharePhoto, this);
    }

    public void m7716a(ShareVideo shareVideo) {
        bcd.m7703b(shareVideo, this);
    }

    public boolean m7718a() {
        return this.f5895a;
    }
}
