package com.ushareit.listenit;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;

public class cgz implements Creator<GetServiceRequest> {
    public static void m11205a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, getServiceRequest.f1713a);
        cfc.m11046a(parcel, 2, getServiceRequest.f1714b);
        cfc.m11046a(parcel, 3, getServiceRequest.f1715c);
        cfc.m11055a(parcel, 4, getServiceRequest.f1716d, false);
        cfc.m11049a(parcel, 5, getServiceRequest.f1717e, false);
        cfc.m11061a(parcel, 6, getServiceRequest.f1718f, i, false);
        cfc.m11048a(parcel, 7, getServiceRequest.f1719g, false);
        cfc.m11050a(parcel, 8, getServiceRequest.f1720h, i, false);
        cfc.m11047a(parcel, 9, getServiceRequest.f1721i);
        cfc.m11043a(parcel, a);
    }

    public GetServiceRequest m11206a(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = cfa.m11020b(parcel);
        long j = 0;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 3:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 4:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 5:
                    iBinder = cfa.m11035n(parcel, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) cfa.m11022b(parcel, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = cfa.m11036o(parcel, a);
                    break;
                case 8:
                    account = (Account) cfa.m11017a(parcel, a, Account.CREATOR);
                    break;
                case 9:
                    j = cfa.m11028g(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account, j);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public GetServiceRequest[] m11207a(int i) {
        return new GetServiceRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11206a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11207a(i);
    }
}
