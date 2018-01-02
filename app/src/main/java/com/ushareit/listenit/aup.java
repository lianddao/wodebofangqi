package com.ushareit.listenit;

import android.content.Context;
import com.umeng.analytics.pro.C0277j;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class aup {
    public static final String m7214a(Context context, String str) {
        try {
            return m7218b(context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e) {
            return null;
        }
    }

    public static final String m7215a(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            InputStream fileInputStream = new FileInputStream(file);
            int read;
            do {
                read = fileInputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                }
            } while (read != -1);
            fileInputStream.close();
            return m7217a(instance.digest());
        } catch (Exception e) {
            return null;
        }
    }

    public static String m7216a(String str) {
        try {
            return m7217a(MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            return null;
        }
    }

    private static final String m7217a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            stringBuilder.append(Integer.toString((b & 255) + C0277j.f3694e, 16).substring(1));
        }
        return stringBuilder.toString();
    }

    public static final String m7218b(String str) {
        return m7215a(new File(str));
    }
}
