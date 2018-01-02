package com.xiaomi.music.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicHttpResponse;

public class SecurityGruadian {
    private static final Uri DOWNLOAD_URI = Uri.parse("content://downloads/my_downloads");
    static final String TAG = "SecurityGruadian";

    public static boolean isActiveNetworkMetered(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).isActiveNetworkMetered();
        } catch (SecurityException e) {
            MusicLog.m397e(TAG, e.toString());
            return false;
        }
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo info = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (info != null) {
                return info.getType();
            }
        } catch (SecurityException e) {
            MusicLog.m397e(TAG, e.toString());
        }
        return -1;
    }

    public static Account getAccountByType(Context context, String type) {
        try {
            Account[] accounts = AccountManager.get(context).getAccountsByType(type);
            if (accounts.length > 0) {
                return accounts[0];
            }
            return null;
        } catch (SecurityException e) {
            MusicLog.m397e(TAG, e.toString());
            return null;
        }
    }

    public static Cursor queryDownloadByAppointName(Context context, String appointName) {
        try {
            String where = "appointname=?";
            return context.getContentResolver().query(DOWNLOAD_URI, new String[]{"_id"}, "appointname=?", new String[]{appointName}, null);
        } catch (SecurityException e) {
            MusicLog.m397e(TAG, e.toString());
            return null;
        }
    }

    public static HttpResponse executeRequest(HttpClient client, HttpUriRequest request) throws ClientProtocolException, IOException {
        try {
            return client.execute(request);
        } catch (SecurityException e) {
            MusicLog.m397e(TAG, e.toString());
            return new BasicHttpResponse(new HttpVersion(1, 1), 403, "no permission of INTERNET");
        }
    }
}
