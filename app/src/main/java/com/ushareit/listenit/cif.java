package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.stats.ConnectionEvent;

public class cif implements Creator<ConnectionEvent> {
    public static void m11361a(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, connectionEvent.f1741a);
        cfc.m11047a(parcel, 2, connectionEvent.mo261a());
        cfc.m11055a(parcel, 4, connectionEvent.m2305c(), false);
        cfc.m11055a(parcel, 5, connectionEvent.m2306d(), false);
        cfc.m11055a(parcel, 6, connectionEvent.m2307e(), false);
        cfc.m11055a(parcel, 7, connectionEvent.m2308f(), false);
        cfc.m11055a(parcel, 8, connectionEvent.m2309g(), false);
        cfc.m11047a(parcel, 10, connectionEvent.m2313k());
        cfc.m11047a(parcel, 11, connectionEvent.m2312j());
        cfc.m11046a(parcel, 12, connectionEvent.mo262b());
        cfc.m11055a(parcel, 13, connectionEvent.m2310h(), false);
        cfc.m11043a(parcel, a);
    }

    public ConnectionEvent m11362a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 4:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 5:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 6:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                case 7:
                    str4 = cfa.m11034m(parcel, a);
                    break;
                case 8:
                    str5 = cfa.m11034m(parcel, a);
                    break;
                case 10:
                    j2 = cfa.m11028g(parcel, a);
                    break;
                case 11:
                    j3 = cfa.m11028g(parcel, a);
                    break;
                case 12:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 13:
                    str6 = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ConnectionEvent[] m11363a(int i) {
        return new ConnectionEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11362a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11363a(i);
    }
}
