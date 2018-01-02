package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.internal.ShareFeedContent;

public final class bci implements Creator<ShareFeedContent> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7724a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7725a(i);
    }

    public ShareFeedContent m7724a(Parcel parcel) {
        return new ShareFeedContent(parcel);
    }

    public ShareFeedContent[] m7725a(int i) {
        return new ShareFeedContent[i];
    }
}
