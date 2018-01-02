package com.ushareit.listenit;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Environment;
import android.os.StatFs;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class asm {
    private static SensorManager f5324a = null;
    private static Sensor f5325b = null;
    private static Sensor f5326c = null;
    private static volatile float[] f5327d;
    private static volatile float[] f5328e;
    private static Map<String, String> f5329f = new ConcurrentHashMap();
    private static String[] f5330g = new String[]{"x", "y", "z"};

    public static Map<String, String> m6975a() {
        Map hashMap = new HashMap();
        hashMap.putAll(f5329f);
        m6978a(hashMap);
        return hashMap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m6976a(android.content.Context r5) {
        /*
        r1 = com.ushareit.listenit.asm.class;
        monitor-enter(r1);
        m6981b(r5);	 Catch:{ all -> 0x005f }
        m6984c(r5);	 Catch:{ all -> 0x005f }
        m6985d(r5);	 Catch:{ all -> 0x005f }
        r0 = f5324a;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x0020;
    L_0x0010:
        r0 = "sensor";
        r0 = r5.getSystemService(r0);	 Catch:{ all -> 0x005f }
        r0 = (android.hardware.SensorManager) r0;	 Catch:{ all -> 0x005f }
        f5324a = r0;	 Catch:{ all -> 0x005f }
        r0 = f5324a;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x0020;
    L_0x001e:
        monitor-exit(r1);
        return;
    L_0x0020:
        r0 = f5325b;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x002d;
    L_0x0024:
        r0 = f5324a;	 Catch:{ all -> 0x005f }
        r2 = 1;
        r0 = r0.getDefaultSensor(r2);	 Catch:{ all -> 0x005f }
        f5325b = r0;	 Catch:{ all -> 0x005f }
    L_0x002d:
        r0 = f5326c;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x003a;
    L_0x0031:
        r0 = f5324a;	 Catch:{ all -> 0x005f }
        r2 = 4;
        r0 = r0.getDefaultSensor(r2);	 Catch:{ all -> 0x005f }
        f5326c = r0;	 Catch:{ all -> 0x005f }
    L_0x003a:
        r0 = f5325b;	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x004c;
    L_0x003e:
        r0 = f5324a;	 Catch:{ all -> 0x005f }
        r2 = new com.ushareit.listenit.aso;	 Catch:{ all -> 0x005f }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x005f }
        r3 = f5325b;	 Catch:{ all -> 0x005f }
        r4 = 3;
        r0.registerListener(r2, r3, r4);	 Catch:{ all -> 0x005f }
    L_0x004c:
        r0 = f5326c;	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x001e;
    L_0x0050:
        r0 = f5324a;	 Catch:{ all -> 0x005f }
        r2 = new com.ushareit.listenit.aso;	 Catch:{ all -> 0x005f }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x005f }
        r3 = f5326c;	 Catch:{ all -> 0x005f }
        r4 = 3;
        r0.registerListener(r2, r3, r4);	 Catch:{ all -> 0x005f }
        goto L_0x001e;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.asm.a(android.content.Context):void");
    }

    public static synchronized void m6977a(aso com_ushareit_listenit_aso) {
        synchronized (asm.class) {
            if (f5324a != null) {
                f5324a.unregisterListener(com_ushareit_listenit_aso);
            }
        }
    }

    private static void m6978a(Map<String, String> map) {
        int i;
        int i2 = 0;
        float[] fArr = f5327d;
        float[] fArr2 = f5328e;
        if (fArr != null) {
            int min = Math.min(f5330g.length, fArr.length);
            for (i = 0; i < min; i++) {
                map.put("accelerometer_" + f5330g[i], String.valueOf(fArr[i]));
            }
        }
        if (fArr2 != null) {
            i = Math.min(f5330g.length, fArr2.length);
            while (i2 < i) {
                map.put("rotation_" + f5330g[i2], String.valueOf(fArr2[i2]));
                i2++;
            }
        }
    }

    private static void m6981b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        f5329f.put("available_memory", String.valueOf(memoryInfo.availMem));
    }

    private static void m6984c(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocks = (long) statFs.getAvailableBlocks();
        f5329f.put("free_space", String.valueOf(availableBlocks * ((long) statFs.getBlockSize())));
    }

    private static void m6985d(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            int intExtra3 = registerReceiver.getIntExtra("status", -1);
            Object obj = (intExtra3 == 2 || intExtra3 == 5) ? 1 : null;
            float f = 0.0f;
            if (intExtra2 > 0) {
                f = (((float) intExtra) / ((float) intExtra2)) * 100.0f;
            }
            f5329f.put("battery", String.valueOf(f));
            f5329f.put("charging", obj != null ? "1" : "0");
        }
    }
}
