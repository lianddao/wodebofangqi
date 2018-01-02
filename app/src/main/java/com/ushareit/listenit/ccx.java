package com.ushareit.listenit;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

public class ccx implements Creator<GoogleSignInOptions> {
    public static void m10864a(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, googleSignInOptions.f1654e);
        cfc.m11068c(parcel, 2, googleSignInOptions.m2216a(), false);
        cfc.m11050a(parcel, 3, googleSignInOptions.m2217b(), i, false);
        cfc.m11058a(parcel, 4, googleSignInOptions.m2218c());
        cfc.m11058a(parcel, 5, googleSignInOptions.m2219d());
        cfc.m11058a(parcel, 6, googleSignInOptions.m2220e());
        cfc.m11055a(parcel, 7, googleSignInOptions.m2221f(), false);
        cfc.m11055a(parcel, 8, googleSignInOptions.m2222g(), false);
        cfc.m11043a(parcel, a);
    }

    public GoogleSignInOptions m10865a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = cfa.m11020b(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    arrayList = cfa.m11023c(parcel, a, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) cfa.m11017a(parcel, a, Account.CREATOR);
                    break;
                case 4:
                    z3 = cfa.m11024c(parcel, a);
                    break;
                case 5:
                    z2 = cfa.m11024c(parcel, a);
                    break;
                case 6:
                    z = cfa.m11024c(parcel, a);
                    break;
                case 7:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 8:
                    str = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInOptions(i, arrayList, account, z3, z2, z, str2, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInOptions[] m10866a(int i) {
        return new GoogleSignInOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10865a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10866a(i);
    }
}
