package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;

public final class bhj implements Creator<DrmInitData> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8422a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8423a(i);
    }

    public DrmInitData m8422a(Parcel parcel) {
        return new DrmInitData(parcel);
    }

    public DrmInitData[] m8423a(int i) {
        return new DrmInitData[i];
    }
}
