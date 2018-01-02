package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.ProviderUserInfoList;

public class ebt implements Creator<GetAccountInfoUser> {
    public static void m16668a(GetAccountInfoUser getAccountInfoUser, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, getAccountInfoUser.f1963a);
        cfc.m11055a(parcel, 2, getAccountInfoUser.m2498c(), false);
        cfc.m11055a(parcel, 3, getAccountInfoUser.m2496a(), false);
        cfc.m11058a(parcel, 4, getAccountInfoUser.m2497b());
        cfc.m11055a(parcel, 5, getAccountInfoUser.m2499d(), false);
        cfc.m11055a(parcel, 6, getAccountInfoUser.m2500e(), false);
        cfc.m11050a(parcel, 7, getAccountInfoUser.m2504i(), i, false);
        cfc.m11055a(parcel, 8, getAccountInfoUser.m2502g(), false);
        cfc.m11043a(parcel, a);
    }

    public GetAccountInfoUser m16669a(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = cfa.m11020b(parcel);
        ProviderUserInfoList providerUserInfoList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str5 = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    str4 = cfa.m11034m(parcel, a);
                    break;
                case 4:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 5:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                case 6:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 7:
                    providerUserInfoList = (ProviderUserInfoList) cfa.m11017a(parcel, a, ProviderUserInfoList.CREATOR);
                    break;
                case 8:
                    str = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetAccountInfoUser(i, str5, str4, z, str3, str2, providerUserInfoList, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public GetAccountInfoUser[] m16670a(int i) {
        return new GetAccountInfoUser[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16669a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16670a(i);
    }
}
