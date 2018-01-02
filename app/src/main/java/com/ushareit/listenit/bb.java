package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentManagerState;

public final class bb implements Creator<FragmentManagerState> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7591a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7592a(i);
    }

    public FragmentManagerState m7591a(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    public FragmentManagerState[] m7592a(int i) {
        return new FragmentManagerState[i];
    }
}
