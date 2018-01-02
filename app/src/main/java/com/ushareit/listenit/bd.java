package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentState;

public final class bd implements Creator<FragmentState> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7791a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7792a(i);
    }

    public FragmentState m7791a(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] m7792a(int i) {
        return new FragmentState[i];
    }
}
