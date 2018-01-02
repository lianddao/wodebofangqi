package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.auth.api.model.StringList;
import java.util.List;

public class eby implements Creator<StringList> {
    public static void m16683a(StringList stringList, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, stringList.f1986a);
        cfc.m11066b(parcel, 2, stringList.m2523a(), false);
        cfc.m11043a(parcel, a);
    }

    public StringList m16684a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    list = cfa.m11041t(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StringList(i, list);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public StringList[] m16685a(int i) {
        return new StringList[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16684a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16685a(i);
    }
}
