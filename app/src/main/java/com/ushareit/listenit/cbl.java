package com.ushareit.listenit;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.IdToken;
import java.util.List;

public class cbl implements Creator<Credential> {
    public static void m10690a(Credential credential, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11055a(parcel, 1, credential.m2164a(), false);
        cfc.m11055a(parcel, 2, credential.m2165b(), false);
        cfc.m11050a(parcel, 3, credential.m2166c(), i, false);
        cfc.m11068c(parcel, 4, credential.m2167d(), false);
        cfc.m11055a(parcel, 5, credential.m2168e(), false);
        cfc.m11055a(parcel, 6, credential.m2170g(), false);
        cfc.m11055a(parcel, 7, credential.m2169f(), false);
        cfc.m11046a(parcel, 1000, credential.f1570a);
        cfc.m11055a(parcel, 8, credential.m2171h(), false);
        cfc.m11043a(parcel, a);
    }

    public Credential m10691a(Parcel parcel) {
        String str = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        List list = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    str6 = cfa.m11034m(parcel, a);
                    break;
                case 2:
                    str5 = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    uri = (Uri) cfa.m11017a(parcel, a, Uri.CREATOR);
                    break;
                case 4:
                    list = cfa.m11023c(parcel, a, IdToken.CREATOR);
                    break;
                case 5:
                    str4 = cfa.m11034m(parcel, a);
                    break;
                case 6:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                case 7:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 8:
                    str = cfa.m11034m(parcel, a);
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
            return new Credential(i, str6, str5, uri, list, str4, str3, str2, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public Credential[] m10692a(int i) {
        return new Credential[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10691a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10692a(i);
    }
}
