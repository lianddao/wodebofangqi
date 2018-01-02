package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.auth.UserProfileChangeRequest;

public class eca implements Creator<UserProfileChangeRequest> {
    public static void m16695a(UserProfileChangeRequest userProfileChangeRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, userProfileChangeRequest.f1951a);
        cfc.m11055a(parcel, 2, userProfileChangeRequest.m2486a(), false);
        cfc.m11055a(parcel, 3, userProfileChangeRequest.m2487b(), false);
        cfc.m11058a(parcel, 4, userProfileChangeRequest.m2488c());
        cfc.m11058a(parcel, 5, userProfileChangeRequest.m2489d());
        cfc.m11043a(parcel, a);
    }

    public UserProfileChangeRequest m16696a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = cfa.m11020b(parcel);
        boolean z2 = false;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 4:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 5:
                    z = cfa.m11024c(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new UserProfileChangeRequest(i, str2, str, z2, z);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public UserProfileChangeRequest[] m16697a(int i) {
        return new UserProfileChangeRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16696a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16697a(i);
    }
}
