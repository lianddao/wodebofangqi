package com.ushareit.listenit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Pair;
import java.net.HttpURLConnection;
import java.net.URL;

public class eyw {
    public static Pair<Boolean, Boolean> m18568a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
        }
        boolean isConnected;
        boolean isConnected2;
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null) {
            isConnected = networkInfo.isConnected();
        } else {
            isConnected = false;
        }
        if (networkInfo2 != null) {
            isConnected2 = networkInfo2.isConnected();
        } else {
            isConnected2 = false;
        }
        return new Pair(Boolean.valueOf(isConnected), Boolean.valueOf(isConnected2));
    }

    public static boolean m18569a() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://www.bing.com").openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.getContent();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m18570a(String str, int i) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.getResponseCode();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
