package com.ushareit.listenit;

import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;

class bcg extends bcf {
    private bcg() {
        super();
    }

    public void mo845a(SharePhotoContent sharePhotoContent) {
        throw new aif("Cannot share SharePhotoContent via web sharing dialogs");
    }

    public void mo846a(ShareVideoContent shareVideoContent) {
        throw new aif("Cannot share ShareVideoContent via web sharing dialogs");
    }

    public void mo844a(SharePhoto sharePhoto) {
        bcd.m7708e(sharePhoto, this);
    }
}
