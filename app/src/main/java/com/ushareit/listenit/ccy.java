package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;

public class ccy implements Creator<SignInAccount> {
    public static void m10867a(SignInAccount signInAccount, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, signInAccount.f1662a);
        cfc.m11055a(parcel, 4, signInAccount.f1663b, false);
        cfc.m11050a(parcel, 7, signInAccount.m2224a(), i, false);
        cfc.m11055a(parcel, 8, signInAccount.f1664c, false);
        cfc.m11043a(parcel, a);
    }

    public SignInAccount m10868a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = "";
        while (parcel.dataPosition() < b) {
            GoogleSignInAccount googleSignInAccount2;
            String str3;
            int e;
            String str4;
            int a = cfa.m11015a(parcel);
            String str5;
            switch (cfa.m11014a(a)) {
                case 1:
                    str5 = str2;
                    googleSignInAccount2 = googleSignInAccount;
                    str3 = str;
                    e = cfa.m11026e(parcel, a);
                    str4 = str5;
                    break;
                case 4:
                    e = i;
                    GoogleSignInAccount googleSignInAccount3 = googleSignInAccount;
                    str3 = cfa.m11034m(parcel, a);
                    str4 = str2;
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 7:
                    str3 = str;
                    e = i;
                    str5 = str2;
                    googleSignInAccount2 = (GoogleSignInAccount) cfa.m11017a(parcel, a, GoogleSignInAccount.CREATOR);
                    str4 = str5;
                    break;
                case 8:
                    str4 = cfa.m11034m(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    str3 = str;
                    e = i;
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    str4 = str2;
                    googleSignInAccount2 = googleSignInAccount;
                    str3 = str;
                    e = i;
                    break;
            }
            i = e;
            str = str3;
            googleSignInAccount = googleSignInAccount2;
            str2 = str4;
        }
        if (parcel.dataPosition() == b) {
            return new SignInAccount(i, str, googleSignInAccount, str2);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public SignInAccount[] m10869a(int i) {
        return new SignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10868a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10869a(i);
    }
}
