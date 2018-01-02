package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;

public class bvy implements Creator<SearchAdRequestParcel> {
    public static void m10157a(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, searchAdRequestParcel.f1533a);
        cfc.m11046a(parcel, 2, searchAdRequestParcel.f1534b);
        cfc.m11046a(parcel, 3, searchAdRequestParcel.f1535c);
        cfc.m11046a(parcel, 4, searchAdRequestParcel.f1536d);
        cfc.m11046a(parcel, 5, searchAdRequestParcel.f1537e);
        cfc.m11046a(parcel, 6, searchAdRequestParcel.f1538f);
        cfc.m11046a(parcel, 7, searchAdRequestParcel.f1539g);
        cfc.m11046a(parcel, 8, searchAdRequestParcel.f1540h);
        cfc.m11046a(parcel, 9, searchAdRequestParcel.f1541i);
        cfc.m11055a(parcel, 10, searchAdRequestParcel.f1542j, false);
        cfc.m11046a(parcel, 11, searchAdRequestParcel.f1543k);
        cfc.m11055a(parcel, 12, searchAdRequestParcel.f1544l, false);
        cfc.m11046a(parcel, 13, searchAdRequestParcel.f1545m);
        cfc.m11046a(parcel, 14, searchAdRequestParcel.f1546n);
        cfc.m11055a(parcel, 15, searchAdRequestParcel.f1547o, false);
        cfc.m11043a(parcel, a);
    }

    public SearchAdRequestParcel m10158a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 3:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                case 4:
                    i4 = cfa.m11026e(parcel, a);
                    break;
                case 5:
                    i5 = cfa.m11026e(parcel, a);
                    break;
                case 6:
                    i6 = cfa.m11026e(parcel, a);
                    break;
                case 7:
                    i7 = cfa.m11026e(parcel, a);
                    break;
                case 8:
                    i8 = cfa.m11026e(parcel, a);
                    break;
                case 9:
                    i9 = cfa.m11026e(parcel, a);
                    break;
                case 10:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 11:
                    i10 = cfa.m11026e(parcel, a);
                    break;
                case 12:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 13:
                    i11 = cfa.m11026e(parcel, a);
                    break;
                case 14:
                    i12 = cfa.m11026e(parcel, a);
                    break;
                case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public SearchAdRequestParcel[] m10159a(int i) {
        return new SearchAdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10158a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10159a(i);
    }
}
