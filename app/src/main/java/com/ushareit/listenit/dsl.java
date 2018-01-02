package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationAvailability;

public class dsl implements Creator<LocationAvailability> {
    public static void m15435a(LocationAvailability locationAvailability, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, locationAvailability.f1817a);
        cfc.m11046a(parcel, 2, locationAvailability.f1818b);
        cfc.m11047a(parcel, 3, locationAvailability.f1819c);
        cfc.m11046a(parcel, 4, locationAvailability.f1820d);
        cfc.m11046a(parcel, 1000, locationAvailability.m2371b());
        cfc.m11043a(parcel, a);
    }

    public LocationAvailability m15436a(Parcel parcel) {
        int i = 1;
        int b = cfa.m11020b(parcel);
        int i2 = 0;
        int i3 = 1000;
        long j = 0;
        int i4 = 1;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i4 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 3:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 4:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                case 1000:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LocationAvailability(i2, i3, i4, i, j);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public LocationAvailability[] m15437a(int i) {
        return new LocationAvailability[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15436a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15437a(i);
    }
}
