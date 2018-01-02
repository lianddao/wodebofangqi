package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareOpenGraphObject;

public final class bcy implements Creator<ShareOpenGraphObject> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7789a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7790a(i);
    }

    public ShareOpenGraphObject m7789a(Parcel parcel) {
        return new ShareOpenGraphObject(parcel);
    }

    public ShareOpenGraphObject[] m7790a(int i) {
        return new ShareOpenGraphObject[i];
    }
}
