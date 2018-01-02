package com.ushareit.listenit;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C0148R;
import com.google.android.gms.common.api.Status;

@Deprecated
public final class dnw {
    private static Object f10068a = new Object();
    private static dnw f10069b;
    private final String f10070c;
    private final String f10071d;
    private final Status f10072e;
    private final String f10073f;
    private final String f10074g;
    private final String f10075h;
    private final boolean f10076i;
    private final boolean f10077j;

    dnw(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C0148R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            if (z2) {
                z = false;
            }
            this.f10077j = z;
            z = z2;
        } else {
            this.f10077j = false;
        }
        this.f10076i = z;
        cfo com_ushareit_listenit_cfo = new cfo(context);
        this.f10073f = com_ushareit_listenit_cfo.m11111a("firebase_database_url");
        this.f10075h = com_ushareit_listenit_cfo.m11111a("google_storage_bucket");
        this.f10074g = com_ushareit_listenit_cfo.m11111a("gcm_defaultSenderId");
        this.f10071d = com_ushareit_listenit_cfo.m11111a("google_api_key");
        Object a = cfe.m11073a(context);
        if (a == null) {
            a = com_ushareit_listenit_cfo.m11111a("google_app_id");
        }
        if (TextUtils.isEmpty(a)) {
            this.f10072e = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f10070c = null;
            return;
        }
        this.f10070c = a;
        this.f10072e = Status.f1686a;
    }

    dnw(String str, boolean z) {
        this(str, z, null, null, null);
    }

    dnw(String str, boolean z, String str2, String str3, String str4) {
        this.f10070c = str;
        this.f10071d = null;
        this.f10072e = Status.f1686a;
        this.f10076i = z;
        this.f10077j = !z;
        this.f10073f = str2;
        this.f10074g = str4;
        this.f10075h = str3;
    }

    public static Status m15139a(Context context) {
        Status status;
        cfi.m11081a((Object) context, (Object) "Context must not be null.");
        synchronized (f10068a) {
            if (f10069b == null) {
                f10069b = new dnw(context);
            }
            status = f10069b.f10072e;
        }
        return status;
    }

    public static Status m15140a(Context context, String str, boolean z) {
        Status a;
        cfi.m11081a((Object) context, (Object) "Context must not be null.");
        cfi.m11083a(str, (Object) "App ID must be nonempty.");
        synchronized (f10068a) {
            if (f10069b != null) {
                a = f10069b.m15144a(str);
            } else {
                f10069b = new dnw(str, z);
                a = f10069b.f10072e;
            }
        }
        return a;
    }

    public static String m15141a() {
        return m15142b("getGoogleAppId").f10070c;
    }

    private static dnw m15142b(String str) {
        dnw com_ushareit_listenit_dnw;
        synchronized (f10068a) {
            if (f10069b == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            com_ushareit_listenit_dnw = f10069b;
        }
        return com_ushareit_listenit_dnw;
    }

    public static boolean m15143b() {
        return m15142b("isMeasurementExplicitlyDisabled").f10077j;
    }

    Status m15144a(String str) {
        if (this.f10070c == null || this.f10070c.equals(str)) {
            return Status.f1686a;
        }
        String str2 = this.f10070c;
        return new Status(10, new StringBuilder(String.valueOf(str2).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str2).append("'.").toString());
    }
}
