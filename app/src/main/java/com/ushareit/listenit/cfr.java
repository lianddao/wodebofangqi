package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;

public class cfr implements Creator<AuthAccountRequest> {
    public static void m11116a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, authAccountRequest.f1708a);
        cfc.m11049a(parcel, 2, authAccountRequest.f1709b, false);
        cfc.m11061a(parcel, 3, authAccountRequest.f1710c, i, false);
        cfc.m11053a(parcel, 4, authAccountRequest.f1711d, false);
        cfc.m11053a(parcel, 5, authAccountRequest.f1712e, false);
        cfc.m11043a(parcel, a);
    }

    public AuthAccountRequest m11117a(Parcel parcel) {
        Integer num = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    scopeArr = (Scope[]) cfa.m11022b(parcel, a, Scope.CREATOR);
                    break;
                case 4:
                    num2 = cfa.m11027f(parcel, a);
                    break;
                case 5:
                    num = cfa.m11027f(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountRequest[] m11118a(int i) {
        return new AuthAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11117a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11118a(i);
    }
}
