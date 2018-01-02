package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.firebase.iid.FirebaseInstanceId;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class eeo {
    static Map<String, eeo> f10878a = new HashMap();
    public static String f10879e;
    private static ees f10880f;
    private static eeq f10881g;
    Context f10882b;
    KeyPair f10883c;
    String f10884d = "";

    protected eeo(Context context, String str, Bundle bundle) {
        this.f10882b = context.getApplicationContext();
        this.f10884d = str;
    }

    public static synchronized eeo m16849a(Context context, Bundle bundle) {
        eeo com_ushareit_listenit_eeo;
        synchronized (eeo.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (f10880f == null) {
                f10880f = new ees(applicationContext);
                f10881g = new eeq(applicationContext);
            }
            f10879e = Integer.toString(FirebaseInstanceId.m2555b(applicationContext));
            com_ushareit_listenit_eeo = (eeo) f10878a.get(str);
            if (com_ushareit_listenit_eeo == null) {
                com_ushareit_listenit_eeo = new eeo(applicationContext, str, bundle);
                f10878a.put(str, com_ushareit_listenit_eeo);
            }
        }
        return com_ushareit_listenit_eeo;
    }

    public KeyPair m16850a() {
        if (this.f10883c == null) {
            this.f10883c = f10880f.m16890d(this.f10884d);
        }
        if (this.f10883c == null) {
            this.f10883c = f10880f.m16883a(this.f10884d);
        }
        return this.f10883c;
    }

    public void m16851a(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        f10880f.m16886b(this.f10884d, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.f10884d) ? str : this.f10884d);
        String str3 = "X-subtype";
        if (!"".equals(this.f10884d)) {
            str = this.f10884d;
        }
        bundle.putString(str3, str);
        f10881g.m16874b(f10881g.m16868a(bundle, m16850a()));
    }

    public String m16852b(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Object obj = 1;
        if (bundle.getString("ttl") != null || "jwt".equals(bundle.getString(VastExtensionXmlManager.TYPE))) {
            obj = null;
        } else {
            eet a = f10880f.m16882a(this.f10884d, str, str2);
            if (!(a == null || a.m16893b(f10879e))) {
                return a.f10906a;
            }
        }
        String c = m16855c(str, str2, bundle);
        if (c == null || r0 == null) {
            return c;
        }
        f10880f.m16884a(this.f10884d, str, str2, c, f10879e);
        return c;
    }

    public void m16853b() {
        f10880f.m16885b(this.f10884d);
        this.f10883c = null;
    }

    public ees m16854c() {
        return f10880f;
    }

    public String m16855c(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.f10884d) ? str : this.f10884d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return f10881g.m16874b(f10881g.m16868a(bundle, m16850a()));
    }

    public eeq m16856d() {
        return f10881g;
    }
}
