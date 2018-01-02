package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class cjk {
    private static cjk f8369a;
    private final Context f8370b;

    private cjk(Context context) {
        this.f8370b = context.getApplicationContext();
    }

    public static cjk m11438a(Context context) {
        cfi.m11080a((Object) context);
        synchronized (cjk.class) {
            if (f8369a == null) {
                cjc.m11428a(context);
                f8369a = new cjk(context);
            }
        }
        return f8369a;
    }

    cjd m11439a(PackageInfo packageInfo, cjd... com_ushareit_listenit_cjdArr) {
        int i = 0;
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        cje com_ushareit_listenit_cje = new cje(packageInfo.signatures[0].toByteArray());
        while (i < com_ushareit_listenit_cjdArr.length) {
            if (com_ushareit_listenit_cjdArr[i].equals(com_ushareit_listenit_cje)) {
                return com_ushareit_listenit_cjdArr[i];
            }
            i++;
        }
        return null;
    }

    public boolean m11440a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            cjd a;
            if (z) {
                a = m11439a(packageInfo, cjg.f8368a);
            } else {
                a = m11439a(packageInfo, cjg.f8368a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean m11441a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m11440a(packageInfo, false)) {
            return true;
        }
        if (!m11440a(packageInfo, true)) {
            return false;
        }
        if (cjj.zzbv(this.f8370b)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }
}
