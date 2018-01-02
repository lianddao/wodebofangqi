package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;

public class cbr implements Creator<ProxyGrpcRequest> {
    public static void m10705a(ProxyGrpcRequest proxyGrpcRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11055a(parcel, 1, proxyGrpcRequest.f1609b, false);
        cfc.m11046a(parcel, 2, proxyGrpcRequest.f1610c);
        cfc.m11047a(parcel, 3, proxyGrpcRequest.f1611d);
        cfc.m11059a(parcel, 4, proxyGrpcRequest.f1612e, false);
        cfc.m11055a(parcel, 5, proxyGrpcRequest.f1613f, false);
        cfc.m11046a(parcel, 1000, proxyGrpcRequest.f1608a);
        cfc.m11043a(parcel, a);
    }

    public ProxyGrpcRequest m10706a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = cfa.m11020b(parcel);
        long j = 0;
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 2:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 3:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 4:
                    bArr = cfa.m11037p(parcel, a);
                    break;
                case 5:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 1000:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ProxyGrpcRequest(i2, str2, i, j, bArr, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ProxyGrpcRequest[] m10707a(int i) {
        return new ProxyGrpcRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10706a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10707a(i);
    }
}
