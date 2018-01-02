package com.ushareit.listenit;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.List;

public class dsf implements Creator<ActivityRecognitionResult> {
    public static void m15423a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11068c(parcel, 1, activityRecognitionResult.f1788a, false);
        cfc.m11047a(parcel, 2, activityRecognitionResult.f1789b);
        cfc.m11047a(parcel, 3, activityRecognitionResult.f1790c);
        cfc.m11046a(parcel, 4, activityRecognitionResult.f1791d);
        cfc.m11048a(parcel, 5, activityRecognitionResult.f1792e, false);
        cfc.m11046a(parcel, 1000, activityRecognitionResult.m2351a());
        cfc.m11043a(parcel, a);
    }

    public ActivityRecognitionResult m15424a(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int i = 0;
        int b = cfa.m11020b(parcel);
        long j2 = 0;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    list = cfa.m11023c(parcel, a, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = cfa.m11028g(parcel, a);
                    break;
                case 3:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 4:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 5:
                    bundle = cfa.m11036o(parcel, a);
                    break;
                case 1000:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ActivityRecognitionResult(i2, list, j2, j, i, bundle);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ActivityRecognitionResult[] m15425a(int i) {
        return new ActivityRecognitionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15424a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15425a(i);
    }
}
