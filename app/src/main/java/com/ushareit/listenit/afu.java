package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class afu {
    private static final char[] f4283a = "0123456789abcdef".toCharArray();
    private static final char[] f4284b = new char[64];
    private static final char[] f4285c = new char[40];

    public static String m5493a(byte[] bArr) {
        String a;
        synchronized (f4284b) {
            a = m5494a(bArr, f4284b);
        }
        return a;
    }

    private static String m5494a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f4283a[i2 >>> 4];
            cArr[(i * 2) + 1] = f4283a[i2 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(19)
    public static int m5492a(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static int m5490a(int i, int i2, Config config) {
        return (i * i2) * m5491a(config);
    }

    private static int m5491a(Config config) {
        if (config == null) {
            config = Config.ARGB_8888;
        }
        switch (afv.f4286a[config.ordinal()]) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            default:
                return 4;
        }
    }

    public static boolean m5498a(int i, int i2) {
        return m5500b(i) && m5500b(i2);
    }

    private static boolean m5500b(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static void m5497a() {
        if (!m5499b()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean m5499b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean m5501c() {
        return !m5499b();
    }

    public static <T> Queue<T> m5496a(int i) {
        return new ArrayDeque(i);
    }

    public static <T> List<T> m5495a(Collection<T> collection) {
        List<T> arrayList = new ArrayList(collection.size());
        for (T add : collection) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
