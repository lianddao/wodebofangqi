package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutManager.SavedState;

public final class rk implements Creator<SavedState> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m25955a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m25956a(i);
    }

    public SavedState m25955a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m25956a(int i) {
        return new SavedState[i];
    }
}
