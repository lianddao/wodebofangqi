package com.ushareit.listenit;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;

public class cer implements Creator<Status> {
    public static void m10991a(Status status, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, status.m2259h());
        cfc.m11055a(parcel, 2, status.m2254c(), false);
        cfc.m11050a(parcel, 3, status.m2251a(), i, false);
        cfc.m11046a(parcel, 1000, status.m2255d());
        cfc.m11043a(parcel, a);
    }

    public Status m10992a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = cfa.m11020b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) cfa.m11017a(parcel, a, PendingIntent.CREATOR);
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
            return new Status(i2, i, str, pendingIntent);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public Status[] m10993a(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10992a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10993a(i);
    }
}
