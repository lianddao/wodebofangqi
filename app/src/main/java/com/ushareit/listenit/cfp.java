package com.ushareit.listenit;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ValidateAccountRequest;

public class cfp implements Creator<ValidateAccountRequest> {
    public static void m11112a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, validateAccountRequest.f1735a);
        cfc.m11046a(parcel, 2, validateAccountRequest.m2289a());
        cfc.m11049a(parcel, 3, validateAccountRequest.f1736b, false);
        cfc.m11061a(parcel, 4, validateAccountRequest.m2290b(), i, false);
        cfc.m11048a(parcel, 5, validateAccountRequest.m2292d(), false);
        cfc.m11055a(parcel, 6, validateAccountRequest.m2291c(), false);
        cfc.m11043a(parcel, a);
    }

    public ValidateAccountRequest m11113a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = cfa.m11020b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 3:
                    iBinder = cfa.m11035n(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) cfa.m11022b(parcel, a, Scope.CREATOR);
                    break;
                case 5:
                    bundle = cfa.m11036o(parcel, a);
                    break;
                case 6:
                    str = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ValidateAccountRequest[] m11114a(int i) {
        return new ValidateAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11113a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11114a(i);
    }
}
