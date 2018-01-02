package com.ushareit.listenit;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class cfs<T extends IInterface> {
    public static final String[] f8046c = new String[]{"service_esmobile", "service_googleme"};
    final Handler f8047a;
    protected AtomicInteger f8048b;
    private int f8049d;
    private long f8050e;
    private long f8051f;
    private int f8052g;
    private long f8053h;
    private final Context f8054i;
    private final Looper f8055j;
    private final chf f8056k;
    private final cjb f8057l;
    private final Object f8058m;
    private final Object f8059n;
    private chv f8060o;
    private cfy f8061p;
    private T f8062q;
    private final ArrayList<cfx<?>> f8063r;
    private cga f8064s;
    private int f8065t;
    private final cfu f8066u;
    private final cfv f8067v;
    private final int f8068w;
    private final String f8069x;

    protected cfs(Context context, Looper looper, int i, cfu com_ushareit_listenit_cfu, cfv com_ushareit_listenit_cfv, String str) {
        this(context, looper, chf.m11221a(context), cjb.m10875b(), i, (cfu) cfi.m11080a((Object) com_ushareit_listenit_cfu), (cfv) cfi.m11080a((Object) com_ushareit_listenit_cfv), str);
    }

    protected cfs(Context context, Looper looper, chf com_ushareit_listenit_chf, cjb com_ushareit_listenit_cjb, int i, cfu com_ushareit_listenit_cfu, cfv com_ushareit_listenit_cfv, String str) {
        this.f8058m = new Object();
        this.f8059n = new Object();
        this.f8063r = new ArrayList();
        this.f8065t = 1;
        this.f8048b = new AtomicInteger(0);
        this.f8054i = (Context) cfi.m11081a((Object) context, (Object) "Context must not be null");
        this.f8055j = (Looper) cfi.m11081a((Object) looper, (Object) "Looper must not be null");
        this.f8056k = (chf) cfi.m11081a((Object) com_ushareit_listenit_chf, (Object) "Supervisor must not be null");
        this.f8057l = (cjb) cfi.m11081a((Object) com_ushareit_listenit_cjb, (Object) "API availability must not be null");
        this.f8047a = new cfw(this, looper);
        this.f8068w = i;
        this.f8066u = com_ushareit_listenit_cfu;
        this.f8067v = com_ushareit_listenit_cfv;
        this.f8069x = str;
    }

    private boolean m10597a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f8058m) {
            if (this.f8065t != i) {
                z = false;
            } else {
                m10600b(i2, t);
                z = true;
            }
        }
        return z;
    }

    private void m10600b(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        cfi.m11089b(z);
        synchronized (this.f8058m) {
            this.f8065t = i;
            this.f8062q = t;
            mo1303a(i, (IInterface) t);
            switch (i) {
                case 1:
                    mo1242x();
                    break;
                case 2:
                    mo1281f();
                    break;
                case 3:
                    m10611a((IInterface) t);
                    break;
            }
        }
    }

    private void mo1281f() {
        if (this.f8064s != null) {
            String valueOf = String.valueOf(mo1243a());
            String valueOf2 = String.valueOf(d_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.f8056k.mo1321b(mo1243a(), d_(), this.f8064s, m10628n());
            this.f8048b.incrementAndGet();
        }
        this.f8064s = new cga(this, this.f8048b.get());
        if (!this.f8056k.mo1320a(mo1243a(), d_(), this.f8064s, m10628n())) {
            valueOf = String.valueOf(mo1243a());
            valueOf2 = String.valueOf(d_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
            m10608a(16, null, this.f8048b.get());
        }
    }

    private void mo1242x() {
        if (this.f8064s != null) {
            this.f8056k.mo1321b(mo1243a(), d_(), this.f8064s, m10628n());
            this.f8064s = null;
        }
    }

    protected abstract String mo1243a();

    protected void m10607a(int i) {
        this.f8049d = i;
        this.f8050e = System.currentTimeMillis();
    }

    protected void m10608a(int i, Bundle bundle, int i2) {
        this.f8047a.sendMessage(this.f8047a.obtainMessage(5, i2, -1, new cgd(this, i, bundle)));
    }

    protected void m10609a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f8047a.sendMessage(this.f8047a.obtainMessage(1, i2, -1, new cgc(this, i, iBinder, bundle)));
    }

    void mo1303a(int i, T t) {
    }

    protected void m10611a(T t) {
        this.f8051f = System.currentTimeMillis();
    }

    protected void m10612a(ConnectionResult connectionResult) {
        this.f8052g = connectionResult.m2236c();
        this.f8053h = System.currentTimeMillis();
    }

    public void m10613a(cfy com_ushareit_listenit_cfy) {
        this.f8061p = (cfy) cfi.m11081a((Object) com_ushareit_listenit_cfy, (Object) "Connection progress callbacks cannot be null.");
        m10600b(2, null);
    }

    public void m10614a(chm com_ushareit_listenit_chm, Set<Scope> set) {
        try {
            GetServiceRequest a = new GetServiceRequest(this.f8068w).m2277a(this.f8054i.getPackageName()).m2275a(mo1246c());
            if (set != null) {
                a.m2278a((Collection) set);
            }
            if (mo1936j()) {
                a.m2274a(m10632r()).m2276a(com_ushareit_listenit_chm);
            } else if (m10636v()) {
                a.m2274a(mo1240q());
            }
            synchronized (this.f8059n) {
                if (this.f8060o != null) {
                    this.f8060o.mo1334a(new cfz(this, this.f8048b.get()), a);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            m10618b(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public void m10615a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.f8058m) {
            int i = this.f8065t;
            IInterface iInterface = this.f8062q;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(mo1245b()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f8051f > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f8051f;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f8051f)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f8050e > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f8049d) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f8049d));
                    break;
            }
            append = printWriter.append(" lastSuspendedTime=");
            j = this.f8050e;
            valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f8050e)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f8053h > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(cdy.m10920a(this.f8052g));
            append = printWriter.append(" lastFailedTime=");
            j = this.f8053h;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.f8053h)));
            append.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j).append(" ").append(valueOf2).toString());
        }
    }

    protected abstract T mo1244b(IBinder iBinder);

    protected abstract String mo1245b();

    public void m10618b(int i) {
        this.f8047a.sendMessage(this.f8047a.obtainMessage(4, this.f8048b.get(), i));
    }

    protected Bundle mo1246c() {
        return new Bundle();
    }

    public boolean mo1279d() {
        return false;
    }

    protected String d_() {
        return "com.google.android.gms";
    }

    public Intent mo1280e() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public void mo2075g() {
        this.f8048b.incrementAndGet();
        synchronized (this.f8063r) {
            int size = this.f8063r.size();
            for (int i = 0; i < size; i++) {
                ((cfx) this.f8063r.get(i)).m11123e();
            }
            this.f8063r.clear();
        }
        synchronized (this.f8059n) {
            this.f8060o = null;
        }
        m10600b(1, null);
    }

    public boolean m10623h() {
        boolean z;
        synchronized (this.f8058m) {
            z = this.f8065t == 3;
        }
        return z;
    }

    public boolean m10624i() {
        boolean z;
        synchronized (this.f8058m) {
            z = this.f8065t == 2;
        }
        return z;
    }

    public boolean mo1936j() {
        return false;
    }

    public boolean mo1399k() {
        return true;
    }

    public IBinder m10627l() {
        IBinder iBinder;
        synchronized (this.f8059n) {
            if (this.f8060o == null) {
                iBinder = null;
            } else {
                iBinder = this.f8060o.asBinder();
            }
        }
        return iBinder;
    }

    protected final String m10628n() {
        return this.f8069x == null ? this.f8054i.getClass().getName() : this.f8069x;
    }

    public void m10629o() {
        int a = this.f8057l.mo1287a(this.f8054i);
        if (a != 0) {
            m10600b(1, null);
            this.f8061p = new cgb(this);
            this.f8047a.sendMessage(this.f8047a.obtainMessage(3, this.f8048b.get(), a));
            return;
        }
        m10613a(new cgb(this));
    }

    public final Context m10630p() {
        return this.f8054i;
    }

    public Account mo1240q() {
        return null;
    }

    public final Account m10632r() {
        return mo1240q() != null ? mo1240q() : new Account("<<default account>>", "com.google");
    }

    protected final void m10633s() {
        if (!m10623h()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle m10634t() {
        return null;
    }

    public final T m10635u() {
        T t;
        synchronized (this.f8058m) {
            if (this.f8065t == 4) {
                throw new DeadObjectException();
            }
            m10633s();
            cfi.m11086a(this.f8062q != null, (Object) "Client is connected but service is null");
            t = this.f8062q;
        }
        return t;
    }

    public boolean m10636v() {
        return false;
    }

    protected Set<Scope> mo1241w() {
        return Collections.EMPTY_SET;
    }
}
