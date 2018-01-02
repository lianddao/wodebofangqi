package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.config.internal.CustomVariable;

public class cjw implements Creator<CustomVariable> {
    public static void m11483a(CustomVariable customVariable, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, customVariable.m2318a());
        cfc.m11055a(parcel, 2, customVariable.m2319b(), false);
        cfc.m11055a(parcel, 3, customVariable.m2320c(), false);
        cfc.m11043a(parcel, a);
    }

    public CustomVariable m11484a(Parcel parcel) {
        String str = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str2 = null;
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
                    str = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CustomVariable(i, str2, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public CustomVariable[] m11485a(int i) {
        return new CustomVariable[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11484a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11485a(i);
    }
}
