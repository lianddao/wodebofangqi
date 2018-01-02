package com.ushareit.listenit;

import android.net.Uri;
import com.facebook.share.model.ShareLinkContent;

public final class bct extends bcr<ShareLinkContent, bct> {
    private String f5910a;
    private String f5911b;
    private Uri f5912c;

    public bct m7771a(String str) {
        this.f5910a = str;
        return this;
    }

    public bct m7773b(String str) {
        this.f5911b = str;
        return this;
    }

    public bct m7772b(Uri uri) {
        this.f5912c = uri;
        return this;
    }

    public ShareLinkContent m7770a() {
        return new ShareLinkContent();
    }
}
