package com.ushareit.listenit;

import android.location.Location;
import android.os.Bundle;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class bvj {
    private final HashSet<String> f7808a = new HashSet();
    private final Bundle f7809b = new Bundle();
    private final HashMap<Class<? extends Object>, Object> f7810c = new HashMap();
    private final HashSet<String> f7811d = new HashSet();
    private final Bundle f7812e = new Bundle();
    private final HashSet<String> f7813f = new HashSet();
    private Date f7814g;
    private String f7815h;
    private int f7816i = -1;
    private Location f7817j;
    private boolean f7818k = false;
    private String f7819l;
    private String f7820m;
    private int f7821n = -1;
    private boolean f7822o;

    public void m9999a(int i) {
        this.f7816i = i;
    }

    public void m10000a(Location location) {
        this.f7817j = location;
    }

    public void m10001a(Class<? extends bzh> cls, Bundle bundle) {
        this.f7809b.putBundle(cls.getName(), bundle);
    }

    public void m10002a(String str) {
        this.f7808a.add(str);
    }

    public void m10003a(Date date) {
        this.f7814g = date;
    }

    public void m10004a(boolean z) {
        this.f7821n = z ? 1 : 0;
    }

    public void m10005b(String str) {
        this.f7811d.add(str);
    }

    public void m10006b(boolean z) {
        this.f7822o = z;
    }

    public void m10007c(String str) {
        this.f7811d.remove(str);
    }

    public void m10008d(String str) {
        this.f7820m = str;
    }
}
