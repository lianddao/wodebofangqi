package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ff<T> implements Creator<T> {
    final fg<T> f12575a;

    public ff(fg<T> fgVar) {
        this.f12575a = fgVar;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f12575a.mo2684a(parcel, null);
    }

    public T[] newArray(int i) {
        return this.f12575a.mo2685a(i);
    }
}
