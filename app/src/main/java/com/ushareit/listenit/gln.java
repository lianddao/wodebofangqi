package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class gln {
    public static int m22368a(long j) {
        return (int) (((float) (Math.abs(gvj.am(eys.m18562a()) - (j - 180)) / 100000)) / 1.1132f);
    }

    public static long m22370a(long j, long j2) {
        return (long) (((((float) (new Random(System.currentTimeMillis()).nextInt(90) + 10)) / 200.0f) * 1.0E10f) + ((float) (j + j2)));
    }

    public static long m22369a(double d) {
        return (((long) ((180.0d + d) * 100000.0d)) * 100000) + ((long) new Random(System.currentTimeMillis()).nextInt(100000));
    }

    public static boolean m22372a() {
        return gvj.am(eys.m18562a()) > 0;
    }

    public static long m22373b() {
        long am = gvj.am(eys.m18562a());
        long as = gvj.as(eys.m18562a());
        long at = gvj.at(eys.m18562a());
        return Math.abs(as - am) > Math.abs(at - am) ? Math.abs(as - am) : Math.abs(at - am);
    }

    public static boolean m22375c() {
        boolean z;
        long am = gvj.am(eys.m18562a());
        long as = gvj.as(eys.m18562a());
        long at = gvj.at(eys.m18562a());
        String str = "NearbyHelper";
        StringBuilder append = new StringBuilder().append("isFirstSearchPosition: left=").append(as).append("right=").append(at).append(", userLongitude=").append(am).append(", result=");
        if (as < 1 || at < 1 || (as == am - 1 && at == am + 1)) {
            z = true;
        } else {
            z = false;
        }
        exw.m18443a(str, append.append(z).toString());
        if (as == -1001 && at == -999) {
            return true;
        }
        if (as == am - 1 && at == am + 1) {
            return true;
        }
        return false;
    }

    public static void m22374b(long j) {
        exw.m18443a("NearbyHelper", "updateSearchPosition, left=" + (j - 1) + ", right=" + (j + 1));
        gvj.m23012n(eys.m18562a(), j - 1);
        gvj.m23016o(eys.m18562a(), j + 1);
    }

    public static void m22371a(List<fni> list) {
        if (list != null && list.size() >= 2) {
            Collections.sort(list, new glo(gvj.am(eys.m18562a())));
        }
    }
}
