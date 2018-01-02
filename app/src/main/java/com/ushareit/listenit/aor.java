package com.ushareit.listenit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.mopub.common.GpsHelper;

public class aor {
    public static final String f5086a = VERSION.RELEASE;
    public static String f5087b = "";
    public static String f5088c = "";
    public static String f5089d = "";
    public static String f5090e = "";
    public static String f5091f = "";
    public static int f5092g = 0;
    public static String f5093h = "";
    public static String f5094i = "";
    public static int f5095j = 0;
    public static String f5096k = "";
    public static int f5097l = 0;
    public static String f5098m = "";
    public static String f5099n = "";
    public static String f5100o = "";
    public static boolean f5101p = false;
    public static String f5102q = "";
    private static boolean f5103r = false;

    public static synchronized void m6486a(Context context) {
        synchronized (aor.class) {
            if (!f5103r) {
                f5103r = true;
                m6488c(context);
            }
            m6489d(context);
        }
    }

    public static void m6487b(Context context) {
        if (f5103r) {
            try {
                aua a;
                aob a2;
                SharedPreferences sharedPreferences = context.getSharedPreferences("SDKIDFA", 0);
                if (sharedPreferences.contains("attributionId")) {
                    f5099n = sharedPreferences.getString("attributionId", "");
                }
                if (sharedPreferences.contains(GpsHelper.ADVERTISING_ID_KEY)) {
                    f5100o = sharedPreferences.getString(GpsHelper.ADVERTISING_ID_KEY, "");
                    f5101p = sharedPreferences.getBoolean("limitAdTracking", f5101p);
                    f5102q = aof.SHARED_PREFS.name();
                }
                try {
                    a = atz.m7156a(context.getContentResolver());
                } catch (Throwable e) {
                    att.m7141a(atq.m7138a(e, "Error retrieving attribution id from fb4a"));
                    a = null;
                }
                if (a != null) {
                    String str = a.f5474a;
                    if (str != null) {
                        f5099n = str;
                    }
                }
                try {
                    a2 = aob.m6442a(context, a);
                } catch (Throwable e2) {
                    att.m7141a(atq.m7138a(e2, "Error retrieving advertising id from Google Play Services"));
                    a2 = null;
                }
                if (a2 != null) {
                    String a3 = a2.m6445a();
                    Boolean valueOf = Boolean.valueOf(a2.m6446b());
                    if (a3 != null) {
                        f5100o = a3;
                        f5101p = valueOf.booleanValue();
                        f5102q = a2.m6447c().name();
                    }
                }
                Editor edit = sharedPreferences.edit();
                edit.putString("attributionId", f5099n);
                edit.putString(GpsHelper.ADVERTISING_ID_KEY, f5100o);
                edit.putBoolean("limitAdTracking", f5101p);
                edit.apply();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private static void m6488c(Context context) {
        String networkOperatorName;
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            f5089d = packageInfo.packageName;
            f5091f = packageInfo.versionName;
            f5092g = packageInfo.versionCode;
        } catch (NameNotFoundException e) {
        }
        try {
            if (f5089d != null && f5089d.length() >= 0) {
                String installerPackageName = packageManager.getInstallerPackageName(f5089d);
                if (installerPackageName != null && installerPackageName.length() > 0) {
                    f5093h = installerPackageName;
                }
            }
        } catch (Exception e2) {
        }
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            if (applicationLabel != null && applicationLabel.length() > 0) {
                f5090e = applicationLabel.toString();
            }
        } catch (NameNotFoundException e3) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName != null && networkOperatorName.length() > 0) {
                f5094i = networkOperatorName;
            }
        }
        networkOperatorName = Build.MANUFACTURER;
        if (networkOperatorName != null && networkOperatorName.length() > 0) {
            f5087b = networkOperatorName;
        }
        networkOperatorName = Build.MODEL;
        if (networkOperatorName != null && networkOperatorName.length() > 0) {
            f5088c = Build.MODEL;
        }
    }

    private static void m6489d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                f5095j = activeNetworkInfo.getType();
                f5096k = activeNetworkInfo.getTypeName();
                f5097l = activeNetworkInfo.getSubtype();
                f5098m = activeNetworkInfo.getSubtypeName();
            }
        } catch (Exception e) {
        }
    }
}
