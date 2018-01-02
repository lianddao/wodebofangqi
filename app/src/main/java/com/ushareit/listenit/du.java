package com.ushareit.listenit;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.ushareit.listenit.du$com.ushareit.listenit.dv;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;

public abstract class du<D> extends dz<D> {
    volatile dv f8096a;
    volatile dv f8097b;
    long f8098c;
    long f8099d;
    Handler f8100e;
    private final Executor f8101o;

    public abstract D mo1264d();

    public du(Context context) {
        this(context, eg.f10369c);
    }

    private du(Context context, Executor executor) {
        super(context);
        this.f8099d = -10000;
        this.f8101o = executor;
    }

    protected void mo1261a() {
        super.mo1261a();
        m10754k();
        this.f8096a = new dv(this);
        m10769c();
    }

    protected boolean mo1263b() {
        boolean z = false;
        if (this.f8096a != null) {
            if (this.f8097b != null) {
                if (this.f8096a.f10376a) {
                    this.f8096a.f10376a = false;
                    this.f8100e.removeCallbacks(this.f8096a);
                }
                this.f8096a = null;
            } else if (this.f8096a.f10376a) {
                this.f8096a.f10376a = false;
                this.f8100e.removeCallbacks(this.f8096a);
                this.f8096a = null;
            } else {
                z = this.f8096a.m15731a(false);
                if (z) {
                    this.f8097b = this.f8096a;
                    m10772f();
                }
                this.f8096a = null;
            }
        }
        return z;
    }

    public void m10765a(D d) {
    }

    void m10769c() {
        if (this.f8097b == null && this.f8096a != null) {
            if (this.f8096a.f10376a) {
                this.f8096a.f10376a = false;
                this.f8100e.removeCallbacks(this.f8096a);
            }
            if (this.f8098c <= 0 || SystemClock.uptimeMillis() >= this.f8099d + this.f8098c) {
                this.f8096a.m15727a(this.f8101o, (Object[]) (Void[]) null);
                return;
            }
            this.f8096a.f10376a = true;
            this.f8100e.postAtTime(this.f8096a, this.f8099d + this.f8098c);
        }
    }

    void m10764a(dv dvVar, D d) {
        m10765a(d);
        if (this.f8097b == dvVar) {
            m10761r();
            this.f8099d = SystemClock.uptimeMillis();
            this.f8097b = null;
            m10750g();
            m10769c();
        }
    }

    void m10767b(dv dvVar, D d) {
        if (this.f8096a != dvVar) {
            m10764a(dvVar, d);
        } else if (m10751h()) {
            m10765a(d);
        } else {
            m10760q();
            this.f8099d = SystemClock.uptimeMillis();
            this.f8096a = null;
            m10747b((Object) d);
        }
    }

    protected D m10771e() {
        return mo1264d();
    }

    public void m10772f() {
    }

    public void mo1262a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo1262a(str, fileDescriptor, printWriter, strArr);
        if (this.f8096a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f8096a);
            printWriter.print(" waiting=");
            printWriter.println(this.f8096a.f10376a);
        }
        if (this.f8097b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f8097b);
            printWriter.print(" waiting=");
            printWriter.println(this.f8097b.f10376a);
        }
        if (this.f8098c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            gi.m22044a(this.f8098c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            gi.m22043a(this.f8099d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
