package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareVideo;

public final class bdd implements Creator<ShareVideo> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7813a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7814a(i);
    }

    public ShareVideo m7813a(Parcel parcel) {
        return new ShareVideo(parcel);
    }

    public ShareVideo[] m7814a(int i) {
        return new ShareVideo[i];
    }
}
