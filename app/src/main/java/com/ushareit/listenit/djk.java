package com.ushareit.listenit;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Date;
import java.util.HashSet;

public final class djk {
    public static int m14657a(bed com_ushareit_listenit_bed) {
        switch (djl.f9859b[com_ushareit_listenit_bed.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    public static bee m14658a(int i) {
        switch (i) {
            case 1:
                return bee.MALE;
            case 2:
                return bee.FEMALE;
            default:
                return bee.UNKNOWN;
        }
    }

    public static bef m14659a(AdSizeParcel adSizeParcel) {
        int i = 0;
        bef[] com_ushareit_listenit_befArr = new bef[]{bef.f5989a, bef.f5990b, bef.f5991c, bef.f5992d, bef.f5993e, bef.f5994f};
        while (i < 6) {
            if (com_ushareit_listenit_befArr[i].m7883a() == adSizeParcel.f1527f && com_ushareit_listenit_befArr[i].m7884b() == adSizeParcel.f1524c) {
                return com_ushareit_listenit_befArr[i];
            }
            i++;
        }
        return new bef(cao.m10568a(adSizeParcel.f1527f, adSizeParcel.f1524c, adSizeParcel.f1523b));
    }

    public static ben m14660a(AdRequestParcel adRequestParcel) {
        return new ben(new Date(adRequestParcel.f1505b), m14658a(adRequestParcel.f1507d), adRequestParcel.f1508e != null ? new HashSet(adRequestParcel.f1508e) : null, adRequestParcel.f1509f, adRequestParcel.f1514k);
    }
}
