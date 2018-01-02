package com.ushareit.listenit;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.RecordConsentRequest;

public class dzg implements Creator<RecordConsentRequest> {
    public static void m16535a(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, recordConsentRequest.f1934a);
        cfc.m11050a(parcel, 2, recordConsentRequest.m2456a(), i, false);
        cfc.m11061a(parcel, 3, recordConsentRequest.m2457b(), i, false);
        cfc.m11055a(parcel, 4, recordConsentRequest.m2458c(), false);
        cfc.m11043a(parcel, a);
    }

    public RecordConsentRequest m16536a(Parcel parcel) {
        String str = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < b) {
            Scope[] scopeArr2;
            Account account2;
            int e;
            String str2;
            int a = cfa.m11015a(parcel);
            String str3;
            switch (cfa.m11014a(a)) {
                case 1:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    e = cfa.m11026e(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    e = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) cfa.m11017a(parcel, a, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case 3:
                    account2 = account;
                    e = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) cfa.m11022b(parcel, a, Scope.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = cfa.m11034m(parcel, a);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    e = i;
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    e = i;
                    break;
            }
            i = e;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public RecordConsentRequest[] m16537a(int i) {
        return new RecordConsentRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16536a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16537a(i);
    }
}
