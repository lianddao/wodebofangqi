package com.ushareit.listenit;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.util.Log;
import java.io.File;

public class auk {
    private static final String f5506a = auk.class.getSimpleName();

    public static aul m7203a() {
        try {
            Object obj = (m7208c() || m7206b() || m7205a("su")) ? 1 : null;
            return obj != null ? aul.ROOTED : aul.UNROOTED;
        } catch (Throwable th) {
            return aul.UNKNOWN;
        }
    }

    public static boolean m7204a(Context context) {
        return m7207b(context) && atp.m7135c(context);
    }

    private static boolean m7205a(String str) {
        for (String file : System.getenv("PATH").split(":")) {
            File file2 = new File(file);
            if (file2.exists() && file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    for (File name : listFiles) {
                        if (name.getName().equals(str)) {
                            return true;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    private static boolean m7206b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean m7207b(Context context) {
        if (context == null) {
            Log.v(f5506a, "Invalid context in screen interactive check, assuming interactive.");
            return true;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Exception e) {
            Log.e(f5506a, "Exception in screen interactive check, assuming interactive.", e);
            auj.m7198a(e, context);
            return true;
        }
    }

    private static boolean m7208c() {
        return new File("/system/app/Superuser.apk").exists();
    }
}
