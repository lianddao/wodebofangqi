package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.UUID;

public class fah {
    private static String f12303a = null;
    private static String f12304b = null;
    private static String f12305c = null;
    private static String f12306d = null;
    private static String f12307e = null;
    private static String f12308f = "mmc_host";
    private static String f12309g = "/mmc0/mmc0:0001/cid";
    private static String f12310h = null;

    public static String m18702a(Context context) {
        exz com_ushareit_listenit_exz = new exz(context);
        String b = com_ushareit_listenit_exz.m17993b("DEVICE_ID");
        if (!TextUtils.isEmpty(b) && !m18705b(b) && !m18708c(b)) {
            return b;
        }
        String b2;
        faj com_ushareit_listenit_faj = faj.MAC;
        try {
            b2 = m18704b(context);
            if (TextUtils.isEmpty(b2)) {
                com_ushareit_listenit_faj = faj.ANDROID;
                b2 = m18707c(context);
                if (m18708c(b2)) {
                    b2 = null;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                com_ushareit_listenit_faj = faj.UUID;
                b2 = m18706c();
            }
        } catch (Exception e) {
            exw.m18456d("Helper", "can't get real device id, generate one by random instead");
            com_ushareit_listenit_faj = faj.UUID;
            b2 = m18706c();
        }
        b = com_ushareit_listenit_faj.m18714a() + "." + b2;
        com_ushareit_listenit_exz.m17991a("DEVICE_ID", b);
        return b;
    }

    public static String m18704b(Context context) {
        if (!TextUtils.isEmpty(f12303a)) {
            return f12303a;
        }
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        String macAddress = connectionInfo.getMacAddress();
        if (!TextUtils.isEmpty(macAddress)) {
            macAddress = macAddress.replace(":", "");
        }
        if (!TextUtils.isEmpty(macAddress) && m18705b(faj.MAC.m18714a() + "." + macAddress)) {
            macAddress = m18709d();
            if (!TextUtils.isEmpty(macAddress)) {
                macAddress = macAddress.replace(":", "");
            }
        }
        f12303a = macAddress;
        return f12303a;
    }

    public static String m18707c(Context context) {
        if (!TextUtils.isEmpty(f12304b)) {
            return f12304b;
        }
        String string = Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string.trim())) {
            return null;
        }
        f12304b = string;
        return f12304b;
    }

    public static String m18710d(Context context) {
        if (!TextUtils.isEmpty(f12305c)) {
            return f12305c;
        }
        fam a = fal.m18717a(context);
        if (a == null || !a.m18723a()) {
            return null;
        }
        f12305c = a.m18724b();
        return f12305c;
    }

    public static String m18701a() {
        Closeable fileInputStream;
        Throwable th;
        if (!TextUtils.isEmpty(f12306d)) {
            return f12306d;
        }
        File e = m18711e();
        if (e == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(e);
            try {
                byte[] bArr = new byte[128];
                String str = new String(bArr, 0, fileInputStream.read(bArr, 0, 128));
                if (str.length() < 32 || str.contains("00000000000000000000")) {
                    fbb.m18757a(fileInputStream);
                    return null;
                }
                char[] toCharArray = fbp.m18801b(str.trim()).toCharArray();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(toCharArray, 0, 6);
                stringBuilder.append(toCharArray, 16, 10);
                f12306d = stringBuilder.toString();
                String str2 = f12306d;
                fbb.m18757a(fileInputStream);
                return str2;
            } catch (Exception e2) {
                fbb.m18757a(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fbb.m18757a(fileInputStream);
                throw th;
            }
        } catch (Exception e3) {
            fileInputStream = null;
            fbb.m18757a(fileInputStream);
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = null;
            th = th4;
            fbb.m18757a(fileInputStream);
            throw th;
        }
    }

    public static String m18703b() {
        if (!TextUtils.isEmpty(f12307e)) {
            return f12307e;
        }
        Class cls = Build.class;
        try {
            f12307e = (String) cls.getDeclaredField("SERIAL").get(cls);
            return f12307e;
        } catch (Exception e) {
            return null;
        }
    }

    public static String m18706c() {
        return new UUID((long) (Math.random() * 9.223372036854776E18d), (long) Build.FINGERPRINT.hashCode()).toString();
    }

    public static faj m18699a(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf(".") != 1) {
            return faj.UNKNOWN;
        }
        return faj.m18713a(str.charAt(0));
    }

    public static boolean m18705b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (faj.MAC.m18714a() + "." + "020000000000").equals(str);
    }

    public static boolean m18708c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (faj.ANDROID.m18714a() + "." + "9774d56d682e549c").equalsIgnoreCase(str);
    }

    @TargetApi(9)
    private static String m18709d() {
        if (VERSION.SDK_INT < 9) {
            return "";
        }
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "";
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                Object name = networkInterface.getName();
                if (!TextUtils.isEmpty(name) && fbp.m18797a(name).contains("wlan")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    StringBuilder stringBuilder = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    return stringBuilder.toString();
                }
            }
            return "";
        } catch (Throwable th) {
        }
    }

    private static File m18700a(File file) {
        if (file.getName().equals(f12308f)) {
            File file2 = new File(file.getAbsolutePath() + f12309g);
            if (file2.exists() && file2.canRead()) {
                return file2;
            }
        }
        return null;
    }

    private static File m18711e() {
        File[] listFiles = new File("/sys/devices").listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file : listFiles) {
            if (!file.isFile()) {
                File a = m18700a(file);
                if (a != null) {
                    return a;
                }
                File[] listFiles2 = file.listFiles();
                if (listFiles2 != null) {
                    for (File file2 : listFiles2) {
                        if (!file2.isFile()) {
                            a = m18700a(file2);
                            if (a != null) {
                                return a;
                            }
                            File[] listFiles3 = file2.listFiles();
                            if (listFiles3 != null) {
                                for (File a2 : listFiles3) {
                                    a2 = m18700a(a2);
                                    if (a2 != null) {
                                        return a2;
                                    }
                                }
                                continue;
                            } else {
                                continue;
                            }
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public static String m18712e(Context context) {
        if (!TextUtils.isEmpty(f12310h)) {
            return f12310h;
        }
        try {
            f12310h = ezy.m18664a(context);
            exw.m18443a("GAID", "the google adversting id: " + f12310h);
        } catch (Throwable th) {
        }
        return f12310h;
    }
}
