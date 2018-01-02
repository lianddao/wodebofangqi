package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class fsf extends fsc {
    public List<fsg> f13354d;

    public fsf(JSONObject jSONObject, boolean z) {
        super(jSONObject, z);
        m20766b(1);
    }

    public void mo2556a(JSONObject jSONObject, boolean z) {
        JSONArray jSONArray = jSONObject.getJSONArray("content");
        int length = jSONArray.length();
        this.f13354d = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.f13354d.add(new fsg(jSONArray.getJSONObject(i), z));
        }
        exw.m18457e("dfs", super.toString() + ", playlistsize=" + this.f13354d.size());
    }
}
