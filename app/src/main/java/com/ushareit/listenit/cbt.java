package com.ushareit.listenit;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public class cbt implements Creator<ProxyResponse> {
    public static void m10711a(ProxyResponse proxyResponse, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, proxyResponse.f1630b);
        cfc.m11050a(parcel, 2, proxyResponse.f1631c, i, false);
        cfc.m11046a(parcel, 3, proxyResponse.f1632d);
        cfc.m11048a(parcel, 4, proxyResponse.f1633e, false);
        cfc.m11059a(parcel, 5, proxyResponse.f1634f, false);
        cfc.m11046a(parcel, 1000, proxyResponse.f1629a);
        cfc.m11043a(parcel, a);
    }

    public ProxyResponse m10712a(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int b = cfa.m11020b(parcel);
        Bundle bundle = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) cfa.m11017a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 3:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 4:
                    bundle = cfa.m11036o(parcel, a);
                    break;
                case 5:
                    bArr = cfa.m11037p(parcel, a);
                    break;
                case 1000:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ProxyResponse(i3, i2, pendingIntent, i, bundle, bArr);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ProxyResponse[] m10713a(int i) {
        return new ProxyResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10712a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10713a(i);
    }
}
