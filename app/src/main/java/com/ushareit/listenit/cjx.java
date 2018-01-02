package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.config.internal.AnalyticsUserProperty;
import com.google.android.gms.config.internal.FetchConfigIpcRequest;
import java.util.List;

public class cjx implements Creator<FetchConfigIpcRequest> {
    public static void m11486a(FetchConfigIpcRequest fetchConfigIpcRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, fetchConfigIpcRequest.f1759a);
        cfc.m11055a(parcel, 2, fetchConfigIpcRequest.m2321a(), false);
        cfc.m11047a(parcel, 3, fetchConfigIpcRequest.m2322b());
        cfc.m11050a(parcel, 4, fetchConfigIpcRequest.m2323c(), i, false);
        cfc.m11055a(parcel, 5, fetchConfigIpcRequest.m2324d(), false);
        cfc.m11055a(parcel, 6, fetchConfigIpcRequest.m2325e(), false);
        cfc.m11055a(parcel, 7, fetchConfigIpcRequest.m2326f(), false);
        cfc.m11066b(parcel, 8, fetchConfigIpcRequest.m2327g(), false);
        cfc.m11046a(parcel, 9, fetchConfigIpcRequest.m2328h());
        cfc.m11068c(parcel, 10, fetchConfigIpcRequest.m2329i(), false);
        cfc.m11043a(parcel, a);
    }

    public FetchConfigIpcRequest m11487a(Parcel parcel) {
        int i = 0;
        List list = null;
        int b = cfa.m11020b(parcel);
        long j = 0;
        List list2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        DataHolder dataHolder = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str4 = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 4:
                    dataHolder = (DataHolder) cfa.m11017a(parcel, a, DataHolder.CREATOR);
                    break;
                case 5:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                case 6:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 7:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 8:
                    list2 = cfa.m11041t(parcel, a);
                    break;
                case 9:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 10:
                    list = cfa.m11023c(parcel, a, AnalyticsUserProperty.CREATOR);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FetchConfigIpcRequest(i2, str4, j, dataHolder, str3, str2, str, list2, i, list);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public FetchConfigIpcRequest[] m11488a(int i) {
        return new FetchConfigIpcRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11487a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11488a(i);
    }
}
