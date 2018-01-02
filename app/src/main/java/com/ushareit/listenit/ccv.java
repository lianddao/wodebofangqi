package com.ushareit.listenit;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class ccv {
    private static final Lock f8133a = new ReentrantLock();
    private static ccv f8134b;
    private final Lock f8135c = new ReentrantLock();
    private final SharedPreferences f8136d;

    ccv(Context context) {
        this.f8136d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static ccv m10848a(Context context) {
        cfi.m11080a((Object) context);
        f8133a.lock();
        try {
            if (f8134b == null) {
                f8134b = new ccv(context.getApplicationContext());
            }
            ccv com_ushareit_listenit_ccv = f8134b;
            return com_ushareit_listenit_ccv;
        } finally {
            f8133a.unlock();
        }
    }

    private String m10849b(String str, String str2) {
        String valueOf = String.valueOf(":");
        return new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    public GoogleSignInAccount m10850a() {
        return m10851a(m10857c("defaultGoogleSignInAccount"));
    }

    GoogleSignInAccount m10851a(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m10857c(m10849b("googleSignInAccount", str));
            if (c != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.m2191a(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    void m10852a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        cfi.m11080a((Object) googleSignInAccount);
        cfi.m11080a((Object) googleSignInOptions);
        String j = googleSignInAccount.m2204j();
        m10853a(m10849b("googleSignInAccount", j), googleSignInAccount.m2206l());
        m10853a(m10849b("googleSignInOptions", j), googleSignInOptions.m2223h());
    }

    protected void m10853a(String str, String str2) {
        this.f8135c.lock();
        try {
            this.f8136d.edit().putString(str, str2).apply();
        } finally {
            this.f8135c.unlock();
        }
    }

    public GoogleSignInOptions m10854b() {
        return m10855b(m10857c("defaultGoogleSignInAccount"));
    }

    GoogleSignInOptions m10855b(String str) {
        GoogleSignInOptions googleSignInOptions = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m10857c(m10849b("googleSignInOptions", str));
            if (c != null) {
                try {
                    googleSignInOptions = GoogleSignInOptions.m2207a(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInOptions;
    }

    public void m10856b(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        cfi.m11080a((Object) googleSignInAccount);
        cfi.m11080a((Object) googleSignInOptions);
        m10853a("defaultGoogleSignInAccount", googleSignInAccount.m2204j());
        m10852a(googleSignInAccount, googleSignInOptions);
    }

    protected String m10857c(String str) {
        this.f8135c.lock();
        try {
            String string = this.f8136d.getString(str, null);
            return string;
        } finally {
            this.f8135c.unlock();
        }
    }

    public void m10858c() {
        String c = m10857c("defaultGoogleSignInAccount");
        m10860e("defaultGoogleSignInAccount");
        m10859d(c);
    }

    void m10859d(String str) {
        if (!TextUtils.isEmpty(str)) {
            m10860e(m10849b("googleSignInAccount", str));
            m10860e(m10849b("googleSignInOptions", str));
        }
    }

    protected void m10860e(String str) {
        this.f8135c.lock();
        try {
            this.f8136d.edit().remove(str).apply();
        } finally {
            this.f8135c.unlock();
        }
    }
}
