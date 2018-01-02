package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;

public class bye implements Creator<NativeAdOptionsParcel> {
    public static void m10360a(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, nativeAdOptionsParcel.f1552a);
        cfc.m11058a(parcel, 2, nativeAdOptionsParcel.f1553b);
        cfc.m11046a(parcel, 3, nativeAdOptionsParcel.f1554c);
        cfc.m11058a(parcel, 4, nativeAdOptionsParcel.f1555d);
        cfc.m11046a(parcel, 5, nativeAdOptionsParcel.f1556e);
        cfc.m11050a(parcel, 6, nativeAdOptionsParcel.f1557f, i, false);
        cfc.m11043a(parcel, a);
    }

    public NativeAdOptionsParcel m10361a(Parcel parcel) {
        int i = 0;
        int b = cfa.m11020b(parcel);
        VideoOptionsParcel videoOptionsParcel = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 3:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 4:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 5:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 6:
                    videoOptionsParcel = (VideoOptionsParcel) cfa.m11017a(parcel, a, VideoOptionsParcel.CREATOR);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new NativeAdOptionsParcel(i3, z2, i2, z, i, videoOptionsParcel);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public NativeAdOptionsParcel[] m10362a(int i) {
        return new NativeAdOptionsParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10361a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10362a(i);
    }
}
