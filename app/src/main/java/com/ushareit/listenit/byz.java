package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;

public class byz implements Creator<RewardItemParcel> {
    public static void m10462a(RewardItemParcel rewardItemParcel, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, rewardItemParcel.f1561a);
        cfc.m11055a(parcel, 2, rewardItemParcel.f1562b, false);
        cfc.m11046a(parcel, 3, rewardItemParcel.f1563c);
        cfc.m11043a(parcel, a);
    }

    public RewardItemParcel m10463a(Parcel parcel) {
        int i = 0;
        int b = cfa.m11020b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    i2 = cfa.m11026e(parcel, a);
                    break;
                case 2:
                    str = cfa.m11034m(parcel, a);
                    break;
                case 3:
                    i = cfa.m11026e(parcel, a);
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new RewardItemParcel(i2, str, i);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public RewardItemParcel[] m10464a(int i) {
        return new RewardItemParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10463a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10464a(i);
    }
}
