package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest;

public class cbd implements Creator<GeneratePasswordRequest> {
    public static void m10666a(GeneratePasswordRequest generatePasswordRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11050a(parcel, 1, generatePasswordRequest.m2189a(), i, false);
        cfc.m11046a(parcel, 1000, generatePasswordRequest.f1604a);
        cfc.m11043a(parcel, a);
    }

    public GeneratePasswordRequest m10667a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        PasswordSpecification passwordSpecification = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    passwordSpecification = (PasswordSpecification) cfa.m11017a(parcel, a, PasswordSpecification.CREATOR);
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
            return new GeneratePasswordRequest(i, passwordSpecification);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public GeneratePasswordRequest[] m10668a(int i) {
        return new GeneratePasswordRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10667a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10668a(i);
    }
}
