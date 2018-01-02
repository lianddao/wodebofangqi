package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView.SavedState;

public final class sp implements Creator<SavedState> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m26179a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m26180a(i);
    }

    public SavedState m26179a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m26180a(int i) {
        return new SavedState[i];
    }
}
