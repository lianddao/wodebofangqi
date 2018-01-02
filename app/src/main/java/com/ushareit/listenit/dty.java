package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.internal.ParcelableGeofence;

public class dty implements Creator<ParcelableGeofence> {
    public static void m15589a(ParcelableGeofence parcelableGeofence, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11055a(parcel, 1, parcelableGeofence.m2419f(), false);
        cfc.m11047a(parcel, 2, parcelableGeofence.m2420g());
        cfc.m11057a(parcel, 3, parcelableGeofence.m2415b());
        cfc.m11044a(parcel, 4, parcelableGeofence.m2416c());
        cfc.m11044a(parcel, 5, parcelableGeofence.m2417d());
        cfc.m11045a(parcel, 6, parcelableGeofence.m2418e());
        cfc.m11046a(parcel, 7, parcelableGeofence.m2421h());
        cfc.m11046a(parcel, 1000, parcelableGeofence.m2414a());
        cfc.m11046a(parcel, 8, parcelableGeofence.m2422i());
        cfc.m11046a(parcel, 9, parcelableGeofence.m2423j());
        cfc.m11043a(parcel, a);
    }

    public ParcelableGeofence m15590a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 2:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 3:
                    s = cfa.m11025d(parcel, a);
                    break;
                case 4:
                    d = cfa.m11032k(parcel, a);
                    break;
                case 5:
                    d2 = cfa.m11032k(parcel, a);
                    break;
                case 6:
                    f = cfa.m11030i(parcel, a);
                    break;
                case 7:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 8:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                case 9:
                    i4 = cfa.m11026e(parcel, a);
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
            return new ParcelableGeofence(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ParcelableGeofence[] m15591a(int i) {
        return new ParcelableGeofence[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15590a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15591a(i);
    }
}
