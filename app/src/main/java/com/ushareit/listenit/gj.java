package com.ushareit.listenit;

import android.os.Parcel;
import android.support.v4.view.AbsSavedState;

public final class gj implements fg<AbsSavedState> {
    public /* synthetic */ Object mo2684a(Parcel parcel, ClassLoader classLoader) {
        return m22056b(parcel, classLoader);
    }

    public /* synthetic */ Object[] mo2685a(int i) {
        return m22057b(i);
    }

    public AbsSavedState m22056b(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return AbsSavedState.f35a;
        }
        throw new IllegalStateException("superState must be null");
    }

    public AbsSavedState[] m22057b(int i) {
        return new AbsSavedState[i];
    }
}
