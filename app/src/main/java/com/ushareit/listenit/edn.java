package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.database.connection.idl.HostInfoParcelable;

public class edn implements Creator<HostInfoParcelable> {
    public static void m16823a(HostInfoParcelable hostInfoParcelable, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, hostInfoParcelable.f2008a);
        cfc.m11055a(parcel, 2, hostInfoParcelable.f2009b, false);
        cfc.m11055a(parcel, 3, hostInfoParcelable.f2010c, false);
        cfc.m11058a(parcel, 4, hostInfoParcelable.f2011d);
        cfc.m11043a(parcel, a);
    }

    public HostInfoParcelable m16824a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = cfa.m11020b(parcel);
        String str2 = null;
        int i = 0;
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
                case 4:
                    z = cfa.m11024c(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new HostInfoParcelable(i, str2, str, z);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public HostInfoParcelable[] m16825a(int i) {
        return new HostInfoParcelable[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16824a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16825a(i);
    }
}
