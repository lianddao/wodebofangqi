package com.ushareit.listenit;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import java.util.Date;

public class gbj {
    public static boolean m21593a(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static boolean m21594a(gay com_ushareit_listenit_gay, Location location) {
        if (location != null) {
            float accuracy = location.getAccuracy();
            if (new Date().getTime() - com_ushareit_listenit_gay.m21552m() <= location.getTime() && com_ushareit_listenit_gay.m21551l() >= accuracy) {
                return true;
            }
        }
        return false;
    }
}
