package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;

public final class fap {
    private static long f12327a = -1;
    private static Pair<Integer, Integer> f12328b = null;

    public static long m18730a() {
        if (f12327a == -1) {
            f12327a = m18732b();
        }
        return f12327a;
    }

    private static long m18732b() {
        Closeable fileReader;
        Closeable bufferedReader;
        Throwable th;
        Closeable closeable = null;
        long j = 0;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    Object readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        j = Long.valueOf(readLine.split("\\s+")[1]).longValue() / 1024;
                    }
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(fileReader);
                } catch (Exception e) {
                    closeable = fileReader;
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(closeable);
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(fileReader);
                    throw th;
                }
            } catch (Exception e2) {
                bufferedReader = null;
                closeable = fileReader;
                fbb.m18757a(bufferedReader);
                fbb.m18757a(closeable);
                return j;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                fbb.m18757a(bufferedReader);
                fbb.m18757a(fileReader);
                throw th;
            }
        } catch (Exception e3) {
            bufferedReader = null;
            fbb.m18757a(bufferedReader);
            fbb.m18757a(closeable);
            return j;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
            fbb.m18757a(bufferedReader);
            fbb.m18757a(fileReader);
            throw th;
        }
        return j;
    }

    public static Pair<Integer, Integer> m18731a(Context context) {
        if (f12328b == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (!(windowManager == null || windowManager.getDefaultDisplay() == null)) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                f12328b = new Pair(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
            }
        }
        return f12328b;
    }
}
