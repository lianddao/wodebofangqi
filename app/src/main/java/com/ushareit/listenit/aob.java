package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.mopub.common.GpsHelper;
import java.lang.reflect.Method;

public class aob {
    public static final String f5017a = aob.class.getSimpleName();
    private final String f5018b;
    private final boolean f5019c;
    private final aof f5020d;

    private aob(String str, boolean z, aof com_ushareit_listenit_aof) {
        this.f5018b = str;
        this.f5019c = z;
        this.f5020d = com_ushareit_listenit_aof;
    }

    private static aob m6441a(Context context) {
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return new aob(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled(), aof.DIRECT);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static aob m6442a(Context context, aua com_ushareit_listenit_aua) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        } else if (com_ushareit_listenit_aua != null && !TextUtils.isEmpty(com_ushareit_listenit_aua.f5475b)) {
            return new aob(com_ushareit_listenit_aua.f5475b, com_ushareit_listenit_aua.f5476c, aof.FB4A);
        } else {
            aob a = m6441a(context);
            if (a == null || TextUtils.isEmpty(a.m6445a())) {
                a = m6443b(context);
            }
            return (a == null || TextUtils.isEmpty(a.m6445a())) ? m6444c(context) : a;
        }
    }

    private static aob m6443b(Context context) {
        Method a = atz.m7166a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (a == null) {
            return null;
        }
        Object a2 = atz.m7157a(null, a, context);
        if (a2 == null || ((Integer) a2).intValue() != 0) {
            return null;
        }
        a = atz.m7166a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
        if (a == null) {
            return null;
        }
        Object a3 = atz.m7157a(null, a, context);
        if (a3 == null) {
            return null;
        }
        a = atz.m7165a(a3.getClass(), "getId", new Class[0]);
        Method a4 = atz.m7165a(a3.getClass(), GpsHelper.IS_LIMIT_AD_TRACKING_ENABLED_KEY, new Class[0]);
        return (a == null || a4 == null) ? null : new aob((String) atz.m7157a(a3, a, new Object[0]), ((Boolean) atz.m7157a(a3, a4, new Object[0])).booleanValue(), aof.REFLECTION);
    }

    private static aob m6444c(Context context) {
        ServiceConnection com_ushareit_listenit_aoe = new aoe();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, com_ushareit_listenit_aoe, 1)) {
            aob com_ushareit_listenit_aob;
            try {
                aod com_ushareit_listenit_aod = new aod(com_ushareit_listenit_aoe.m6450a());
                com_ushareit_listenit_aob = new aob(com_ushareit_listenit_aod.m6448a(), com_ushareit_listenit_aod.m6449b(), aof.SERVICE);
                return com_ushareit_listenit_aob;
            } catch (Exception e) {
                com_ushareit_listenit_aob = e;
            } finally {
                context.unbindService(com_ushareit_listenit_aoe);
            }
        }
        return null;
    }

    public String m6445a() {
        return this.f5018b;
    }

    public boolean m6446b() {
        return this.f5019c;
    }

    public aof m6447c() {
        return this.f5020d;
    }
}
