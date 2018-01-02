package com.ushareit.listenit;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

public class eui {
    private static final byte[] f11886a = new byte[]{(byte) 54, (byte) -22, (byte) -74, (byte) -7, (byte) -54, (byte) 122, (byte) -21, (byte) -91, (byte) -48, (byte) -85, (byte) 93, (byte) -67, (byte) 51, (byte) 22, (byte) -87, (byte) 33};
    private static boolean f11887b = false;

    static {
        m18004a();
    }

    public static byte[] m18005a(String str) {
        byte[] a;
        euj com_ushareit_listenit_euj;
        ByteArrayOutputStream byteArrayOutputStream;
        euj com_ushareit_listenit_euj2 = euj.ZIP;
        OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
        gZIPOutputStream.write(str.getBytes("UTF-8"));
        gZIPOutputStream.close();
        byte[] toByteArray = byteArrayOutputStream2.toByteArray();
        if (f11887b) {
            String a2 = fao.m18729a(16);
            exu.m18433a(a2.length() == 16);
            byte[] bytes = a2.getBytes("UTF-8");
            a = fbd.m18771a(toByteArray, bytes);
            if (a != null && a.length % 16 == 0) {
                euj com_ushareit_listenit_euj3 = euj.ENCRYPT_CONTENTS;
                String str2 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBnfRKIUm5FCy+vMxaGPwIpK0y573bFJIzebpcg1mXA5QOEg/xg0wtjZ+Sc+WI2LflEm7H3sf6G9vh30j7Ua94LQr/e8Th44o57dmq38JY8ZYU6Tyxd2zUCS3nqB6XQF9wfqFdST3BK2uMXE7SUcxSJHXbizt1cnt6xXtFGgaJ0wIDAQAB";
                toByteArray = fbg.m18780a(bytes, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBnfRKIUm5FCy+vMxaGPwIpK0y573bFJIzebpcg1mXA5QOEg/xg0wtjZ+Sc+WI2LflEm7H3sf6G9vh30j7Ua94LQr/e8Th44o57dmq38JY8ZYU6Tyxd2zUCS3nqB6XQF9wfqFdST3BK2uMXE7SUcxSJHXbizt1cnt6xXtFGgaJ0wIDAQAB");
                if (toByteArray != null) {
                    com_ushareit_listenit_euj = euj.ENCRYPT_KEY_CONTENTS;
                } else {
                    toByteArray = bytes;
                    com_ushareit_listenit_euj = com_ushareit_listenit_euj3;
                }
                exw.m18443a("Beyla.DecorP", "encrpyt type:" + com_ushareit_listenit_euj);
                byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(com_ushareit_listenit_euj.m18006a());
                if (toByteArray != null) {
                    byteArrayOutputStream.write(fbb.m18759a(toByteArray.length));
                    byteArrayOutputStream.write(toByteArray);
                }
                byteArrayOutputStream.write(a);
                return byteArrayOutputStream.toByteArray();
            }
        }
        a = toByteArray;
        com_ushareit_listenit_euj = com_ushareit_listenit_euj2;
        toByteArray = null;
        exw.m18443a("Beyla.DecorP", "encrpyt type:" + com_ushareit_listenit_euj);
        byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(com_ushareit_listenit_euj.m18006a());
        if (toByteArray != null) {
            byteArrayOutputStream.write(fbb.m18759a(toByteArray.length));
            byteArrayOutputStream.write(toByteArray);
        }
        byteArrayOutputStream.write(a);
        return byteArrayOutputStream.toByteArray();
    }

    private static void m18004a() {
        eug com_ushareit_listenit_eug = new eug(eys.m18562a());
        if (com_ushareit_listenit_eug.m18000e("support_aes")) {
            f11887b = com_ushareit_listenit_eug.m17998c("support_aes");
            exw.m18443a("Beyla.DecorP", "support aes:" + f11887b);
            return;
        }
        try {
            byte[] a = fbd.m18771a("best shareit!".getBytes("UTF-8"), "1234567890abcdef".getBytes("UTF-8"));
            f11887b = a == null ? false : Arrays.equals(a, f11886a);
        } catch (Throwable th) {
        }
        com_ushareit_listenit_eug.m17997b("support_aes", f11887b);
    }
}
