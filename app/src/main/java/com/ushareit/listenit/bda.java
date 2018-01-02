package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.SharePhoto;

public final class bda implements Creator<SharePhoto> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7793a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7794a(i);
    }

    public SharePhoto m7793a(Parcel parcel) {
        return new SharePhoto(parcel);
    }

    public SharePhoto[] m7794a(int i) {
        return new SharePhoto[i];
    }
}
