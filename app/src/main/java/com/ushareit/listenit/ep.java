package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

public abstract class ep extends BroadcastReceiver {
    private static final SparseArray<WakeLock> f1881a = new SparseArray();
    private static int f1882b = 1;

    public static ComponentName a_(Context context, Intent intent) {
        synchronized (f1881a) {
            int i = f1882b;
            f1882b++;
            if (f1882b <= 0) {
                f1882b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            f1881a.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean m2433a(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (f1881a) {
            WakeLock wakeLock = (WakeLock) f1881a.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                f1881a.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + intExtra);
            return true;
        }
    }
}
