package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.StaggeredGridLayoutManager.SavedState;

public final class tg implements Creator<SavedState> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m26257a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m26258a(i);
    }

    public SavedState m26257a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m26258a(int i) {
        return new SavedState[i];
    }
}
