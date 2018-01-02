package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class clo extends cha<clv> implements cln {
    private static dpy f8428d = new dpy("FirebaseAuth", "FirebaseAuth:");
    private final Context f8429e;
    private final cma f8430f;

    public clo(Context context, Looper looper, cgs com_ushareit_listenit_cgs, cma com_ushareit_listenit_cma, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        super(context, looper, 112, com_ushareit_listenit_cgs, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
        this.f8429e = (Context) cfi.m11080a((Object) context);
        this.f8430f = com_ushareit_listenit_cma;
    }

    protected clv m11582a(IBinder iBinder) {
        return clw.m11647a(iBinder);
    }

    protected String mo1243a() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    protected /* synthetic */ IInterface mo1244b(IBinder iBinder) {
        return m11582a(iBinder);
    }

    protected String mo1245b() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    protected Bundle mo1246c() {
        Bundle c = super.mo1246c();
        if (c == null) {
            c = new Bundle();
        }
        if (this.f8430f != null) {
            c.putString("com.google.firebase.auth.API_KEY", this.f8430f.m11670a());
        }
        return c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.String d_() {
        /*
        r4 = this;
        r2 = -1;
        r1 = 0;
        r0 = "firebear.preference";
        r0 = com.ushareit.listenit.cmj.m11689a(r0);
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 == 0) goto L_0x0010;
    L_0x000e:
        r0 = "default";
    L_0x0010:
        r3 = r0.hashCode();
        switch(r3) {
            case 103145323: goto L_0x004f;
            case 1544803905: goto L_0x0059;
            default: goto L_0x0017;
        };
    L_0x0017:
        r3 = r2;
    L_0x0018:
        switch(r3) {
            case 0: goto L_0x001d;
            case 1: goto L_0x001d;
            default: goto L_0x001b;
        };
    L_0x001b:
        r0 = "default";
    L_0x001d:
        r3 = r0.hashCode();
        switch(r3) {
            case 103145323: goto L_0x0063;
            default: goto L_0x0024;
        };
    L_0x0024:
        r0 = r2;
    L_0x0025:
        switch(r0) {
            case 0: goto L_0x006d;
            default: goto L_0x0028;
        };
    L_0x0028:
        r0 = f8428d;
        r2 = "Loading module via default loading order.";
        r3 = new java.lang.Object[r1];
        r0.m15258a(r2, r3);
        r0 = r4.f8429e;
        r2 = "com.google.firebase.auth";
        r0 = com.ushareit.listenit.dql.m15281a(r0, r2);
        r2 = r4.f8429e;
        r3 = "com.google.android.gms.firebase_auth";
        r2 = com.ushareit.listenit.dql.m15286b(r2, r3);
        if (r2 < r0) goto L_0x007d;
    L_0x0043:
        r0 = f8428d;
        r2 = "Loading remote module.";
        r1 = new java.lang.Object[r1];
        r0.m15258a(r2, r1);
        r0 = "com.google.android.gms";
    L_0x004e:
        return r0;
    L_0x004f:
        r3 = "local";
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0017;
    L_0x0057:
        r3 = r1;
        goto L_0x0018;
    L_0x0059:
        r3 = "default";
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0017;
    L_0x0061:
        r3 = 1;
        goto L_0x0018;
    L_0x0063:
        r3 = "local";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0024;
    L_0x006b:
        r0 = r1;
        goto L_0x0025;
    L_0x006d:
        r0 = f8428d;
        r2 = "Loading fallback module override.";
        r1 = new java.lang.Object[r1];
        r0.m15258a(r2, r1);
        r0 = r4.f8429e;
        r0 = r0.getPackageName();
        goto L_0x004e;
    L_0x007d:
        r0 = f8428d;
        r2 = "Loading fallback module.";
        r1 = new java.lang.Object[r1];
        r0.m15258a(r2, r1);
        r0 = r4.f8429e;
        r0 = r0.getPackageName();
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.clo.d_():java.lang.String");
    }

    public /* synthetic */ clv mo1281f() {
        return (clv) super.m10635u();
    }

    public boolean mo1399k() {
        return dql.m15281a(this.f8429e, "com.google.firebase.auth") == 0;
    }
}
