package com.ushareit.listenit;

import com.facebook.internal.bo;
import com.facebook.internal.ci;
import com.facebook.share.model.SharePhoto;
import java.util.UUID;

final class bcm implements ci<SharePhoto, bo> {
    final /* synthetic */ UUID f5903a;

    bcm(UUID uuid) {
        this.f5903a = uuid;
    }

    public bo m7750a(SharePhoto sharePhoto) {
        return bcj.m7743b(this.f5903a, sharePhoto);
    }
}
