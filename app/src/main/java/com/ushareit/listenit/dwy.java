package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;

public class dwy implements Creator<EventParcel> {
    public static void m16165a(EventParcel eventParcel, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, eventParcel.f1899a);
        cfc.m11055a(parcel, 2, eventParcel.f1900b, false);
        cfc.m11050a(parcel, 3, eventParcel.f1901c, i, false);
        cfc.m11055a(parcel, 4, eventParcel.f1902d, false);
        cfc.m11047a(parcel, 5, eventParcel.f1903e);
        cfc.m11043a(parcel, a);
    }

    public EventParcel m16166a(Parcel parcel) {
        String str = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    eventParams = (EventParams) cfa.m11017a(parcel, a, EventParams.CREATOR);
                    break;
                case 4:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 5:
                    j = cfa.m11028g(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParcel(i, str2, eventParams, str, j);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public EventParcel[] m16167a(int i) {
        return new EventParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16166a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16167a(i);
    }
}
