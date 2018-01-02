package com.ushareit.listenit;

import org.json.JSONException;
import org.json.JSONObject;

public class evi {
    public int f11953a;
    public int f11954b;
    public String f11955c;
    public String f11956d;
    public String f11957e;
    public String f11958f;
    public boolean f11959g;
    public String f11960h;
    public int f11961i;
    public int f11962j;
    public int f11963k;
    public String f11964l;
    public int f11965m;
    public String f11966n;

    public evi(String str) {
        this(new JSONObject(str));
    }

    public evi(JSONObject jSONObject) {
        if (jSONObject.has("id")) {
            this.f11953a = jSONObject.getInt("id");
        } else {
            this.f11953a = 0;
        }
        if (jSONObject.has("notify_style")) {
            this.f11954b = jSONObject.getInt("notify_style");
        } else {
            this.f11954b = 0;
        }
        if (jSONObject.has("notify_title")) {
            this.f11955c = jSONObject.getString("notify_title");
        } else {
            this.f11955c = "";
        }
        if (jSONObject.has("notify_content")) {
            this.f11956d = jSONObject.getString("notify_content");
        } else {
            this.f11956d = "";
        }
        if (jSONObject.has("notify_ticker")) {
            this.f11957e = jSONObject.getString("notify_ticker");
        } else {
            this.f11957e = "";
        }
        if (jSONObject.has("notify_thumb_url")) {
            this.f11958f = jSONObject.getString("notify_thumb_url");
        } else {
            this.f11958f = "";
        }
        if (jSONObject.has("disp_img_force")) {
            this.f11959g = jSONObject.getBoolean("disp_img_force");
        } else {
            this.f11959g = false;
        }
        if (jSONObject.has("notify_btn")) {
            this.f11960h = jSONObject.getString("notify_btn");
        } else {
            this.f11960h = "";
        }
        if (jSONObject.has("notify_flag")) {
            this.f11961i = jSONObject.getInt("notify_flag");
        } else {
            this.f11961i = 0;
        }
        if (jSONObject.has("notify_action_flag")) {
            this.f11962j = jSONObject.getInt("notify_action_flag");
        } else {
            this.f11962j = 0;
        }
        if (jSONObject.has("confirm_event")) {
            this.f11963k = jSONObject.getInt("confirm_event");
        } else {
            this.f11963k = 0;
        }
        if (jSONObject.has("confirm_uri")) {
            this.f11964l = jSONObject.getString("confirm_uri");
        } else {
            this.f11964l = "";
        }
        if (jSONObject.has("cancel_event")) {
            this.f11965m = jSONObject.getInt("cancel_event");
        } else {
            this.f11965m = 0;
        }
        if (jSONObject.has("cancel_uri")) {
            this.f11966n = jSONObject.getString("cancel_uri");
        } else {
            this.f11966n = "";
        }
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f11953a != 0) {
                jSONObject.put("id", this.f11953a);
            }
            jSONObject.put("notify_style", this.f11954b);
            if (fbb.m18765d(this.f11955c)) {
                jSONObject.put("notify_title", this.f11955c);
            }
            if (fbb.m18765d(this.f11956d)) {
                jSONObject.put("notify_content", this.f11956d);
            }
            if (fbb.m18765d(this.f11957e)) {
                jSONObject.put("notify_ticker", this.f11957e);
            }
            if (fbb.m18765d(this.f11958f)) {
                jSONObject.put("notify_thumb_url", this.f11958f);
            }
            if (fbb.m18765d(this.f11960h)) {
                jSONObject.put("notify_btn", this.f11960h);
            }
            if (this.f11961i != 0) {
                jSONObject.put("notify_flag", this.f11961i);
            }
            if (this.f11962j != 0) {
                jSONObject.put("notify_action_flag", this.f11962j);
            }
            if (this.f11963k != 0) {
                jSONObject.put("confirm_event", this.f11963k);
            }
            if (fbb.m18765d(this.f11964l)) {
                jSONObject.put("confirm_uri", this.f11964l);
            }
            if (this.f11965m != 0) {
                jSONObject.put("cancel_event", this.f11965m);
            }
            if (fbb.m18765d(this.f11966n)) {
                jSONObject.put("cancel_uri", this.f11966n);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
