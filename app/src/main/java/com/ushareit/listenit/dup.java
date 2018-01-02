package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;

public class dup implements Creator<LocationSettingsResult> {
    public static void m15622a(LocationSettingsResult locationSettingsResult, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11050a(parcel, 1, locationSettingsResult.mo260b(), i, false);
        cfc.m11050a(parcel, 2, locationSettingsResult.m2388c(), i, false);
        cfc.m11046a(parcel, 1000, locationSettingsResult.m2386a());
        cfc.m11043a(parcel, a);
    }

    public LocationSettingsResult m15623a(Parcel parcel) {
        LocationSettingsStates locationSettingsStates = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int i2;
            LocationSettingsStates locationSettingsStates2;
            Status status2;
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) cfa.m11017a(parcel, a, Status.CREATOR);
                    locationSettingsStates2 = locationSettingsStates;
                    status2 = status3;
                    break;
                case 2:
                    locationSettingsStates2 = (LocationSettingsStates) cfa.m11017a(parcel, a, LocationSettingsStates.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    LocationSettingsStates locationSettingsStates3 = locationSettingsStates;
                    status2 = status;
                    i2 = cfa.m11026e(parcel, a);
                    locationSettingsStates2 = locationSettingsStates3;
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    locationSettingsStates2 = locationSettingsStates;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            locationSettingsStates = locationSettingsStates2;
        }
        if (parcel.dataPosition() == b) {
            return new LocationSettingsResult(i, status, locationSettingsStates);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public LocationSettingsResult[] m15624a(int i) {
        return new LocationSettingsResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15623a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15624a(i);
    }
}
