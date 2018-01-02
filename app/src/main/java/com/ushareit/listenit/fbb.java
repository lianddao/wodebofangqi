package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.umeng.analytics.pro.C0277j;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.UUID;

public final class fbb {
    private static String[] f12353a = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", fno.KEY_VERSION, "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String m18754a(String str, int i, char c) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str == null ? 0 : str.length();
        while (length < i) {
            stringBuilder.append(c);
            length++;
        }
        if (str != null) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static String m18750a(byte b) {
        if (b < (byte) 0) {
            b += C0277j.f3694e;
        }
        return m18754a(Integer.toHexString(b), 2, '0');
    }

    public static String m18755a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (byte a : bArr) {
            stringBuilder.append(m18750a(a));
        }
        return stringBuilder.toString();
    }

    public static boolean m18758a(String str) {
        return str == null || "".equals(str) || "".equals(str.trim());
    }

    public static boolean m18761b(String str) {
        return !m18758a(str);
    }

    public static boolean m18763c(String str) {
        return str == null || "".equals(str);
    }

    public static boolean m18765d(String str) {
        return !m18763c(str);
    }

    public static String m18753a(InputStream inputStream, boolean z) {
        BufferedReader bufferedReader = new BufferedReader(z ? new InputStreamReader(inputStream, Charset.forName("UTF-8")) : new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuffer.append(readLine);
            } else {
                bufferedReader.close();
                return stringBuffer.toString().trim();
            }
        }
    }

    public static String m18751a(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso() + "";
        } catch (Exception e) {
            return "";
        }
    }

    public static byte[] m18759a(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) i;
            i >>= 8;
        }
        return bArr;
    }

    public static void m18756a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
            }
        }
    }

    public static void m18757a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static fbc m18760b(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
            if (Math.sqrt(Math.pow((double) (((float) displayMetrics.heightPixels) / (((float) displayMetrics.densityDpi) > displayMetrics.ydpi ? (float) displayMetrics.densityDpi : displayMetrics.ydpi)), 2.0d) + Math.pow((double) (((float) displayMetrics.widthPixels) / (((float) displayMetrics.densityDpi) > displayMetrics.xdpi ? (float) displayMetrics.densityDpi : displayMetrics.xdpi)), 2.0d)) >= 6.5d) {
                return fbc.DEVICE_PAD;
            }
            return fbc.DEVICE_PHONE;
        } catch (Exception e) {
            return fbc.DEVICE_PHONE;
        }
    }

    public static int m18762c(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int m18764d(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int m18766e(Context context) {
        Resources resources = context.getResources();
        int i = 0;
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i = resources.getDimensionPixelSize(identifier);
        }
        return i == 0 ? 30 : i;
    }

    public static float m18767f(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static String m18752a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string != null) {
            return string;
        }
        int i = bundle.getInt(str);
        if (i != 0) {
            return String.valueOf(i);
        }
        return null;
    }

    public static int m18768g(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            return i;
        }
    }

    public static boolean m18769h(Context context) {
        try {
            if (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode == 1) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean m18770i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() == 5;
    }

    public static String m18749a() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
