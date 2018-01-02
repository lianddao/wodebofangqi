package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

public class dwi implements Creator<UserAttributeParcel> {
    public static void m15913a(UserAttributeParcel userAttributeParcel, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, userAttributeParcel.f1904a);
        cfc.m11055a(parcel, 2, userAttributeParcel.f1905b, false);
        cfc.m11047a(parcel, 3, userAttributeParcel.f1906c);
        cfc.m11054a(parcel, 4, userAttributeParcel.f1907d, false);
        cfc.m11052a(parcel, 5, userAttributeParcel.f1908e, false);
        cfc.m11055a(parcel, 6, userAttributeParcel.f1909f, false);
        cfc.m11055a(parcel, 7, userAttributeParcel.f1910g, false);
        cfc.m11051a(parcel, 8, userAttributeParcel.f1911h, false);
        cfc.m11043a(parcel, a);
    }

    public UserAttributeParcel m15914a(Parcel parcel) {
        Double d = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 4:
                    l = cfa.m11029h(parcel, a);
                    break;
                case 5:
                    f = cfa.m11031j(parcel, a);
                    break;
                case 6:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 7:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 8:
                    d = cfa.m11033l(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new UserAttributeParcel(i, str3, j, l, f, str2, str, d);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public UserAttributeParcel[] m15915a(int i) {
        return new UserAttributeParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15914a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15915a(i);
    }
}
