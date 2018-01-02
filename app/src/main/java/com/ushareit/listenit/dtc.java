package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.internal.FusedLocationProviderResult;

public class dtc implements Creator<FusedLocationProviderResult> {
    public static void m15475a(FusedLocationProviderResult fusedLocationProviderResult, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11050a(parcel, 1, fusedLocationProviderResult.mo260b(), i, false);
        cfc.m11046a(parcel, 1000, fusedLocationProviderResult.m2397a());
        cfc.m11043a(parcel, a);
    }

    public FusedLocationProviderResult m15476a(Parcel parcel) {
        int b = cfa.m11020b(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    status = (Status) cfa.m11017a(parcel, a, Status.CREATOR);
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
            return new FusedLocationProviderResult(i, status);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public FusedLocationProviderResult[] m15477a(int i) {
        return new FusedLocationProviderResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15476a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15477a(i);
    }
}
