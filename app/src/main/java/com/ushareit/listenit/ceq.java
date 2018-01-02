package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;

public class ceq implements Creator<Scope> {
    public static void m10988a(Scope scope, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, scope.f1684a);
        cfc.m11055a(parcel, 2, scope.m2248a(), false);
        cfc.m11043a(parcel, a);
    }

    public Scope m10989a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Scope(i, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public Scope[] m10990a(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10989a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10990a(i);
    }
}
