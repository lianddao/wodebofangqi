package com.ushareit.listenit;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public class cbs implements Creator<ProxyRequest> {
    public static void m10708a(ProxyRequest proxyRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11055a(parcel, 1, proxyRequest.f1624k, false);
        cfc.m11046a(parcel, 2, proxyRequest.f1625l);
        cfc.m11047a(parcel, 3, proxyRequest.f1626m);
        cfc.m11059a(parcel, 4, proxyRequest.f1627n, false);
        cfc.m11048a(parcel, 5, proxyRequest.f1628o, false);
        cfc.m11046a(parcel, 1000, proxyRequest.f1623j);
        cfc.m11043a(parcel, a);
    }

    public ProxyRequest m10709a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = cfa.m11020b(parcel);
        long j = 0;
        byte[] bArr = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    str = cfa.m11034m(parcel, a);
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
                    bundle = cfa.m11036o(parcel, a);
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
            return new ProxyRequest(i2, str, i, j, bArr, bundle);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ProxyRequest[] m10710a(int i) {
        return new ProxyRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10709a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10710a(i);
    }
}
