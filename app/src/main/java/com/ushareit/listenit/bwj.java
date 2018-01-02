package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

public class bwj {
    private bxu f7884a;
    private final Object f7885b = new Object();
    private final bwe f7886c;
    private final bwd f7887d;
    private final bvp f7888e;
    private final die f7889f;
    private final bys f7890g;
    private final dkm f7891h;
    private final djm f7892i;

    public bwj(bwe com_ushareit_listenit_bwe, bwd com_ushareit_listenit_bwd, bvp com_ushareit_listenit_bvp, die com_ushareit_listenit_die, bys com_ushareit_listenit_bys, dkm com_ushareit_listenit_dkm, djm com_ushareit_listenit_djm) {
        this.f7886c = com_ushareit_listenit_bwe;
        this.f7887d = com_ushareit_listenit_bwd;
        this.f7888e = com_ushareit_listenit_bvp;
        this.f7889f = com_ushareit_listenit_die;
        this.f7890g = com_ushareit_listenit_bys;
        this.f7891h = com_ushareit_listenit_dkm;
        this.f7892i = com_ushareit_listenit_djm;
    }

    private static bxu m10211a() {
        try {
            Object newInstance = bwj.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return bxv.m10335a((IBinder) newInstance);
            }
            bze.m10490c("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            bze.m10491c("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    private void m10213a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        bwt.m10268a().m10472a(context, null, "gmob-apps", bundle, true);
    }

    private static boolean m10215a(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        bze.m10488b("useClientJar flag not found in activity intent extras.");
        return false;
    }

    private bxu m10217b() {
        bxu com_ushareit_listenit_bxu;
        synchronized (this.f7885b) {
            if (this.f7884a == null) {
                this.f7884a = m10211a();
            }
            com_ushareit_listenit_bxu = this.f7884a;
        }
        return com_ushareit_listenit_bxu;
    }

    public bxf m10223a(Context context, String str, dii com_ushareit_listenit_dii) {
        return (bxf) m10229a(context, false, new bwn(this, context, str, com_ushareit_listenit_dii));
    }

    public bxl m10224a(Context context, AdSizeParcel adSizeParcel, String str) {
        return (bxl) m10229a(context, false, new bwl(this, context, adSizeParcel, str));
    }

    public bxl m10225a(Context context, AdSizeParcel adSizeParcel, String str, dii com_ushareit_listenit_dii) {
        return (bxl) m10229a(context, false, new bwk(this, context, adSizeParcel, str, com_ushareit_listenit_dii));
    }

    public bya m10226a(Context context) {
        return (bya) m10229a(context, false, new bwo(this, context));
    }

    public dhb m10227a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (dhb) m10229a(context, false, new bwp(this, frameLayout, frameLayout2, context));
    }

    public djz m10228a(Activity activity) {
        return (djz) m10229a((Context) activity, m10215a(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new bwq(this, activity));
    }

    <T> T m10229a(Context context, boolean z, bws<T> com_ushareit_listenit_bws_T) {
        if (!(z || bwt.m10268a().m10479b(context))) {
            bze.m10485a("Google Play Services is not available");
            z = true;
        }
        T c;
        if (z) {
            c = com_ushareit_listenit_bws_T.m10234c();
            return c == null ? com_ushareit_listenit_bws_T.m10235d() : c;
        } else {
            c = com_ushareit_listenit_bws_T.m10235d();
            return c == null ? com_ushareit_listenit_bws_T.m10234c() : c;
        }
    }

    public bxl m10230b(Context context, AdSizeParcel adSizeParcel, String str, dii com_ushareit_listenit_dii) {
        return (bxl) m10229a(context, false, new bwm(this, context, adSizeParcel, str, com_ushareit_listenit_dii));
    }

    public djn m10231b(Activity activity) {
        return (djn) m10229a((Context) activity, m10215a(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new bwr(this, activity));
    }
}
