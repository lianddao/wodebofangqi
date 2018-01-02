package com.ushareit.listenit;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;

public abstract class dlw extends dod implements OnCancelListener {
    protected boolean f9892a;
    protected boolean f9893b;
    protected final cdd f9894c;
    private ConnectionResult f9895e;
    private int f9896f;
    private final Handler f9897g;

    protected dlw(doe com_ushareit_listenit_doe) {
        this(com_ushareit_listenit_doe, cdd.m10887a());
    }

    dlw(doe com_ushareit_listenit_doe, cdd com_ushareit_listenit_cdd) {
        super(com_ushareit_listenit_doe);
        this.f9896f = -1;
        this.f9897g = new Handler(Looper.getMainLooper());
        this.f9894c = com_ushareit_listenit_cdd;
    }

    public void mo1671a() {
        super.mo1671a();
        this.f9892a = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1947a(int r6, int r7, android.content.Intent r8) {
        /*
        r5 = this;
        r4 = 18;
        r2 = 13;
        r0 = 1;
        r1 = 0;
        switch(r6) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0010;
            default: goto L_0x0009;
        };
    L_0x0009:
        r0 = r1;
    L_0x000a:
        if (r0 == 0) goto L_0x003d;
    L_0x000c:
        r5.m14801d();
    L_0x000f:
        return;
    L_0x0010:
        r2 = r5.f9894c;
        r3 = r5.m13527e();
        r2 = r2.mo1287a(r3);
        if (r2 != 0) goto L_0x0047;
    L_0x001c:
        r1 = r5.f9895e;
        r1 = r1.m2236c();
        if (r1 != r4) goto L_0x000a;
    L_0x0024:
        if (r2 != r4) goto L_0x000a;
    L_0x0026:
        goto L_0x000f;
    L_0x0027:
        r3 = -1;
        if (r7 == r3) goto L_0x000a;
    L_0x002a:
        if (r7 != 0) goto L_0x0009;
    L_0x002c:
        if (r8 == 0) goto L_0x0045;
    L_0x002e:
        r0 = "<<ResolutionFailureErrorDetail>>";
        r0 = r8.getIntExtra(r0, r2);
    L_0x0034:
        r2 = new com.google.android.gms.common.ConnectionResult;
        r3 = 0;
        r2.<init>(r0, r3);
        r5.f9895e = r2;
        goto L_0x0009;
    L_0x003d:
        r0 = r5.f9895e;
        r1 = r5.f9896f;
        r5.mo1951a(r0, r1);
        goto L_0x000f;
    L_0x0045:
        r0 = r2;
        goto L_0x0034;
    L_0x0047:
        r0 = r1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.dlw.a(int, int, android.content.Intent):void");
    }

    public void mo1948a(Bundle bundle) {
        super.mo1948a(bundle);
        if (bundle != null) {
            this.f9893b = bundle.getBoolean("resolving_error", false);
            if (this.f9893b) {
                this.f9896f = bundle.getInt("failed_client_id", -1);
                this.f9895e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    protected abstract void mo1951a(ConnectionResult connectionResult, int i);

    public void mo1949b() {
        super.mo1949b();
        this.f9892a = true;
    }

    public void mo1950b(Bundle bundle) {
        super.mo1950b(bundle);
        bundle.putBoolean("resolving_error", this.f9893b);
        if (this.f9893b) {
            bundle.putInt("failed_client_id", this.f9896f);
            bundle.putInt("failed_status", this.f9895e.m2236c());
            bundle.putParcelable("failed_resolution", this.f9895e.m2237d());
        }
    }

    public void m14799b(ConnectionResult connectionResult, int i) {
        if (!this.f9893b) {
            this.f9893b = true;
            this.f9896f = i;
            this.f9895e = connectionResult;
            this.f9897g.post(new dly());
        }
    }

    protected abstract void mo1953c();

    protected void m14801d() {
        this.f9896f = -1;
        this.f9893b = false;
        this.f9895e = null;
        mo1953c();
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo1951a(new ConnectionResult(13, null), this.f9896f);
        m14801d();
    }
}
