package com.ushareit.listenit;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public class ccw implements Creator<GoogleSignInAccount> {
    public static void m10861a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, googleSignInAccount.f1637b);
        cfc.m11055a(parcel, 2, googleSignInAccount.m2194a(), false);
        cfc.m11055a(parcel, 3, googleSignInAccount.m2196b(), false);
        cfc.m11055a(parcel, 4, googleSignInAccount.m2197c(), false);
        cfc.m11055a(parcel, 5, googleSignInAccount.m2198d(), false);
        cfc.m11050a(parcel, 6, googleSignInAccount.m2201g(), i, false);
        cfc.m11055a(parcel, 7, googleSignInAccount.m2202h(), false);
        cfc.m11047a(parcel, 8, googleSignInAccount.m2203i());
        cfc.m11055a(parcel, 9, googleSignInAccount.m2204j(), false);
        cfc.m11068c(parcel, 10, googleSignInAccount.f1638c, false);
        cfc.m11055a(parcel, 11, googleSignInAccount.m2199e(), false);
        cfc.m11055a(parcel, 12, googleSignInAccount.m2200f(), false);
        cfc.m11043a(parcel, a);
    }

    public GoogleSignInAccount m10862a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 4:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                case 5:
                    str4 = cfa.m11034m(parcel, a);
                    break;
                case 6:
                    uri = (Uri) cfa.m11017a(parcel, a, Uri.CREATOR);
                    break;
                case 7:
                    str5 = cfa.m11034m(parcel, a);
                    break;
                case 8:
                    j = cfa.m11028g(parcel, a);
                    break;
                case 9:
                    str6 = cfa.m11034m(parcel, a);
                    break;
                case 10:
                    list = cfa.m11023c(parcel, a, Scope.CREATOR);
                    break;
                case 11:
                    str7 = cfa.m11034m(parcel, a);
                    break;
                case 12:
                    str8 = cfa.m11034m(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInAccount[] m10863a(int i) {
        return new GoogleSignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10862a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10863a(i);
    }
}
