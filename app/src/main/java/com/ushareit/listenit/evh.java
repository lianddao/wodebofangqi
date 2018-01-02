package com.ushareit.listenit;

import org.json.JSONException;
import org.json.JSONObject;

public class evh {
    public String f11942a;
    public String f11943b;
    public int f11944c;
    public String f11945d;
    public String f11946e;
    public int f11947f;
    public int f11948g;
    public String f11949h;
    public int f11950i;
    public String f11951j;
    public int f11952k;

    public evh(String str) {
        this(new JSONObject(str));
    }

    public evh(JSONObject jSONObject) {
        if (jSONObject.has("msgbox_title")) {
            this.f11942a = jSONObject.getString("msgbox_title");
        } else {
            this.f11942a = "";
        }
        if (jSONObject.has("msgbox_content")) {
            this.f11943b = jSONObject.getString("msgbox_content");
        } else {
            this.f11943b = "";
        }
        if (jSONObject.has("msgbox_mode")) {
            this.f11944c = jSONObject.getInt("msgbox_mode");
        } else {
            this.f11944c = 0;
        }
        if (jSONObject.has("msgbox_confirm_txt")) {
            this.f11945d = jSONObject.getString("msgbox_confirm_txt");
        } else {
            this.f11945d = "";
        }
        if (jSONObject.has("msgbox_cancel_txt")) {
            this.f11946e = jSONObject.getString("msgbox_cancel_txt");
        } else {
            this.f11946e = "";
        }
        if (jSONObject.has("msgbox_max_cancel_count")) {
            this.f11947f = jSONObject.getInt("msgbox_max_cancel_count");
        } else {
            this.f11947f = 0;
        }
        if (jSONObject.has("confirm_event")) {
            this.f11948g = jSONObject.getInt("confirm_event");
        } else {
            this.f11948g = 0;
        }
        if (jSONObject.has("confirm_uri")) {
            this.f11949h = jSONObject.getString("confirm_uri");
        } else {
            this.f11949h = "";
        }
        if (jSONObject.has("cancel_event")) {
            this.f11950i = jSONObject.getInt("cancel_event");
        } else {
            this.f11950i = 0;
        }
        if (jSONObject.has("cancel_uri")) {
            this.f11951j = jSONObject.getString("cancel_uri");
        } else {
            this.f11951j = "";
        }
        if (jSONObject.has("msgbox_disp_count")) {
            this.f11952k = jSONObject.getInt("msgbox_disp_count");
        } else {
            this.f11952k = 0;
        }
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (fbb.m18765d(this.f11942a)) {
                jSONObject.put("msgbox_title", this.f11942a);
            }
            if (fbb.m18765d(this.f11943b)) {
                jSONObject.put("msgbox_content", this.f11943b);
            }
            if (this.f11944c != 0) {
                jSONObject.put("msgbox_mode", this.f11944c);
            }
            if (fbb.m18765d(this.f11945d)) {
                jSONObject.put("msgbox_confirm_txt", this.f11945d);
            }
            if (fbb.m18765d(this.f11946e)) {
                jSONObject.put("msgbox_cancel_txt", this.f11946e);
            }
            if (this.f11947f != 0) {
                jSONObject.put("msgbox_max_cancel_count", this.f11947f);
            }
            if (this.f11948g != 0) {
                jSONObject.put("confirm_event", this.f11948g);
            }
            if (fbb.m18765d(this.f11949h)) {
                jSONObject.put("confirm_uri", this.f11949h);
            }
            if (this.f11950i != 0) {
                jSONObject.put("cancel_event", this.f11950i);
            }
            if (fbb.m18765d(this.f11951j)) {
                jSONObject.put("cancel_uri", this.f11951j);
            }
            if (this.f11952k != 0) {
                jSONObject.put("msgbox_disp_count", this.f11952k);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
