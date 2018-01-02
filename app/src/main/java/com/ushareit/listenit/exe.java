package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class exe {
    public String f12096a;
    public exj f12097b;
    public String f12098c;
    public int f12099d;
    public String f12100e;
    public List<String> f12101f = new ArrayList();

    public exe(fcf com_ushareit_listenit_fcf) {
        m18354a(com_ushareit_listenit_fcf);
    }

    public exe(JSONObject jSONObject) {
        m18355a(jSONObject);
    }

    public void m18354a(fcf com_ushareit_listenit_fcf) {
        int i = 0;
        this.f12096a = com_ushareit_listenit_fcf.m18848a("address", "");
        this.f12097b = exj.m18382a(com_ushareit_listenit_fcf.m18848a("address_d", ""));
        this.f12098c = com_ushareit_listenit_fcf.m18848a("thumb_url", "");
        this.f12099d = com_ushareit_listenit_fcf.m18846a("auto_dl_mode", 0);
        this.f12100e = com_ushareit_listenit_fcf.m18848a("mime", "");
        if (com_ushareit_listenit_fcf.m18850a("tags")) {
            try {
                JSONArray jSONArray = new JSONArray(com_ushareit_listenit_fcf.m18848a("tags", ""));
                while (i < jSONArray.length()) {
                    this.f12101f.add(jSONArray.optString(i));
                    i++;
                }
            } catch (Exception e) {
            }
        }
    }

    public void m18355a(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject.has("address")) {
            this.f12096a = jSONObject.getString("address");
        } else {
            this.f12096a = "";
        }
        if (jSONObject.has("address_d")) {
            this.f12097b = exj.m18382a(jSONObject.getString("address_d"));
        } else {
            this.f12097b = null;
        }
        if (jSONObject.has("thumb_url")) {
            this.f12098c = jSONObject.getString("thumb_url");
        } else {
            this.f12098c = "";
        }
        if (jSONObject.has("auto_dl_mode")) {
            this.f12099d = jSONObject.getInt("auto_dl_mode");
        } else {
            this.f12099d = 0;
        }
        if (jSONObject.has("mime")) {
            this.f12100e = jSONObject.getString("mime");
        } else {
            this.f12100e = "";
        }
        if (jSONObject.has("tags")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.getString("tags"));
                while (i < jSONArray.length()) {
                    this.f12101f.add(jSONArray.optString(i));
                    i++;
                }
            } catch (Exception e) {
            }
        }
    }

    public void m18356b(JSONObject jSONObject) {
        if (fbb.m18765d(this.f12096a)) {
            jSONObject.put("address", this.f12096a);
        }
        if (this.f12097b != null) {
            jSONObject.put("address_d", this.f12097b.toString());
        }
        if (fbb.m18765d(this.f12098c)) {
            jSONObject.put("thumb_url", this.f12098c);
        }
        if (this.f12099d != 0) {
            jSONObject.put("auto_dl_mode", this.f12099d);
        }
        if (fbb.m18765d(this.f12100e)) {
            jSONObject.put("mime", this.f12100e);
        }
        if (this.f12101f != null && this.f12101f.size() > 0) {
            jSONObject.put("tags", new JSONArray(this.f12101f).toString());
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            m18356b(jSONObject);
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
