package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessToken;

public final class ahl implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5643a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5644a(i);
    }

    public AccessToken m5643a(Parcel parcel) {
        return new AccessToken(parcel);
    }

    public AccessToken[] m5644a(int i) {
        return new AccessToken[i];
    }
}
