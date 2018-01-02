package com.ushareit.listenit;

import android.content.Context;

public class fiy {
    private int f12786a = 0;
    private int f12787b = 0;
    private int f12788c = 0;
    private int f12789d = 0;
    private int f12790e = 0;
    private int f12791f = 0;
    private int f12792g = 0;
    private long f12793h = -1;

    public fiy(Context context) {
        String r = gvj.m23026r(context);
        if (!fbb.m18763c(r)) {
            String[] split = r.split(",");
            if (split != null && split.length == 7) {
                try {
                    this.f12786a = Integer.parseInt(split[0]);
                    this.f12787b = Integer.parseInt(split[1]);
                    this.f12788c = Integer.parseInt(split[2]);
                    this.f12789d = Integer.parseInt(split[3]);
                    this.f12790e = Integer.parseInt(split[4]);
                    this.f12791f = Integer.parseInt(split[5]);
                    this.f12792g = Integer.parseInt(split[6]);
                    exw.m18443a("UserListenBehavor", "UserListenBehavor: playlist=" + this.f12786a + ", fav=" + this.f12787b + ", most=" + this.f12788c + ", recent=" + this.f12789d + ", all=" + this.f12790e + ", folder=" + this.f12791f + ", other=" + this.f12792g);
                } catch (Exception e) {
                }
            }
        }
    }

    public void m19494a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f12786a).append(",");
        stringBuilder.append(this.f12787b).append(",");
        stringBuilder.append(this.f12788c).append(",");
        stringBuilder.append(this.f12789d).append(",");
        stringBuilder.append(this.f12790e).append(",");
        stringBuilder.append(this.f12791f).append(",");
        stringBuilder.append(this.f12792g);
        exw.m18443a("UserListenBehavor", "storeUserListenBehavor: listenBehavor=" + stringBuilder.toString());
        gvj.m22922c(context, stringBuilder.toString());
    }

    public void m19497b(Context context) {
        this.f12786a = 0;
        this.f12787b = 0;
        this.f12788c = 0;
        this.f12789d = 0;
        this.f12790e = 0;
        this.f12791f = 0;
        this.f12792g = 0;
        gvj.m22922c(context, "");
    }

    public void m19495a(Context context, long j) {
        if (j != this.f12793h) {
            this.f12793h = j;
            int l = gvj.m22994l(context);
            exw.m18443a("UserListenBehavor", "increaseSongCount: mediaItemType=" + l);
            switch (l) {
                case 0:
                    this.f12790e++;
                    return;
                case 7:
                    this.f12791f++;
                    return;
                case 8:
                    this.f12786a++;
                    return;
                case 9:
                    this.f12788c++;
                    return;
                case 10:
                    this.f12789d++;
                    return;
                case 11:
                    this.f12787b++;
                    return;
                default:
                    this.f12792g++;
                    return;
            }
        }
    }

    public int m19493a() {
        return this.f12786a;
    }

    public int m19496b() {
        return this.f12787b;
    }

    public int m19498c() {
        return this.f12788c;
    }

    public int m19499d() {
        return this.f12789d;
    }

    public int m19500e() {
        return this.f12790e;
    }

    public int m19501f() {
        return this.f12792g;
    }

    public int m19502g() {
        return this.f12791f;
    }
}
