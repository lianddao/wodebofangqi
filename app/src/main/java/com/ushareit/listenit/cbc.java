package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.internal.DeleteRequest;

public class cbc implements Creator<DeleteRequest> {
    public static void m10663a(DeleteRequest deleteRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11050a(parcel, 1, deleteRequest.m2188a(), i, false);
        cfc.m11046a(parcel, 1000, deleteRequest.f1602a);
        cfc.m11043a(parcel, a);
    }

    public DeleteRequest m10664a(Parcel parcel) {
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
            return new DeleteRequest(i, credential);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public DeleteRequest[] m10665a(int i) {
        return new DeleteRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10664a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10665a(i);
    }
}
