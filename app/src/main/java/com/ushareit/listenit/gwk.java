package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public class gwk {
    private static gwk f14822a = new gwk();
    private boolean f14823b = false;
    private Context f14824c = eys.m18562a();
    private WeakReference<gwm> f14825d;
    private long f14826e;
    private final long f14827f = 1000;
    @SuppressLint({"HandlerLeak"})
    private Handler f14828g = new gwl(this, Looper.getMainLooper());

    public static gwk m23063a() {
        if (f14822a == null) {
            f14822a = new gwk();
        }
        return f14822a;
    }

    public void m23070a(int i) {
        int i2 = (i * 60) * 1000;
        this.f14826e = SystemClock.elapsedRealtime() + ((long) i2);
        exw.m18454c("Sleep", "Start Alarm:" + i2);
        if (!(this.f14825d == null || this.f14825d.get() == null)) {
            ((gwm) this.f14825d.get()).mo2688b();
        }
        this.f14823b = true;
        this.f14828g.removeMessages(0);
        this.f14828g.sendMessage(this.f14828g.obtainMessage(0));
    }

    public void m23074b() {
        this.f14823b = false;
        if (!(this.f14825d == null || this.f14825d.get() == null)) {
            ((gwm) this.f14825d.get()).mo2690d();
        }
        if (this.f14828g != null) {
            this.f14828g.removeMessages(0);
        }
    }

    public void m23075c() {
        m23074b();
        f14822a = null;
    }

    public void m23076d() {
        this.f14823b = false;
        gvj.m22904b(0);
        if (this.f14828g != null) {
            this.f14828g.removeMessages(0);
        }
        if (!(this.f14825d == null || this.f14825d.get() == null)) {
            ((gwm) this.f14825d.get()).mo2689c();
        }
        exw.m18454c("Sleep", "Success");
    }

    public boolean m23073a(String str) {
        boolean z = true;
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            return false;
        }
        int intValue = Integer.valueOf(str).intValue();
        if (intValue < 1 || intValue > 720) {
            z = false;
        }
        return z;
    }

    public void m23072a(gwm com_ushareit_listenit_gwm) {
        this.f14825d = new WeakReference(com_ushareit_listenit_gwm);
    }

    public String m23077e() {
        long elapsedRealtime = (this.f14826e - SystemClock.elapsedRealtime()) / 1000;
        long j = elapsedRealtime / 60;
        long j2 = j / 60;
        if (j2 > 0) {
            String b = m23066b(j2);
            String b2 = m23066b(j % 60);
            return b + ":" + b2 + ":" + m23066b(elapsedRealtime % 60);
        }
        b2 = m23066b(j % 60);
        return b2 + ":" + m23066b(elapsedRealtime % 60);
    }

    public boolean m23078f() {
        return this.f14823b;
    }

    protected void m23071a(long j) {
        if (this.f14825d != null && this.f14825d.get() != null) {
            ((gwm) this.f14825d.get()).mo2687a();
        }
    }

    private void m23069g() {
        ListenItApp listenItApp = (ListenItApp) eys.m18562a();
        if (listenItApp != null && listenItApp.m4930a() != null && listenItApp.m4930a().mo2425a()) {
            listenItApp.m4930a().mo2444e();
        }
    }

    private gwk() {
    }

    private String m23066b(long j) {
        return j < 10 ? "0" + String.valueOf(j) : String.valueOf(j);
    }
}
