package com.ushareit.listenit;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;

public class dtx implements Creator<LocationRequestUpdateData> {
    public static void m15586a(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, locationRequestUpdateData.f1862a);
        cfc.m11050a(parcel, 2, locationRequestUpdateData.f1863b, i, false);
        cfc.m11049a(parcel, 3, locationRequestUpdateData.m2406b(), false);
        cfc.m11050a(parcel, 4, locationRequestUpdateData.f1865d, i, false);
        cfc.m11049a(parcel, 5, locationRequestUpdateData.m2407c(), false);
        cfc.m11049a(parcel, 6, locationRequestUpdateData.m2408d(), false);
        cfc.m11046a(parcel, 1000, locationRequestUpdateData.m2405a());
        cfc.m11043a(parcel, a);
    }

    public LocationRequestUpdateData m15587a(Parcel parcel) {
        IBinder iBinder = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        int i2 = 1;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        LocationRequestInternal locationRequestInternal = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    locationRequestInternal = (LocationRequestInternal) cfa.m11017a(parcel, a, LocationRequestInternal.CREATOR);
                    break;
                case 3:
                    iBinder3 = cfa.m11035n(parcel, a);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) cfa.m11017a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = cfa.m11035n(parcel, a);
                    break;
                case 6:
                    iBinder = cfa.m11035n(parcel, a);
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
            return new LocationRequestUpdateData(i, i2, locationRequestInternal, iBinder3, pendingIntent, iBinder2, iBinder);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public LocationRequestUpdateData[] m15588a(int i) {
        return new LocationRequestUpdateData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15587a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15588a(i);
    }
}
