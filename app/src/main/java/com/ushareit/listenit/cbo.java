package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.IdToken;

public class cbo implements Creator<IdToken> {
    public static void m10699a(IdToken idToken, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11055a(parcel, 1, idToken.m2180a(), false);
        cfc.m11055a(parcel, 2, idToken.m2181b(), false);
        cfc.m11046a(parcel, 1000, idToken.f1589a);
        cfc.m11043a(parcel, a);
    }

    public IdToken m10700a(Parcel parcel) {
        String str = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 2:
                    str = cfa.m11034m(parcel, a);
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
            return new IdToken(i, str2, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public IdToken[] m10701a(int i) {
        return new IdToken[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10700a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10701a(i);
    }
}
