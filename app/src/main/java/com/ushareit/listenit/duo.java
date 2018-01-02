package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import java.util.List;

public class duo implements Creator<LocationSettingsRequest> {
    public static void m15619a(LocationSettingsRequest locationSettingsRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11068c(parcel, 1, locationSettingsRequest.m2383b(), false);
        cfc.m11058a(parcel, 2, locationSettingsRequest.m2384c());
        cfc.m11058a(parcel, 3, locationSettingsRequest.m2385d());
        cfc.m11046a(parcel, 1000, locationSettingsRequest.m2382a());
        cfc.m11043a(parcel, a);
    }

    public LocationSettingsRequest m15620a(Parcel parcel) {
        boolean z = false;
        int b = cfa.m11020b(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    list = cfa.m11023c(parcel, a, LocationRequest.CREATOR);
                    break;
                case 2:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 3:
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
            return new LocationSettingsRequest(i, list, z2, z);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public LocationSettingsRequest[] m15621a(int i) {
        return new LocationSettingsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15620a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15621a(i);
    }
}
