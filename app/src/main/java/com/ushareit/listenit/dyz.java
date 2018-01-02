package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import java.util.List;

public class dyz implements Creator<CheckServerAuthResult> {
    public static void m16506a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, checkServerAuthResult.f1931a);
        cfc.m11058a(parcel, 2, checkServerAuthResult.f1932b);
        cfc.m11068c(parcel, 3, checkServerAuthResult.f1933c, false);
        cfc.m11043a(parcel, a);
    }

    public CheckServerAuthResult m16507a(Parcel parcel) {
        boolean z = false;
        int b = cfa.m11020b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 3:
                    list = cfa.m11023c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public CheckServerAuthResult[] m16508a(int i) {
        return new CheckServerAuthResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16507a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16508a(i);
    }
}
