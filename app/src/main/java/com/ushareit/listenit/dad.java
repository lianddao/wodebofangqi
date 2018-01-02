package com.ushareit.listenit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.io.InputStream;
import java.net.SocketException;
import org.json.JSONObject;

public class dad {
    static final /* synthetic */ boolean f9448a = (!dad.class.desiredAssertionStatus());
    private czw f9449b;
    private Exception f9450c;
    private int f9451d;
    private Exception f9452e;

    public dad(czw com_ushareit_listenit_czw) {
        this.f9449b = com_ushareit_listenit_czw;
    }

    private boolean m13612a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        this.f9451d = -2;
        this.f9452e = new SocketException("Network subsystem is unavailable");
        return false;
    }

    public String m13613a(String str) {
        try {
            return this.f9449b.mo1679c(str);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "NetworkRequestProxy";
            String str3 = "getResultString failed with a RemoteException:";
            String valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), th);
            return null;
        }
    }

    public void m13614a() {
        try {
            this.f9451d = 0;
            this.f9452e = null;
            this.f9449b.mo1673a();
        } catch (Throwable e) {
            this.f9450c = e;
            Log.e("NetworkRequestProxy", "reset failed with a RemoteException:", e);
        }
    }

    public void m13615a(String str, Context context) {
        try {
            if (m13612a(context)) {
                this.f9449b.mo1674a(str);
            }
        } catch (Throwable e) {
            this.f9450c = e;
            Log.e("NetworkRequestProxy", "performRequest failed with a RemoteException:", e);
        }
    }

    public void m13616b() {
        try {
            this.f9449b.mo1676b();
        } catch (Throwable e) {
            this.f9450c = e;
            Log.e("NetworkRequestProxy", "performRequestEnd failed with a RemoteException:", e);
        }
    }

    public void m13617b(String str) {
        try {
            this.f9449b.mo1677b(str);
        } catch (Throwable e) {
            this.f9450c = e;
            Log.e("NetworkRequestProxy", "performRequestStart failed with a RemoteException:", e);
        }
    }

    public InputStream m13618c() {
        try {
            return (InputStream) ckj.m11513a(this.f9449b.mo1678c());
        } catch (Throwable e) {
            this.f9450c = e;
            Log.e("NetworkRequestProxy", "getStream failed with a RemoteException:", e);
            return null;
        }
    }

    public JSONObject m13619d() {
        return (JSONObject) ckj.m11513a(this.f9449b.mo1680d());
    }

    public String m13620e() {
        try {
            this.f9449b.mo1681e();
        } catch (Throwable e) {
            this.f9450c = e;
            Log.e("NetworkRequestProxy", "getRawResult failed with a RemoteException:", e);
        }
        return null;
    }

    public Exception m13621f() {
        try {
            return this.f9452e != null ? this.f9452e : this.f9450c != null ? this.f9450c : (Exception) ckj.m11513a(this.f9449b.mo1683g());
        } catch (Throwable e) {
            this.f9450c = e;
            Log.e("NetworkRequestProxy", "getException failed with a RemoteException:", e);
            return null;
        }
    }

    public int m13622g() {
        try {
            return this.f9451d != 0 ? this.f9451d : this.f9449b.mo1684h();
        } catch (Throwable e) {
            this.f9450c = e;
            Log.e("NetworkRequestProxy", "getResultCode failed with a RemoteException:", e);
            return 0;
        }
    }

    public boolean m13623h() {
        boolean z = false;
        try {
            if (this.f9451d != -2 && this.f9452e == null) {
                z = this.f9449b.mo1685i();
            }
        } catch (Throwable e) {
            this.f9450c = e;
            Log.e("NetworkRequestProxy", "isResultSuccess failed with a RemoteException:", e);
        }
        return z;
    }

    public int m13624i() {
        try {
            return this.f9449b.mo1686j();
        } catch (Throwable e) {
            this.f9450c = e;
            Log.e("NetworkRequestProxy", "getResultingContentLength failed with a RemoteException:", e);
            return 0;
        }
    }
}
