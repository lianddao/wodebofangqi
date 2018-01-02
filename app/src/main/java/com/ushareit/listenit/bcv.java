package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareOpenGraphAction;

public final class bcv implements Creator<ShareOpenGraphAction> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7777a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7778a(i);
    }

    public ShareOpenGraphAction m7777a(Parcel parcel) {
        return new ShareOpenGraphAction(parcel);
    }

    public ShareOpenGraphAction[] m7778a(int i) {
        return new ShareOpenGraphAction[i];
    }
}
