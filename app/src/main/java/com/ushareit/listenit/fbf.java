package com.ushareit.listenit;

import android.os.Build.VERSION;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;

public final class fbf {
    private static MessageDigest f12361a;

    private fbf() {
    }

    private static synchronized MessageDigest m18775a() {
        MessageDigest messageDigest;
        synchronized (fbf.class) {
            if (f12361a == null) {
                try {
                    f12361a = MessageDigest.getInstance("MD5");
                } catch (Throwable e) {
                    exw.m18450b("HashUtils", e.getMessage(), e);
                }
            }
            messageDigest = f12361a;
        }
        return messageDigest;
    }

    private static MessageDigest m18777b() {
        MessageDigest a = m18775a();
        if (a != null) {
            try {
                return (MessageDigest) a.clone();
            } catch (Exception e) {
                exw.m18449b("HashUtils", e.toString());
            }
        }
        return a;
    }

    public static String m18774a(eyh com_ushareit_listenit_eyh) {
        return com_ushareit_listenit_eyh != null ? fbb.m18755a(m18778b(com_ushareit_listenit_eyh)) : null;
    }

    public static byte[] m18778b(eyh com_ushareit_listenit_eyh) {
        if (com_ushareit_listenit_eyh == null) {
            return null;
        }
        MessageDigest a;
        if (VERSION.SDK_INT <= 8) {
            a = m18775a();
            if (a != null) {
                byte[] a2;
                synchronized (fbf.class) {
                    a2 = m18776a(a, com_ushareit_listenit_eyh);
                }
                return a2;
            }
        }
        a = m18777b();
        if (a != null) {
            return m18776a(a, com_ushareit_listenit_eyh);
        }
        return null;
    }

    private static byte[] m18776a(MessageDigest messageDigest, eyh com_ushareit_listenit_eyh) {
        byte[] digest;
        Throwable e;
        try {
            long j;
            int i;
            long j2;
            long currentTimeMillis = System.currentTimeMillis();
            long g = com_ushareit_listenit_eyh.mo2332g();
            com_ushareit_listenit_eyh.mo2322a(eyi.Read);
            if (g > 8388608) {
                j = 8388608 / ((long) 8);
                i = 8;
                j2 = (g - 8388608) / ((long) 7);
            } else {
                j2 = 0;
                i = 1;
                j = g;
            }
            g = 0;
            long j3 = 0;
            for (int i2 = 0; i2 < i; i2++) {
                j3 += m18773a(messageDigest, com_ushareit_listenit_eyh, g, j);
                g += j + j2;
            }
            digest = messageDigest.digest();
            try {
                exw.m18443a("HashUtils", j3 + "/" + com_ushareit_listenit_eyh.mo2332g() + " bytes file newHash, cost-time: " + (((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d) + " s.");
                com_ushareit_listenit_eyh.mo2337l();
            } catch (FileNotFoundException e2) {
                e = e2;
                try {
                    exw.m18450b("HashUtils", e.getMessage(), e);
                    return digest;
                } finally {
                    com_ushareit_listenit_eyh.mo2337l();
                }
            } catch (IOException e3) {
                e = e3;
                exw.m18450b("HashUtils", e.getMessage(), e);
                com_ushareit_listenit_eyh.mo2337l();
                return digest;
            }
        } catch (Throwable e4) {
            e = e4;
            digest = null;
            exw.m18450b("HashUtils", e.getMessage(), e);
            return digest;
        } catch (Throwable e42) {
            e = e42;
            digest = null;
            exw.m18450b("HashUtils", e.getMessage(), e);
            com_ushareit_listenit_eyh.mo2337l();
            return digest;
        }
        return digest;
    }

    private static long m18773a(MessageDigest messageDigest, eyh com_ushareit_listenit_eyh, long j, long j2) {
        long j3 = 0;
        com_ushareit_listenit_eyh.mo2323a(eyi.Read, j);
        byte[] bArr = new byte[8192];
        int min = (int) Math.min(8192, j2 - 0);
        while (min > 0) {
            min = com_ushareit_listenit_eyh.mo2321a(bArr, 0, min);
            if (min == -1) {
                break;
            }
            messageDigest.update(bArr, 0, min);
            j3 += (long) min;
            j += (long) min;
            min = (int) Math.min(8192, j2 - j3);
        }
        return j3;
    }
}
