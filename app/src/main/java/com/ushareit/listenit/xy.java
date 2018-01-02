package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.Log;

public class xy {
    private final int f17547a;
    private final int f17548b;
    private final Context f17549c;

    public xy(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new xz(context.getResources().getDisplayMetrics()));
    }

    xy(Context context, ActivityManager activityManager, ya yaVar) {
        this.f17549c = context;
        int a = m27227a(activityManager);
        int a2 = (yaVar.mo3146a() * yaVar.mo3147b()) * 4;
        int i = a2 * 4;
        a2 *= 2;
        if (a2 + i <= a) {
            this.f17548b = a2;
            this.f17547a = i;
        } else {
            int round = Math.round(((float) a) / 6.0f);
            this.f17548b = round * 2;
            this.f17547a = round * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculated memory cache size: " + m27228a(this.f17548b) + " pool size: " + m27228a(this.f17547a) + " memory class limited? " + (a2 + i > a) + " max size: " + m27228a(a) + " memoryClass: " + activityManager.getMemoryClass() + " isLowMemoryDevice: " + m27229b(activityManager));
        }
    }

    public int m27230a() {
        return this.f17548b;
    }

    public int m27231b() {
        return this.f17547a;
    }

    private static int m27227a(ActivityManager activityManager) {
        return Math.round((m27229b(activityManager) ? 0.33f : 0.4f) * ((float) ((activityManager.getMemoryClass() * 1024) * 1024)));
    }

    private String m27228a(int i) {
        return Formatter.formatFileSize(this.f17549c, (long) i);
    }

    @TargetApi(19)
    private static boolean m27229b(ActivityManager activityManager) {
        if (VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return VERSION.SDK_INT < 11;
    }
}
