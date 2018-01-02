package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class auc {
    private final String f5477a;
    private final String f5478b;
    private final String f5479c;
    private final List<String> f5480d;
    private final String f5481e;
    private final String f5482f;

    private auc(String str, String str2, String str3, List<String> list, String str4, String str5) {
        this.f5477a = str;
        this.f5478b = str2;
        this.f5479c = str3;
        this.f5480d = list;
        this.f5481e = str4;
        this.f5482f = str5;
    }

    public static auc m7179a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("package");
        String optString2 = jSONObject.optString("appsite");
        String optString3 = jSONObject.optString("appsite_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("key_hashes");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
        }
        return new auc(optString, optString2, optString3, arrayList, jSONObject.optString("market_uri"), jSONObject.optString("fallback_url"));
    }

    public String m7180a() {
        return this.f5477a;
    }

    public String m7181b() {
        return this.f5478b;
    }

    public String m7182c() {
        return this.f5479c;
    }
}
