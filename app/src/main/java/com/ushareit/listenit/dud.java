package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.ActivityTransition;

public class dud implements Creator<ActivityTransition> {
    public static void m15601a(ActivityTransition activityTransition, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, activityTransition.m2353b());
        cfc.m11046a(parcel, 2, activityTransition.m2354c());
        cfc.m11046a(parcel, 1000, activityTransition.m2352a());
        cfc.m11043a(parcel, a);
    }

    public ActivityTransition m15602a(Parcel parcel) {
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
            return new ActivityTransition(i3, i2, i);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ActivityTransition[] m15603a(int i) {
        return new ActivityTransition[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15602a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15603a(i);
    }
}
