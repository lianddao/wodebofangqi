package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.iid.MessengerCompat;

public final class ckx implements Creator<MessengerCompat> {
    public MessengerCompat m11524a(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
    }

    public MessengerCompat[] m11525a(int i) {
        return new MessengerCompat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11524a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11525a(i);
    }
}
