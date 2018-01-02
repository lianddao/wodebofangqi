package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetAccountInfoUserList;
import java.util.List;

public class ebu implements Creator<GetAccountInfoUserList> {
    public static void m16671a(GetAccountInfoUserList getAccountInfoUserList, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, getAccountInfoUserList.f1971a);
        cfc.m11068c(parcel, 2, getAccountInfoUserList.m2505a(), false);
        cfc.m11043a(parcel, a);
    }

    public GetAccountInfoUserList m16672a(Parcel parcel) {
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
                    list = cfa.m11023c(parcel, a, GetAccountInfoUser.CREATOR);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetAccountInfoUserList(i, list);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public GetAccountInfoUserList[] m16673a(int i) {
        return new GetAccountInfoUserList[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16672a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16673a(i);
    }
}
