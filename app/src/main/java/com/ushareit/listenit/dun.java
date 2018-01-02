package com.ushareit.listenit;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationResult;
import java.util.List;

public class dun implements Creator<LocationResult> {
    public static void m15616a(LocationResult locationResult, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11068c(parcel, 1, locationResult.m2380a(), false);
        cfc.m11046a(parcel, 1000, locationResult.m2381b());
        cfc.m11043a(parcel, a);
    }

    public LocationResult m15617a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        List list = LocationResult.f1831a;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    list = cfa.m11023c(parcel, a, Location.CREATOR);
                    break;
                case 1000:
                    i = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LocationResult(i, list);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public LocationResult[] m15618a(int i) {
        return new LocationResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15617a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15618a(i);
    }
}
