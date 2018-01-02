package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.auth.api.model.GetTokenResponse;

public class ebv implements Creator<GetTokenResponse> {
    public static void m16674a(GetTokenResponse getTokenResponse, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, getTokenResponse.f1973a);
        cfc.m11055a(parcel, 2, getTokenResponse.m2508b(), false);
        cfc.m11055a(parcel, 3, getTokenResponse.m2509c(), false);
        cfc.m11054a(parcel, 4, Long.valueOf(getTokenResponse.m2510d()), false);
        cfc.m11055a(parcel, 5, getTokenResponse.m2511e(), false);
        cfc.m11054a(parcel, 6, Long.valueOf(getTokenResponse.m2512f()), false);
        cfc.m11043a(parcel, a);
    }

    public GetTokenResponse m16675a(Parcel parcel) {
        Long l = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str = null;
        Long l2 = null;
        String str2 = null;
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
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 4:
                    l2 = cfa.m11029h(parcel, a);
                    break;
                case 5:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 6:
                    l = cfa.m11029h(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetTokenResponse(i, str3, str2, l2, str, l);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public GetTokenResponse[] m16676a(int i) {
        return new GetTokenResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16675a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16676a(i);
    }
}
