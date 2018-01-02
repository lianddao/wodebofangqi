package com.ushareit.listenit;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;

public class cez implements Creator<DataHolder> {
    public static void m11010a(DataHolder dataHolder, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11062a(parcel, 1, dataHolder.m2267c(), false);
        cfc.m11061a(parcel, 2, dataHolder.m2268d(), i, false);
        cfc.m11046a(parcel, 3, dataHolder.m2269e());
        cfc.m11048a(parcel, 4, dataHolder.m2270f(), false);
        cfc.m11046a(parcel, 1000, dataHolder.m2266b());
        cfc.m11043a(parcel, a);
    }

    public DataHolder m11011a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = cfa.m11020b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    strArr = cfa.m11039r(parcel, a);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) cfa.m11022b(parcel, a, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 4:
                    bundle = cfa.m11036o(parcel, a);
                    break;
                case 1000:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new cfb("Overread allowed size end=" + b, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.m2264a();
        return dataHolder;
    }

    public DataHolder[] m11012a(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11011a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11012a(i);
    }
}
