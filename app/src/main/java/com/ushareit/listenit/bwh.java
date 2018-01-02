package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

public class bwh implements Creator<AdSizeParcel> {
    public static void m10205a(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, adSizeParcel.f1522a);
        cfc.m11055a(parcel, 2, adSizeParcel.f1523b, false);
        cfc.m11046a(parcel, 3, adSizeParcel.f1524c);
        cfc.m11046a(parcel, 4, adSizeParcel.f1525d);
        cfc.m11058a(parcel, 5, adSizeParcel.f1526e);
        cfc.m11046a(parcel, 6, adSizeParcel.f1527f);
        cfc.m11046a(parcel, 7, adSizeParcel.f1528g);
        cfc.m11061a(parcel, 8, adSizeParcel.f1529h, i, false);
        cfc.m11058a(parcel, 9, adSizeParcel.f1530i);
        cfc.m11058a(parcel, 10, adSizeParcel.f1531j);
        cfc.m11058a(parcel, 11, adSizeParcel.f1532k);
        cfc.m11043a(parcel, a);
    }

    public AdSizeParcel m10206a(Parcel parcel) {
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z = false;
        int b = cfa.m11020b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i5 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    i4 = cfa.m11026e(parcel, a);
                    break;
                case 4:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                case 5:
                    z4 = cfa.m11024c(parcel, a);
                    break;
                case 6:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 7:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 8:
                    adSizeParcelArr = (AdSizeParcel[]) cfa.m11022b(parcel, a, AdSizeParcel.CREATOR);
                    break;
                case 9:
                    z3 = cfa.m11024c(parcel, a);
                    break;
                case 10:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 11:
                    z = cfa.m11024c(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdSizeParcel(i5, str, i4, i3, z4, i2, i, adSizeParcelArr, z3, z2, z);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public AdSizeParcel[] m10207a(int i) {
        return new AdSizeParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10206a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10207a(i);
    }
}
