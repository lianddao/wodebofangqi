package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.util.Base64;
import com.facebook.internal.C0101i;
import com.facebook.internal.bp;
import com.facebook.internal.cb;
import com.facebook.internal.cj;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ail {
    private static final String f4426a = ail.class.getCanonicalName();
    private static final HashSet<ajk> f4427b = new HashSet(Arrays.asList(new ajk[]{ajk.DEVELOPER_ERRORS}));
    private static volatile Executor f4428c;
    private static volatile String f4429d;
    private static volatile String f4430e;
    private static volatile String f4431f;
    private static volatile int f4432g;
    private static volatile String f4433h = "facebook.com";
    private static AtomicLong f4434i = new AtomicLong(65536);
    private static volatile boolean f4435j = false;
    private static boolean f4436k = false;
    private static File f4437l;
    private static Context f4438m;
    private static int f4439n = 64206;
    private static final Object f4440o = new Object();
    private static final BlockingQueue<Runnable> f4441p = new LinkedBlockingQueue(10);
    private static final ThreadFactory f4442q = new aim();
    private static Boolean f4443r = Boolean.valueOf(false);

    public static synchronized void m5700a(Context context) {
        synchronized (ail.class) {
            m5701a(context, null);
        }
    }

    public static synchronized void m5701a(Context context, aip com_ushareit_listenit_aip) {
        synchronized (ail.class) {
            if (!f4443r.booleanValue()) {
                cj.m1640a((Object) context, "applicationContext");
                cj.m1645b(context, false);
                cj.m1639a(context, false);
                f4438m = context.getApplicationContext();
                m5710c(f4438m);
                cb.m1577a(f4438m, f4429d);
                bp.m1514b();
                C0101i.m1689a(f4438m);
                f4437l = f4438m.getCacheDir();
                m5713d().execute(new FutureTask(new ain(com_ushareit_listenit_aip)));
                f4443r = Boolean.valueOf(true);
            } else if (com_ushareit_listenit_aip != null) {
                com_ushareit_listenit_aip.m5725a();
            }
        }
    }

    public static synchronized boolean m5704a() {
        boolean booleanValue;
        synchronized (ail.class) {
            booleanValue = f4443r.booleanValue();
        }
        return booleanValue;
    }

    public static boolean m5705a(ajk com_ushareit_listenit_ajk) {
        boolean z;
        synchronized (f4427b) {
            z = m5707b() && f4427b.contains(com_ushareit_listenit_ajk);
        }
        return z;
    }

    public static boolean m5707b() {
        return f4435j;
    }

    public static boolean m5711c() {
        return f4436k;
    }

    public static Executor m5713d() {
        synchronized (f4440o) {
            if (f4428c == null) {
                Executor n = m5723n();
                if (n == null) {
                    n = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f4441p, f4442q);
                }
                f4428c = n;
            }
        }
        return f4428c;
    }

    public static String m5714e() {
        return f4433h;
    }

    public static Context m5715f() {
        cj.m1643b();
        return f4438m;
    }

    private static Executor m5723n() {
        try {
            try {
                Object obj = AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null);
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Executor) {
                    return (Executor) obj;
                }
                return null;
            } catch (IllegalAccessException e) {
                return null;
            }
        } catch (NoSuchFieldException e2) {
            return null;
        }
    }

    public static void m5702a(Context context, String str) {
        m5713d().execute(new aio(context.getApplicationContext(), str));
    }

    static com.ushareit.listenit.ajh m5706b(android.content.Context r14, java.lang.String r15) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.ushareit.listenit.ail.b(android.content.Context, java.lang.String):com.ushareit.listenit.ajh. bs: [B:3:0x0007, B:11:0x005d]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r12 = 0;
        r1 = 0;
        if (r14 == 0) goto L_0x0007;
    L_0x0005:
        if (r15 != 0) goto L_0x0021;
    L_0x0007:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ Exception -> 0x000f }
        r2 = "Both context and applicationId must be non-null";	 Catch:{ Exception -> 0x000f }
        r0.<init>(r2);	 Catch:{ Exception -> 0x000f }
        throw r0;	 Catch:{ Exception -> 0x000f }
    L_0x000f:
        r0 = move-exception;
        r2 = r0;
        r0 = "Facebook-publish";
        com.facebook.internal.cb.m1584a(r0, r2);
        r0 = new com.ushareit.listenit.ajh;
        r3 = new com.ushareit.listenit.aih;
        r3.<init>(r1, r2);
        r0.<init>(r1, r1, r3);
    L_0x0020:
        return r0;
    L_0x0021:
        r0 = com.facebook.internal.C0097e.m1677a(r14);	 Catch:{ Exception -> 0x000f }
        r2 = "com.facebook.sdk.attributionTracking";	 Catch:{ Exception -> 0x000f }
        r3 = 0;	 Catch:{ Exception -> 0x000f }
        r2 = r14.getSharedPreferences(r2, r3);	 Catch:{ Exception -> 0x000f }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x000f }
        r3.<init>();	 Catch:{ Exception -> 0x000f }
        r3 = r3.append(r15);	 Catch:{ Exception -> 0x000f }
        r4 = "ping";	 Catch:{ Exception -> 0x000f }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x000f }
        r3 = r3.toString();	 Catch:{ Exception -> 0x000f }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x000f }
        r4.<init>();	 Catch:{ Exception -> 0x000f }
        r4 = r4.append(r15);	 Catch:{ Exception -> 0x000f }
        r5 = "json";	 Catch:{ Exception -> 0x000f }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x000f }
        r4 = r4.toString();	 Catch:{ Exception -> 0x000f }
        r6 = 0;	 Catch:{ Exception -> 0x000f }
        r6 = r2.getLong(r3, r6);	 Catch:{ Exception -> 0x000f }
        r5 = 0;	 Catch:{ Exception -> 0x000f }
        r5 = r2.getString(r4, r5);	 Catch:{ Exception -> 0x000f }
        r8 = com.facebook.internal.C0096d.MOBILE_INSTALL_EVENT;	 Catch:{ JSONException -> 0x00a6 }
        r9 = com.facebook.appevents.C0075a.m1190b(r14);	 Catch:{ JSONException -> 0x00a6 }
        r10 = m5709b(r14);	 Catch:{ JSONException -> 0x00a6 }
        r0 = com.facebook.internal.C0094b.m1437a(r8, r0, r9, r10, r14);	 Catch:{ JSONException -> 0x00a6 }
        r8 = "%s/activities";	 Catch:{ Exception -> 0x000f }
        r9 = 1;	 Catch:{ Exception -> 0x000f }
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x000f }
        r10 = 0;	 Catch:{ Exception -> 0x000f }
        r9[r10] = r15;	 Catch:{ Exception -> 0x000f }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ Exception -> 0x000f }
        r9 = 0;	 Catch:{ Exception -> 0x000f }
        r10 = 0;	 Catch:{ Exception -> 0x000f }
        r8 = com.facebook.GraphRequest.m725a(r9, r8, r0, r10);	 Catch:{ Exception -> 0x000f }
        r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r0 == 0) goto L_0x00bc;
    L_0x0081:
        if (r5 == 0) goto L_0x00e1;
    L_0x0083:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00af }
        r0.<init>(r5);	 Catch:{ JSONException -> 0x00af }
    L_0x0088:
        r2 = r0;
    L_0x0089:
        if (r2 != 0) goto L_0x00b2;
    L_0x008b:
        r0 = "true";	 Catch:{ Exception -> 0x000f }
        r2 = 0;	 Catch:{ Exception -> 0x000f }
        r3 = new com.ushareit.listenit.aje;	 Catch:{ Exception -> 0x000f }
        r4 = 1;	 Catch:{ Exception -> 0x000f }
        r4 = new com.facebook.GraphRequest[r4];	 Catch:{ Exception -> 0x000f }
        r5 = 0;	 Catch:{ Exception -> 0x000f }
        r4[r5] = r8;	 Catch:{ Exception -> 0x000f }
        r3.<init>(r4);	 Catch:{ Exception -> 0x000f }
        r0 = com.ushareit.listenit.ajh.m5772a(r0, r2, r3);	 Catch:{ Exception -> 0x000f }
        r2 = 0;	 Catch:{ Exception -> 0x000f }
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x000f }
        r0 = (com.ushareit.listenit.ajh) r0;	 Catch:{ Exception -> 0x000f }
        goto L_0x0020;	 Catch:{ Exception -> 0x000f }
    L_0x00a6:
        r0 = move-exception;	 Catch:{ Exception -> 0x000f }
        r2 = new com.ushareit.listenit.aif;	 Catch:{ Exception -> 0x000f }
        r3 = "An error occurred while publishing install.";	 Catch:{ Exception -> 0x000f }
        r2.<init>(r3, r0);	 Catch:{ Exception -> 0x000f }
        throw r2;	 Catch:{ Exception -> 0x000f }
    L_0x00af:
        r0 = move-exception;	 Catch:{ Exception -> 0x000f }
        r2 = r1;	 Catch:{ Exception -> 0x000f }
        goto L_0x0089;	 Catch:{ Exception -> 0x000f }
    L_0x00b2:
        r0 = new com.ushareit.listenit.ajh;	 Catch:{ Exception -> 0x000f }
        r3 = 0;	 Catch:{ Exception -> 0x000f }
        r4 = 0;	 Catch:{ Exception -> 0x000f }
        r5 = 0;	 Catch:{ Exception -> 0x000f }
        r0.<init>(r3, r4, r5, r2);	 Catch:{ Exception -> 0x000f }
        goto L_0x0020;	 Catch:{ Exception -> 0x000f }
    L_0x00bc:
        r0 = r8.m773g();	 Catch:{ Exception -> 0x000f }
        r2 = r2.edit();	 Catch:{ Exception -> 0x000f }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x000f }
        r2.putLong(r3, r6);	 Catch:{ Exception -> 0x000f }
        r3 = r0.m5777b();	 Catch:{ Exception -> 0x000f }
        if (r3 == 0) goto L_0x00dc;	 Catch:{ Exception -> 0x000f }
    L_0x00d1:
        r3 = r0.m5777b();	 Catch:{ Exception -> 0x000f }
        r3 = r3.toString();	 Catch:{ Exception -> 0x000f }
        r2.putString(r4, r3);	 Catch:{ Exception -> 0x000f }
    L_0x00dc:
        r2.apply();	 Catch:{ Exception -> 0x000f }
        goto L_0x0020;
    L_0x00e1:
        r0 = r1;
        goto L_0x0088;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.ail.b(android.content.Context, java.lang.String):com.ushareit.listenit.ajh");
    }

    public static boolean m5709b(Context context) {
        cj.m1643b();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static long m5716g() {
        cj.m1643b();
        return f4434i.get();
    }

    static void m5710c(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (f4429d == null) {
                        Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                        if (obj instanceof String) {
                            f4429d = (String) obj;
                        } else if (obj instanceof Integer) {
                            f4429d = obj.toString();
                        }
                    }
                    if (f4430e == null) {
                        f4430e = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
                    }
                    if (f4431f == null) {
                        f4431f = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
                    }
                    if (f4432g == 0) {
                        m5699a(applicationInfo.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                    }
                }
            } catch (NameNotFoundException e) {
            }
        }
    }

    public static String m5712d(Context context) {
        String str = null;
        cj.m1643b();
        if (context == null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return str;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return str;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(packageInfo.signatures[0].toByteArray());
                return Base64.encodeToString(instance.digest(), 9);
            } catch (NoSuchAlgorithmException e) {
                return str;
            }
        } catch (NameNotFoundException e2) {
            return str;
        }
    }

    public static String m5717h() {
        cj.m1643b();
        return f4429d;
    }

    public static void m5703a(String str) {
        f4429d = str;
    }

    public static String m5718i() {
        cj.m1643b();
        return f4430e;
    }

    public static String m5719j() {
        cj.m1643b();
        return f4431f;
    }

    public static int m5720k() {
        cj.m1643b();
        return f4432g;
    }

    public static void m5699a(int i) {
        f4432g = i;
    }

    public static File m5721l() {
        cj.m1643b();
        return f4437l;
    }

    public static int m5722m() {
        cj.m1643b();
        return f4439n;
    }

    public static boolean m5708b(int i) {
        return i >= f4439n && i < f4439n + 100;
    }
}
