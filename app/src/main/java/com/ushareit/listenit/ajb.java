package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;

public final class ajb implements Creator<ParcelableResourceWithMimeType> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5735a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5736a(i);
    }

    public ParcelableResourceWithMimeType m5735a(Parcel parcel) {
        return new ParcelableResourceWithMimeType(parcel);
    }

    public ParcelableResourceWithMimeType[] m5736a(int i) {
        return new ParcelableResourceWithMimeType[i];
    }
}
