package com.ushareit.listenit;

public class esd extends eyq {
    public esd(int i) {
        super(i, m17711a(i));
    }

    public esd(int i, String str) {
        super(i, str);
    }

    public static String m17711a(int i) {
        switch (i) {
            case 1000:
                return "network error";
            case 1001:
                return "no fill error";
            case 1002:
                return "load too frequently error";
            case 1003:
                return "invalid request error";
            case 2000:
                return "server error";
            case 2001:
                return "internal error";
            case 2002:
                return "less count";
            case 9000:
                return "cancel";
            case 9001:
                return "forbid as crash";
            case 9002:
                return "low version";
            case 9003:
                return "unsupport type";
            case 9004:
                return "has no GMS";
            case 9005:
                return "unsupport dis condition";
            case 9006:
                return "has no cloud config";
            default:
                return "unknown error";
        }
    }
}
