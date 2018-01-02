package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import org.json.JSONObject;

public class dac {
    private static final Object f9444a = new Object();
    private static volatile dac f9445b;
    private czz f9446c;
    private Context f9447d;

    private dac(Context context) {
        this.f9447d = context;
        try {
            this.f9446c = daa.m13592a(dql.m15283a(context, dql.f10164a, "com.google.android.gms.firebasestorage").m15288a("com.google.firebase.storage.network.NetworkRequestFactoryImpl"));
            if (this.f9446c == null) {
                Log.e("NetworkRqFactoryProxy", "Unable to load Firebase Storage Network layer.");
                throw new RemoteException();
            }
        } catch (Throwable e) {
            Log.e("NetworkRqFactoryProxy", "NetworkRequestFactoryProxy failed with a RemoteException:", e);
            throw new RemoteException();
        }
    }

    public static dac m13605a(eah com_ushareit_listenit_eah) {
        if (f9445b == null) {
            synchronized (f9444a) {
                if (f9445b == null) {
                    f9445b = new dac(com_ushareit_listenit_eah.m16618a());
                }
            }
        }
        return f9445b;
    }

    public dad m13606a(Uri uri, long j) {
        return new dad(this.f9446c.mo1688a(uri, ckj.m11512a(this.f9447d), j));
    }

    public dad m13607a(Uri uri, String str) {
        return new dad(this.f9446c.mo1696b(uri, ckj.m11512a(this.f9447d), str));
    }

    public dad m13608a(Uri uri, String str, byte[] bArr, long j, int i, boolean z) {
        return new dad(this.f9446c.mo1692a(uri, ckj.m11512a(this.f9447d), str, ckj.m11512a((Object) bArr), j, i, z));
    }

    public dad m13609a(Uri uri, JSONObject jSONObject, String str) {
        return new dad(this.f9446c.mo1690a(uri, ckj.m11512a(this.f9447d), ckj.m11512a((Object) jSONObject), str));
    }

    public String m13610a() {
        try {
            return this.f9446c.mo1693a();
        } catch (Throwable e) {
            Log.e("NetworkRqFactoryProxy", "getBackendAuthority failed with a RemoteException:", e);
            return null;
        }
    }

    public dad m13611b(Uri uri, String str) {
        return new dad(this.f9446c.mo1698c(uri, ckj.m11512a(this.f9447d), str));
    }
}
