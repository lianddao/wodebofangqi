package com.ushareit.listenit;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.Date;

public final class btz {
    private final bvj f7752a = new bvj();

    public btz() {
        this.f7752a.m10005b(btx.f7750a);
    }

    public btx m9848a() {
        return new btx();
    }

    public btz m9849a(int i) {
        this.f7752a.m9999a(i);
        return this;
    }

    public btz m9850a(Location location) {
        this.f7752a.m10000a(location);
        return this;
    }

    public btz m9851a(Class<? extends bzh> cls, Bundle bundle) {
        this.f7752a.m10001a(cls, bundle);
        if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
            this.f7752a.m10007c(btx.f7750a);
        }
        return this;
    }

    public btz m9852a(String str) {
        this.f7752a.m10002a(str);
        return this;
    }

    public btz m9853a(Date date) {
        this.f7752a.m10003a(date);
        return this;
    }

    public btz m9854a(boolean z) {
        this.f7752a.m10004a(z);
        return this;
    }

    public btz m9855b(String str) {
        this.f7752a.m10005b(str);
        return this;
    }

    public btz m9856b(boolean z) {
        this.f7752a.m10006b(z);
        return this;
    }

    public btz m9857c(String str) {
        this.f7752a.m10008d(str);
        return this;
    }
}
