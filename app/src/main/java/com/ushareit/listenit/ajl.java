package com.ushareit.listenit;

import android.net.Uri;
import com.facebook.Profile;
import com.facebook.internal.ch;
import org.json.JSONObject;

public final class ajl implements ch {
    public void mo198a(JSONObject jSONObject) {
        String optString = jSONObject.optString("id");
        if (optString != null) {
            String optString2 = jSONObject.optString("link");
            Profile.m778a(new Profile(optString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
        }
    }

    public void mo197a(aif com_ushareit_listenit_aif) {
    }
}
