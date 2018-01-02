package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.phenotype.Configuration;
import com.google.android.gms.phenotype.Flag;

public class dyv implements Creator<Configuration> {
    public static void m16497a(Configuration configuration, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, configuration.f1912a);
        cfc.m11046a(parcel, 2, configuration.f1913b);
        cfc.m11061a(parcel, 3, configuration.f1914c, i, false);
        cfc.m11062a(parcel, 4, configuration.f1915d, false);
        cfc.m11043a(parcel, a);
    }

    public Configuration m16498a(Parcel parcel) {
        String[] strArr = null;
        int i = 0;
        int b = cfa.m11020b(parcel);
        Flag[] flagArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            Flag[] flagArr2;
            int i3;
            String[] strArr2;
            int a = cfa.m11015a(parcel);
            String[] strArr3;
            switch (cfa.m11014a(a)) {
                case 1:
                    strArr3 = strArr;
                    flagArr2 = flagArr;
                    i3 = i;
                    i = cfa.m11026e(parcel, a);
                    strArr2 = strArr3;
                    break;
                case 2:
                    i = i2;
                    Flag[] flagArr3 = flagArr;
                    i3 = cfa.m11026e(parcel, a);
                    strArr2 = strArr;
                    flagArr2 = flagArr3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    strArr3 = strArr;
                    flagArr2 = (Flag[]) cfa.m11022b(parcel, a, Flag.CREATOR);
                    strArr2 = strArr3;
                    break;
                case 4:
                    strArr2 = cfa.m11039r(parcel, a);
                    flagArr2 = flagArr;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    strArr2 = strArr;
                    flagArr2 = flagArr;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            flagArr = flagArr2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == b) {
            return new Configuration(i2, i, flagArr, strArr);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public Configuration[] m16499a(int i) {
        return new Configuration[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16498a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16499a(i);
    }
}
