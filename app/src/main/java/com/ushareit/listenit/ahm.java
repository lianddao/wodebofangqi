package com.ushareit.listenit;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.internal.cj;
import org.json.JSONException;
import org.json.JSONObject;

class ahm {
    private final SharedPreferences f4363a;
    private final ahn f4364b;
    private ajj f4365c;

    ahm(SharedPreferences sharedPreferences, ahn com_ushareit_listenit_ahn) {
        this.f4363a = sharedPreferences;
        this.f4364b = com_ushareit_listenit_ahn;
    }

    public ahm() {
        this(ail.m5715f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new ahn());
    }

    public AccessToken m5650a() {
        if (m5645c()) {
            return m5646d();
        }
        if (!m5647e()) {
            return null;
        }
        AccessToken f = m5648f();
        if (f == null) {
            return f;
        }
        m5651a(f);
        m5649g().m5785b();
        return f;
    }

    public void m5651a(AccessToken accessToken) {
        cj.m1640a((Object) accessToken, "accessToken");
        try {
            this.f4363a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.m686j().toString()).apply();
        } catch (JSONException e) {
        }
    }

    public void m5652b() {
        this.f4363a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (m5647e()) {
            m5649g().m5785b();
        }
    }

    private boolean m5645c() {
        return this.f4363a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private AccessToken m5646d() {
        AccessToken accessToken = null;
        String string = this.f4363a.getString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken);
        if (string != null) {
            try {
                accessToken = AccessToken.m673a(new JSONObject(string));
            } catch (JSONException e) {
            }
        }
        return accessToken;
    }

    private boolean m5647e() {
        return ail.m5711c();
    }

    private AccessToken m5648f() {
        Bundle a = m5649g().m5784a();
        if (a == null || !ajj.m5780a(a)) {
            return null;
        }
        return AccessToken.m672a(a);
    }

    private ajj m5649g() {
        if (this.f4365c == null) {
            synchronized (this) {
                if (this.f4365c == null) {
                    this.f4365c = this.f4364b.m5653a();
                }
            }
        }
        return this.f4365c;
    }
}
