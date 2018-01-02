package com.ushareit.listenit;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.internal.EventParams;

public class dwx implements Creator<EventParams> {
    public static void m16162a(EventParams eventParams, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, eventParams.f1897a);
        cfc.m11048a(parcel, 2, eventParams.m2444b(), false);
        cfc.m11043a(parcel, a);
    }

    public EventParams m16163a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    bundle = cfa.m11036o(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParams(i, bundle);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public EventParams[] m16164a(int i) {
        return new EventParams[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16163a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16164a(i);
    }
}
