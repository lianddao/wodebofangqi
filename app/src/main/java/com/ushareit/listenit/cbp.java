package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import java.util.List;

public class cbp implements Creator<PasswordSpecification> {
    public static void m10702a(PasswordSpecification passwordSpecification, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11055a(parcel, 1, passwordSpecification.f1595d, false);
        cfc.m11066b(parcel, 2, passwordSpecification.f1596e, false);
        cfc.m11056a(parcel, 3, passwordSpecification.f1597f, false);
        cfc.m11046a(parcel, 4, passwordSpecification.f1598g);
        cfc.m11046a(parcel, 5, passwordSpecification.f1599h);
        cfc.m11046a(parcel, 1000, passwordSpecification.f1594c);
        cfc.m11043a(parcel, a);
    }

    public PasswordSpecification m10703a(Parcel parcel) {
        List list = null;
        int i = 0;
        int b = cfa.m11020b(parcel);
        int i2 = 0;
        List list2 = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 2:
                    list2 = cfa.m11041t(parcel, a);
                    break;
                case 3:
                    list = cfa.m11040s(parcel, a);
                    break;
                case 4:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 5:
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
            return new PasswordSpecification(i3, str, list2, list, i2, i);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public PasswordSpecification[] m10704a(int i) {
        return new PasswordSpecification[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10703a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10704a(i);
    }
}
