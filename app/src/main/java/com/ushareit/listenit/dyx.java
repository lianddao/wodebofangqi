package com.ushareit.listenit;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.signin.internal.AuthAccountResult;

public class dyx implements Creator<AuthAccountResult> {
    public static void m16503a(AuthAccountResult authAccountResult, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, authAccountResult.f1928a);
        cfc.m11046a(parcel, 2, authAccountResult.m2453a());
        cfc.m11050a(parcel, 3, authAccountResult.m2455c(), i, false);
        cfc.m11043a(parcel, a);
    }

    public AuthAccountResult m16504a(Parcel parcel) {
        int i = 0;
        int b = cfa.m11020b(parcel);
        Intent intent = null;
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
                    intent = (Intent) cfa.m11017a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountResult(i2, i, intent);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountResult[] m16505a(int i) {
        return new AuthAccountResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16504a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16505a(i);
    }
}
