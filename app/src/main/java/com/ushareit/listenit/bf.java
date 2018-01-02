package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentTabHost.SavedState;

public final class bf implements Creator<SavedState> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7951a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7952a(i);
    }

    public SavedState m7951a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m7952a(int i) {
        return new SavedState[i];
    }
}
