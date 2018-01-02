package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

public class ccu implements Creator<SignInConfiguration> {
    public static void m10845a(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, signInConfiguration.f1666a);
        cfc.m11055a(parcel, 2, signInConfiguration.m2225a(), false);
        cfc.m11050a(parcel, 5, signInConfiguration.m2226b(), i, false);
        cfc.m11043a(parcel, a);
    }

    public SignInConfiguration m10846a(Parcel parcel) {
        GoogleSignInOptions googleSignInOptions = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) cfa.m11017a(parcel, a, GoogleSignInOptions.CREATOR);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInConfiguration(i, str, googleSignInOptions);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public SignInConfiguration[] m10847a(int i) {
        return new SignInConfiguration[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10846a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10847a(i);
    }
}
