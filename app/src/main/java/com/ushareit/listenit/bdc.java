package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.SharePhotoContent;

public final class bdc implements Creator<SharePhotoContent> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7811a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7812a(i);
    }

    public SharePhotoContent m7811a(Parcel parcel) {
        return new SharePhotoContent(parcel);
    }

    public SharePhotoContent[] m7812a(int i) {
        return new SharePhotoContent[i];
    }
}
