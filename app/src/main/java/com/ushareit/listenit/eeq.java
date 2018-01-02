package com.ushareit.listenit;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import com.umeng.analytics.pro.C0321x;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class eeq {
    static String f10887a = null;
    static int f10888b = 0;
    static int f10889c = 0;
    static int f10890d = 0;
    Context f10891e;
    Map<String, Object> f10892f = new HashMap();
    Messenger f10893g;
    Messenger f10894h;
    MessengerCompat f10895i;
    PendingIntent f10896j;
    long f10897k;
    long f10898l;
    int f10899m;
    int f10900n;
    long f10901o;

    public eeq(Context context) {
        this.f10891e = context;
    }

    public static String m16859a(Context context) {
        ApplicationInfo applicationInfo;
        if (f10887a != null) {
            return f10887a;
        }
        f10888b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo2.uid);
                    f10889c = applicationInfo2.uid;
                    f10887a = resolveInfo.serviceInfo.packageName;
                    return f10887a;
                } catch (NameNotFoundException e) {
                }
            } else {
                String valueOf = String.valueOf(resolveInfo.serviceInfo.packageName);
                String valueOf2 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
                Log.w("InstanceID/Rpc", new StringBuilder((String.valueOf(valueOf).length() + 56) + String.valueOf(valueOf2).length()).append("Possible malicious package ").append(valueOf).append(" declares ").append(valueOf2).append(" without permission").toString());
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try {
            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
            f10887a = applicationInfo.packageName;
            f10889c = applicationInfo.uid;
            return f10887a;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                f10887a = applicationInfo.packageName;
                f10889c = applicationInfo.uid;
                return f10887a;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    static String m16860a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = FirebaseInstanceId.m2553a(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private void m16861a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f10892f.keySet()) {
                Object obj2 = this.f10892f.get(str);
                this.f10892f.put(str, obj);
                m16862a(obj2, obj);
            }
        }
    }

    private void m16862a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf).toString());
            }
        }
    }

    private void m16863a(String str) {
        if ("com.google.android.gsf".equals(f10887a)) {
            this.f10899m++;
            if (this.f10899m >= 3) {
                if (this.f10899m == 3) {
                    this.f10900n = new Random().nextInt(1000) + 1000;
                }
                this.f10900n *= 2;
                this.f10901o = SystemClock.elapsedRealtime() + ((long) this.f10900n);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.f10900n).toString());
            }
        }
    }

    private void m16864a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f10892f.get(str);
            this.f10892f.put(str, obj);
            m16862a(obj2, obj);
        }
    }

    private static int m16865b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(m16859a(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private Intent m16866b(Bundle bundle, KeyPair keyPair) {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String b = m16867b();
        synchronized (getClass()) {
            this.f10892f.put(b, conditionVariable);
        }
        m16872a(bundle, keyPair, b);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.f10892f.remove(b);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                String valueOf = String.valueOf(remove);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 12).append("No response ").append(valueOf).toString());
                throw new IOException("TIMEOUT");
            }
        }
        return intent;
    }

    public static synchronized String m16867b() {
        String num;
        synchronized (eeq.class) {
            int i = f10890d;
            f10890d = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    Intent m16868a(Bundle bundle, KeyPair keyPair) {
        Intent b = m16866b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : m16866b(bundle, keyPair);
    }

    void m16869a() {
        if (this.f10893g == null) {
            m16859a(this.f10891e);
            this.f10893g = new Messenger(new eer(this, Looper.getMainLooper()));
        }
    }

    public synchronized void m16870a(Intent intent) {
        if (this.f10896j == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f10896j = PendingIntent.getBroadcast(this.f10891e, 0, intent2, 0);
        }
        intent.putExtra("app", this.f10896j);
    }

    protected void m16871a(Intent intent, String str) {
        this.f10897k = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(f10887a);
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (equals) {
            this.f10891e.startService(intent);
            return;
        }
        intent.putExtra("google.messenger", this.f10893g);
        if (!(this.f10894h == null && this.f10895i == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.f10894h != null) {
                    this.f10894h.send(obtain);
                    return;
                } else {
                    this.f10895i.m2340b(obtain);
                    return;
                }
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.f10891e.startService(intent);
    }

    public void m16872a(Bundle bundle, KeyPair keyPair, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f10901o == 0 || elapsedRealtime > this.f10901o) {
            m16869a();
            if (f10887a == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.f10897k = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(f10887a);
            bundle.putString("gmsv", Integer.toString(m16865b(this.f10891e)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.m2555b(this.f10891e)));
            bundle.putString("app_ver_name", FirebaseInstanceId.m2556c(this.f10891e));
            bundle.putString("cliv", "fiid-9683000");
            bundle.putString("appid", FirebaseInstanceId.m2552a(keyPair));
            String a = FirebaseInstanceId.m2551a(this.f10891e);
            if (a != null) {
                bundle.putString("gmp_app_id", a);
            }
            bundle.putString("pub2", FirebaseInstanceId.m2553a(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", m16860a(keyPair, this.f10891e.getPackageName(), a));
            intent.putExtras(bundle);
            m16870a(intent);
            m16871a(intent, str);
            return;
        }
        elapsedRealtime = this.f10901o - elapsedRealtime;
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + elapsedRealtime + " interval: " + this.f10900n);
        throw new IOException("RETRY_LATER");
    }

    public void m16873a(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.f10895i = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f10894h = (Messenger) parcelableExtra;
                    }
                }
                m16876d((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    String m16874b(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra(C0321x.aF);
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        String valueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    void m16875c(Intent intent) {
        String stringExtra = intent.getStringExtra(C0321x.aF);
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            valueOf = "InstanceID/Rpc";
            String str = "Received InstanceID error ";
            String valueOf2 = String.valueOf(stringExtra);
            Log.d(valueOf, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String str2 = "InstanceID/Rpc";
                String str3 = "Unexpected structured response ";
                valueOf2 = String.valueOf(stringExtra);
                Log.w(str2, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            }
            if (split.length > 2) {
                valueOf2 = split[2];
                valueOf = split[3];
                if (valueOf.startsWith(":")) {
                    valueOf = valueOf.substring(1);
                }
            } else {
                valueOf = "UNKNOWN";
                valueOf2 = null;
            }
            intent.putExtra(C0321x.aF, valueOf);
        } else {
            valueOf2 = null;
            valueOf = stringExtra;
        }
        if (valueOf2 == null) {
            m16861a((Object) valueOf);
        } else {
            m16864a(valueOf2, (Object) valueOf);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.f10898l = SystemClock.elapsedRealtime();
            this.f10900n = ((int) longExtra) * 1000;
            this.f10901o = SystemClock.elapsedRealtime() + ((long) this.f10900n);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.f10900n);
        } else if ("SERVICE_NOT_AVAILABLE".equals(valueOf) || "AUTHENTICATION_FAILED".equals(valueOf)) {
            m16863a(valueOf);
        }
    }

    public void m16876d(Intent intent) {
        if (intent != null) {
            String stringExtra;
            String str;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                stringExtra = intent.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    m16875c(intent);
                    return;
                }
                this.f10897k = SystemClock.elapsedRealtime();
                this.f10901o = 0;
                this.f10899m = 0;
                this.f10900n = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    String valueOf = String.valueOf(intent.getExtras());
                    Log.d("InstanceID/Rpc", new StringBuilder((String.valueOf(stringExtra).length() + 16) + String.valueOf(valueOf).length()).append("AppIDResponse: ").append(stringExtra).append(" ").append(valueOf).toString());
                }
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        str = "InstanceID/Rpc";
                        String str2 = "Unexpected structured response ";
                        stringExtra = String.valueOf(stringExtra);
                        Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                    }
                    str = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            FirebaseInstanceId.m2557d(this.f10891e);
                        } else if ("RST".equals(split[3])) {
                            FirebaseInstanceId.m2554a(this.f10891e, eeo.m16849a(this.f10891e, null).m16854c());
                            intent.removeExtra("registration_id");
                            m16864a(str, (Object) intent);
                            return;
                        }
                    }
                    stringExtra = split[split.length - 1];
                    if (stringExtra.startsWith(":")) {
                        stringExtra = stringExtra.substring(1);
                    }
                    intent.putExtra("registration_id", stringExtra);
                    stringExtra = str;
                } else {
                    stringExtra = null;
                }
                if (stringExtra == null) {
                    m16861a((Object) intent);
                } else {
                    m16864a(stringExtra, (Object) intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                str = "InstanceID/Rpc";
                String str3 = "Unexpected response ";
                stringExtra = String.valueOf(intent.getAction());
                Log.d(str, stringExtra.length() != 0 ? str3.concat(stringExtra) : new String(str3));
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
