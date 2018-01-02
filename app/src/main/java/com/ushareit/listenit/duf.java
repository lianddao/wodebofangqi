package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.List;

public class duf implements Creator<GeofencingRequest> {
    public static void m15607a(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11068c(parcel, 1, geofencingRequest.m2366b(), false);
        cfc.m11046a(parcel, 2, geofencingRequest.m2367c());
        cfc.m11046a(parcel, 1000, geofencingRequest.m2365a());
        cfc.m11043a(parcel, a);
    }

    public GeofencingRequest m15608a(Parcel parcel) {
        int i = 0;
        int b = cfa.m11020b(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    list = cfa.m11023c(parcel, a, ParcelableGeofence.CREATOR);
                    break;
                case 2:
                    i = cfa.m11026e(parcel, a);
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
            return new GeofencingRequest(i2, list, i);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public GeofencingRequest[] m15609a(int i) {
        return new GeofencingRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15608a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15609a(i);
    }
}
