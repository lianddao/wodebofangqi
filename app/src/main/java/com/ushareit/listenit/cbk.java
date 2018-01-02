package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.internal.SaveRequest;

public class cbk implements Creator<SaveRequest> {
    public static void m10687a(SaveRequest saveRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11050a(parcel, 1, saveRequest.m2190a(), i, false);
        cfc.m11046a(parcel, 1000, saveRequest.f1606a);
        cfc.m11043a(parcel, a);
    }

    public SaveRequest m10688a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        Credential credential = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    credential = (Credential) cfa.m11017a(parcel, a, Credential.CREATOR);
                    break;
                case 1000:
                    i = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SaveRequest(i, credential);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public SaveRequest[] m10689a(int i) {
        return new SaveRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10688a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10689a(i);
    }
}
