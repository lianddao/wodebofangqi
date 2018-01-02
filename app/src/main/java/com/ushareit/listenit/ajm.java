package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.Profile;

public final class ajm implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5788a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5789a(i);
    }

    public Profile m5788a(Parcel parcel) {
        return new Profile(parcel);
    }

    public Profile[] m5789a(int i) {
        return new Profile[i];
    }
}
