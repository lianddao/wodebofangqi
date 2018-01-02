package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationSettingsStates;

public class duq implements Creator<LocationSettingsStates> {
    public static void m15625a(LocationSettingsStates locationSettingsStates, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11058a(parcel, 1, locationSettingsStates.m2390b());
        cfc.m11058a(parcel, 2, locationSettingsStates.m2392d());
        cfc.m11058a(parcel, 3, locationSettingsStates.m2394f());
        cfc.m11058a(parcel, 4, locationSettingsStates.m2391c());
        cfc.m11058a(parcel, 5, locationSettingsStates.m2393e());
        cfc.m11058a(parcel, 6, locationSettingsStates.m2395g());
        cfc.m11046a(parcel, 1000, locationSettingsStates.m2389a());
        cfc.m11043a(parcel, a);
    }

    public LocationSettingsStates m15626a(Parcel parcel) {
        boolean z = false;
        int b = cfa.m11020b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    z6 = cfa.m11024c(parcel, a);
                    break;
                case 2:
                    z5 = cfa.m11024c(parcel, a);
                    break;
                case 3:
                    z4 = cfa.m11024c(parcel, a);
                    break;
                case 4:
                    z3 = cfa.m11024c(parcel, a);
                    break;
                case 5:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 6:
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
            return new LocationSettingsStates(i, z6, z5, z4, z3, z2, z);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public LocationSettingsStates[] m15627a(int i) {
        return new LocationSettingsStates[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15626a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15627a(i);
    }
}
