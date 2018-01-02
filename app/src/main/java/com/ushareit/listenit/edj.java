package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.database.connection.idl.ConnectionConfig;
import com.google.firebase.database.connection.idl.HostInfoParcelable;
import java.util.List;

public class edj implements Creator<ConnectionConfig> {
    public static void m16792a(ConnectionConfig connectionConfig, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, connectionConfig.f2001a);
        cfc.m11050a(parcel, 2, connectionConfig.f2002b, i, false);
        cfc.m11046a(parcel, 3, connectionConfig.f2003c);
        cfc.m11066b(parcel, 4, connectionConfig.f2004d, false);
        cfc.m11058a(parcel, 5, connectionConfig.f2005e);
        cfc.m11055a(parcel, 6, connectionConfig.f2006f, false);
        cfc.m11055a(parcel, 7, connectionConfig.f2007g, false);
        cfc.m11043a(parcel, a);
    }

    public ConnectionConfig m16793a(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = cfa.m11020b(parcel);
        String str2 = null;
        List list = null;
        int i = 0;
        HostInfoParcelable hostInfoParcelable = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    hostInfoParcelable = (HostInfoParcelable) cfa.m11017a(parcel, a, HostInfoParcelable.CREATOR);
                    break;
                case 3:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 4:
                    list = cfa.m11041t(parcel, a);
                    break;
                case 5:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 6:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 7:
                    str = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionConfig(i2, hostInfoParcelable, i, list, z, str2, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ConnectionConfig[] m16794a(int i) {
        return new ConnectionConfig[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16793a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16794a(i);
    }
}
