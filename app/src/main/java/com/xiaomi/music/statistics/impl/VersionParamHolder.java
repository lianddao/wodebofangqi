package com.xiaomi.music.statistics.impl;

import android.accounts.Account;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.cloud.AccountUtils;
import java.util.Locale;

public class VersionParamHolder {
    private static String sApkVersion;
    private static String sImei;
    private static String sSDKVersion;
    private static String sSystemVersion;

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static String getSystemVersion() {
        if (TextUtils.isEmpty(sSystemVersion)) {
            return VERSION.RELEASE + "_" + VERSION.INCREMENTAL;
        }
        return sSystemVersion;
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }

    public static String getApkVersion(Context context) {
        if (sApkVersion == null) {
            int version = 0;
            try {
                version = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            sApkVersion = String.valueOf(version);
        }
        return sApkVersion;
    }

    public static String getSDKVersion(Context context) {
        if (sSDKVersion == null) {
            sSDKVersion = MusicEngine.get(context).getVersion();
        }
        return sSDKVersion;
    }

    public static String getAccountName(Context context) {
        Account account = AccountUtils.getAccount(context);
        return account != null ? account.name : null;
    }
}
