package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.auth.api.model.ProviderUserInfo;
import com.google.firebase.auth.api.model.ProviderUserInfoList;
import java.util.List;

public class ebx implements Creator<ProviderUserInfoList> {
    public static void m16680a(ProviderUserInfoList providerUserInfoList, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, providerUserInfoList.f1984a);
        cfc.m11068c(parcel, 2, providerUserInfoList.m2520a(), false);
        cfc.m11043a(parcel, a);
    }

    public ProviderUserInfoList m16681a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    list = cfa.m11023c(parcel, a, ProviderUserInfo.CREATOR);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ProviderUserInfoList(i, list);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ProviderUserInfoList[] m16682a(int i) {
        return new ProviderUserInfoList[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16681a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16682a(i);
    }
}
