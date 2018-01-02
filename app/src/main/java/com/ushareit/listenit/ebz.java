package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class ebz implements Creator<VerifyAssertionRequest> {
    public static void m16686a(VerifyAssertionRequest verifyAssertionRequest, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, verifyAssertionRequest.f1988a);
        cfc.m11055a(parcel, 2, verifyAssertionRequest.m2524a(), false);
        cfc.m11055a(parcel, 3, verifyAssertionRequest.m2525b(), false);
        cfc.m11055a(parcel, 4, verifyAssertionRequest.m2526c(), false);
        cfc.m11055a(parcel, 5, verifyAssertionRequest.m2527d(), false);
        cfc.m11055a(parcel, 6, verifyAssertionRequest.m2528e(), false);
        cfc.m11055a(parcel, 7, verifyAssertionRequest.m2531h(), false);
        cfc.m11055a(parcel, 8, verifyAssertionRequest.m2532i(), false);
        cfc.m11055a(parcel, 9, verifyAssertionRequest.m2529f(), false);
        cfc.m11058a(parcel, 10, verifyAssertionRequest.m2530g());
        cfc.m11043a(parcel, a);
    }

    public VerifyAssertionRequest m16687a(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = cfa.m11020b(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str8 = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    str7 = cfa.m11034m(parcel, a);
                    break;
                case 4:
                    str6 = cfa.m11034m(parcel, a);
                    break;
                case 5:
                    str5 = cfa.m11034m(parcel, a);
                    break;
                case 6:
                    str4 = cfa.m11034m(parcel, a);
                    break;
                case 7:
                    str3 = cfa.m11034m(parcel, a);
                    break;
                case 8:
                    str2 = cfa.m11034m(parcel, a);
                    break;
                case 9:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 10:
                    z = cfa.m11024c(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new VerifyAssertionRequest(i, str8, str7, str6, str5, str4, str3, str2, str, z);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public VerifyAssertionRequest[] m16688a(int i) {
        return new VerifyAssertionRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16687a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16688a(i);
    }
}
