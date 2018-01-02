package com.ushareit.listenit;

public enum aoi {
    UNKNOWN,
    BANNER,
    INTERSTITIAL,
    NATIVE,
    REWARDED_VIDEO;

    public static aoi m6457a(ano com_ushareit_listenit_ano) {
        switch (aoj.f5044a[com_ushareit_listenit_ano.ordinal()]) {
            case 1:
                return NATIVE;
            case 2:
            case 3:
            case 4:
            case 5:
                return BANNER;
            case 6:
            case 7:
            case 8:
            case 9:
                return INTERSTITIAL;
            case 10:
                return REWARDED_VIDEO;
            default:
                return UNKNOWN;
        }
    }
}
