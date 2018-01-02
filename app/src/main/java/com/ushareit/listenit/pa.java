package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.widget.NestedScrollView.SavedState;

public final class pa implements Creator<SavedState> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m25416a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m25417a(i);
    }

    public SavedState m25416a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m25417a(int i) {
        return new SavedState[i];
    }
}
