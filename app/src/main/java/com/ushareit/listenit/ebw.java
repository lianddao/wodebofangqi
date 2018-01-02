package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.auth.api.model.ProviderUserInfo;

public class ebw implements Creator<ProviderUserInfo> {
    public static void m16677a(ProviderUserInfo providerUserInfo, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, providerUserInfo.f1979a);
        cfc.m11055a(parcel, 2, providerUserInfo.m2513a(), false);
        cfc.m11055a(parcel, 3, providerUserInfo.m2514b(), false);
        cfc.m11055a(parcel, 4, providerUserInfo.m2515c(), false);
        cfc.m11055a(parcel, 5, providerUserInfo.m2517e(), false);
        cfc.m11043a(parcel, a);
    }

    public ProviderUserInfo m16678a(Parcel parcel) {
        String str = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str4 = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                case 4:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 5:
                    str = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ProviderUserInfo(i, str4, str3, str2, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ProviderUserInfo[] m16679a(int i) {
        return new ProviderUserInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16678a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16679a(i);
    }
}
