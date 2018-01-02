package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareLinkContent;

public final class bcs implements Creator<ShareLinkContent> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7765a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7766a(i);
    }

    public ShareLinkContent m7765a(Parcel parcel) {
        return new ShareLinkContent(parcel);
    }

    public ShareLinkContent[] m7766a(int i) {
        return new ShareLinkContent[i];
    }
}
