package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.config.internal.FetchConfigIpcResponse;

public class cjy implements Creator<FetchConfigIpcResponse> {
    public static void m11489a(FetchConfigIpcResponse fetchConfigIpcResponse, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, fetchConfigIpcResponse.m2330a());
        cfc.m11046a(parcel, 2, fetchConfigIpcResponse.m2331b());
        cfc.m11050a(parcel, 3, fetchConfigIpcResponse.m2332c(), i, false);
        cfc.m11047a(parcel, 4, fetchConfigIpcResponse.m2333d());
        cfc.m11043a(parcel, a);
    }

    public FetchConfigIpcResponse m11490a(Parcel parcel) {
        int i = 0;
        int b = cfa.m11020b(parcel);
        DataHolder dataHolder = null;
        long j = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 3:
                    dataHolder = (DataHolder) cfa.m11017a(parcel, a, DataHolder.CREATOR);
                    break;
                case 4:
                    j = cfa.m11028g(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FetchConfigIpcResponse(i2, i, dataHolder, j);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public FetchConfigIpcResponse[] m11491a(int i) {
        return new FetchConfigIpcResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11490a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11491a(i);
    }
}
