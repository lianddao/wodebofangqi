package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareOpenGraphContent;

public final class bcx implements Creator<ShareOpenGraphContent> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7787a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7788a(i);
    }

    public ShareOpenGraphContent m7787a(Parcel parcel) {
        return new ShareOpenGraphContent(parcel);
    }

    public ShareOpenGraphContent[] m7788a(int i) {
        return new ShareOpenGraphContent[i];
    }
}
