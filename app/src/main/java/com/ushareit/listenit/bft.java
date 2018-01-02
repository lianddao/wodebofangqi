package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.Format;

public final class bft implements Creator<Format> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8125a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8126a(i);
    }

    public Format m8125a(Parcel parcel) {
        return new Format(parcel);
    }

    public Format[] m8126a(int i) {
        return new Format[i];
    }
}
