package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;

public class cfk implements Creator<ResolveAccountResponse> {
    public static void m11096a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, resolveAccountResponse.f1726a);
        cfc.m11049a(parcel, 2, resolveAccountResponse.f1727b, false);
        cfc.m11050a(parcel, 3, resolveAccountResponse.m2283b(), i, false);
        cfc.m11058a(parcel, 4, resolveAccountResponse.m2284c());
        cfc.m11058a(parcel, 5, resolveAccountResponse.m2285d());
        cfc.m11043a(parcel, a);
    }

    public ResolveAccountResponse m11097a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = cfa.m11020b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    iBinder = cfa.m11035n(parcel, a);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) cfa.m11017a(parcel, a, ConnectionResult.CREATOR);
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
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountResponse[] m11098a(int i) {
        return new ResolveAccountResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11097a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11098a(i);
    }
}
