package com.ushareit.listenit;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import java.util.List;

public class bwf implements Creator<AdRequestParcel> {
    public static void m10200a(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, adRequestParcel.f1504a);
        cfc.m11047a(parcel, 2, adRequestParcel.f1505b);
        cfc.m11048a(parcel, 3, adRequestParcel.f1506c, false);
        cfc.m11046a(parcel, 4, adRequestParcel.f1507d);
        cfc.m11066b(parcel, 5, adRequestParcel.f1508e, false);
        cfc.m11058a(parcel, 6, adRequestParcel.f1509f);
        cfc.m11046a(parcel, 7, adRequestParcel.f1510g);
        cfc.m11058a(parcel, 8, adRequestParcel.f1511h);
        cfc.m11055a(parcel, 9, adRequestParcel.f1512i, false);
        cfc.m11050a(parcel, 10, adRequestParcel.f1513j, i, false);
        cfc.m11050a(parcel, 11, adRequestParcel.f1514k, i, false);
        cfc.m11055a(parcel, 12, adRequestParcel.f1515l, false);
        cfc.m11048a(parcel, 13, adRequestParcel.f1516m, false);
        cfc.m11048a(parcel, 14, adRequestParcel.f1517n, false);
        cfc.m11066b(parcel, 15, adRequestParcel.f1518o, false);
        cfc.m11055a(parcel, 16, adRequestParcel.f1519p, false);
        cfc.m11055a(parcel, 17, adRequestParcel.f1520q, false);
        cfc.m11058a(parcel, 18, adRequestParcel.f1521r);
        cfc.m11043a(parcel, a);
    }

    public AdRequestParcel m10201a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 3:
                    bundle = cfa.m11036o(parcel, a);
                    break;
                case 4:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 5:
                    list = cfa.m11041t(parcel, a);
                    break;
                case 6:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 7:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                case 8:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 9:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) cfa.m11017a(parcel, a, SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) cfa.m11017a(parcel, a, Location.CREATOR);
                    break;
                case 12:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 13:
                    bundle2 = cfa.m11036o(parcel, a);
                    break;
                case 14:
                    bundle3 = cfa.m11036o(parcel, a);
                    break;
                case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
                    list2 = cfa.m11041t(parcel, a);
                    break;
                case 16:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
                    str4 = cfa.m11034m(parcel, a);
                    break;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    z3 = cfa.m11024c(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public AdRequestParcel[] m10202a(int i) {
        return new AdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10201a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10202a(i);
    }
}
