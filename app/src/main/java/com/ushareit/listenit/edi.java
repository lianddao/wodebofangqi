package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.database.connection.idl.CompoundHashParcelable;
import java.util.List;

public class edi implements Creator<CompoundHashParcelable> {
    public static void m16789a(CompoundHashParcelable compoundHashParcelable, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, compoundHashParcelable.f1998a);
        cfc.m11066b(parcel, 2, compoundHashParcelable.f1999b, false);
        cfc.m11066b(parcel, 3, compoundHashParcelable.f2000c, false);
        cfc.m11043a(parcel, a);
    }

    public CompoundHashParcelable m16790a(Parcel parcel) {
        List list = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        List list2 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    list2 = cfa.m11041t(parcel, a);
                    break;
                case 3:
                    list = cfa.m11041t(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CompoundHashParcelable(i, list2, list);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public CompoundHashParcelable[] m16791a(int i) {
        return new CompoundHashParcelable[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16790a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16791a(i);
    }
}
