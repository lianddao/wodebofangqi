package com.ushareit.listenit;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;

public class cjb {
    private static final cjb f8145a = new cjb();
    public static final int f8146b = cjj.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    cjb() {
    }

    public static cjb m10875b() {
        return f8145a;
    }

    private String m10876b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(f8146b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(dqc.m15265b(context).m15264b(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int mo1287a(Context context) {
        int isGooglePlayServicesAvailable = cjj.isGooglePlayServicesAvailable(context);
        return cjj.zzd(context, isGooglePlayServicesAvailable) ? 18 : isGooglePlayServicesAvailable;
    }

    public PendingIntent mo1288a(Context context, int i, int i2) {
        return mo1289a(context, i, i2, null);
    }

    public PendingIntent mo1289a(Context context, int i, int i2, String str) {
        if (cir.m11399a(context) && i == 2) {
            i = 42;
        }
        Intent a = mo1290a(context, i, str);
        return a == null ? null : PendingIntent.getActivity(context, i2, a, 268435456);
    }

    public Intent mo1290a(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return chk.m11249a("com.google.android.gms", m10876b(context, str));
            case 3:
                return chk.m11248a("com.google.android.gms");
            case 42:
                return chk.m11247a();
            default:
                return null;
        }
    }

    public boolean mo1291a(int i) {
        return cjj.isUserRecoverableError(i);
    }

    public boolean mo1292a(Context context, int i) {
        return cjj.zzd(context, i);
    }

    public boolean m10883a(Context context, String str) {
        return cjj.zzs(context, str);
    }

    public int mo1293b(Context context) {
        return cjj.zzbo(context);
    }

    @Deprecated
    public Intent mo1294b(int i) {
        return mo1290a(null, i, null);
    }

    public void m10886c(Context context) {
        cjj.zzbq(context);
    }
}
