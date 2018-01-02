package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ushareit.listenit.widget.WheelProgress.WheelSavedState;

public final class heg implements Creator<WheelSavedState> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m23599a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m23600a(i);
    }

    public WheelSavedState m23599a(Parcel parcel) {
        return new WheelSavedState(parcel);
    }

    public WheelSavedState[] m23600a(int i) {
        return new WheelSavedState[i];
    }
}
