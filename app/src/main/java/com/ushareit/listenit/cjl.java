package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.config.internal.AnalyticsUserProperty;

public class cjl implements Creator<AnalyticsUserProperty> {
    public static void m11442a(AnalyticsUserProperty analyticsUserProperty, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, analyticsUserProperty.m2315a());
        cfc.m11055a(parcel, 2, analyticsUserProperty.m2316b(), false);
        cfc.m11055a(parcel, 3, analyticsUserProperty.m2317c(), false);
        cfc.m11043a(parcel, a);
    }

    public AnalyticsUserProperty m11443a(Parcel parcel) {
        String str = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    str = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AnalyticsUserProperty(i, str2, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public AnalyticsUserProperty[] m11444a(int i) {
        return new AnalyticsUserProperty[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11443a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11444a(i);
    }
}
