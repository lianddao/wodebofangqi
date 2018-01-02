package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.umeng.analytics.C0154a;

public class dsn implements Creator<LocationRequest> {
    public static void m15439a(LocationRequest locationRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, locationRequest.f1822a);
        cfc.m11047a(parcel, 2, locationRequest.f1823b);
        cfc.m11047a(parcel, 3, locationRequest.f1824c);
        cfc.m11058a(parcel, 4, locationRequest.f1825d);
        cfc.m11047a(parcel, 5, locationRequest.f1826e);
        cfc.m11046a(parcel, 6, locationRequest.f1827f);
        cfc.m11045a(parcel, 7, locationRequest.f1828g);
        cfc.m11046a(parcel, 1000, locationRequest.m2378b());
        cfc.m11047a(parcel, 8, locationRequest.f1829h);
        cfc.m11043a(parcel, a);
    }

    public LocationRequest m15440a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        int i2 = 102;
        long j = C0154a.f2954j;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = MoPubClientPositioning.NO_REPEAT;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 3:
                    j2 = cfa.m11028g(parcel, a);
                    break;
                case 4:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 5:
                    j3 = cfa.m11028g(parcel, a);
                    break;
                case 6:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                case 7:
                    f = cfa.m11030i(parcel, a);
                    break;
                case 8:
                    j4 = cfa.m11028g(parcel, a);
                    break;
                case 1000:
                    i = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public LocationRequest[] m15441a(int i) {
        return new LocationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15440a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15441a(i);
    }
}
