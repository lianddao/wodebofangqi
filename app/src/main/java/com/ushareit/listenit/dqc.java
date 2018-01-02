package com.ushareit.listenit;

import android.content.Context;

public class dqc {
    private static dqc f10151b = new dqc();
    private dqb f10152a = null;

    public static dqb m15265b(Context context) {
        return f10151b.m15266a(context);
    }

    public synchronized dqb m15266a(Context context) {
        if (this.f10152a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f10152a = new dqb(context);
        }
        return this.f10152a;
    }
}
