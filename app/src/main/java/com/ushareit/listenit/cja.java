package com.ushareit.listenit;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;

public class cja implements Creator<ConnectionResult> {
    public static void m11425a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, connectionResult.f1675b);
        cfc.m11046a(parcel, 2, connectionResult.m2236c());
        cfc.m11050a(parcel, 3, connectionResult.m2237d(), i, false);
        cfc.m11055a(parcel, 4, connectionResult.m2238e(), false);
        cfc.m11043a(parcel, a);
    }

    public ConnectionResult m11426a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = cfa.m11020b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = cfa.m11015a(parcel);
            String str3;
            switch (cfa.m11014a(a)) {
                case 1:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = cfa.m11026e(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = cfa.m11026e(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) cfa.m11017a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = cfa.m11034m(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] m11427a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11426a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11427a(i);
    }
}
