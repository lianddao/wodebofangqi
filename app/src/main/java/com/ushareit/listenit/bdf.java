package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareVideoContent;

public final class bdf implements Creator<ShareVideoContent> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7821a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7822a(i);
    }

    public ShareVideoContent m7821a(Parcel parcel) {
        return new ShareVideoContent(parcel);
    }

    public ShareVideoContent[] m7822a(int i) {
        return new ShareVideoContent[i];
    }
}
