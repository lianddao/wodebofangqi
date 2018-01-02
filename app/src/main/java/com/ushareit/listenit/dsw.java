package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.internal.ClientIdentity;

public class dsw implements Creator<ClientIdentity> {
    public static void m15459a(ClientIdentity clientIdentity, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, clientIdentity.f1848a);
        cfc.m11055a(parcel, 2, clientIdentity.f1849b, false);
        cfc.m11046a(parcel, 1000, clientIdentity.m2396a());
        cfc.m11043a(parcel, a);
    }

    public ClientIdentity m15460a(Parcel parcel) {
        int i = 0;
        int b = cfa.m11020b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str = cfa.m11034m(parcel, a);
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
            return new ClientIdentity(i2, i, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ClientIdentity[] m15461a(int i) {
        return new ClientIdentity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15460a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15461a(i);
    }
}
