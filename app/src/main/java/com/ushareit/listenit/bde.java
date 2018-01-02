package com.ushareit.listenit;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareVideo;

public final class bde extends bcu<ShareVideo, bde> {
    private Uri f5919a;

    public bde m7818a(Uri uri) {
        this.f5919a = uri;
        return this;
    }

    public ShareVideo m7816a() {
        return new ShareVideo();
    }

    public bde m7820a(ShareVideo shareVideo) {
        return shareVideo == null ? this : ((bde) super.mo850a((ShareMedia) shareVideo)).m7818a(shareVideo.m1982b());
    }

    public bde m7819a(Parcel parcel) {
        return m7820a((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
    }
}
