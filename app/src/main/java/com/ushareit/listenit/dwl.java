package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.internal.AppMetadata;

public class dwl implements Creator<AppMetadata> {
    public static void m15993a(AppMetadata appMetadata, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, appMetadata.f1885a);
        cfc.m11055a(parcel, 2, appMetadata.f1886b, false);
        cfc.m11055a(parcel, 3, appMetadata.f1887c, false);
        cfc.m11055a(parcel, 4, appMetadata.f1888d, false);
        cfc.m11055a(parcel, 5, appMetadata.f1889e, false);
        cfc.m11047a(parcel, 6, appMetadata.f1890f);
        cfc.m11047a(parcel, 7, appMetadata.f1891g);
        cfc.m11055a(parcel, 8, appMetadata.f1892h, false);
        cfc.m11058a(parcel, 9, appMetadata.f1893i);
        cfc.m11058a(parcel, 10, appMetadata.f1894j);
        cfc.m11047a(parcel, 11, appMetadata.f1895k);
        cfc.m11055a(parcel, 12, appMetadata.f1896l, false);
        cfc.m11043a(parcel, a);
    }

    public AppMetadata m15994a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
        long j3 = 0;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 4:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                case 5:
                    str4 = cfa.m11034m(parcel, a);
                    break;
                case 6:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 7:
                    j2 = cfa.m11028g(parcel, a);
                    break;
                case 8:
                    str5 = cfa.m11034m(parcel, a);
                    break;
                case 9:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 10:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 11:
                    j3 = cfa.m11028g(parcel, a);
                    break;
                case 12:
                    str6 = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AppMetadata(i, str, str2, str3, str4, j, j2, str5, z, z2, j3, str6);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public AppMetadata[] m15995a(int i) {
        return new AppMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15994a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15995a(i);
    }
}
