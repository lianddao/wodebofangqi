package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;

public final class bhk implements Creator<SchemeData> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8424a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8425a(i);
    }

    public SchemeData m8424a(Parcel parcel) {
        return new SchemeData(parcel);
    }

    public SchemeData[] m8425a(int i) {
        return new SchemeData[i];
    }
}
