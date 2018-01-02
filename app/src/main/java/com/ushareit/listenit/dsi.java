package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.DetectedActivity;

public class dsi implements Creator<DetectedActivity> {
    public static void m15428a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, detectedActivity.f1805d);
        cfc.m11046a(parcel, 2, detectedActivity.f1806e);
        cfc.m11046a(parcel, 1000, detectedActivity.m2364c());
        cfc.m11043a(parcel, a);
    }

    public DetectedActivity m15429a(Parcel parcel) {
        int i = 0;
        int b = cfa.m11020b(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 1000:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public DetectedActivity[] m15430a(int i) {
        return new DetectedActivity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15429a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15430a(i);
    }
}
