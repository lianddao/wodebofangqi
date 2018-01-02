package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.database.connection.idl.RangeParcelable;
import java.util.List;

public class eeg implements Creator<RangeParcelable> {
    public static void m16839a(RangeParcelable rangeParcelable, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, rangeParcelable.f2013a);
        cfc.m11066b(parcel, 2, rangeParcelable.f2014b, false);
        cfc.m11066b(parcel, 3, rangeParcelable.f2015c, false);
        cfc.m11043a(parcel, a);
    }

    public RangeParcelable m16840a(Parcel parcel) {
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
            return new RangeParcelable(i, list2, list);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public RangeParcelable[] m16841a(int i) {
        return new RangeParcelable[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16840a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16841a(i);
    }
}
