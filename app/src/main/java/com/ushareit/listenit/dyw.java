package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.phenotype.Flag;

public class dyw implements Creator<Flag> {
    public static void m16500a(Flag flag, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, flag.f1919a);
        cfc.m11055a(parcel, 2, flag.f1920b, false);
        cfc.m11047a(parcel, 3, flag.f1921c);
        cfc.m11058a(parcel, 4, flag.f1922d);
        cfc.m11044a(parcel, 5, flag.f1923e);
        cfc.m11055a(parcel, 6, flag.f1924f, false);
        cfc.m11059a(parcel, 7, flag.f1925g, false);
        cfc.m11046a(parcel, 8, flag.f1926h);
        cfc.m11046a(parcel, 9, flag.f1927i);
        cfc.m11043a(parcel, a);
    }

    public Flag m16501a(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int b = cfa.m11020b(parcel);
        long j = 0;
        double d = 0.0d;
        int i2 = 0;
        String str = null;
        boolean z = false;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 4:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 5:
                    d = cfa.m11032k(parcel, a);
                    break;
                case 6:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 7:
                    bArr = cfa.m11037p(parcel, a);
                    break;
                case 8:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 9:
                    i = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Flag(i3, str2, j, z, d, str, bArr, i2, i);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public Flag[] m16502a(int i) {
        return new Flag[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16501a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16502a(i);
    }
}
