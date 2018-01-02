package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.internal.ClientIdentity;
import com.google.android.gms.location.internal.LocationRequestInternal;
import java.util.List;

public class dtw implements Creator<LocationRequestInternal> {
    public static void m15583a(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11050a(parcel, 1, locationRequestInternal.f1855b, i, false);
        cfc.m11058a(parcel, 4, locationRequestInternal.f1856c);
        cfc.m11068c(parcel, 5, locationRequestInternal.f1857d, false);
        cfc.m11055a(parcel, 6, locationRequestInternal.f1858e, false);
        cfc.m11058a(parcel, 7, locationRequestInternal.f1859f);
        cfc.m11046a(parcel, 1000, locationRequestInternal.m2401a());
        cfc.m11058a(parcel, 8, locationRequestInternal.f1860g);
        cfc.m11043a(parcel, a);
    }

    public LocationRequestInternal m15584a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = cfa.m11020b(parcel);
        boolean z2 = true;
        List list = LocationRequestInternal.f1854a;
        boolean z3 = false;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    locationRequest = (LocationRequest) cfa.m11017a(parcel, a, LocationRequest.CREATOR);
                    break;
                case 4:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 5:
                    list = cfa.m11023c(parcel, a, ClientIdentity.CREATOR);
                    break;
                case 6:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 7:
                    z3 = cfa.m11024c(parcel, a);
                    break;
                case 8:
                    z = cfa.m11024c(parcel, a);
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
            return new LocationRequestInternal(i, locationRequest, z2, list, str, z3, z);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public LocationRequestInternal[] m15585a(int i) {
        return new LocationRequestInternal[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15584a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15585a(i);
    }
}
