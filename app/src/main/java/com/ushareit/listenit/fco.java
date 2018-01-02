package com.ushareit.listenit;

import java.util.Locale;

public final class fco {
    public static String m18855a(fcg com_ushareit_listenit_fcg) {
        switch (fcp.f12442a[com_ushareit_listenit_fcg.ordinal()]) {
            case 1:
                return String.format(Locale.US, "_size > %s", new Object[]{Long.valueOf(10240)}) + " AND " + "title NOT LIKE '%/./%' AND title NOT LIKE '%log%' AND title NOT LIKE '%tmp%' AND title NOT LIKE '%temp%' AND title NOT LIKE '%cache%' AND _data NOT LIKE '%/.%' AND _data NOT LIKE '%/log/%' AND _data NOT LIKE '%/tmp/%' AND _data NOT LIKE '%/temp/%' AND _data NOT LIKE '%/ads/%' AND _data NOT LIKE '%/cache/%'";
            case 2:
                return String.format(Locale.US, "_size > %s", new Object[]{Long.valueOf(512000)}) + " AND " + "title NOT LIKE '%/./%' AND title NOT LIKE '%log%' AND title NOT LIKE '%tmp%' AND title NOT LIKE '%temp%' AND title NOT LIKE '%cache%' AND _data NOT LIKE '%/.%' AND _data NOT LIKE '%/log/%' AND _data NOT LIKE '%/tmp/%' AND _data NOT LIKE '%/temp/%' AND _data NOT LIKE '%/ads/%' AND _data NOT LIKE '%/cache/%'";
            case 3:
                return String.format(Locale.US, "_size > %s", new Object[]{Long.valueOf(512000)}) + " AND " + "title NOT LIKE '%/./%' AND title NOT LIKE '%log%' AND title NOT LIKE '%tmp%' AND title NOT LIKE '%temp%' AND title NOT LIKE '%cache%' AND _data NOT LIKE '%/.%' AND _data NOT LIKE '%/log/%' AND _data NOT LIKE '%/tmp/%' AND _data NOT LIKE '%/temp/%' AND _data NOT LIKE '%/ads/%' AND _data NOT LIKE '%/cache/%'";
            case 4:
                return String.format(Locale.US, "_size > %s", new Object[]{Long.valueOf(1)}) + " AND " + "title NOT LIKE '%/./%' AND title NOT LIKE '%log%' AND title NOT LIKE '%tmp%' AND title NOT LIKE '%temp%' AND title NOT LIKE '%cache%' AND _data NOT LIKE '%/.%' AND _data NOT LIKE '%/log/%' AND _data NOT LIKE '%/tmp/%' AND _data NOT LIKE '%/temp/%' AND _data NOT LIKE '%/ads/%' AND _data NOT LIKE '%/cache/%'";
            case 5:
                return String.format(Locale.US, "_size > %s", new Object[]{Long.valueOf(1)}) + " AND " + "title NOT LIKE '%/./%' AND title NOT LIKE '%log%' AND title NOT LIKE '%tmp%' AND title NOT LIKE '%temp%' AND title NOT LIKE '%cache%' AND _data NOT LIKE '%/.%' AND _data NOT LIKE '%/log/%' AND _data NOT LIKE '%/tmp/%' AND _data NOT LIKE '%/temp/%' AND _data NOT LIKE '%/ads/%' AND _data NOT LIKE '%/cache/%'";
            case 6:
                return String.format(Locale.US, "_size > %s", new Object[]{Long.valueOf(1)}) + " AND " + "title NOT LIKE '%/./%' AND title NOT LIKE '%log%' AND title NOT LIKE '%tmp%' AND title NOT LIKE '%temp%' AND title NOT LIKE '%cache%' AND _data NOT LIKE '%/.%' AND _data NOT LIKE '%/log/%' AND _data NOT LIKE '%/tmp/%' AND _data NOT LIKE '%/temp/%' AND _data NOT LIKE '%/ads/%' AND _data NOT LIKE '%/cache/%'";
            default:
                return null;
        }
    }

    public static String m18857b(fcg com_ushareit_listenit_fcg) {
        return "_size = 0  AND title NOT LIKE '%/./%' AND title NOT LIKE '%log%' AND title NOT LIKE '%tmp%' AND title NOT LIKE '%temp%' AND title NOT LIKE '%cache%' AND _data NOT LIKE '%/.%' AND _data NOT LIKE '%/log/%' AND _data NOT LIKE '%/tmp/%' AND _data NOT LIKE '%/temp/%' AND _data NOT LIKE '%/ads/%' AND _data NOT LIKE '%/cache/%'";
    }

    public static String m18858c(fcg com_ushareit_listenit_fcg) {
        switch (fcp.f12442a[com_ushareit_listenit_fcg.ordinal()]) {
            case 1:
                return String.format(Locale.US, "(_size = 0  OR _size > %s)", new Object[]{Long.valueOf(10240)}) + " AND " + "title NOT LIKE '%/./%' AND title NOT LIKE '%log%' AND title NOT LIKE '%tmp%' AND title NOT LIKE '%temp%' AND title NOT LIKE '%cache%' AND _data NOT LIKE '%/.%' AND _data NOT LIKE '%/log/%' AND _data NOT LIKE '%/tmp/%' AND _data NOT LIKE '%/temp/%' AND _data NOT LIKE '%/ads/%' AND _data NOT LIKE '%/cache/%'";
            case 2:
                return String.format(Locale.US, "(_size = 0  OR _size > %s)", new Object[]{Long.valueOf(512000)}) + " AND " + "title NOT LIKE '%/./%' AND title NOT LIKE '%log%' AND title NOT LIKE '%tmp%' AND title NOT LIKE '%temp%' AND title NOT LIKE '%cache%' AND _data NOT LIKE '%/.%' AND _data NOT LIKE '%/log/%' AND _data NOT LIKE '%/tmp/%' AND _data NOT LIKE '%/temp/%' AND _data NOT LIKE '%/ads/%' AND _data NOT LIKE '%/cache/%'";
            case 3:
                return String.format(Locale.US, "(_size = 0  OR _size > %s)", new Object[]{Long.valueOf(512000)}) + " AND " + "title NOT LIKE '%/./%' AND title NOT LIKE '%log%' AND title NOT LIKE '%tmp%' AND title NOT LIKE '%temp%' AND title NOT LIKE '%cache%' AND _data NOT LIKE '%/.%' AND _data NOT LIKE '%/log/%' AND _data NOT LIKE '%/tmp/%' AND _data NOT LIKE '%/temp/%' AND _data NOT LIKE '%/ads/%' AND _data NOT LIKE '%/cache/%'";
            default:
                return null;
        }
    }

    public static String m18859d(fcg com_ushareit_listenit_fcg) {
        switch (fcp.f12442a[com_ushareit_listenit_fcg.ordinal()]) {
            case 1:
                return "datetaken DESC";
            case 2:
                return "date_added DESC";
            case 3:
                return "datetaken DESC";
            default:
                return null;
        }
    }

    public static boolean m18856a(fcg com_ushareit_listenit_fcg, long j) {
        switch (fcp.f12442a[com_ushareit_listenit_fcg.ordinal()]) {
            case 1:
                if (j >= 10240) {
                    return false;
                }
                return true;
            case 2:
                if (j >= 512000) {
                    return false;
                }
                return true;
            case 3:
                if (j >= 512000) {
                    return false;
                }
                return true;
            case 4:
                if (j >= 1) {
                    return false;
                }
                return true;
            case 5:
                if (j >= 1) {
                    return false;
                }
                return true;
            case 6:
                return j < 1;
            default:
                return false;
        }
    }
}
