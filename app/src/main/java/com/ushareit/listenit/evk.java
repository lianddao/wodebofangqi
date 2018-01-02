package com.ushareit.listenit;

import org.json.JSONException;
import org.json.JSONObject;

public class evk {
    public String f11967a;
    public int f11968b;
    public int f11969c;
    public String f11970d;

    public evk(JSONObject jSONObject) {
        if (jSONObject.has("pkg_name")) {
            this.f11967a = jSONObject.getString("pkg_name");
        } else {
            this.f11967a = "";
        }
        if (jSONObject.has("ver_code")) {
            this.f11968b = jSONObject.getInt("ver_code");
        } else {
            this.f11968b = 0;
        }
        if (jSONObject.has("intent_event")) {
            this.f11969c = jSONObject.getInt("intent_event");
        } else {
            this.f11969c = 0;
        }
        if (jSONObject.has("intent_uri")) {
            this.f11970d = jSONObject.getString("intent_uri");
        } else {
            this.f11970d = "";
        }
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (fbb.m18765d(this.f11967a)) {
                jSONObject.put("pkg_name", this.f11967a);
            }
            if (this.f11969c > 0) {
                jSONObject.put("ver_code", this.f11968b);
            }
            if (this.f11969c != 0) {
                jSONObject.put("intent_event", this.f11969c);
            }
            if (fbb.m18765d(this.f11970d)) {
                jSONObject.put("intent_uri", this.f11970d);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
