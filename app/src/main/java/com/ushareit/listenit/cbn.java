package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public class cbn implements Creator<CredentialRequest> {
    public static void m10696a(CredentialRequest credentialRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11058a(parcel, 1, credentialRequest.m2176a());
        cfc.m11062a(parcel, 2, credentialRequest.m2177b(), false);
        cfc.m11050a(parcel, 3, credentialRequest.m2178c(), i, false);
        cfc.m11050a(parcel, 4, credentialRequest.m2179d(), i, false);
        cfc.m11046a(parcel, 1000, credentialRequest.f1584a);
        cfc.m11043a(parcel, a);
    }

    public CredentialRequest m10697a(Parcel parcel) {
        boolean z = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int b = cfa.m11020b(parcel);
        CredentialPickerConfig credentialPickerConfig2 = null;
        String[] strArr = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 2:
                    strArr = cfa.m11039r(parcel, a);
                    break;
                case 3:
                    credentialPickerConfig2 = (CredentialPickerConfig) cfa.m11017a(parcel, a, CredentialPickerConfig.CREATOR);
                    break;
                case 4:
                    credentialPickerConfig = (CredentialPickerConfig) cfa.m11017a(parcel, a, CredentialPickerConfig.CREATOR);
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
            return new CredentialRequest(i, z, strArr, credentialPickerConfig2, credentialPickerConfig);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public CredentialRequest[] m10698a(int i) {
        return new CredentialRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10697a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10698a(i);
    }
}
