package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class fsh extends fsc {
    public List<fsi> f13361d;

    public fsh(JSONObject jSONObject, boolean z) {
        super(jSONObject, z);
        m20766b(2);
    }

    public void mo2556a(JSONObject jSONObject, boolean z) {
        this.b = jSONObject.getString("name");
        JSONArray jSONArray = jSONObject.getJSONArray("content");
        int length = jSONArray.length();
        this.f13361d = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.f13361d.add(new fsi(jSONArray.getJSONObject(i)));
        }
    }
}
