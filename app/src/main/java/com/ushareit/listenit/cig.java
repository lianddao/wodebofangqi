package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class cig {
    private static final Object f8324a = new Object();
    private static cig f8325b;
    private static Integer f8326h;
    private final List<String> f8327c;
    private final List<String> f8328d;
    private final List<String> f8329e;
    private final List<String> f8330f;
    private cik f8331g;
    private cik f8332i;

    private cig() {
        if (m11374c() == cij.f8342b) {
            this.f8327c = Collections.EMPTY_LIST;
            this.f8328d = Collections.EMPTY_LIST;
            this.f8329e = Collections.EMPTY_LIST;
            this.f8330f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) cii.f8336b.m15222a();
        this.f8327c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) cii.f8337c.m15222a();
        this.f8328d = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) cii.f8338d.m15222a();
        this.f8329e = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) cii.f8339e.m15222a();
        this.f8330f = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.f8331g = new cik(1024, ((Long) cii.f8340f.m15222a()).longValue());
        this.f8332i = new cik(1024, ((Long) cii.f8340f.m15222a()).longValue());
    }

    public static cig m11364a() {
        synchronized (f8324a) {
            if (f8325b == null) {
                f8325b = new cig();
            }
        }
        return f8325b;
    }

    private static String m11365a(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(m11367a(stackTrace, i)).append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    private String m11366a(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private static String m11367a(StackTraceElement[] stackTraceElementArr, int i) {
        if (i + 4 >= stackTraceElementArr.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr[i + 4];
        String valueOf = String.valueOf(stackTraceElement.getClassName());
        String valueOf2 = String.valueOf(stackTraceElement.getMethodName());
        return new StringBuilder((String.valueOf(valueOf).length() + 13) + String.valueOf(valueOf2).length()).append(valueOf).append(".").append(valueOf2).append(":").append(stackTraceElement.getLineNumber()).toString();
    }

    private void m11368a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Parcelable connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((m11374c() & cij.f8346f) == 0 || i == 13)) {
            str6 = m11365a(3, 5);
        }
        long j = 0;
        if ((m11374c() & cij.f8348h) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(cij.f8341a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void m11369a(Context context, String str, String str2, Intent intent, int i) {
        String str3 = null;
        if (m11373b() && this.f8331g != null) {
            String str4;
            String str5;
            if (i != 4 && i != 1) {
                ServiceInfo b = m11372b(context, intent);
                if (b == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = b.processName;
                str5 = b.name;
                str3 = civ.m11416a();
                if (m11371a(str3, str2, str4, str5)) {
                    this.f8331g.m11381a(str);
                } else {
                    return;
                }
            } else if (this.f8331g.m11382b(str)) {
                str5 = null;
                str4 = null;
            } else {
                return;
            }
            m11368a(context, str, i, str3, str2, str4, str5);
        }
    }

    private boolean m11370a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? false : cin.m11386a(context, component.getPackageName());
    }

    private boolean m11371a(String str, String str2, String str3, String str4) {
        return (this.f8327c.contains(str) || this.f8328d.contains(str2) || this.f8329e.contains(str3) || this.f8330f.contains(str4) || (str3.equals(str) && (m11374c() & cij.f8347g) != 0)) ? false : true;
    }

    private static ServiceInfo m11372b(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), m11365a(3, 20)}));
            return null;
        } else if (queryIntentServices.size() <= 1) {
            return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
        } else {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), m11365a(3, 20)}));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                Log.w("ConnectionTracker", resolveInfo.serviceInfo.name);
            }
            return null;
        }
    }

    private boolean m11373b() {
        return false;
    }

    private static int m11374c() {
        if (f8326h == null) {
            try {
                f8326h = Integer.valueOf(cin.m11385a() ? ((Integer) cii.f8335a.m15222a()).intValue() : cij.f8342b);
            } catch (SecurityException e) {
                f8326h = Integer.valueOf(cij.f8342b);
            }
        }
        return f8326h.intValue();
    }

    @SuppressLint({"UntrackedBindService"})
    public void m11375a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        m11369a(context, m11366a(serviceConnection), null, null, 1);
    }

    public void m11376a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        m11369a(context, m11366a(serviceConnection), str, intent, 3);
    }

    public boolean m11377a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m11378a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean m11378a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (m11370a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            m11369a(context, m11366a(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void m11379b(Context context, ServiceConnection serviceConnection) {
        m11369a(context, m11366a(serviceConnection), null, null, 4);
    }
}
