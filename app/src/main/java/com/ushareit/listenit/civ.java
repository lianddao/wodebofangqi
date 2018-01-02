package com.ushareit.listenit;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class civ {
    private static String f8359a = null;

    public static String m11416a() {
        return m11417a(Binder.getCallingPid());
    }

    private static String m11417a(int i) {
        Throwable e;
        Throwable th;
        String str = null;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                str = bufferedReader.readLine().trim();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e2) {
                        Log.w("ProcessUtils", e2.getMessage(), e2);
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    Log.e("ProcessUtils", e2.getMessage(), e2);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e22) {
                            Log.w("ProcessUtils", e22.getMessage(), e22);
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e222) {
                            Log.w("ProcessUtils", e222.getMessage(), e222);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e222 = e4;
            bufferedReader = str;
            Log.e("ProcessUtils", e222.getMessage(), e222);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str;
        } catch (Throwable e2222) {
            bufferedReader = str;
            th = e2222;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return str;
    }

    public static String m11418b() {
        if (f8359a == null) {
            f8359a = m11417a(Process.myPid());
        }
        return f8359a;
    }
}
