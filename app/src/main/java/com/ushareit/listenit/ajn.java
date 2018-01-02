package com.ushareit.listenit;

import android.content.SharedPreferences;
import com.facebook.Profile;
import com.facebook.internal.cj;
import org.json.JSONException;
import org.json.JSONObject;

final class ajn {
    private final SharedPreferences f4496a = ail.m5715f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    ajn() {
    }

    Profile m5790a() {
        String string = this.f4496a.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (string != null) {
            try {
                return new Profile(new JSONObject(string));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    void m5791a(Profile profile) {
        cj.m1640a((Object) profile, "profile");
        JSONObject d = profile.m781d();
        if (d != null) {
            this.f4496a.edit().putString("com.facebook.ProfileManager.CachedProfile", d.toString()).apply();
        }
    }

    void m5792b() {
        this.f4496a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}
