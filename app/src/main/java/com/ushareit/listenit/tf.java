package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem;

public final class tf implements Creator<FullSpanItem> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m26255a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m26256a(i);
    }

    public FullSpanItem m26255a(Parcel parcel) {
        return new FullSpanItem(parcel);
    }

    public FullSpanItem[] m26256a(int i) {
        return new FullSpanItem[i];
    }
}
