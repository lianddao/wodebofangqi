package com.ushareit.listenit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;

public class byu implements Creator<RewardedVideoAdRequestParcel> {
    public static void m10422a(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        int a = cfc.m11042a(parcel);
        cfc.m11046a(parcel, 1, rewardedVideoAdRequestParcel.f1558a);
        cfc.m11050a(parcel, 2, rewardedVideoAdRequestParcel.f1559b, i, false);
        cfc.m11055a(parcel, 3, rewardedVideoAdRequestParcel.f1560c, false);
        cfc.m11043a(parcel, a);
    }

    public RewardedVideoAdRequestParcel m10423a(Parcel parcel) {
        String str = null;
        int b = cfa.m11020b(parcel);
        int i = 0;
        AdRequestParcel adRequestParcel = null;
        while (parcel.dataPosition() < b) {
            AdRequestParcel adRequestParcel2;
            int e;
            String str2;
            int a = cfa.m11015a(parcel);
            switch (cfa.m11014a(a)) {
                case 1:
                    String str3 = str;
                    adRequestParcel2 = adRequestParcel;
                    e = cfa.m11026e(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    e = i;
                    AdRequestParcel adRequestParcel3 = (AdRequestParcel) cfa.m11017a(parcel, a, AdRequestParcel.CREATOR);
                    str2 = str;
                    adRequestParcel2 = adRequestParcel3;
                    break;
                case 3:
                    str2 = cfa.m11034m(parcel, a);
                    adRequestParcel2 = adRequestParcel;
                    e = i;
                    break;
                default:
                    cfa.m11021b(parcel, a);
                    str2 = str;
                    adRequestParcel2 = adRequestParcel;
                    e = i;
                    break;
            }
            i = e;
            adRequestParcel = adRequestParcel2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new RewardedVideoAdRequestParcel(i, adRequestParcel, str);
        }
        throw new cfb("Overread allowed size end=" + b, parcel);
    }

    public RewardedVideoAdRequestParcel[] m10424a(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10423a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10424a(i);
    }
}
