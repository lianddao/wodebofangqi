package com.ushareit.listenit;

import android.content.Context;

public class eya implements exv {
    private Context f12151a;
    private String f12152b;
    private long f12153c;
    private long f12154d;
    private long f12155e;

    public static exv m18461a(Context context, String str, long j, long j2) {
        return new eya(context, str, j, j2);
    }

    public static exv m18462a(Context context, String str, long j, long j2, int i) {
        return new eya(context, str, j, j2, (long) i);
    }

    protected eya(Context context, String str, long j, long j2) {
        this.f12151a = context;
        this.f12152b = str;
        this.f12153c = j;
        this.f12154d = j2;
    }

    protected eya(Context context, String str, long j, long j2, long j3) {
        this.f12151a = context;
        this.f12152b = str;
        this.f12153c = j;
        this.f12154d = j2;
        this.f12155e = j3;
    }

    public boolean mo2319a(int i) {
        if (i == 0) {
            return false;
        }
        if (((long) i) >= this.f12155e) {
            return true;
        }
        return mo2318a();
    }

    public boolean mo2318a() {
        boolean z;
        String str = "RB_" + this.f12152b + ".SUCC";
        String str2 = "RB_" + this.f12152b + ".FAIL";
        long currentTimeMillis = System.currentTimeMillis();
        long a = currentTimeMillis - new exz(this.f12151a).m17989a(str, 0);
        currentTimeMillis -= new exz(this.f12151a).m17989a(str2, 0);
        if (a < currentTimeMillis) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (a > this.f12153c) {
                return true;
            }
            return false;
        } else if (currentTimeMillis <= this.f12154d) {
            return false;
        } else {
            return true;
        }
    }

    public void mo2317a(boolean z) {
        new exz(this.f12151a).m17996b("RB_" + this.f12152b + (z ? ".SUCC" : ".FAIL"), System.currentTimeMillis());
    }
}
