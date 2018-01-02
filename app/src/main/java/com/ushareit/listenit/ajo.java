package com.ushareit.listenit;

import android.content.Intent;
import com.facebook.Profile;
import com.facebook.internal.cb;
import com.facebook.internal.cj;

public final class ajo {
    private static volatile ajo f4497a;
    private final ec f4498b;
    private final ajn f4499c;
    private Profile f4500d;

    ajo(ec ecVar, ajn com_ushareit_listenit_ajn) {
        cj.m1640a((Object) ecVar, "localBroadcastManager");
        cj.m1640a((Object) com_ushareit_listenit_ajn, "profileCache");
        this.f4498b = ecVar;
        this.f4499c = com_ushareit_listenit_ajn;
    }

    public static ajo m5793a() {
        if (f4497a == null) {
            synchronized (ajo.class) {
                if (f4497a == null) {
                    f4497a = new ajo(ec.m16689a(ail.m5715f()), new ajn());
                }
            }
        }
        return f4497a;
    }

    public Profile m5797b() {
        return this.f4500d;
    }

    boolean m5798c() {
        Profile a = this.f4499c.m5790a();
        if (a == null) {
            return false;
        }
        m5795a(a, false);
        return true;
    }

    public void m5796a(Profile profile) {
        m5795a(profile, true);
    }

    private void m5795a(Profile profile, boolean z) {
        Profile profile2 = this.f4500d;
        this.f4500d = profile;
        if (z) {
            if (profile != null) {
                this.f4499c.m5791a(profile);
            } else {
                this.f4499c.m5792b();
            }
        }
        if (!cb.m1590a((Object) profile2, (Object) profile)) {
            m5794a(profile2, profile);
        }
    }

    private void m5794a(Profile profile, Profile profile2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile2);
        this.f4498b.m16694a(intent);
    }
}
