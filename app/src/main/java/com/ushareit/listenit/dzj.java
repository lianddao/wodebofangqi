package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.SignInResponse;

public class dzj implements Creator<SignInResponse> {
    public static void m16553a(SignInResponse signInResponse, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, signInResponse.f1940a);
        cfc.m11050a(parcel, 2, signInResponse.m2460a(), i, false);
        cfc.m11050a(parcel, 3, signInResponse.m2461b(), i, false);
        cfc.m11043a(parcel, a);
    }

    public SignInResponse m16554a(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < b) {
            ConnectionResult connectionResult2;
            int e;
            ResolveAccountResponse resolveAccountResponse2;
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    e = cfa.m11026e(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse3;
                    break;
                case 2:
                    e = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) cfa.m11017a(parcel, a, ConnectionResult.CREATOR);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult3;
                    break;
                case 3:
                    resolveAccountResponse2 = (ResolveAccountResponse) cfa.m11017a(parcel, a, ResolveAccountResponse.CREATOR);
                    connectionResult2 = connectionResult;
                    e = i;
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    e = i;
                    break;
            }
            i = e;
            connectionResult = connectionResult2;
            resolveAccountResponse = resolveAccountResponse2;
        }
        if (parcel.dataPosition() == b) {
            return new SignInResponse(i, connectionResult, resolveAccountResponse);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public SignInResponse[] m16555a(int i) {
        return new SignInResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16554a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16555a(i);
    }
}
