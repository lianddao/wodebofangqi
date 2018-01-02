package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.SignInRequest;

public class dzi implements Creator<SignInRequest> {
    public static void m16550a(SignInRequest signInRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, signInRequest.f1938a);
        cfc.m11050a(parcel, 2, signInRequest.m2459a(), i, false);
        cfc.m11043a(parcel, a);
    }

    public SignInRequest m16551a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    resolveAccountRequest = (ResolveAccountRequest) cfa.m11017a(parcel, a, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public SignInRequest[] m16552a(int i) {
        return new SignInRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16551a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16552a(i);
    }
}
