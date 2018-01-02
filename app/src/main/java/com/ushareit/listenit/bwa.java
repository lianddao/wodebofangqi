package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;

public class bwa implements Creator<VideoOptionsParcel> {
    public static void m10177a(VideoOptionsParcel videoOptionsParcel, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, videoOptionsParcel.f1548a);
        cfc.m11058a(parcel, 2, videoOptionsParcel.f1549b);
        cfc.m11043a(parcel, a);
    }

    public VideoOptionsParcel m10178a(Parcel parcel) {
        boolean z = false;
        int b = cfa.m11020b(parcel);
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
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new VideoOptionsParcel(i, z);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public VideoOptionsParcel[] m10179a(int i) {
        return new VideoOptionsParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10178a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10179a(i);
    }
}
