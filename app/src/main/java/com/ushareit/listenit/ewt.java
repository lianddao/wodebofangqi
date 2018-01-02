package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class ewt {
    private static ewv f12047a = null;
    private static ewu f12048b = null;

    public static void m18317a(ewv com_ushareit_listenit_ewv) {
        f12047a = com_ushareit_listenit_ewv;
    }

    public static void m18315a(Context context, evi com_ushareit_listenit_evi) {
        if (f12047a != null) {
            f12047a.mo2313a(context, com_ushareit_listenit_evi);
        }
    }

    public static void m18313a(Context context, int i) {
        if (f12047a != null) {
            f12047a.mo2312a(context, i);
        }
    }

    public static void m18314a(Context context, evh com_ushareit_listenit_evh) {
        try {
            Intent intent = new Intent("com.ushareit.cmd.action.COMMAND_SHOW_MSGBOX");
            intent.setPackage(context.getPackageName());
            intent.addFlags(268435456);
            intent.putExtra("msgbox", com_ushareit_listenit_evh.toString());
            context.startActivity(intent);
        } catch (Exception e) {
            exw.m18449b("CMD.Utils", e.toString());
        }
    }

    public static boolean m18321a(Context context, String str, int i, String str2) {
        if (f12048b != null) {
            return f12048b.m18323a(context, str, i, str2);
        }
        return m18319a(context, i, str2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m18319a(android.content.Context r5, int r6, java.lang.String r7) {
        /*
        r0 = 1;
        r1 = 0;
        switch(r6) {
            case 1: goto L_0x0007;
            case 2: goto L_0x0048;
            case 3: goto L_0x0039;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        return r0;
    L_0x0007:
        r2 = com.ushareit.listenit.fbb.m18761b(r7);	 Catch:{ Exception -> 0x001b }
        if (r2 == 0) goto L_0x0005;
    L_0x000d:
        r2 = 0;
        r2 = android.content.Intent.parseUri(r7, r2);	 Catch:{ Exception -> 0x001b }
        r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r2.addFlags(r3);	 Catch:{ Exception -> 0x001b }
        r5.startActivity(r2);	 Catch:{ Exception -> 0x001b }
        goto L_0x0006;
    L_0x001b:
        r0 = move-exception;
        r2 = "CMD.Utils";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "execute event execption: ";
        r3 = r3.append(r4);
        r0 = r0.toString();
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.ushareit.listenit.exw.m18449b(r2, r0);
        goto L_0x0005;
    L_0x0039:
        r2 = com.ushareit.listenit.fbb.m18761b(r7);	 Catch:{ Exception -> 0x001b }
        if (r2 == 0) goto L_0x0005;
    L_0x003f:
        r2 = 0;
        r2 = android.content.Intent.parseUri(r7, r2);	 Catch:{ Exception -> 0x001b }
        r5.startService(r2);	 Catch:{ Exception -> 0x001b }
        goto L_0x0006;
    L_0x0048:
        r2 = com.ushareit.listenit.fbb.m18761b(r7);	 Catch:{ Exception -> 0x001b }
        if (r2 == 0) goto L_0x0005;
    L_0x004e:
        r2 = 0;
        r2 = android.content.Intent.parseUri(r7, r2);	 Catch:{ Exception -> 0x001b }
        r5.sendBroadcast(r2);	 Catch:{ Exception -> 0x001b }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.ewt.a(android.content.Context, int, java.lang.String):boolean");
    }

    public static void m18316a(Context context, evl com_ushareit_listenit_evl, evp com_ushareit_listenit_evp) {
        if (com_ushareit_listenit_evp != null && !fbb.m18763c(com_ushareit_listenit_evp.f11981a)) {
            com_ushareit_listenit_evl.m18170a(com_ushareit_listenit_evp);
            euz.m18091a(context, com_ushareit_listenit_evp);
        }
    }

    public static boolean m18320a(Context context, evb com_ushareit_listenit_evb) {
        if (com_ushareit_listenit_evb == null) {
            return true;
        }
        switch (com_ushareit_listenit_evb.f11924a) {
            case 1:
                return ((Boolean) eyw.m18568a(context).second).booleanValue();
            case 2:
                boolean z = ((Boolean) eyw.m18568a(context).first).booleanValue() || ((Boolean) eyw.m18568a(context).second).booleanValue();
                return z;
            default:
                return true;
        }
    }

    public static boolean m18322b(Context context, evb com_ushareit_listenit_evb) {
        if (com_ushareit_listenit_evb == null) {
            return true;
        }
        PackageInfo a = m18311a(context, com_ushareit_listenit_evb.f11927d);
        switch (com_ushareit_listenit_evb.f11926c) {
            case 1:
                if (a == null || ((com_ushareit_listenit_evb.f11928e != -1 && a.versionCode < com_ushareit_listenit_evb.f11928e) || (com_ushareit_listenit_evb.f11929f != -1 && a.versionCode > com_ushareit_listenit_evb.f11929f))) {
                    return false;
                }
                return true;
            case 2:
                if (a != null) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    public static boolean m18318a(Context context, int i, int i2) {
        switch (i2) {
            case 1:
                return ((Boolean) eyw.m18568a(context).first).booleanValue() || ((Boolean) eyw.m18568a(context).second).booleanValue();
            case 2:
                return ((Boolean) eyw.m18568a(context).second).booleanValue();
            default:
                return false;
        }
    }

    private static PackageInfo m18311a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static evd m18312a(Context context, evl com_ushareit_listenit_evl, Class<?> cls) {
        try {
            return (evd) eyt.m18564a(cls, new Object[]{context, com_ushareit_listenit_evl}, Context.class, evl.class);
        } catch (Exception e) {
            exw.m18449b("CMD.Utils", e.toString());
            return null;
        }
    }
}
