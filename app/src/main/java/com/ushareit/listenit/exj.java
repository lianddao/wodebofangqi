package com.ushareit.listenit;

import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class exj {
    public exl f12120a;
    public String f12121b = "";
    public List<String> f12122c = new ArrayList();
    public Map<String, String> f12123d = new HashMap();

    public exj(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f12120a = exl.m18387a(jSONObject.getString(VastExtensionXmlManager.TYPE));
        switch (exk.f12124a[this.f12120a.ordinal()]) {
            case 1:
                if (jSONObject.has("url")) {
                    this.f12121b = jSONObject.getString("url");
                    return;
                }
                return;
            case 2:
                if (jSONObject.has("urls")) {
                    this.f12122c = m18383a(jSONObject.getJSONArray("urls"));
                    return;
                }
                return;
            case 3:
                if (jSONObject.has("urls_cfg")) {
                    this.f12123d = m18386b(jSONObject.getJSONArray("urls_cfg"));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(VastExtensionXmlManager.TYPE, this.f12120a);
            switch (exk.f12124a[this.f12120a.ordinal()]) {
                case 1:
                    if (fbb.m18765d(this.f12121b)) {
                        jSONObject.put("url", this.f12121b);
                        break;
                    }
                    break;
                case 2:
                    if (this.f12122c != null && this.f12122c.size() > 0) {
                        jSONObject.put("urls", m18384a(this.f12122c));
                        break;
                    }
                case 3:
                    if (this.f12123d != null && this.f12123d.size() > 0) {
                        jSONObject.put("urls_cfg", m18385a(this.f12123d));
                        break;
                    }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    public static exj m18382a(String str) {
        try {
            return new exj(str);
        } catch (JSONException e) {
            return null;
        }
    }

    public static JSONArray m18384a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static List<String> m18383a(JSONArray jSONArray) {
        List<String> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static JSONArray m18385a(Map<String, String> map) {
        JSONArray jSONArray = new JSONArray();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", str);
            jSONObject.put("value", str2);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static Map<String, String> m18386b(JSONArray jSONArray) {
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            hashMap.put(optJSONObject.getString("key"), optJSONObject.getString("value"));
        }
        return hashMap;
    }
}
