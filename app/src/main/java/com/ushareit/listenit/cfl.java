package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;

public class cfl implements Creator<SignInButtonConfig> {
    public static void m11099a(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, signInButtonConfig.f1731a);
        cfc.m11046a(parcel, 2, signInButtonConfig.m2286a());
        cfc.m11046a(parcel, 3, signInButtonConfig.m2287b());
        cfc.m11061a(parcel, 4, signInButtonConfig.m2288c(), i, false);
        cfc.m11043a(parcel, a);
    }

    public SignInButtonConfig m11100a(Parcel parcel) {
        int i = 0;
        int b = cfa.m11020b(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i3 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 3:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) cfa.m11022b(parcel, a, Scope.CREATOR);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInButtonConfig(i3, i2, i, scopeArr);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public SignInButtonConfig[] m11101a(int i) {
        return new SignInButtonConfig[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11100a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11101a(i);
    }
}
