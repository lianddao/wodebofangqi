package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Pair;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ewc extends evd {
    public ewc(Context context, evl com_ushareit_listenit_evl) {
        super(context, com_ushareit_listenit_evl);
    }

    public evf mo2300c(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        m18143a(com_ushareit_listenit_eva, evf.RUNNING);
        ewd com_ushareit_listenit_ewd = new ewd(com_ushareit_listenit_eva);
        if (m18147a(i, (eva) com_ushareit_listenit_ewd, com_ushareit_listenit_eva.m18123h())) {
            if (!com_ushareit_listenit_ewd.m18283t()) {
                m18150b(com_ushareit_listenit_eva, "executed", null);
                m18146a((eva) com_ushareit_listenit_ewd, "is_exected", "true");
            }
            boolean z = false;
            switch (com_ushareit_listenit_ewd.m18280q()) {
                case 1:
                    z = m18269a(com_ushareit_listenit_ewd);
                    break;
                case 2:
                    z = m18271b(com_ushareit_listenit_ewd);
                    break;
                case 3:
                    z = m18273c(com_ushareit_listenit_ewd);
                    break;
                default:
                    m18268a(com_ushareit_listenit_ewd, "do not support the collect type: " + com_ushareit_listenit_ewd.m18280q() + ", Properties: " + com_ushareit_listenit_ewd.m18122g(), true);
                    break;
            }
            if (z) {
                m18143a(com_ushareit_listenit_eva, evf.COMPLETED);
                m18150b(com_ushareit_listenit_eva, "completed", null);
            }
            return com_ushareit_listenit_eva.m18125j();
        }
        m18143a(com_ushareit_listenit_eva, evf.WAITING);
        return com_ushareit_listenit_eva.m18125j();
    }

    private void m18267a(ewd com_ushareit_listenit_ewd, int i) {
        com_ushareit_listenit_ewd.m18279c(i);
        m18146a((eva) com_ushareit_listenit_ewd, "collected_basic_mask", com_ushareit_listenit_ewd.m18282s() + "");
    }

    private boolean m18269a(ewd com_ushareit_listenit_ewd) {
        int r = com_ushareit_listenit_ewd.m18281r();
        if ((r & 1) != 0) {
            m18262a(this.a, com_ushareit_listenit_ewd);
            m18267a(com_ushareit_listenit_ewd, 1);
        }
        if ((r & 2) != 0) {
            m18270b(this.a, com_ushareit_listenit_ewd);
            m18267a(com_ushareit_listenit_ewd, 2);
        }
        if ((r & 4) != 0) {
            m18272c(this.a, com_ushareit_listenit_ewd);
            m18267a(com_ushareit_listenit_ewd, 4);
        }
        if ((r & 8) != 0) {
            m18274d(this.a, com_ushareit_listenit_ewd);
            m18267a(com_ushareit_listenit_ewd, 8);
        }
        if ((r & 16) != 0) {
            m18276f(this.a, com_ushareit_listenit_ewd);
            m18267a(com_ushareit_listenit_ewd, 16);
        }
        if ((r & 32) != 0) {
            m18275e(this.a, com_ushareit_listenit_ewd);
            m18267a(com_ushareit_listenit_ewd, 32);
        }
        if ((r & 64) != 0) {
            m18277g(this.a, com_ushareit_listenit_ewd);
            m18267a(com_ushareit_listenit_ewd, 64);
        }
        if (com_ushareit_listenit_ewd.m18282s() != 0) {
            return true;
        }
        m18268a(com_ushareit_listenit_ewd, "", true);
        return false;
    }

    private boolean m18271b(ewd com_ushareit_listenit_ewd) {
        String b = com_ushareit_listenit_ewd.m18108b("pkg_name", "");
        if (fbb.m18758a(b)) {
            m18268a(com_ushareit_listenit_ewd, "Package name is empty", true);
            return false;
        }
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("name", b);
            try {
                PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(b, 0);
                linkedHashMap.put("md5", fbf.m18774a(eyh.m18491a(packageInfo.applicationInfo.sourceDir)));
                if ((packageInfo.applicationInfo.flags & 1) != 0) {
                    linkedHashMap.put("installed", "SYS_INSTALLED");
                } else {
                    linkedHashMap.put("installed", "INSTALLED");
                }
                linkedHashMap.put("version", packageInfo.versionName);
            } catch (NameNotFoundException e) {
                linkedHashMap.put("md5", null);
                linkedHashMap.put("installed", "NOT_INSTALLED");
                linkedHashMap.put("version", null);
            }
            linkedHashMap.put("cmd_id", com_ushareit_listenit_ewd.m18099a());
            exw.m18443a("CMD.AnalyticsCmdHandler", "collectAppInfo() event = ENV_AppInfo, value = " + linkedHashMap.toString());
            esr.m17812a(this.a, "ENV_AppInfo", linkedHashMap, ete.class);
            return true;
        } catch (Exception e2) {
            m18268a(com_ushareit_listenit_ewd, e2.toString(), false);
            return false;
        }
    }

    private boolean m18273c(ewd com_ushareit_listenit_ewd) {
        Pair a = eyw.m18568a(this.a);
        if (!((Boolean) a.first).booleanValue() && !((Boolean) a.second).booleanValue()) {
            return false;
        }
        String b = com_ushareit_listenit_ewd.m18108b("ping_url", "");
        if (fbb.m18758a(b)) {
            m18268a(com_ushareit_listenit_ewd, "ping Url is empty", true);
            return false;
        }
        int min = Math.min(com_ushareit_listenit_ewd.m18096a("ping_cnt", 3), 3);
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("cmd_id", com_ushareit_listenit_ewd.m18099a());
            linkedHashMap.put("url", b);
            linkedHashMap.put("network", ((Boolean) a.first).booleanValue() ? "mobile" : "wlan");
            for (int i = 0; i < min; i++) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean a2 = eyw.m18570a(b, 15000);
                exw.m18443a("CMD.AnalyticsCmdHandler", "ping url:" + b + ", number:" + i + ", succeed:" + a2);
                linkedHashMap.put("result" + i, a2 ? String.valueOf(System.currentTimeMillis() - currentTimeMillis) : String.valueOf(-1));
                if (i + 1 < min) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                }
            }
            esr.m17812a(this.a, "ENV_PingInfo", linkedHashMap, ete.class);
            return true;
        } catch (Exception e2) {
            m18268a(com_ushareit_listenit_ewd, e2.toString(), true);
            return false;
        }
    }

    public static void m18262a(Context context, ewd com_ushareit_listenit_ewd) {
        int i = 0;
        try {
            PackageManager packageManager = context.getPackageManager();
            int i2 = 0;
            int i3 = 0;
            for (PackageInfo packageInfo : fbj.m18785a(context, 0, "StatsCmd")) {
                if (packageManager.getLaunchIntentForPackage(packageInfo.packageName) != null || (packageInfo.applicationInfo.flags & 1) == 0) {
                    int i4;
                    i3++;
                    if ((packageInfo.applicationInfo.flags & 1) != 0) {
                        int i5 = i;
                        i = i2 + 1;
                        i4 = i5;
                    } else {
                        i4 = i + 1;
                        i = i2;
                    }
                    i2 = i;
                    i = i4;
                }
            }
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("total_app", i3 + "");
            linkedHashMap.put("system_app", i2 + "");
            linkedHashMap.put("other_app", i + "");
            linkedHashMap.put("cmd_id", com_ushareit_listenit_ewd.m18099a());
            exw.m18443a("CMD.AnalyticsCmdHandler", "collectAppSum() event = ENV_AppSum, value = " + linkedHashMap.toString());
            esr.m17812a(context, "ENV_AppSum", linkedHashMap, ete.class);
        } catch (Exception e) {
        }
    }

    public static void m18270b(Context context, ewd com_ushareit_listenit_ewd) {
        try {
            PackageManager packageManager = context.getPackageManager();
            for (PackageInfo packageInfo : fbj.m18785a(context, 0, "StatsCmd")) {
                if (packageManager.getLaunchIntentForPackage(packageInfo.packageName) != null || (packageInfo.applicationInfo.flags & 1) == 0) {
                    m18263a(context, com_ushareit_listenit_ewd, packageInfo);
                }
            }
        } catch (Exception e) {
        }
    }

    private static void m18263a(Context context, ewd com_ushareit_listenit_ewd, PackageInfo packageInfo) {
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            eyh a = eyh.m18491a(packageInfo.applicationInfo.sourceDir);
            linkedHashMap.put("name", packageInfo.packageName);
            if (a.mo2328c()) {
                linkedHashMap.put("size", a.mo2332g() + "");
                linkedHashMap.put("md5", fbf.m18774a(a));
            } else {
                linkedHashMap.put("size", null);
                linkedHashMap.put("md5", null);
            }
            linkedHashMap.put("version", packageInfo.versionName);
            linkedHashMap.put("cmd_id", com_ushareit_listenit_ewd.m18099a());
            exw.m18443a("CMD.AnalyticsCmdHandler", "collectAppList() event = ENV_AppList, value = " + linkedHashMap.toString());
            esr.m17812a(context, "ENV_AppList", linkedHashMap, ete.class);
        } catch (Exception e) {
        }
    }

    public static void m18272c(Context context, ewd com_ushareit_listenit_ewd) {
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("photo", etc.m17839a(fcw.m18867a(context)));
            linkedHashMap.put("music", etc.m17839a(fcw.m18871c(context)));
            linkedHashMap.put("video", etc.m17839a(fcw.m18873e(context)));
            linkedHashMap.put("cmd_id", com_ushareit_listenit_ewd.m18099a());
            exw.m18443a("CMD.AnalyticsCmdHandler", "collectMediaSum() event = ENV_MediaSum, value = " + linkedHashMap.toString());
            esr.m17812a(context, "ENV_MediaSum", linkedHashMap, ete.class);
        } catch (Exception e) {
        }
    }

    public static void m18274d(Context context, ewd com_ushareit_listenit_ewd) {
        try {
            for (fcb com_ushareit_listenit_fcb : fcw.m18872d(context)) {
                if (com_ushareit_listenit_fcb instanceof fcl) {
                    m18264a(context, com_ushareit_listenit_ewd, (fcl) com_ushareit_listenit_fcb);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void m18275e(Context context, ewd com_ushareit_listenit_ewd) {
        try {
            for (fcb com_ushareit_listenit_fcb : fcw.m18870b(context)) {
                if (com_ushareit_listenit_fcb instanceof fcm) {
                    m18265a(context, com_ushareit_listenit_ewd, (fcm) com_ushareit_listenit_fcb);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void m18276f(Context context, ewd com_ushareit_listenit_ewd) {
        try {
            for (fcb com_ushareit_listenit_fcb : fcw.m18874f(context)) {
                if (com_ushareit_listenit_fcb instanceof fcn) {
                    m18266a(context, com_ushareit_listenit_ewd, (fcn) com_ushareit_listenit_fcb);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void m18277g(Context context, ewd com_ushareit_listenit_ewd) {
        String str = "";
        try {
            Object obj;
            Pair a;
            Object valueOf;
            Object obj2;
            int a2 = fbj.m18784a(context, "cn.xender", 0);
            if (a2 != 0) {
                obj = "inst";
            } else {
                String str2 = "noinst";
            }
            List<eyk> a3 = eyj.m18512a(context);
            if (a2 != 0) {
                a2 = 0;
                long j = 0;
                for (eyk com_ushareit_listenit_eyk : a3) {
                    a = m18261a(new File(com_ushareit_listenit_eyk.f12178d, "Xender"));
                    j += ((Long) a.first).longValue();
                    a2 = ((Integer) a.second).intValue() + a2;
                }
                str = String.valueOf(j);
                valueOf = String.valueOf(a2);
                obj2 = str;
            } else {
                valueOf = null;
                obj2 = null;
            }
            long j2 = 0;
            int i = 0;
            for (eyk com_ushareit_listenit_eyk2 : a3) {
                Pair a4 = m18261a(new File(com_ushareit_listenit_eyk2.f12178d, "SHAREit"));
                j2 += ((Long) a4.first).longValue();
                i += ((Integer) a4.second).intValue();
                a4 = m18261a(new File(com_ushareit_listenit_eyk2.f12178d, "Android/data/com.lenovo.anyshare.gps/files/SHAREit"));
                j2 += ((Long) a4.first).longValue();
                int intValue = ((Integer) a4.second).intValue() + i;
                a = m18261a(new File(com_ushareit_listenit_eyk2.f12178d, "Android/data/com.lenovo.anyshare.gps/SHAREit"));
                j2 = ((Long) a.first).longValue() + j2;
                i = ((Integer) a.second).intValue() + intValue;
            }
            String valueOf2 = String.valueOf(j2);
            String valueOf3 = String.valueOf(i);
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", obj);
            linkedHashMap.put("x_size", obj2);
            linkedHashMap.put("x_cnt", valueOf);
            linkedHashMap.put("s_size", valueOf2);
            linkedHashMap.put("s_cnt", valueOf3);
            linkedHashMap.put("cmd_id", com_ushareit_listenit_ewd.m18099a());
            exw.m18443a("CMD.AnalyticsCmdHandler", "collect event = ENV_XenderSum, value = " + linkedHashMap.toString());
            esr.m17812a(context, "ENV_XenderSum", linkedHashMap, ete.class);
        } catch (Exception e) {
        }
    }

    private static void m18264a(Context context, ewd com_ushareit_listenit_ewd, fcl com_ushareit_listenit_fcl) {
        Object obj = null;
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("name", com_ushareit_listenit_fcl.m18340h());
            linkedHashMap.put("size", com_ushareit_listenit_fcl.m18345d() + "");
            linkedHashMap.put("md5", fbf.m18774a(eyh.m18491a(com_ushareit_listenit_fcl.m18343b())));
            Object i = com_ushareit_listenit_fcl.m18359i();
            String str = "album";
            if (fbb.m18758a((String) i) || "<unknown>".equalsIgnoreCase(i)) {
                i = null;
            }
            linkedHashMap.put(str, i);
            i = com_ushareit_listenit_fcl.m18360j();
            str = "artist";
            if (fbb.m18758a((String) i) || "<unknown>".equalsIgnoreCase(i)) {
                i = null;
            }
            linkedHashMap.put(str, i);
            String a = eye.m18476a(com_ushareit_listenit_fcl.m18344c());
            str = "extension";
            if (!fbb.m18758a(a)) {
                String str2 = a;
            }
            linkedHashMap.put(str, obj);
            linkedHashMap.put("cmd_id", com_ushareit_listenit_ewd.m18099a());
            exw.m18443a("CMD.AnalyticsCmdHandler", "collectMusicList() event = ENV_MusicList, value = " + linkedHashMap.toString());
            esr.m17812a(context, "ENV_MusicList", linkedHashMap, ete.class);
        } catch (Exception e) {
        }
    }

    private static void m18265a(Context context, ewd com_ushareit_listenit_ewd, fcm com_ushareit_listenit_fcm) {
        Object obj = null;
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("name", com_ushareit_listenit_fcm.m18340h());
            linkedHashMap.put("size", com_ushareit_listenit_fcm.m18345d() + "");
            linkedHashMap.put("md5", fbf.m18774a(eyh.m18491a(com_ushareit_listenit_fcm.m18343b())));
            Object i = com_ushareit_listenit_fcm.m18368i();
            String str = "album";
            if (fbb.m18758a((String) i)) {
                i = null;
            }
            linkedHashMap.put(str, i);
            String a = eye.m18476a(com_ushareit_listenit_fcm.m18344c());
            str = "extension";
            if (!fbb.m18758a(a)) {
                String str2 = a;
            }
            linkedHashMap.put(str, obj);
            linkedHashMap.put("cmd_id", com_ushareit_listenit_ewd.m18099a());
            exw.m18443a("CMD.AnalyticsCmdHandler", "collectPhotoList() event = ENV_PhotoList, value = " + linkedHashMap.toString());
            esr.m17812a(context, "ENV_PhotoList", linkedHashMap, ete.class);
        } catch (Exception e) {
        }
    }

    private static void m18266a(Context context, ewd com_ushareit_listenit_ewd, fcn com_ushareit_listenit_fcn) {
        Object obj = null;
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("name", com_ushareit_listenit_fcn.m18340h());
            linkedHashMap.put("size", com_ushareit_listenit_fcn.m18345d() + "");
            linkedHashMap.put("md5", fbf.m18774a(eyh.m18491a(com_ushareit_listenit_fcn.m18343b())));
            Object i = com_ushareit_listenit_fcn.m18376i();
            String str = "album";
            if (fbb.m18758a((String) i)) {
                i = null;
            }
            linkedHashMap.put(str, i);
            String a = eye.m18476a(com_ushareit_listenit_fcn.m18344c());
            str = "extension";
            if (!fbb.m18758a(a)) {
                String str2 = a;
            }
            linkedHashMap.put(str, obj);
            linkedHashMap.put("cmd_id", com_ushareit_listenit_ewd.m18099a());
            exw.m18443a("CMD.AnalyticsCmdHandler", "collectVideoList() event = ENV_VideoList, value = " + linkedHashMap.toString());
            esr.m17812a(context, "ENV_VideoList", linkedHashMap, ete.class);
        } catch (Exception e) {
        }
    }

    private static Pair<Long, Integer> m18261a(File file) {
        int i = 0;
        long j = 0;
        if (!file.exists() || !file.isDirectory()) {
            return new Pair(Long.valueOf(0), Integer.valueOf(0));
        }
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        int i2 = 0;
        while (i2 < length) {
            int i3;
            File file2 = listFiles[i2];
            if (file2.isHidden()) {
                i3 = i;
            } else if (file2.isDirectory()) {
                Pair a = m18261a(file2);
                j += ((Long) a.first).longValue();
                i3 = ((Integer) a.second).intValue() + i;
            } else {
                j += file2.length();
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        return new Pair(Long.valueOf(j), Integer.valueOf(i));
    }

    private void m18268a(ewd com_ushareit_listenit_ewd, String str, boolean z) {
        m18143a((eva) com_ushareit_listenit_ewd, evf.ERROR);
        m18146a((eva) com_ushareit_listenit_ewd, "error_reason", str);
        if (z) {
            m18152c(com_ushareit_listenit_ewd);
        }
    }
}
