package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.auth.api.model.CreateAuthUriResponse;
import com.google.firebase.auth.api.model.StringList;

public class ebs implements Creator<CreateAuthUriResponse> {
    public static void m16665a(CreateAuthUriResponse createAuthUriResponse, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, createAuthUriResponse.f1957a);
        cfc.m11055a(parcel, 2, createAuthUriResponse.m2490a(), false);
        cfc.m11058a(parcel, 3, createAuthUriResponse.m2491b());
        cfc.m11055a(parcel, 4, createAuthUriResponse.m2492c(), false);
        cfc.m11058a(parcel, 5, createAuthUriResponse.m2493d());
        cfc.m11050a(parcel, 6, createAuthUriResponse.m2494e(), i, false);
        cfc.m11043a(parcel, a);
    }

    public CreateAuthUriResponse m16666a(Parcel parcel) {
        StringList stringList = null;
        boolean z = false;
        int b = cfa.m11020b(parcel);
        String str = null;
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
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 4:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 5:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 6:
                    stringList = (StringList) cfa.m11017a(parcel, a, StringList.CREATOR);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CreateAuthUriResponse(i, str2, z2, str, z, stringList);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public CreateAuthUriResponse[] m16667a(int i) {
        return new CreateAuthUriResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16666a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16667a(i);
    }
}
