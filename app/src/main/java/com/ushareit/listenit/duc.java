package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.location.ActivityRecognitionRequest;

public class duc implements Creator<ActivityRecognitionRequest> {
    public static void m15598a(ActivityRecognitionRequest activityRecognitionRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11047a(parcel, 1, activityRecognitionRequest.m2341a());
        cfc.m11058a(parcel, 2, activityRecognitionRequest.m2342b());
        cfc.m11050a(parcel, 3, activityRecognitionRequest.m2343c(), i, false);
        cfc.m11055a(parcel, 4, activityRecognitionRequest.m2344d(), false);
        cfc.m11060a(parcel, 5, activityRecognitionRequest.m2345e(), false);
        cfc.m11058a(parcel, 6, activityRecognitionRequest.m2346f());
        cfc.m11055a(parcel, 7, activityRecognitionRequest.m2347g(), false);
        cfc.m11046a(parcel, 1000, activityRecognitionRequest.m2349i());
        cfc.m11047a(parcel, 8, activityRecognitionRequest.m2348h());
        cfc.m11043a(parcel, a);
    }

    public ActivityRecognitionRequest m15599a(Parcel parcel) {
        long j = 0;
        boolean z = false;
        String str = null;
        int b = cfa.m11020b(parcel);
        int[] iArr = null;
        String str2 = null;
        WorkSource workSource = null;
        boolean z2 = false;
        long j2 = 0;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    j2 = cfa.m11028g(parcel, a);
                    break;
                case 2:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 3:
                    workSource = (WorkSource) cfa.m11017a(parcel, a, WorkSource.CREATOR);
                    break;
                case 4:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 5:
                    iArr = cfa.m11038q(parcel, a);
                    break;
                case 6:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 7:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 8:
                    j = cfa.m11028g(parcel, a);
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
            return new ActivityRecognitionRequest(i, j2, z2, workSource, str2, iArr, z, str, j);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ActivityRecognitionRequest[] m15600a(int i) {
        return new ActivityRecognitionRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15599a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15600a(i);
    }
}
