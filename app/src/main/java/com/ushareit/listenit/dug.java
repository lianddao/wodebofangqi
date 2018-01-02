package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.GestureRequest;
import java.util.List;

public class dug implements Creator<GestureRequest> {
    public static void m15610a(GestureRequest gestureRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11056a(parcel, 1, gestureRequest.m2369b(), false);
        cfc.m11046a(parcel, 1000, gestureRequest.m2368a());
        cfc.m11043a(parcel, a);
    }

    public GestureRequest m15611a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    list = cfa.m11040s(parcel, a);
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
            return new GestureRequest(i, list);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public GestureRequest[] m15612a(int i) {
        return new GestureRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15611a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15612a(i);
    }
}
