package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;

public class cbm implements Creator<CredentialPickerConfig> {
    public static void m10693a(CredentialPickerConfig credentialPickerConfig, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11058a(parcel, 1, credentialPickerConfig.m2172a());
        cfc.m11058a(parcel, 2, credentialPickerConfig.m2173b());
        cfc.m11058a(parcel, 3, credentialPickerConfig.m2174c());
        cfc.m11046a(parcel, 4, credentialPickerConfig.m2175d());
        cfc.m11046a(parcel, 1000, credentialPickerConfig.f1579a);
        cfc.m11043a(parcel, a);
    }

    public CredentialPickerConfig m10694a(Parcel parcel) {
        int i = 0;
        int b = cfa.m11020b(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    z3 = cfa.m11024c(parcel, a);
                    break;
                case 2:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 3:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 4:
                    i = cfa.m11026e(parcel, a);
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
            return new CredentialPickerConfig(i2, z3, z2, z, i);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public CredentialPickerConfig[] m10695a(int i) {
        return new CredentialPickerConfig[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10694a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10695a(i);
    }
}
