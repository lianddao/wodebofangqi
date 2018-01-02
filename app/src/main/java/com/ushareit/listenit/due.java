package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.internal.ClientIdentity;
import java.util.List;

public class due implements Creator<ActivityTransitionRequest> {
    public static void m15604a(ActivityTransitionRequest activityTransitionRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11068c(parcel, 1, activityTransitionRequest.m2357b(), false);
        cfc.m11055a(parcel, 2, activityTransitionRequest.m2358c(), false);
        cfc.m11068c(parcel, 3, activityTransitionRequest.m2359d(), false);
        cfc.m11046a(parcel, 1000, activityTransitionRequest.m2356a());
        cfc.m11043a(parcel, a);
    }

    public ActivityTransitionRequest m15605a(Parcel parcel) {
        List list = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str = null;
        List list2 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    list2 = cfa.m11023c(parcel, a, ActivityTransition.CREATOR);
                    break;
                case 2:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    list = cfa.m11023c(parcel, a, ClientIdentity.CREATOR);
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
            return new ActivityTransitionRequest(i, list2, str, list);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ActivityTransitionRequest[] m15606a(int i) {
        return new ActivityTransitionRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15605a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15606a(i);
    }
}
