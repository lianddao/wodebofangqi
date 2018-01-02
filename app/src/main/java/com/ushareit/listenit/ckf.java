package com.ushareit.listenit;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.config.internal.PackageConfigTable;

public class ckf implements Creator<PackageConfigTable> {
    public static void m11508a(PackageConfigTable packageConfigTable, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, packageConfigTable.m2335a());
        cfc.m11048a(parcel, 2, packageConfigTable.m2336b(), false);
        cfc.m11043a(parcel, a);
    }

    public PackageConfigTable m11509a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    bundle = cfa.m11036o(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PackageConfigTable(i, bundle);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public PackageConfigTable[] m11510a(int i) {
        return new PackageConfigTable[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11509a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11510a(i);
    }
}
