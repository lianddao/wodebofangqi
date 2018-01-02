package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.BackStackState;

public final class ab implements Creator<BackStackState> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5054a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5055a(i);
    }

    public BackStackState m5054a(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] m5055a(int i) {
        return new BackStackState[i];
    }
}
