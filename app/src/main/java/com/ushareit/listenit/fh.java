package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class fh<T> implements ClassLoaderCreator<T> {
    private final fg<T> f12705a;

    public fh(fg<T> fgVar) {
        this.f12705a = fgVar;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f12705a.mo2684a(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f12705a.mo2684a(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f12705a.mo2685a(i);
    }
}
