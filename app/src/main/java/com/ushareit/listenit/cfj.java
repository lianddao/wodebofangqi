package com.ushareit.listenit;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;

public class cfj implements Creator<ResolveAccountRequest> {
    public static void m11093a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, resolveAccountRequest.f1722a);
        cfc.m11050a(parcel, 2, resolveAccountRequest.m2279a(), i, false);
        cfc.m11046a(parcel, 3, resolveAccountRequest.m2280b());
        cfc.m11050a(parcel, 4, resolveAccountRequest.m2281c(), i, false);
        cfc.m11043a(parcel, a);
    }

    public ResolveAccountRequest m11094a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int b = cfa.m11020b(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            Account account2;
            int e;
            GoogleSignInAccount googleSignInAccount2;
            int a = cfa.m11015a(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (cfa.m11014a(a)) {
                case 1:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    e = cfa.m11026e(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 2:
                    e = i2;
                    int i4 = i;
                    account2 = (Account) cfa.m11017a(parcel, a, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case 3:
                    account2 = account;
                    e = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = cfa.m11026e(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 4:
                    googleSignInAccount2 = (GoogleSignInAccount) cfa.m11017a(parcel, a, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    e = i2;
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    e = i2;
                    break;
            }
            i2 = e;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountRequest[] m11095a(int i) {
        return new ResolveAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11094a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11095a(i);
    }
}
