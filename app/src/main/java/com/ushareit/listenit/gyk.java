package com.ushareit.listenit;

import java.io.Closeable;
import java.io.FileInputStream;
import java.security.MessageDigest;

public final class gyk {
    private static final char[] f14920a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String m23154a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(f14920a[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(f14920a[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }

    public static String m23153a(String str) {
        Object e;
        Throwable th;
        String str2 = null;
        byte[] bArr = new byte[2048];
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                str2 = m23154a(instance.digest());
                fbb.m18757a(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    exw.m18456d("Md5sum", "error:" + e);
                    fbb.m18757a(fileInputStream);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    fbb.m18757a(fileInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            Object obj = str2;
            exw.m18456d("Md5sum", "error:" + e);
            fbb.m18757a(fileInputStream);
            return str2;
        } catch (Throwable th3) {
            fileInputStream = str2;
            th = th3;
            fbb.m18757a(fileInputStream);
            throw th;
        }
        return str2;
    }

    public static String m23155b(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                if ((b & 255) < 16) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(Integer.toHexString(b & 255));
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        }
    }
}
